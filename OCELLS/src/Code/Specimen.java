package Code;

import java.util.ArrayList;
import java.util.Date;

public class Specimen {
	private String	name;
	private int		numOfSightings;
	private Date	latestDate;
	
	Specimen(String name, int numOfSightings, Date latestDate){
		this.name = name;
		this.latestDate = latestDate;
		this.numOfSightings = numOfSightings;
	}
	
	public String toString() {
		String info = "";
		info += "{ Nom: " + this.name;
		info += ", Nombre Obs.: " + this.numOfSightings;
		info += ", Data Obs. més recent: " + this.latestDate.toString();
		info += "}"; 
		return info;
	}
	
	public int compare(Specimen sp) {
		return this.name.compareTo(sp.name);
	}
	
	public boolean areSameType(Specimen sp) {
		return (this.name.compareTo(sp.name) == 0);
	}
	
	public void update(Specimen sp) {
		this.numOfSightings += sp.numOfSightings;
		if (this.latestDate.before(sp.latestDate)) {
			this.latestDate = sp.latestDate;
		}
	}
	
}
