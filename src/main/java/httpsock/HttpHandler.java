package httpsock;

import java.net.Socket;

/**
 * HTTP 요청 처리에 대한 인터페이스
 * @author Lukas
 */
public interface HttpHandler {
    /**
     * HTTP 요청 핸들링
     * @param session 세션 객체
     * @return 처리 결과에 대한 응답 객체
     */
    HttpResponse handle(HttpSession session);
}
