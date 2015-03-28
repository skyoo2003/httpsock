package httpsock;

import httpsock.impl.HttpResponseImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by lukas on 15. 3. 29..
 */
public class HttpResponseTest {
    private HttpResponse response;

    @Before
    public void before() {
        response = new HttpResponseImpl();
    }

    @Test
    public void testConstructorUsingStatusCode() {
        response = new HttpResponseImpl(HttpConstants.NOT_FOUND_STATUS_CODE);

        assertThat(response.getStatusCode(), notNullValue());
        assertThat(response.getStatusCode(), is(HttpConstants.NOT_FOUND_STATUS_CODE));

        assertThat(response.getStatusReason(), notNullValue());
        assertThat(response.getStatusReason(), is(HttpConstants.NOT_FOUND_STATUS_REASON));
    }

    @Test
    public void testConstructorUsingStatusCodeAndContent() {
        response = new HttpResponseImpl(HttpConstants.NOT_FOUND_STATUS_CODE, "Hello, World!");

        assertThat(response.getStatusCode(), notNullValue());
        assertThat(response.getStatusCode(), is(HttpConstants.NOT_FOUND_STATUS_CODE));

        assertThat(response.getStatusReason(), notNullValue());
        assertThat(response.getStatusReason(), is(HttpConstants.NOT_FOUND_STATUS_REASON));

        assertThat(response.getContent(), notNullValue());
        assertThat(response.getContent(), is("Hello, World!"));
    }

    @Test
    public void testSetAndGetVersion() {
        response.setVersion("HTTP/1.1");

        assertThat(response.getVersion(), notNullValue());
        assertThat(response.getVersion(), is("HTTP/1.1"));
    }

    @Test
    public void testSetAndGetStatusCode() {
        response.setStatusCode(HttpConstants.NOT_FOUND_STATUS_CODE);

        assertThat(response.getStatusCode(), notNullValue());
        assertThat(response.getStatusCode(), is(HttpConstants.NOT_FOUND_STATUS_CODE));
    }

    @Test
    public void testSetAndGetStatusReason() {
        response.setStatusReason(HttpConstants.NOT_FOUND_STATUS_REASON);

        assertThat(response.getStatusReason(), notNullValue());
        assertThat(response.getStatusReason(), is(HttpConstants.NOT_FOUND_STATUS_REASON));
    }

    @Test
    public void testSetAndGetHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("header1", "value1");
        headers.put("header2", "value2");
        headers.put("header3", "value3");

        response.setHeaders(headers);

        assertThat(response.getHeaders(), notNullValue());
        assertThat(response.getHeaders().size(), is(3));

        assertThat(response.getHeader("header1"), notNullValue());
        assertThat(response.getHeader("header1"), is("value1"));

        assertThat(response.getHeader("header2"), notNullValue());
        assertThat(response.getHeader("header2"), is("value2"));

        assertThat(response.getHeader("header3"), notNullValue());
        assertThat(response.getHeader("header3"), is("value3"));
    }

    @Test
    public void testPutAndGetHeader() {
        response.putHeader("header", "value");

        assertThat(response.getHeader("header"), notNullValue());
        assertThat(response.getHeader("header"), is("value"));
    }

    @Test
    public void testSetAndGetContent() {
        response.setContent("Hello, World!");

        assertThat(response.getContent(), notNullValue());
        assertThat(response.getContent(), is("Hello, World!"));
    }

    @Test
    public void testToString() {
        response.setVersion("HTTP/1.1");
        response.setStatusCode(404);
        response.setStatusReason("Not Found");
        response.putHeader("Content-Length", "13");
        response.setContent("Hello, World!");

        String rawResponse = response.toString();

        assertThat(rawResponse, notNullValue());
        assertThat(rawResponse, is("HTTP/1.1 404 Not Found\r\nContent-Length: 13\r\n\r\nHello, World!"));
    }

}
