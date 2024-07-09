package staticClass;

public class AboutStaticFiled {
	static String a = "1";
	static {
		System.out.println(111);
	}

	public static void main(String[] args) {
		new AboutStaticFiled();
		new AboutStaticFiled();
	}
}
