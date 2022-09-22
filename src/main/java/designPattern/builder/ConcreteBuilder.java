package designPattern.builder;

public class ConcreteBuilder extends Builder {
    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    ConcreteBuilder buildName(String name) {
        product.setName(name);
        return this;
    }

    @Override
    ConcreteBuilder buildSex(String sex) {
        product.setSex(sex);
        return this;
    }

    @Override
    ConcreteBuilder buildAge(int age) {
        product.setAge(age);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}