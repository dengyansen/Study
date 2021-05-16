package tomcat;

import java.io.*;

public class Response {
    public static final int BUFFER_SIZE = 1024;
    OutputStream outputStream;
    Request request;

    public Response(OutputStream output) {
        this.outputStream = output;
    }

    public void write(String msg) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write(msg);
        printWriter.flush();
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        System.out.println("response threadId="+Thread.currentThread().getId());
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        System.out.println(request.getUri());
        File file = new File(HttpServer.WEB_ROOT,request.getUri());
        try {
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    outputStream.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                System.out.println("file not found uri="+request.getUri());
                //filt not found 这段必须严格安装http规范的格式，不然浏览器无法相应，解析
                String errorMessage = Http.PROTOCOL + "\r\n"
                        + Http.CONTENT_TYPE + ":" + Http.CONTENT_TYPE_TEXT+"\r\n"
                        + "Content-Length:23\r\n"
                        + "\r\n"
                        + "<h1>File Not Found</h1>\r\n";
                /**
                 * HTTP/1.1
                 * Content-Type:text/html
                 * Content-Length:23
                 *
                 * <h1>File Not Found</h1>
                 */
                System.out.println(errorMessage);
                outputStream.write(errorMessage.getBytes());
//                outputStream.write("ok\r\n".getBytes());
                outputStream.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                fis.close();
            }
        }
    }
}
