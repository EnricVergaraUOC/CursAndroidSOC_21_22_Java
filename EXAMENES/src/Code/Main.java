package Code;
import java.io.*;
import java.util.Date;

public class Main {
	public static void main(String args[]) {
		Date date = new Date(2000-1900, 1,1);
		Invoice newInvoice = new Invoice(date,"la dolorosa", 10000);
		System.out.println(newInvoice.getDate());
		
	}
	
	
}
