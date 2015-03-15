package httpsock;

/**
 * HTTP 세선 인터페이스
 * @author lukas
 */
public interface HttpSession {
    /**
     * HTTP 연결된 세션으로부터 클라이언트의 요청을 받는다
     * @return 클라이언트가 전달한 요청 객체
     */
    HttpRequest recvRequest();

    /**
     * HTTP로 연결된 세션으로 클라이언트의 요청에 대한 응답을 전달한다.
     * @param response 요청에 대한 응답 객체
     */
    void sendResponse(HttpResponse response);
}
