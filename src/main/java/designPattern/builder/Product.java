package designPattern.builder;

/**
 * Product
 *  产品（房子）
 */
public class Product {
    private int age;
    private Product(){

    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String name;
    private String sex;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("age:");
        builder.append(age);
        builder.append("name:");
        builder.append(name);
        builder.append("sex:");
        builder.append(sex);
        return builder.toString();
    }
}