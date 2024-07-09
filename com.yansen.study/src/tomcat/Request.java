package tomcat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import java.io.*;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public class Request implements ServletRequest {
    InputStream input;
    String uri;

    public Request(InputStream input) {
        this.input = input;
    }


    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public Enumeration getAttributeNames() {
        return null;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

    }

    @Override
    public int getContentLength() {
        return 0;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return null;
    }
    @Override
    public String getParameter(String cmd) {
       return null;
    }

    @Override
    public Enumeration getParameterNames() {
        return null;
    }

    @Override
    public String[] getParameterValues(String s) {
        return new String[0];
    }

    @Override
    public Map getParameterMap() {
        return null;
    }

    @Override
    public String getProtocol() {
        return null;
    }

    @Override
    public String getScheme() {
        return null;
    }

    @Override
    public String getServerName() {
        return null;
    }

    @Override
    public int getServerPort() {
        return 0;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return null;
    }

    @Override
    public String getRemoteAddr() {
        return null;
    }

    @Override
    public String getRemoteHost() {
        return null;
    }

    @Override
    public void setAttribute(String s, Object o) {

    }

    @Override
    public void removeAttribute(String s) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public Enumeration getLocales() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String s) {
        return null;
    }

    @Override
    public String getRealPath(String s) {
        return null;
    }

    @Override
    public int getRemotePort() {
        return 0;
    }

    @Override
    public String getLocalName() {
        return null;
    }

    @Override
    public String getLocalAddr() {
        return null;
    }

    @Override
    public int getLocalPort() {
        return 0;
    }

    public String getUri() {
        return uri;
    }

    public void parse() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        //只读取第一行，请求方法，请求路径
        String str = reader.readLine();
        uri = parseUri(str);
        System.out.println("uri ="+uri);
    }

    private String parseUri(String reqStr) {
        int index1, index2;
        index1 = reqStr.indexOf(" ");
        if (index1 != -1) {
            index2 = reqStr.indexOf(' ', index1 + 1);
            if (index2 > index1) {
                return reqStr.substring(index1 + 1, index2);
            }
        }
        return null;
    }
}
