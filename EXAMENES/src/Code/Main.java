package Code;
import java.io.*;
import java.util.Date;

public class Main {
	public static void main(String args[]) {
		Date date = new Date(2000-1900, 1,1);
		Invoice newInvoice1 = new Invoice(date,"la dolorosa", 10000);
		Invoice newInvoice2 = new Invoice(date,"la dolorosa2", 20000);
		Date date2 = new Date(1989-1900, 1,1);
		Invoice newInvoice3 = new Invoice(date2,"abcd", 100);
		Client client = new Client("Enric");
		client.addNewInvoice(newInvoice1);
		client.addNewInvoice(newInvoice2);
		client.addNewInvoice(newInvoice3);
		System.out.println(client.toString());
		
	}
	
	
}
