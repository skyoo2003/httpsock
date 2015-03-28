package httpsock.impl;

import httpsock.HttpConstants;
import httpsock.HttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lukas on 15. 3. 15..
 */
public class HttpRequestImpl implements HttpRequest {
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

    }

    @Override
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String getBody() {
        return body;
    }

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
