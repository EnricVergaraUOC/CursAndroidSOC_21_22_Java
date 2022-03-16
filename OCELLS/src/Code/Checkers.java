package Code;

import java.util.Date;
import java.io.*;
public class Checkers {
	public static void main(String args[]) {
		
		SpecimenManager specimens = new SpecimenManager();
		MunicipalityManager municipalities = new MunicipalityManager();
		
		BufferedReader in;
		String currentLine = "";
		
		try {
			String s_specimen_name = "";
			String s_municipality_name = "";
			String s_numOfSightings = "";
			String s_date = "";
			in = new BufferedReader (new FileReader("dades-5.txt"));
			while((s_specimen_name = in.readLine()) != null) {
				s_municipality_name = in.readLine();
				s_numOfSightings = in.readLine();
				s_date = in.readLine();
				
				//System.out.println(-ntLine);
				int numSights=Integer.parseInt(s_numOfSightings);
				String[] parts = s_date.split(" ");
				int year = Integer.parseInt(parts[0]) - 1900;
				int month = Integer.parseInt(parts[1]) - 1;
				int day = Integer.parseInt(parts[2]);
				Date d = new Date(year, month, day);
				Specimen specimen = 
						new Specimen(
								s_specimen_name,
								numSights,
								d
								);
				specimens.addSpecimen(specimen);
				
				Municipality municipality = new Municipality (
						s_municipality_name,
						numSights); 
				municipalities.addMunicipality(municipality);		
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(municipalities);
		System.out.println(specimens);
		/*
		boolean endOfFile = false;
		while (!endOfFile) {
			//Leer las lineas para crear un specimen
			String name;
			String municipality;
			int numOfSightings;
			Date latestDate;
			//TODO la lectura de estos parámetros
			Specimen newSpecimen = new Specimen(name,numOfSightings, latestDate);
			specimens.addSpecimen(newSpecimen);
			Municipality newMunicipality = new Municipality(name, numOfSightings);
			municipalities.addMunicipality(newMunicipality);
		}
		System.out.println("Totes les espècies observades són:");
		System.out.println(specimens.to_String());
		System.out.println("Tots els municipis amb espècies observades són:");
		System.out.println(municipalities.to_String());
		
		Date newDate;
		//Llegir del teclar la data..
		
		//-Eliminar del manager les espècies amb data anterior a la passada
		//per argument
		SpecimenManager specimens_previous =  specimens.removePreviousThanDate(newDate);
		
		System.out.println("Totes les espècies observades amb data prèvia a date:");
		System.out.println(specimens_previous.to_String());
		System.out.println("Totes les espècies observades amb data posterior a date:");
		System.out.println(specimens.to_String());
		
		
		//specimens_previous.mostraOrdCronol();
		*/
		 
	}
	
}
