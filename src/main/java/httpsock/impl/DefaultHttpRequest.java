package httpsock.impl;

import httpsock.HttpConstants;
import httpsock.HttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lukas on 15. 3. 15..
 */
public class DefaultHttpRequest implements HttpRequest {
    protected String method;
    protected String url;
    protected String version;
    protected Map<String, String> headers;
    protected String body;

    public DefaultHttpRequest() {
        this.method = HttpConstants.GET_METHOD;
        this.url = "";
        this.version = HttpConstants.HTTP_VERSION_1_1;
        this.headers = new HashMap<String, String>();
        this.body = "";
    }

    public DefaultHttpRequest(String method, String url) {
        this();
        if (method != null) {
            this.method = method;
        }
        if (url != null) {
            this.url = url;
        }
    }

    public DefaultHttpRequest(String method, String url, String body) {
        this(method, url);
        if (body != null) {
            this.body = body;
        }
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
}
