package httpsock;

import com.google.common.base.MoreObjects;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lukas on 15. 3. 15..
 */
public final class HttpConstants {

    /**
     * 서버 정보
     */
    public static final String SERVER_INFO = "HTTP SERVER by Lukas/0.1";

    /**
     * CRLF
     */
    public static final String CRLF = "\r\n";

    // HTTP 버전 상수
    /**
     * HTTP 버전 1.1
     */
    public static final String HTTP_VERSION_1_1 = "HTTP/1.1";

    // HTTP 메소드 상수
    /**
     * HTTP GET 메소드
     */
    public static final String GET_METHOD = "GET";

    /**
     * HTTP POST 메소드
     */
    public static final String POST_METHOD = "POST";

    /**
     * HTTP DELETE 메소드
     */
    public static final String DELETE_METHOD = "DELETE";

    /**
     * HTTP PUT 메소드
     */
    public static final String PUT_METHOD = "PUT";

    // HTTP STATUS CODES
    /**
     * OK 상태 코드
     */
    public static final int OK_STATUS_CODE = 200;

    /**
     * Bad Request 상태 코드
     */
    public static final int BAD_REQUEST_STATUS_CODE = 400;

    /**
     * Not Found 상태 코드
     */
    public static final int NOT_FOUND_STATUS_CODE = 404;

    // HTTP 상태 이유 상수
    /**
     * OK 상태 이유
     */
    public static final String OK_STATUS_REASON = "OK";

    /**
     * Bad Request 상태 이유
     */
    public static final String BAD_REQUEST_STATUS_REASON = "Bad Request";

    /**
     * Not Found 상태 이유
     */
    public static final String NOT_FOUND_STATUS_REASON = "Not Found";

    /**
     * 상태 코드와 상태 이유 매핑 객체
     */
    private static final Map<Integer, String> STATUS_CODE_TO_REASON_MAP = new HashMap<Integer, String>();
    static {
        STATUS_CODE_TO_REASON_MAP.put(OK_STATUS_CODE, OK_STATUS_REASON);
        STATUS_CODE_TO_REASON_MAP.put(BAD_REQUEST_STATUS_CODE, BAD_REQUEST_STATUS_REASON);
        STATUS_CODE_TO_REASON_MAP.put(NOT_FOUND_STATUS_CODE, NOT_FOUND_STATUS_REASON);
    }

    // 마임 타입 상수
    public static final String HTML_MIME_TYPE = "text/html";

    public static final String CSS_MIME_TYPE = "text/css";

    public static final String XML_MIME_TYPE = "text/xml";

    public static final String JAVA_MIME_TYPE = "text/x-java-source, text/java";

    public static final String PLAIN_MIME_TYPE = "text/plain";

    public static final String GIF_MIME_TYPE = "image/gif";

    public static final String JPEG_MIME_TYPE = "image/jpeg";

    public static final String PNG_MIME_TYPE = "image/png";

    public static final String MP3_MIME_TYPE = "audio/mpeg";

    public static final String MP4_MIME_TYPE = "video/mp4";

    public static final String FLASH_MIME_TYPE = "application/x-shockwave-flash";

    public static final String JS_MIME_TYPE = "application/javascript";

    public static final String MSWORD_MIME_TYPE = "application/msword";

    public static final String PDF_MIME_TYPE = "application/pdf";

    public static final String BINARY_MIME_TYPE = "application/octet-stream";

    // 확장자 상수
    public static final String HTML_EXT = "html";

    public static final String HTM_EXT = "html";

    public static final String CSS_EXT = "css";

    public static final String XML_EXT = "xml";

    public static final String JAVA_EXT = "java";

    public static final String TXT_EXT = "txt";

    public static final String GIF_EXT = "gif";

    public static final String JPEG_EXT = "jpeg";

    public static final String JPG_EXT = "jpg";

    public static final String PNG_EXT = "png";

    public static final String MP3_EXT = "mp3";

    public static final String MP4_EXT = "mp4";

    public static final String SWF_EXT = "swf";

    public static final String JS_EXT = "js";

    public static final String PDF_EXT = "pdf";

    public static final String DOC_EXT = "doc";

    public static final String ZIP_EXT = "zip";

    public static final String EXE_EXT = "exe";

    /**
     * 확장자, 마임 타입 매핑 객체
     */
    private static final Map<String, String> EXT_TO_MIME_TYPE_MAP = new HashMap<String, String>();
    static {
        EXT_TO_MIME_TYPE_MAP.put(HTML_EXT, HTML_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(HTM_EXT, HTML_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(CSS_EXT, CSS_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(XML_EXT, XML_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(JAVA_EXT, JAVA_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(TXT_EXT, PLAIN_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(GIF_EXT, GIF_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(JPEG_EXT, JPEG_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(JPG_EXT, JPEG_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(PNG_EXT, PNG_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(MP3_EXT, MP3_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(MP4_EXT, MP4_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(SWF_EXT, FLASH_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(JS_EXT, JS_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(PDF_EXT, PDF_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(DOC_EXT, MSWORD_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(ZIP_EXT, BINARY_MIME_TYPE);
        EXT_TO_MIME_TYPE_MAP.put(EXE_EXT, BINARY_MIME_TYPE);
    }

    /**
     * 상태 코드로 상태 이유를 반환
     * @param statusCode
     * @return
     */
    public static String getStatusReason(int statusCode) {
        return MoreObjects.firstNonNull(STATUS_CODE_TO_REASON_MAP.get(statusCode), "");
    }

    /**
     * 확장자로 마임 타입을 반환
     * @param ext
     * @return
     */
    public static String getMimeType(String ext) {
        return MoreObjects.firstNonNull(EXT_TO_MIME_TYPE_MAP.get(ext), HTML_MIME_TYPE);
    }
}
