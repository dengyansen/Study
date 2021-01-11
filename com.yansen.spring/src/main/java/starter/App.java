package starter;

import core.ClassScanner;
import org.apache.catalina.LifecycleException;
import web.server.TomcatServer;

import java.io.IOException;
import java.util.List;

public class App {
    public static void run(Class<?> cls,String[] args){
        System.out.println("hello ,mini spring");
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
            List<Class<?>> classList = ClassScanner.scanClasses(cls.getPackage().getName());
            classList.forEach(it -> System.out.println(it));
        } catch (LifecycleException | IOException e) {
            System.out.println("tomcat run err e=%s"+e.getMessage());
        }
    }
}
