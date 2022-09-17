package designPattern.builder;


public class Test {
    public static void main(String[] args) {
        Product product = new ConcreteBuilder().buildAge(11).buildSex("女").buildName("lix").getProduct();
        System.out.println(product.toString());
    }
}