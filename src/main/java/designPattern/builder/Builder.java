package designPattern.builder;

/**
 * Builder.java
 * 建造者
 */
abstract class Builder {
    abstract ConcreteBuilder buildName(String name);

    abstract ConcreteBuilder buildSex(String sex);

    abstract ConcreteBuilder buildAge(int age);

    abstract Product getProduct();
}