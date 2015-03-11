package httpserver;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HttpSockServer {
	public static void main(String[] args) {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(100);
		ExecutorService service = new ThreadPoolExecutor(1, 10, 30, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.CallerRunsPolicy());
		
	}
}
