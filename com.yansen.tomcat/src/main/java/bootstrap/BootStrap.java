package bootstrap;

import connector.http.HttpConnector;

/**
 * 启动类
 */
public class BootStrap {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
