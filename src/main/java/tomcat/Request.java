package tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {
    InputStream input;
    String uri;

    public Request(InputStream input) {
        this.input = input;
    }


    public String getParameter(String cmd) throws IOException {
        String reader = new BufferedReader(new InputStreamReader(input)).readLine();
        System.out.println("receive :" + reader);
        return "ok";
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
