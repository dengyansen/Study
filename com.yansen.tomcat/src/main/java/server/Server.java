package server;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer();
        server.await();
    }
}
