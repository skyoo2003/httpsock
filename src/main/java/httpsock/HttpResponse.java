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
     * HTTP 프로토콜 버전을 설정
     * @param version
     */
    void setVersion(String version);

    /**
     * 응답 상태 코드 반환
     * @return
     */
    Integer getStatusCode();

    /**
     * 응답 상태 코드 설정
     * @param statusCode
     */
    void setStatusCode(Integer statusCode);

    /**
     * 응답 상태 코드에 대한 간략한 정보
     * @return
     */
    String getStatusReason();

    /**
     * 응답 상태 코드에 대한 정보 설정
     * @param statusReason
     */
    void setStatusReason(String statusReason);

    /**
     * 응답 헤더들을 반환
     * @return
     */
    Map<String, String> getHeaders();

    /**
     * 응답 헤더들을 설정
     * @param headers
     */
    void setHeaders(Map<String, String> headers);

    /**
     * 특정 응답 헤더 설정
     * @param key
     * @param value
     */
    void putHeader(String key, String value);

    /**
     * 특정 응답 헤더의 값을 반환
     * @param key
     * @return
     */
    String getHeader(String key);

    /**
     * 특정 응답 헤더의 값을 반환, 값이 존재하지 않을 경우 기본값 반환
     * @param key
     * @param def
     * @return
     */
    String getHeader(String key, String def);

    /**
     * 응답 콘텐츠를 반환
     * @return
     */
    String getContent();

    /**
     * 응답 콘텐츠 설정
     * @param content
     */
    void setContent(String content);

    /**
     * HTTP 표준에 따른 응답 반환
     * @return
     */
    String toString();
}
