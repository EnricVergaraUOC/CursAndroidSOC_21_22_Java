package Code;

import java.util.ArrayList;
import java.util.Date;

public class SpecimenManager {
	private ArrayList<Specimen> specimens;
	
	SpecimenManager(){
		specimens = new ArrayList<Specimen>();
	}
	
	SpecimenManager removePreviousThanDate (Date date) {
		SpecimenManager previous = new SpecimenManager();
		for(Specimen s: specimens) {
			//si el la data de s es previa a la "date"-->
			previous.addSpecimen(s);
			specimens.remove(s);
		}
		
		return previous;
	}
	public void addSpecimen(Specimen sp) {
		specimens.add(sp);
	}
	
	public String toString() {
		String info = "Espècies:\n";
		info += "---------\n";
		for(Specimen s: specimens) {
			info+= s.toString() + "\n";
		}
		return info;
	}
}
