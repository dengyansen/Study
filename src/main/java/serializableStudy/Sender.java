package SerializableStudy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sender {
    public static void main(String[] args) throws IOException {
        DataClass g = new DataClass();
        // 序列化到该文件，实际可能是序列化到远程服务器
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
        oos.writeObject(g);
        System.out.println("全路径:"+System.getProperty("user.dir")+"test.txt");
        oos.close();
    }
}
