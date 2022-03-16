package Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MunicipalityManager {
	private ArrayList<Municipality> municipalities;
	
	MunicipalityManager(){
		municipalities = new ArrayList<Municipality>();
	}
	
	public void addMunicipality(Municipality m) {
		boolean found = false;
		int i = 0;
		while( !found &&  i <municipalities.size() ) {
			if (municipalities.get(i).isSameMunicipality(m)) {
				found = true;
				municipalities.get(i).update(m);
			}else {
				i++;
			}
		}
		if (!found) {
			municipalities.add(m);
			SortElements();
		}
		
	}
	
	public String toString() {
		String info = "Municipis:\n";
		info += "---------\n";
		for(Municipality m: municipalities) {
			info+= m.toString() + "\n";
		}
		return info;
	}
	
	private void SortElements() {
		Collections.sort(municipalities, new Comparator<Municipality>(){
		     public int compare(Municipality s1, Municipality s2){
		         return s1.compare(s2);
		    	 
		     }
		});
	}
}
