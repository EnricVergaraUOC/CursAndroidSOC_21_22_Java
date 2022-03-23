package Code;

import java.util.Date;

public class AppManager {
	
	
	
	
	
	public static void main(String args[]) {
		Expense expense = new Expense("rest. ca la pagesa", 100, new Date(2010-1900,1,1));
		expense.AddNewPayer("Enric", 50);
		expense.AddNewPayer("Jose Miguel", 50);
		System.out.println(expense.toString());
		
		User user1 = new User("Enric", "evergaraca@uoc.edu", null);
		System.out.println(user1);
	}
}
