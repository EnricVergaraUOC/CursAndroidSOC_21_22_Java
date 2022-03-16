package Code;

import java.util.Date;

public class Municipality {
	private String	name;
	private int		numOfSightings;
	
	Municipality(String name, int numOfSightings){
		this.name = name;
		this.numOfSightings = numOfSightings;
	}
	
	public String toString() {
		String info = "";
		info += "{ Nom: " + this.name;
		info += ", Nombre Obs.: " + this.numOfSightings;
		info += "}"; 
		return info;
	}
	
	public int compare(Municipality m) {
		return this.name.compareTo(m.name);
	}
	
	public boolean isSameMunicipality(Municipality m) {
		return (this.name.compareTo(m.name) == 0);
	}
	public void update(Municipality sp) {
		this.numOfSightings += sp.numOfSightings;
	}
	
}
