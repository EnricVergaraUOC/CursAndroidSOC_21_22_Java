package Code;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {
	public static void main(String args[]) {
		/*
		//Examen 1:
		ArrayList<Client> clients = new ArrayList<Client>();
		Client newClient1 = new Client ("Client1");
		Client newClient2 = new Client ("Client2");
		
		llegeixFacturesClient(newClient1, "client1.txt");
		llegeixFacturesClient(newClient2, "client2.txt");
		clients.add(newClient1);
		clients.add(newClient2);
		
		escriuDadesClients(clients);
		System.out.println(newClient1.getTotalImport());
		*/
	}
	
	public static void escriuDadesClients(ArrayList<Client> clients) 
	{
		for (Client client: clients) {
			System.out.println(client.toString());
		}
	}
	
	public static void llegeixFacturesClient(Client c, String pathFile) {
		
		try {
			String s_date = "";
			String s_amount = "";
			String s_description = "";
			BufferedReader in;
			in = new BufferedReader (new FileReader(pathFile));
			while((s_date = in.readLine()) != null) {
				s_amount = in.readLine();
				s_description = in.readLine();
				int amount = 0;
				Date d = new Date();
				try{
			            amount = Integer.parseInt(s_amount);
			            String[] parts = s_date.split(" ");
			            int year = Integer.parseInt(parts[0]) - 1900;
						int month = Integer.parseInt(parts[1]) - 1;
						int day = Integer.parseInt(parts[2]);
						d = new Date(year, month, day);
			    }catch (NumberFormatException ex){
			            ex.printStackTrace();
			    }
				Invoice newInvoice = new Invoice(d, s_description, amount);
				c.addNewInvoice(newInvoice);
				
			}
				
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
