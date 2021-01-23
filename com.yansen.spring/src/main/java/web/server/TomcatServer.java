package web.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import web.servlet.DispatcherServlet;

public class TomcatServer {
    private Tomcat tomcat;
    private String[] args;
    public TomcatServer(String[] args){
        this.args = args;
    }

    /**
     * tomcat:Engine host context Wrapper
     * @throws LifecycleException
     */
    public void startServer() throws LifecycleException {
        tomcat = new Tomcat();
        tomcat.setPort(8888);
        tomcat.start();

        Context context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());
        DispatcherServlet servlet = new DispatcherServlet();
        Tomcat.addServlet(context,"dispatcherServlet",servlet).setAsyncSupported(true);
        context.addServletMappingDecoded("/","dispatcherServlet");
        tomcat.getHost().addChild(context);
        Thread awaitThread = new Thread(){
            @Override
            public void run() {
                TomcatServer.this.tomcat.getServer().await();
            }
        };
        awaitThread.setDaemon(false);
        awaitThread.start();
    }

}
