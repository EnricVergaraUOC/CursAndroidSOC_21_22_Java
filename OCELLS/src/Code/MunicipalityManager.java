package Code;

import java.util.ArrayList;

public class MunicipalityManager {
	private ArrayList<Municipality> municipalities;
	
	MunicipalityManager(){
		municipalities = new ArrayList<Municipality>();
	}
	
	public void addMunicipality(Municipality m) {
		municipalities.add(m);
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
