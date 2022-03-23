package Code;

public class User {
	private String name;
	private String email;
	private String image;
	private int amountSpent;
	
	
	
	User (String name, String email, String image){
		this.name = name;
		this.email = email;
		this.image = image;
		this.amountSpent = 0;
	}
	public String getName () {
		return this.name;
	}
	public void AddAmountSpent (int amount) {
		this.amountSpent+= amount;
	}
	
	public String toString() {
		String info = "";
		info += "{ Name: " + this.name;
		info += ", Email: " + this.name;
		info += "}";
		return info;
	}
}
