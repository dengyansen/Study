package connector.http;

import org.apache.poi.ss.formula.functions.T;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpConnector implements Runnable{
    boolean stopped;
    private String scheme = "http";
    public String getScheme() {
        return scheme;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = nu;
        try {
            serverSocket = new ServerSocket(8080,50, InetAddress.getByName("127.0.0.1"));
            while (!stopped){
                // Accept the next connection from the server socket
                Socket socket = serverSocket.accept();
                HttpProcessor processor = new HttpProcessor(this);
                processor.process(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
