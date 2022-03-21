package Code;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
	private Date date;
	private String description;
	private int amount;
	private static int id = 0;
	private int invoiceID;
	
	Invoice(Date date, String description, int amount){
		this.date = date;
		this.description = description;
		this.invoiceID = id;
		this.amount = amount;
		id++;
		
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public int isLessThan(Invoice i) {
		int isLess = 0;
		if (this.date.before(i.date)) {
			isLess = -1;
		}else if (i.date.before(this.date)) {
			isLess = 1;
		}else {
			if (this.amount < i.amount) {
				isLess = -1;
			}else if (this.amount > i.amount) {
				isLess = 1;
			}else {
				isLess = 0;
			}
		}
		
		return isLess;
	}
	
	public String getDate () {
		String date = "";
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		date = formatter.format(this.date);
		
		return date;
	}
	
	public String toString () {
		String info = "";
		info += "{ ID: "+ this.invoiceID + ", Description: " + this.description;
		info += ", Amount: " + this.amount + ", Date: " + getDate() + "}";
		return info;
	}
	
}
