package Code;

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
	
	public String to_String() {
		String info = "";
		//TODO
		return info;
	}
	
	public boolean isGreater(Specimen sp) {
		boolean isGreater = false;
		//TODO
		return isGreater;
	}
	
	public void update(Specimen sp) {
		//TODO
	}
	
}
