package httpsock;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lukas on 15. 3. 15..
 */
public class HttpConstants {
    public static final String HTTP_VERSION_1_1 = "HTTP/1.1";

    public static final int OK_STATUS_CODE = 200;
    public static final int NOT_FOUND_STATUS_CODE = 404;

    public static final String OK_STATUS_REASON = "OK";
    public static final String NOT_FOUND_STATUS_REASON = "Not Found";

    public static final Map<Integer, String> STATUS = new HashMap<Integer, String>();

    static {
        STATUS.put(OK_STATUS_CODE, OK_STATUS_REASON);
        STATUS.put(NOT_FOUND_STATUS_CODE, NOT_FOUND_STATUS_REASON);
    }

    public static final String GET_METHOD = "GET";

    public static final String POST_METHOD = "POST";
}
