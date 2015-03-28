package httpsock.impl;

import httpsock.HttpConstants;
import httpsock.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lukas on 15. 3. 15..
 */
public class HttpResponseImpl implements HttpResponse {

    protected String version;
    protected Integer statusCode;
    protected String statusReason;
    protected Map<String, String> headers;
    protected String content;

    public HttpResponseImpl() {
        this.version = HttpConstants.HTTP_VERSION_1_1;
        this.statusCode = HttpConstants.OK_STATUS_CODE;
        this.statusReason = HttpConstants.OK_STATUS_REASON;
        this.headers = new HashMap<String, String>();
        this.content = "";
    }

    public HttpResponseImpl(Integer statusCode) {
        this();
        if (statusCode != null) {
            this.statusCode = statusCode;
            this.statusReason = HttpConstants.getStatusReason(statusCode);
        }
    }

    public HttpResponseImpl(Integer statusCode, String content) {
        this(statusCode);
        if (content != null) {
            this.content = content;
        }
    }

    @Override
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getVersion()).append(" ").append(getStatusCode()).append(" ").append(getStatusReason()).append("\r\n");
        for (Map.Entry<String, String> entry : getHeaders().entrySet()) {
            buffer.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }
        buffer.append("\r\n").append(getContent());
        return buffer.toString().trim();
    }
}
