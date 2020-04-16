package designPatterns;

public class User {
	private String name;
	private String message;
	User(String name,String message ){
		this.name = name;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public String getMessage() {
		return message;
	}
}
