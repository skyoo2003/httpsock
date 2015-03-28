package httpsock;

import httpsock.impl.HttpRequestImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by lukas on 15. 3. 28..
 */
public class HttpRequestTest {
    private HttpRequest request;

    @Before
    public void before() {
        request = new HttpRequestImpl();
    }

    @Test
    public void testConstructorUsingRawRequest() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("GET / HTTP/1.1").append("\r\n")
                .append("Accept: text/html").append("\r\n")
                .append("User-Agent: custom").append("\r\n\r\n")
                .append("<html><head><title>test</title><body>hello, world!</body></html>");

        request = new HttpRequestImpl(buffer.toString());

        assertThat(request.getMethod(), notNullValue());
        assertThat(request.getMethod(), is("GET"));

        assertThat(request.getUrl(), notNullValue());
        assertThat(request.getUrl(), is("/"));

        assertThat(request.getVersion(), notNullValue());
        assertThat(request.getVersion(), is("HTTP/1.1"));

        assertThat(request.getHeaders(), notNullValue());
        assertThat(request.getHeaders().size(), is(2));

        assertThat(request.getHeader("Accept"), notNullValue());
        assertThat(request.getHeader("Accept"), is("text/html"));

        assertThat(request.getHeader("User-Agent"), notNullValue());
        assertThat(request.getHeader("User-Agent"), is("custom"));

        assertThat(request.getBody(), notNullValue());
        assertThat(request.getBody(), is("<html><head><title>test</title><body>hello, world!</body></html>"));
    }

    @Test
    public void testSetAndGetMethod() {
        request.setMethod(HttpConstants.GET_METHOD);

        assertThat(request.getMethod(), notNullValue());
        assertThat(request.getMethod(), is(HttpConstants.GET_METHOD));
    }

    @Test
    public void testSetAndGetUrl() {
        request.setUrl("http://localhost:80/index.html");

        assertThat(request.getUrl(), notNullValue());
        assertThat(request.getUrl(), is("http://localhost:80/index.html"));
    }

    @Test
    public void testSetAndGetVersion() {
        request.setVersion("HTTP/1.1");

        assertThat(request.getVersion(), notNullValue());
        assertThat(request.getVersion(), is("HTTP/1.1"));
    }

    @Test
    public void testSetAndGetHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("header1", "value1");
        headers.put("header2", "value2");
        headers.put("header3", "value3");

        request.setHeaders(headers);

        assertThat(request.getHeaders(), notNullValue());
        assertThat(request.getHeaders().size(), is(3));

        assertThat(request.getHeader("header1"), notNullValue());
        assertThat(request.getHeader("header1"), is("value1"));

        assertThat(request.getHeader("header2"), notNullValue());
        assertThat(request.getHeader("header2"), is("value2"));

        assertThat(request.getHeader("header3"), notNullValue());
        assertThat(request.getHeader("header3"), is("value3"));
    }

    @Test
    public void testPutAndGetHeader() {
        request.putHeader("header", "value");

        assertThat(request.getHeader("header"), notNullValue());
        assertThat(request.getHeader("header"), is("value"));
    }

    @Test
    public void testSetAndGetBody() {
        request.setBody("body");

        assertThat(request.getBody(), notNullValue());
        assertThat(request.getBody(), is("body"));
    }

    @Test
    public void testToString() {
        request.setMethod("GET");
        request.setUrl("/");
        request.setVersion("HTTP/1.1");
        request.putHeader("User-Agent", "custom");
        request.setBody("<html><head><title>test</title><body>hello, world!</body></html>");

        String rawRequest = request.toString();

        assertThat(rawRequest, notNullValue());
        assertThat(rawRequest, is("GET / HTTP/1.1\r\nUser-Agent: custom\r\n\r\n<html><head><title>test</title><body>hello, world!</body></html>"));
    }

}
