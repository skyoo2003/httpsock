package httpsock;

import java.util.Map;

/**
 * HTTP 요청 인터페이스
 * @author lukas
 */
public interface HttpRequest {
    /**
     * 요청 메소드 반환
     * @return
     */
    String getMethod();

    /**
     * 요청 URL 주소 반환
     * @return
     */
    String getUrl();

    /**
     * HTTP 버전 정보 반환
     * @return
     */
    String getVersion();

    /**
     * 요청에 포함된 헤더들을 반환
     * @return
     */
    Map<String, String> getHeaders();

    /**
     * 요청에 포함된 메세지 반환
     * @return
     */
    String getBody();

    /**
     * HTTP 표준에 따르는 요청 반환
     * @return
     */
    String toString();
}
