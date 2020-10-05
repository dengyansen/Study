package netty.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ExportException;
import java.util.Scanner;

/**
 * 一个简单的bio服务端
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println(" start a bio simple server -- server start");
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new ServerThread(socket)).start();//开启一个服务线程处理
            System.out.println("---- server shutdown");
        }

    }
    static class ServerThread implements Runnable{
        Socket socket ;
        public  ServerThread(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            System.out.println("new thread create id =%s"+Thread.currentThread().getId());
            System.out.println(" create a new Thread to deal this connection thread id ="+Thread.currentThread().getId());
            try {
                Scanner scanner = new Scanner(System.in,"UTF-8");
//                Scanner scannerSys = new Scanner(System.in,"UTF-8");
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                String line = null;
                while ( (line = reader.readLine()) != null){
                    builder.append(line);
                    builder.append("\n");
                }
                StringBuilder msg = new StringBuilder();
                String input = null;
                while ( (input = scanner.nextLine().trim()) != null){
                    System.out.println("服务端输入:"+input);
                    msg.append(input);
                    if(input.equals("quit")){
                        break;
                    }
                }
                System.out.println("---------- server receive="+builder.toString());
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.print (msg);
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    this.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
