package Code;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Trip {
	private String image;
	private Date initDate;
	private String description;
	private ArrayList<User> users;
	private ArrayList<Expense> expenses;
	
	Trip(String image, Date initDate, String description){
		this.image = image;
		this.initDate = initDate;
		this.description = description;
		users = new ArrayList<User>();
		expenses = new ArrayList<Expense>();
	}
	
	public void AddNewUser (User user) {
		users.add(user);
	}
	
	public void AddNewExpense (Expense expense) {
		expenses.add(expense);
	}
	
	public int CalculateSummary () {
		int totalAmount = 0;
		for(Expense expense: expenses) {
			totalAmount += expense.getAmount();
			for(User user: users) {
				Integer amount = expense.getAmountSpentByUser(user.getName());
				if ( amount != null) {
					user.AddAmountSpent(amount);	
				}
			}
		}
		
		return totalAmount;
	}
	
	
	public String toString () {
		String info = "";
		info += "{";
		info += "\n - Description: " + this.description;
		info += "\n - Init Date: " + this.getDate();
		info += "\n - Users: ";
		for(User user: users) {
			info += "\n\t " + user.toString();
		}
		info += "\n - Expenses: ";
		for(Expense expense: expenses) {
			info += "\n\t " + expense.toString();
		}
		return info;
	}
	
	private String getDate () {
		String date = "";
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		date = formatter.format(this.initDate);
		
		return date;
	}
}
