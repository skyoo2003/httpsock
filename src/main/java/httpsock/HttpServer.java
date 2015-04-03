package httpsock;

import httpsock.impl.HttpHandlerImpl;
import httpsock.impl.HttpSessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by lukas on 15. 3. 28..
 */
public final class HttpServer {

    private final Logger logger = LoggerFactory.getLogger(HttpServer.class);

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public HttpServer(int port) {
        InetSocketAddress socketAddress = new InetSocketAddress(port);
        try {
            this.selector = Selector.open();
            this.serverSocketChannel = ServerSocketChannel.open();
            this.serverSocketChannel.socket().bind(socketAddress);
            this.serverSocketChannel.configureBlocking(false);
            this.serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception ex) {
            throw new RuntimeException("[" + getClass().getSimpleName() + "] : " + ex.toString());
        }
    }

    public void run() {
        try {
            selector.selectNow();
            for (SelectionKey key : selector.selectedKeys()) {
                if (key.isAcceptable()) {
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    if (clientChannel != null) {
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, SelectionKey.OP_READ);
                    }
                } else if (key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    if (clientChannel != null) {
                        HttpSession httpSession = (HttpSession) key.attachment();
                        if (httpSession == null) {
                            httpSession = new HttpSessionImpl(clientChannel);
                            key.attach(httpSession);
                        }
                        HttpHandler handler = new HttpHandlerImpl();
                        handler.handle(httpSession);
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("[" + getClass().getSimpleName() + "] : " + ex.toString());
        }
    }

    public static final void main(String[] argv) throws Exception {
        HttpServer httpServer = new HttpServer(8000);
        while (true) {
            httpServer.run();
            Thread.sleep(1000);
        }
    }
}
