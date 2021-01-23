package starter;

import beans.BeanFactory;
import core.ClassScanner;
import org.apache.catalina.LifecycleException;
import web.handler.HandlerManage;
import web.server.TomcatServer;

import java.io.IOException;
import java.util.List;
/*
 */
public class App {
    public static void run(Class<?> cls,String[] args){
        System.out.println("hello ,mini spring");
        // TODO: 2021/1/20  AOP
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
            List<Class<?>> classList = ClassScanner.scanClasses(cls.getPackage().getName());
            BeanFactory.initBean(classList);
            HandlerManage.resolveMappingHandler(classList);
            classList.forEach(it -> System.out.println(it));
        } catch (LifecycleException | IOException | ClassNotFoundException e) {
            System.out.println("tomcat run err e=%s"+e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
