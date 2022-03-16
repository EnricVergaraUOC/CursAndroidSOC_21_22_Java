package Code;

import java.util.ArrayList;

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
	
}
