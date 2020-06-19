package amitMaimon315855478;

import java.util.ArrayList;
import java.util.Scanner;

public class ControlRoom {
	ArrayList<Arrival> arrivals;
	ArrayList<Departure> departures;
	

	
	
	public ControlRoom() {
		arrivals = new ArrayList<Arrival>();
		departures=new ArrayList<Departure>();
		
	}
	
	public boolean addArrival(Arrival arvl) {
		arrivals.add(arvl);
		return true;
	}
	public boolean addDeparture(Departure dep) {
		departures.add(dep);
		return true;
	}
	
	
}
