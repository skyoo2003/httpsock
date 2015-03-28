package httpsock.impl;

import com.google.common.base.Preconditions;
import httpsock.HttpRequest;
import httpsock.HttpResponse;
import httpsock.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created by lukas on 15. 3. 15..
 */
public class HttpSessionImpl implements HttpSession {
    private final Logger logger = LoggerFactory.getLogger(HttpSessionImpl.class);

    protected final CharsetEncoder encoder;
    protected final SocketChannel socketChannel;
    protected final ByteBuffer byteBuffer;

    public HttpSessionImpl(SocketChannel socketChannel) {
        this.encoder = Charset.forName("UTF-8").newEncoder();
        this.socketChannel = socketChannel;
        this.byteBuffer = ByteBuffer.allocate(4096);
    }

    @Override
    public HttpRequest recvRequest() {
        HttpRequest httpRequest = null;
        try {
            Preconditions.checkNotNull(socketChannel, "socketChannel instance is null");
            byteBuffer.limit(byteBuffer.capacity());
            Preconditions.checkState(socketChannel.read(byteBuffer) > 0, "socketChannel's stream is end");
            byteBuffer.flip();
            byteBuffer.position();

            StringBuffer internalBuffer = new StringBuffer();

            while (byteBuffer.hasRemaining()) {
                internalBuffer.append(byteBuffer.getChar());
            }

            httpRequest = new HttpRequestImpl(internalBuffer.toString().trim());
        } catch (NullPointerException ex) {
            logger.error("[" + getClass().getSimpleName() + "] : {}", ex.toString());
        } catch (IllegalStateException ex) {
            logger.error("[" + getClass().getSimpleName() + "] : {}", ex.toString());
        } finally {
            return httpRequest;
        }
    }

    @Override
    public void sendResponse(HttpResponse response) {
        String rawResponse = "";
        try {
            Preconditions.checkNotNull(socketChannel, "socketChannel instance is null");
            Preconditions.checkNotNull(response, "response instance is null");
            rawResponse = response.toString();
        } catch (NullPointerException ex) {
            logger.error("[" + getClass().getSimpleName() + "] : {}", ex.toString());
        } finally {
            try {
                socketChannel.write(encoder.encode(CharBuffer.wrap(rawResponse)));
                socketChannel.close();
            } catch (IOException ex) {
                logger.error("[" + getClass().getSimpleName() + "] : {}", ex.toString());
            }
        }
    }
}
