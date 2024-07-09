package jvm.loadclass;

import java.net.URL;

public class PrintLoadClass {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for(URL url:urls){
            System.out.println("==>"+url.toExternalForm());
        }
        printClass("扩展类加载器",PrintLoadClass.class.getClassLoader());
    }

    private static void printClass(String 扩展类加载器, ClassLoader classLoader) {

    }
    //todo 视频1小时27分
}
