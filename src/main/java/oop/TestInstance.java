package oop;

public class TestInstance {
    /**
     * 其中 obj 为一个对象，Class 表示一个类或者一个接口，当 obj 为 Class 的对象，
     * 或者是其直接或 间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false。
     * 注意：编译器会检查 obj 是否能转换成右边的class类型，
     * 如果不能转换则直接报错，如果不能确定 类型，则通过编译，具体看运行时定。
     * @param args
     */
    public static void main(String[] args) {
        Integer i = 0;
        System.out.println(null instanceof Integer);
        i.intValue();
        System.out.println(new Integer("100"));
    }
}
