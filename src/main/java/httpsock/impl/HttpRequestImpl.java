package httpsock.impl;

import com.google.common.base.MoreObjects;
import httpsock.HttpConstants;
import httpsock.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by lukas on 15. 3. 15..
 */
public class HttpRequestImpl implements HttpRequest {
    private final Logger logger = LoggerFactory.getLogger(HttpRequestImpl.class);

    protected String method;
    protected String url;
    protected String version;
    protected Map<String, String> headers;
    protected String body;

    public HttpRequestImpl() {
        this.method = HttpConstants.GET_METHOD;
        this.url = "";
        this.version = HttpConstants.HTTP_VERSION_1_1;
        this.headers = new HashMap<String, String>();
        this.body = "";
    }

    public HttpRequestImpl(String rawRequest) {
        this();
        StringTokenizer requestParser = new StringTokenizer(rawRequest, "\r\n");

        if (requestParser.hasMoreTokens()) {
            String requestLine = requestParser.nextToken();
            logger.info("[" + getClass().getSimpleName() + "]");
        }

        if (requestParser.hasMoreTokens()) {
            //String headers
        }

        // Method Path Version
        // Headers
        // Data
        // TODO
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public Map<String, String> getHeaders() {
        if (headers == null) {
            headers = new HashMap<String, String>();
        }
        return headers;
    }

    @Override
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public void putHeader(String key, String value) {
        getHeaders().put(key, value);
    }

    @Override
    public String getHeader(String key) {
        return getHeader(key, "");
    }

    @Override
    public String getHeader(String key, String def) {
        return MoreObjects.firstNonNull(getHeaders().get(key), def);
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getMethod()).append(" ").append(getUrl()).append(" ").append(getVersion()).append("\r\n");
        for (Map.Entry<String, String> entry : getHeaders().entrySet()) {
            buffer.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }
        buffer.append("\r\n").append(getBody());
        return buffer.toString().trim();
    }
}
