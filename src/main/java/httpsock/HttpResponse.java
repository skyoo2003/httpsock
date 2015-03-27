package httpsock;

import java.util.Map;

/**
 * HTTP 응답 인터페이스
 * @author lukas
 */
public interface HttpResponse {
    /**
     * HTTP 프로토콜 버전을 반환
     * @return
     */
    String getVersion();

    /**
     * 응답 상태 코드 반환
     * @return
     */
    Integer getStatusCode();

    /**
     * 응답 상태 코드에 대한 간략한 정보
     * @return
     */
    String getStatusReason();

    /**
     * 응답 헤더들을 반환
     * @return
     */
    Map<String, String> getHeaders();

    /**
     * 응답 콘텐츠를 반환
     * @return
     */
    String getContent();
}
