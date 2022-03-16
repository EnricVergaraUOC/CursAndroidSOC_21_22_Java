package Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public class SpecimenManager {
	private ArrayList<Specimen> specimens;
	
	SpecimenManager(){
		specimens = new ArrayList<Specimen>();
	}
	
	SpecimenManager removePreviousThanDate (Date date) {
		SpecimenManager previous = new SpecimenManager();
		
		Iterator<Specimen> it = specimens.iterator();
		while (it.hasNext()) {
			Specimen s = it.next();
			if (s.isPrevious(date)) {
				previous.addSpecimen(s);
				it.remove();	
			}
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
			SortElements();
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
	
	private void SortElements() {
		Collections.sort(specimens, new Comparator<Specimen>(){
		     public int compare(Specimen s1, Specimen s2){
		         return s1.compare(s2);
		    	 
		     }
		});
	}
}
