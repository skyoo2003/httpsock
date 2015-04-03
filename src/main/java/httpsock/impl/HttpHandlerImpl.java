package httpsock.impl;

import com.google.common.base.Preconditions;
import httpsock.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lukas on 15. 3. 28..
 */
public class HttpHandlerImpl implements HttpHandler {

    private final Logger logger = LoggerFactory.getLogger(HttpHandlerImpl.class);

    public static final String ROOT_PATH = "www";

    @Override
    public HttpResponse handle(HttpSession session) {
        HttpResponse response = new HttpResponseImpl();
        try {
            Preconditions.checkNotNull(session, "session is null");
            HttpRequest request = session.recvRequest();
            Preconditions.checkNotNull(request, "request is null");
            File file = getFile(request.getUrl());
            Preconditions.checkNotNull(file, "file by url is null");

            response.getHeaders().put("Date", Calendar.getInstance().getTime().toString());
            response.getHeaders().put("Server", HttpConstants.SERVER_INFO);
            response.getHeaders().put("Connection", "close");

            if (file.exists() && file.canRead()) {
                BufferedReader br = new BufferedReader(new FileReader(file));

                StringBuffer internalBuffer = new StringBuffer();
                String line = null;
                while((line = br.readLine()) != null) {
                    internalBuffer.append(line);
                }

                response.setStatusCode(HttpConstants.OK_STATUS_CODE);
                response.setStatusReason(HttpConstants.OK_STATUS_REASON);

                response.setContent(internalBuffer.toString().trim());
                response.getHeaders().put("Content-Type", HttpConstants.getMimeType(getExt(file.getName())));
                response.getHeaders().put("Content-Length", String.valueOf(response.getContent().length()));

            } else {
                response.setStatusCode(HttpConstants.NOT_FOUND_STATUS_CODE);
                response.setStatusReason(HttpConstants.NOT_FOUND_STATUS_REASON);
                response.setContent("");
            }
        } catch (NullPointerException ex) {
            logger.error("[" + getClass().getSimpleName() + "] : {}", ex.toString());
        } finally {
            session.sendResponse(response);
            return response;
        }
    }

    protected File getFile(String url) {
        File root = new File(ROOT_PATH);
        File file = null;
        try {
            Preconditions.checkNotNull(url, "url is null");
            Preconditions.checkArgument(url.length() > 0, "url is empty");
            url = (url.startsWith("/") ? url.substring(1) : url);
            if (url == null || url.length() == 0) {
                url = "index.html";
            }
            file = new File(root, url);
        } catch (NullPointerException ex) {
            logger.error("[" + getClass().getSimpleName() + "] : {}", ex.toString());
        } catch (IllegalArgumentException ex) {
            logger.error("[" + getClass().getSimpleName() + "] : {}", ex.toString());
        } finally {
            return file;
        }
    }

    protected String getExt(String path) {
        String ext = "";
        try {
            ext = path.substring(path.lastIndexOf(".") + 1);
        } catch (Exception ex) {
            logger.error("[" + getClass().getSimpleName() + "] : {}", ex.toString());
        } finally {
            return ext;
        }
    }
}
