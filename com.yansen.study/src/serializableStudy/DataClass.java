package serializableStudy;
import java.io.Serializable;
//必须实现Serializable接口，不然抛出NotSerializableException
public class DataClass implements Serializable {
        // 自定义 SerialVersionUID
        private static final long serialVersionUID = 20000L;
        String name = "sun";
        int age = 21;
}
