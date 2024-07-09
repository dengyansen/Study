package concurrent;
import java.util.concurrent.Callable;
public final class Rests {


    private Rests(){};

    private static DefaultHandler defaultHanlder = new DefaultHandler();


    /**
     * 执行服务调用，并判断返回状态
     * @param callable
     * @return
     */
    public static <T> T exc(Callable<T> callable){
        return exc(callable, defaultHanlder);
    }

    public static <T> T exc(Callable<T> callable,ResultHandler handler){
        T result = sendReq(callable);
        return handler.handle(result);
    }

    public static String toUrl(String serviceName,String path){
        return "http://" + serviceName + path;
    }

    public static class DefaultHandler implements ResultHandler {

        @Override
        public <T> T handle(T result) {
            System.out.println("hand result"+result.toString());
            return result;
        }

    }

    public interface ResultHandler{
        <T> T handle(T result);
    }

    public static <T> T sendReq(Callable<T> callable){
        T result = null;
        try {
            result = callable.call();
        } catch (Exception e){
            System.out.println(e.getCause().getMessage());
            return null;
        }
        return result;

    }


}
