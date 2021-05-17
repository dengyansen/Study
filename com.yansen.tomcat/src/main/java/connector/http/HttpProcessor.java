package connector.http;

import java.net.Socket;

public class HttpProcessor {
    private final HttpConnector htttpConnector;

    public HttpProcessor(HttpConnector httpConnector) {
        this.htttpConnector = httpConnector;
    }

    public void process(Socket socket) {
    }
}
