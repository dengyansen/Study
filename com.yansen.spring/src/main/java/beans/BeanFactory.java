package beans;

import web.mvc.Controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
    private static Map<Class<?>,Object> classToBean = new ConcurrentHashMap<>();
    public static Object getBean(Class<?> cls){
        return classToBean.get(cls);
    }
    public static void initBean(List<Class<?>> classList) throws Exception {
        List<Class<?>> toCreate = new ArrayList<>(classList);
        while (toCreate.size() != 0){
            int remainSize = toCreate.size();
            for(int i = 0;i<toCreate.size();i++){
                if(finishCreate(toCreate.get(i))){
                    toCreate.remove(i);
                }
            }
            if(toCreate.size() == remainSize){
                // TODO: 2021/1/20  
                throw new Exception("cycle dependency!");
            }
        }
    }

    private static boolean finishCreate(Class<?> aClass) throws IllegalAccessException, InstantiationException {
        if(!aClass.isAnnotationPresent(Bean.class) && !aClass.isAnnotationPresent(Controller.class)){
            return true;
        }
        Object bean = aClass.newInstance();
        for(Field field : aClass.getDeclaredFields()){
            if(field.isAnnotationPresent(AutoWired.class)){
                Class<?> fieldType = field.getType();
                Object reliantBean = BeanFactory.getBean(fieldType);
                if(reliantBean == null){
                    return false;
                }
                field.setAccessible(true);
                field.set(bean,reliantBean);
            }
            classToBean.put(aClass,bean);
        }
        return true;
    }
}
