package httpsock.impl;

import httpsock.HttpRequest;
import httpsock.HttpResponse;
import httpsock.HttpSession;

/**
 * Created by lukas on 15. 3. 15..
 */
public class DefaultHttpSession implements HttpSession {

    protected HttpRequest request;

    public DefaultHttpSession(HttpRequest request) {
        this.request = request;
    }

    @Override
    public HttpRequest recvRequest() {
        return request;
    }

    @Override
    public void sendResponse(HttpResponse response) {

    }
}
