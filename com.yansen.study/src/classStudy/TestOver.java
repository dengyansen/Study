package classStudy;

public class TestOver {
     static abstract class Human{
    }
     static class  Man extends Human{

    }
     static class WoMan extends Human{

    }
    public void SayHello(Human human){
        System.out.println("human");
    }
    public void SayHello(Man man){
        System.out.println("man");
    }
    public void SayHello(WoMan human){
        System.out.println("woman");
    }

    public static void main(String[] args) {
        TestOver over = new TestOver();
        Human woman = new WoMan();
        Human man = new Man();
        over.SayHello(woman);
        over.SayHello(man);
        over.SayHello(new WoMan());
        over.SayHello(new Man());
    }
}
