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
     * 요청 메소드 설정
     * @param method
     */
    void setMethod(String method);

    /**
     * 요청 URL 주소 반환
     * @return
     */
    String getUrl();

    /**
     * 요청 URL 주소 설정
     * @param url
     */
    void setUrl(String url);

    /**
     * HTTP 버전 정보 반환
     * @return
     */
    String getVersion();

    /**
     * HTTP 버전 정보 설정
     * @param version
     */
    void setVersion(String version);

    /**
     * 요청에 포함된 헤더들을 반환
     * @return
     */
    Map<String, String> getHeaders();

    /**
     * 요청 헤더들을 설정
     * @param headers
     */
    void setHeaders(Map<String, String> headers);

    /**
     * 헤더 추가
     * @param key
     * @param value
     */
    void putHeader(String key, String value);

    /**
     * 특정 헤더 정보를 반환
     * @param key
     * @return
     */
    String getHeader(String key);

    /**
     * 특정 헤더 정보를 반환, 존재하지 않을 경우 기본값 반환
     * @param key
     * @param def
     * @return
     */
    String getHeader(String key, String def);

    /**
     * 전달 메세지 반환
     * @return
     */
    String getBody();

    /**
     * 전달할 메세지 설정
     * @param body
     */
    void setBody(String body);

    /**
     * HTTP 표준에 따르는 요청 반환
     * @return
     */
    String toString();
}
