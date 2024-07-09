package tomcat.servlet;

import tomcat.Request;
import tomcat.Response;

import java.io.IOException;

public class StaticResourceProcessor {
    public void process(Request request, Response response) throws IOException {
        response.sendStaticResource();
    }
}
