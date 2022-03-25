package Code;

import java.util.Date;



public class AppManager {
	
	public static void main(String args[]) {
		Expense expense = new Expense("rest. ca la pagesa", 100, new Date(2010-1900,2,1));
		expense.AddNewPayer("Enric", 50);
		expense.AddNewPayer("Jose Miguel", 50);
		
		
		User user1 = new User("Enric", "evergaraca@uoc.edu", null);
		User user2 = new User("Jose Miguel", "jm@uoc.edu", null);
		
		Trip newTrip = new Trip(null, new Date(2010-1900,1,1),"la volta al món");
	
		String json = newTrip.Serialize();
		
		
		newTrip.AddNewUser(user1);
		newTrip.AddNewUser(user2);
		newTrip.AddNewExpense(expense);
		System.out.println(newTrip.toString());
		
		System.out.println(newTrip.GetUserNames());
	}
}
