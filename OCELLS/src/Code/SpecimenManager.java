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
		boolean found = false;
		int i = 0;
		while( !found &&  i <specimens.size() ) {
			if (specimens.get(i).areSameType(sp)) {
				found = true;
				specimens.get(i).update(sp);
			}else {
				i++;
			}
		}
		if (!found) {
			specimens.add(sp);	
		}
		
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
