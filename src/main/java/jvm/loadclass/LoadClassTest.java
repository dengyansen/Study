package jvm.loadclass;

import java.net.URL;
import java.net.URLClassLoader;

/**

 * 输出：
 * D:\Java\jdk1.8.0_60\bin\java.exe "-javaagent:D:\Program Files\JetBrains\IntelliJ IDEA 2020.2.2\lib\idea_rt.jar=49979:D:\Program Files\JetBrains\IntelliJ IDEA 2020.2.2\bin" -Dfile.encoding=UTF-8 -classpath D:\Java\jdk1.8.0_60\jre\lib\charsets.jar;D:\Java\jdk1.8.0_60\jre\lib\deploy.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\access-bridge-64.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\cldrdata.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\dnsns.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\jaccess.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\jfxrt.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\localedata.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\nashorn.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\sunec.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\sunjce_provider.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\sunmscapi.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\sunpkcs11.jar;D:\Java\jdk1.8.0_60\jre\lib\ext\zipfs.jar;D:\Java\jdk1.8.0_60\jre\lib\javaws.jar;D:\Java\jdk1.8.0_60\jre\lib\jce.jar;D:\Java\jdk1.8.0_60\jre\lib\jfr.jar;D:\Java\jdk1.8.0_60\jre\lib\jfxswt.jar;D:\Java\jdk1.8.0_60\jre\lib\jsse.jar;D:\Java\jdk1.8.0_60\jre\lib\management-agent.jar;D:\Java\jdk1.8.0_60\jre\lib\plugin.jar;D:\Java\jdk1.8.0_60\jre\lib\resources.jar;D:\Java\jdk1.8.0_60\jre\lib\rt.jar;D:\code\Study\target\classes;C:\Users\yansen\.m2\repository\javax\servlet\servlet-api\2.5\servlet-api-2.5.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-catalina\8.5.29\tomcat-catalina-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-servlet-api\8.5.29\tomcat-servlet-api-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-jsp-api\8.5.29\tomcat-jsp-api-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-el-api\8.5.29\tomcat-el-api-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-juli\8.5.29\tomcat-juli-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-annotations-api\8.5.29\tomcat-annotations-api-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-api\8.5.29\tomcat-api-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-jni\8.5.29\tomcat-jni-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-coyote\8.5.29\tomcat-coyote-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-util\8.5.29\tomcat-util-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-util-scan\8.5.29\tomcat-util-scan-8.5.29.jar;C:\Users\yansen\.m2\repository\org\apache\tomcat\tomcat-jaspic-api\8.5.29\tomcat-jaspic-api-8.5.29.jar;C:\Users\yansen\.m2\repository\org\springframework\spring-core\5.2.8.RELEASE\spring-core-5.2.8.RELEASE.jar;C:\Users\yansen\.m2\repository\org\springframework\spring-jcl\5.2.8.RELEASE\spring-jcl-5.2.8.RELEASE.jar;C:\Users\yansen\.m2\repository\org\springframework\spring-tx\5.2.9.RELEASE\spring-tx-5.2.9.RELEASE.jar;C:\Users\yansen\.m2\repository\org\springframework\spring-beans\5.2.9.RELEASE\spring-beans-5.2.9.RELEASE.jar;C:\Users\yansen\.m2\repository\org\apache\poi\poi-ooxml\3.8\poi-ooxml-3.8.jar;C:\Users\yansen\.m2\repository\org\apache\poi\poi\3.8\poi-3.8.jar;C:\Users\yansen\.m2\repository\commons-codec\commons-codec\1.5\commons-codec-1.5.jar;C:\Users\yansen\.m2\repository\org\apache\poi\poi-ooxml-schemas\3.8\poi-ooxml-schemas-3.8.jar;C:\Users\yansen\.m2\repository\org\apache\xmlbeans\xmlbeans\2.3.0\xmlbeans-2.3.0.jar;C:\Users\yansen\.m2\repository\stax\stax-api\1.0.1\stax-api-1.0.1.jar;C:\Users\yansen\.m2\repository\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;C:\Users\yansen\.m2\repository\xml-apis\xml-apis\1.0.b2\xml-apis-1.0.b2.jar;C:\Users\yansen\.m2\repository\org\aspectj\aspectjweaver\1.8.9\aspectjweaver-1.8.9.jar;C:\Users\yansen\.m2\repository\org\aspectj\aspectjrt\1.8.13\aspectjrt-1.8.13.jar jvm.loadclass.LoadClassTest
 * sun.misc.Launcher$AppClassLoader@14dad5dc
 * sun.misc.Launcher$AppClassLoader:::sun.misc.Launcher$AppClassLoader
 * sun.misc.Launcher$AppClassLoader:::sun.misc.Launcher$ExtClassLoader
 * java.net.URLClassLoader:::java.net.URLClassLoader
 * java.net.URLClassLoader:::sun.misc.Launcher$AppClassLoader
 * IntProducer 被加载，产生随机数：4
 * sun.misc.Launcher$AppClassLoader@14dad5dc:4
 * sun.misc.Launcher$AppClassLoader@14dad5dc:4
 * sun.misc.Launcher$AppClassLoader@14dad5dc:4
 * sun.misc.Launcher$AppClassLoader@14dad5dc:4
 * loader1=java.net.URLClassLoader@28a418fc
 * loader2=sun.misc.Launcher$AppClassLoader@14dad5dc
 * loader3=sun.misc.Launcher$AppClassLoader@14dad5dc
 * c1=true
 * c2=class jvm.loadclass.IntProducer
 * c3=class jvm.loadclass.IntProducer
 *
 * Process finished with exit code 0
 *  * 这个demo说明，这个类都是由于同一个类加载器去加载的
 *  * 因为Launcher$AppClassLoader 继承自URLClassLoader，符合双亲委派原则，都是委派给URLClassLoader加载了。
 *  因为双亲委派很重要的一点时，只有上层加载器找不到时，类才会自己去加载。
 * Process finished with exit code 0
 *
 * BootStrapClassLoader
 * ExtClassLoader
 * AppClassLoader与java里的ClassLoader是不同的概念？{@link java.lang.ClassLoader}是继承自AppClassLoader?
 */

//todo
public class LoadClassTest {
    public static void main(String[] args) throws Exception
    {
        System.out.println(LoadClassTest.class.getClassLoader());

        ClassLoader loader3 = LoadClassTest.class.getClassLoader();
        System.out.println("系统默认classLoader"+loader3.getClass().getName()+":::"+loader3.getClass().getName());
        System.out.println("系统默认classLoader 的parent"+loader3.getClass().getName()+":::"+loader3.getParent().getClass().getName());
       //下面返回Null，说明是bootStrapLoader
        // System.out.println("系统默认classLoader 的parent的 parent"+loader3.getClass().getName()+":::"+loader3.getParent().getParent().getClass().getName());
        Class c3 = loader3.loadClass("jvm.loadclass.IntProducer");
        //  { new URL("file://D:/") };
        URL[] us = { new URL("file://D:/") };
       // D:\jvm\loadclass\
        URLClassLoader loader1 = new URLClassLoader(us);
        Class c1 = loader1.loadClass("jvm.loadclass.IntProducer");
        System.out.println("URLClassLoader"+loader1.getClass().getName()+":::"+loader1.getClass().getName());
        System.out.println("URLClassLoader 的parent"+loader1.getClass().getName()+":::"+loader1.getParent().getClass().getName());
        System.out.println("URLClassLoader 的parent 的Parent"+loader1.getClass().getName()+":::"+loader1.getParent().getParent().getClass().getName());
        System.out.println(c1.getClassLoader()+":"+c1.getField("age").getInt(c1));

        //再加载一次 为什么URLlassLoader可以看到子类的加载？？？ todo
        URLClassLoader loader2 = new URLClassLoader(us);
        Class c2 = loader2.loadClass("jvm.loadclass.IntProducer");
        System.out.println(c1.getClassLoader()+":"+c2.getField("age").getInt(c2));
        System.out.println(c2.getClassLoader()+":"+c2.getField("age").getInt(c2));
        System.out.println(c3.getClassLoader()+":"+c2.getField("age").getInt(c2));
        System.out.println("loader1="+loader1);
        System.out.println("loader2="+loader3);
        System.out.println("loader3="+loader3);

        System.out.println("c1="+(c1.equals(c2) && c1.equals(c3)));
        System.out.println("c2="+c2);
        System.out.println("c3="+c3);

    }
}
