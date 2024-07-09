package serializableStudy;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Receiver {
        public static void main(String[] args) throws Exception {
            // 从 test.txt反序列化
            FileInputStream fis = new FileInputStream("test.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            DataClass g = (DataClass)ois.readObject();
            System.out.println(g.age);
        }
}
