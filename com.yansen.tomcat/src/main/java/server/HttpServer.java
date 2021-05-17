package server;

import servlet.ServletProcessor;
import servlet.StaticResourceProcessor;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模仿tomcat写一个http服务器
 */
public class HttpServer {
    public static String WEB_ROOT = System.getProperty("user.dir")+"\\com.yansen.tomcat" + File.separator + "webroot";
    boolean shutdown = false;

    void await() throws IOException, ClassNotFoundException, InstantiationException, ServletException, IllegalAccessException {
        // server start
        ServerSocket serverSocket = new ServerSocket(8086, 50, InetAddress.getByName("127.0.0.1"));
        System.out.println("main threadId=" + Thread.currentThread().getId()+"path:"+HttpServer.WEB_ROOT);
        while (!shutdown) {
            Socket clientSocket = serverSocket.accept();
            System.out.println(" *****accept request");
            System.out.println("response init threadId=" + Thread.currentThread().getId());
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            Request request = new Request(input);
            request.parse();
            //create response
            Response response = new Response(output);
            response.setRequest(request);
            if (request.getUri().startsWith("/api")) {
                ServletProcessor servletProcessor = new ServletProcessor();
                servletProcessor.process(request, response);
            } else {
                StaticResourceProcessor servletProcessor = new StaticResourceProcessor();
                servletProcessor.process(request, response);
            }

            shutdown = request.getUri().equals("shut");
            if (shutdown) {
                output.write("shutdown".getBytes());
            }
            clientSocket.shutdownOutput();//关闭输出流 注意，没有这句，会阻塞
            clientSocket.close();
        }
    }
}

