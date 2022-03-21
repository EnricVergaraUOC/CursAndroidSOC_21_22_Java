package Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Client {
	private String name;
	private ArrayList<Invoice> invoices;
	
	Client (String name){
		this.name = name;
		invoices = new ArrayList<Invoice>();
	}
	
	public int getTotalImport() {
		int totalImport = 0;
		for(Invoice invoice: invoices) {
			totalImport += invoice.getAmount();
		}
		return totalImport;
	}
	
	public void addNewInvoice(Invoice newInvoice) {
		invoices.add(newInvoice);
		SortElements();
	}
	
	private void SortElements() {
		Collections.sort(invoices, new Comparator<Invoice>(){
		     public int compare(Invoice s1, Invoice s2){
		         return s1.isLessThan(s2);
		    	 
		     }
		});
	}
	
	public String toString () {
		String info = "Client: " + this.name + "\n";
		for (Invoice invoice: invoices) {
			info += invoice.toString() + "\n";
		}
		

		return info;
	}
	
	
}
