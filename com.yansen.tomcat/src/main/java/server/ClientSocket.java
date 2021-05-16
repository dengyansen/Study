package server;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8086);
        try{
            //2.获取输出流，向服务器端发送信息
            OutputStream os=socket.getOutputStream();//字节输出流
            PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
            String hello = "hello,server,i'm client";
            pw.write(hello);
            pw.flush();
            socket.shutdownOutput();//关闭输出流 注意，没有这句，会阻塞
            //3.获取输入流，并读取服务器端的响应信息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info = null;
            StringBuilder receive = new StringBuilder();
            while((info = br.readLine()) != null){
                System.out.println("我是客户端，服务器说："+info);
                receive.append(info);
            }
            System.out.println("client send:"+hello);
            System.out.println("client receive:"+receive.toString());
        }finally {
            socket.close();
        }

    }
}
