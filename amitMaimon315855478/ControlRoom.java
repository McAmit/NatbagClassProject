package amitMaimon315855478;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.util.List;

public class ControlRoom {
	List<Flight> allFlights,sortedFlights;
	static ArrayList<Arrival> arrivals;
	static ArrayList<Departure> departures;

	public ControlRoom() {
		allFlights=new ArrayList<Flight>();
		arrivals = new ArrayList<Arrival>();
		departures=new ArrayList<Departure>();
		
	}
	
	
	
	private static boolean addArrival(Arrival arvl) {
		arrivals.add(arvl);
		Collections.sort(arrivals);
		return true;
	}
	private static boolean addDeparture(Departure dep) {
		departures.add(dep);
		Collections.sort(departures);
		return true;
	}
	public void addFlight(Flight fly) {
		allFlights.add(fly);
		sortedFlights=sort(allFlights);
	
		String key=fly.getType();
		switch (key) {
		case "Departure":
			break;
		case "Arrival":
			
			break;
		default:
			break;
		}
	}
	public void showArrivals() {
		//List<Arrival> showArr=sort(arrivals);
		for (int i = 0; i < arrivals.size(); i++) {
			System.out.println(arrivals.get(i));
		}
	}
	public void showDepartures() {
		for (int i = 0; i < departures.size(); i++) {
			System.out.println(departures.get(i));
		}
	}
	private static List<Flight> sort(List<Flight>listToSort){
		List<String> dates=new ArrayList<>();
		for (int i = 0; i < listToSort.size(); i++) {
			dates.add(listToSort.get(i).getDateAndTime().toString());
		}
		dates.sort(Comparator.naturalOrder());
		List<Flight>sortedList=new ArrayList<>();
		for (int i = 0; i < dates.size(); i++) {
			for (int j = 0; j < listToSort.size(); j++) {
				if(dates.get(i).equals(listToSort.get(j).getDateAndTime().toString())) {
					sortedList.add(listToSort.get(j));
					break;
				}
			}
		}
		return sortedList;
	}
	
	
}
