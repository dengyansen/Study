package concurrent;

public class TestGenerics {
    public static void main(String[] args) {
//        Data<String> data = new Data<String>();
        Data data = new Data();
        data.set("1");
        System.out.println(data.get());
    }
    static class Data<T>{
        private T name ;
        void set(T t){
            this.name = t;
        }
        T get(){
          return  name;
        }
    }
}
