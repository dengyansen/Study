package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
	public static void main(String[] args) throws NoSuchMethodException {
		Sum call = new Sum();
		Method o = Sum.class.getMethod("sum",int.class,int.class);
		try {
			o.invoke(call,1,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(11);
	}
}
