package tomcat;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模仿tomcat写一个http服务器
 */
public class HttpServer {
    public static String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    boolean shutdown = false;

    void await() throws IOException {
        // server start
        ServerSocket serverSocket = new ServerSocket(8086, 50, InetAddress.getByName("127.0.0.1"));
        System.out.println("main threadId="+Thread.currentThread().getId());
        while (!shutdown) {
            Socket clientSocket = serverSocket.accept();
            System.out.println(" *****accept request");
            System.out.println("response init threadId="+Thread.currentThread().getId());
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            Request request = new Request(input);
            request.parse();
            //create response
            Response response = new Response(output);
            response.setRequest(request);
            response.sendStaticResource();
            shutdown = request.getUri().equals("shut");
//            String res = "HTTP/1.1 200 OK\r\n" +
//                    "Content-Length: " + "145454".getBytes().length + "\r\n" +
//                    "Content-Type: text/html; charset-utf-8\r\n" +
//                    "\r\n" +
//                    145454 + "\r\n";
            if(shutdown){
                output.write("shutdown".getBytes());
            }
            clientSocket.shutdownOutput();//关闭输出流 注意，没有这句，会阻塞
            clientSocket.close();
        }
    }
}

