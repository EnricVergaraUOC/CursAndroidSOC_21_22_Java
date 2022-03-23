package Code;

public class User {
	private String name;
	private String email;
	private String image;
	
	User (String name, String email, String image){
		this.name = name;
		this.email = email;
		this.image = image;
	}
	
	public String toString() {
		String info = "";
		info += "{ Name: " + this.name;
		info += ", Email: " + this.name;
		info += "}";
		return info;
	}
}
