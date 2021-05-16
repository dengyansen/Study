package servlet;

import server.Http;
import server.Request;
import server.Response;

import java.io.IOException;

public class ServletProcessor {
    public void process(Request request, Response response) throws IOException {
        String msg = Http.PROTOCOL + "\r\n"
                + Http.CONTENT_TYPE + ":" + Http.CONTENT_TYPE_TEXT+"\r\n"
                + "Content-Length:23\r\n"
                + "\r\n"
                + "<h1>Hello,client</h1>\r\n";
        response.getWriter().println(msg);
    }
}
