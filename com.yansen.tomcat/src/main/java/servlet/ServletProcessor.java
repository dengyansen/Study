package servlet;

import server.Http;
import server.Request;
import server.Response;
import server.Constants;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ServletProcessor {
    public void process(Request request, Response response) throws IOException, ServletException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //todo 类加载 servlet，可能有bug，暂不调试
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/")+1);
        URLClassLoader loader = null;
        // create a URLClassLoader
        URL[] urls = new URL[1];
        URLStreamHandler streamHandler = null;
        File classPath = new File(Constants.WEB_ROOT);
        String repository = (new URL("file",null,classPath.getCanonicalPath()+File.separator)).toString();
        urls[0] = new URL(null,repository,streamHandler);
        loader = new URLClassLoader(urls);
        Class myClass = loader.loadClass(servletName);
        Servlet servlet = (Servlet) myClass.newInstance();
        servlet.service( request,response);
    }

//    public void process(Request request, Response response) throws IOException {
//        String msg = Http.PROTOCOL + "\r\n"
//                + Http.CONTENT_TYPE + ":" + Http.CONTENT_TYPE_TEXT+"\r\n"
//                + "Content-Length:23\r\n"
//                + "\r\n"
//                + "<h1>Hello,client</h1>\r\n";
//        response.getWriter().println(msg);
//    }
}
