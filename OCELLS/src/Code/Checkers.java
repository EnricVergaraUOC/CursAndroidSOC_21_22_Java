package Code;

import java.util.Date;

public class Checkers {
	public static void main(String args[]) {
		
		SpecimenManager specimens = new SpecimenManager();
		MunicipalityManager municipalities = new MunicipalityManager();
		
		
		Specimen sp1 = new Specimen("pajarrako", 66, new Date(2066,12,66));
		Specimen sp2 = new Specimen("pajaro loco", 33, new Date(2011,12,12));
		specimens.addSpecimen(sp1);
		specimens.addSpecimen(sp2);
		System.out.println(specimens);
		
		/*
		System.out.println("hola mundo");
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
