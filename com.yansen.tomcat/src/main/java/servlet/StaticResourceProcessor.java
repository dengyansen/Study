package servlet;

import server.Request;
import server.Response;

import java.io.IOException;

public class StaticResourceProcessor {
    public void process(Request request, Response response) throws IOException {
        response.sendStaticResource();
    }
}
