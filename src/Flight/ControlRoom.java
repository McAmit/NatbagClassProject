package Flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import Flight.Flight.eStatus;

import java.util.Comparator;
import java.util.List;

public class ControlRoom {
	static List<Flight> allFlights;
	List<Flight> sortedFlights;
	static ArrayList<Arrival> arrivals;
	static ArrayList<Departure> departures;

	public final int INPUTS_IN_PYTHON = 11, INITIAL_ARGS_NUM = 2;

	public ControlRoom() throws UserExceptions {
		allFlights = new ArrayList<Flight>();
		arrivals = new ArrayList<Arrival>();
		departures = new ArrayList<Departure>();
		hc();

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

	public static void addFlight(Flight fly) throws UserExceptions {
		allFlights.add(fly);
		Collections.sort(allFlights);

		String key = fly.getType();
		switch (key) {
		case "Departure":
			addDeparture(new Departure(fly));
			break;
		case "Arrival":
			addArrival(new Arrival(fly));
			break;
		default:
			break;
		}
	}

	public void showArrivals() {
		for (int i = 0; i < arrivals.size(); i++) {
			System.out.println(arrivals.get(i));
		}
	}

	public void showDepartures() {
		for (int i = 0; i < departures.size(); i++) {
			System.out.println(departures.get(i));
		}
	}

	private void hc() throws UserExceptions {
		DateAndTime date1 = new DateAndTime(2020, 10, 12, 4, 20);
		DateAndTime date2 = new DateAndTime(2020, 10, 15, 4, 20);
		DateAndTime date3 = new DateAndTime(2020, 10, 15, 4, 35);
		DateAndTime date4 = new DateAndTime(2020, 10, 15, 7, 20);
		DateAndTime date5 = new DateAndTime(2020, 10, 15, 4, 20);
		DateAndTime d1 = new DateAndTime(2020, 11, 1, 4, 20);
		DateAndTime d2 = new DateAndTime(2020, 11, 2, 4, 20);
		DateAndTime d3 = new DateAndTime(2020, 11, 3, 4, 35);
		DateAndTime d4 = new DateAndTime(2020, 11, 4, 7, 20);
		DateAndTime d5 = new DateAndTime(2020, 11, 4, 4, 20);
		DateAndTime d6 = new DateAndTime(2020, 12, 4, 4, 20);
		DateAndTime d7 = new DateAndTime(2020, 12, 4, 4, 20);
		DateAndTime d8 = new DateAndTime(2020, 12, 22, 4, 35);
		DateAndTime d9 = new DateAndTime(2020, 12, 22, 7, 20);
		DateAndTime d10 = new DateAndTime(2020, 12, 22, 4, 20);
		addFlight(new Arrival("El-Al", "Tel-Aviv", date5, "asd231245", 3, 4, eStatus.OnTime));
		addFlight(new Arrival("El-Al", "Tel-Aviv", date2, "AB7C123", 3, 5, eStatus.OnTime));
		addFlight(new Arrival("El-Al", "Tel-Aviv", date3, "A2B0C123", 3, 5, eStatus.OnTime));
		addFlight(new Arrival("El-Al", "Tel-Aviv", date1, "A93BC123", 3, 5, eStatus.OnTime));
		addFlight(new Arrival("El-Al", "Tel-Aviv", date4, "AB49C123", 3, 5, eStatus.Delayed));
		addFlight(new Arrival("El-Al", "Tel-Aviv", d1, "asd8231245", 3, 4, eStatus.Delayed));
		addFlight(new Arrival("El-Al", "Tel-Aviv", d2, "ABC8123", 3, 5, eStatus.Canceled));
		addFlight(new Departure("El-Al", "Athens", d3, "A2BC123", 2, 5, eStatus.OnTime));
		addFlight(new Departure("El-Al", "Athens", d4, "A3BC123", 4, 5, eStatus.OnTime));
		addFlight(new Departure("El-Al", "Athens", d5, "AB4C2123", 3, 5, eStatus.OnTime));
		addFlight(new Departure("El-Al", "Athens", d6, "asd231245", 1, 4, eStatus.Delayed));
		addFlight(new Departure("El-Al", "Rome", d7, "ABC123", 1, 5, eStatus.Delayed));
		addFlight(new Departure("El-Al", "Rome", d8, "A2B5C123", 3, 5, eStatus.OnTime));
		addFlight(new Departure("El-Al", "Rome", d9, "A3B3C123", 3, 5, eStatus.OnTime));
		addFlight(new Departure("El-Al", "Rome", d10, "A7B4C123", 3, 5, eStatus.Delayed));

	}

	public void searchArrivalsByDate(DateAndTime date1,DateAndTime date2) {
		for (int i = 0; i < arrivals.size(); i++) {
			if(arrivals.get(i).getDateAndTime().isBetweenTwoDates(date1, date2))
				System.out.println(arrivals.get(i));
		}
	}
	public void searchArrivalsByCity(String city) {
		for (int i = 0; i < arrivals.size(); i++) {
			if(arrivals.get(i).getCity().equalsIgnoreCase(city))
				System.out.println(arrivals.get(i));
		}
	}
	public void searchArrivalsByDateAndCity(DateAndTime date1,DateAndTime date2,String city) {
		for (int i = 0; i < arrivals.size(); i++) {
			if(arrivals.get(i).getDateAndTime().isBetweenTwoDates(date1, date2)&&arrivals.get(i).getCity().equalsIgnoreCase(city))
				System.out.println(arrivals.get(i));
		}
	}
	public void searchDeparturesByDate(DateAndTime date1,DateAndTime date2) {
		for (int i = 0; i < departures.size(); i++) {
			if(departures.get(i).getDateAndTime().isBetweenTwoDates(date1, date2))
				System.out.println(departures.get(i));
		}
	}
	public void searchDeparturesByCity(String city) {
		for (int i = 0; i < departures.size(); i++) {
			if(departures.get(i).getCity().equalsIgnoreCase(city))
				System.out.println(departures.get(i));
		}
	}
	public void searchDeparturesByDateAndCity(DateAndTime date1,DateAndTime date2,String city) {
		for (int i = 0; i < departures.size(); i++) {
			if(departures.get(i).getDateAndTime().isBetweenTwoDates(date1, date2)&&arrivals.get(i).getCity().equalsIgnoreCase(city))
				System.out.println(departures.get(i));
		}
	}

	public String setHtmlPage(String[] args, String classKind) throws NumberFormatException, UserExceptions {
		StringBuffer sb = new StringBuffer();
		createPage(sb, classKind);
		int flightsFound=0;
		if (args.length != INPUTS_IN_PYTHON) {
			System.out.println("URL Argument Incorrect, you have to have " + INPUTS_IN_PYTHON + " arguments in it.");
		} else {
			int argsNum;
			for (int i = 0; i < allFlights.size(); i++) {
				argsNum = INITIAL_ARGS_NUM;
				if (classKind.equals(allFlights.get(i).getClass().getSimpleName())) {
					if (allFlights.get(i).getCity().equalsIgnoreCase(args[argsNum])) {
						argsNum ++;
						if (allFlights.get(i).getCompany().equalsIgnoreCase(args[argsNum++])) {
							DateAndTime from, until;
							from = new DateAndTime(Integer.parseInt(args[argsNum]), Integer.parseInt(args[argsNum + 1]),
									Integer.parseInt(args[argsNum + 2]));
							argsNum += 3;
							until = new DateAndTime(Integer.parseInt(args[argsNum]),
									Integer.parseInt(args[argsNum + 1]), Integer.parseInt(args[argsNum + 2]));
							argsNum += 3;
							if (allFlights.get(i).getDateAndTime().isBetweenTwoDates(from, until)) {
								String check=allFlights.get(i).getDayInWeek();
								if (allFlights.get(i).getDayInWeek().equalsIgnoreCase(args[argsNum])) {
									addFlightRow(sb, i);
									flightsFound++;
								}
							}
						}
					}
				}
			}

		}
		endOfLoopHtml(sb,flightsFound);
		return sb.toString();
	}

	private void createPage(StringBuffer sb, String classKind) {
		String headline;
		if (classKind.equalsIgnoreCase("departure")) 
			headline="Departuring Flights:";
		else
			headline="Arriving Flights:";
		
		sb.append(
				"<table style=\"height: 154px; background-color: lightblue; margin-left: auto; margin-right: auto;\" border=\"15\" width=\"686\"><caption>"
						+ "		<h1><span style=\"color: #ffcc00;\"><em><span style=\"text-decoration: underline;\"><strong>"+headline+"</strong></span></em></span></h1>"
						+ "		</caption>" + "		<tbody>" + "		<tr style=\"height: 83.6px;\">"
						+ "		<td style=\"width: 104.8px; height: 83.6px; text-align: center;\"><span style=\"color: #ff0000;\"><strong>Flight Number</strong></span></td>"
						+ "		<td style=\"width: 107.2px; height: 83.6px; text-align: center;\"><span style=\"color: #ff0000;\"><strong>Company</strong></span></td>"
						+ "		<td style=\"width: 107.2px; height: 83.6px; text-align: center;\"><span style=\"color: #ff0000;\"><strong>Arriving to</strong></span></td>"
						+ "		<td style=\"width: 108.8px; height: 83.6px; text-align: center;\"><span style=\"color: #ff0000;\"><strong>Time</strong></span></td>"
						+ "		<td style=\"width: 109.6px; height: 83.6px; text-align: center;\"><span style=\"color: #ff0000;\"><strong>Terminal</strong></span></td>"
						+ "		<td style=\"width: 111.2px; height: 83.6px; text-align: center;\"><span style=\"color: #ff0000;\"><strong>Status</strong></span></td></tr>");
	}

	private void addFlightRow(StringBuffer sb, int index) {
		sb.append("<tr style=\"height: 71.1px;\">"
				+ "<td style=\"width: 104.8px; height: 71.1px; text-align: center;\"><span style=\"color: #ffff00;\">"
				+ allFlights.get(index).getFlightNum() + "</span></td>"
				+ "<td style=\"width: 107.2px; height: 71.1px; text-align: center;\"><span style=\"color: #ffff00;\">"
				+ allFlights.get(index).getCompany() + "</span></td>"
				+ "<td style=\"width: 107.2px; height: 71.1px; text-align: center;\"><span style=\"color: #ffff00;\">"
				+ allFlights.get(index).getCity() + "</span></td>"
				+ "<td style=\"width: 108.8px; height: 71.1px; text-align: center;\">"
				+ "<p><span style=\"color: #ffff00;\">" + allFlights.get(index).getDateAndTime().showDateInPage()
				+ "</span></p>" + "</td>"
				+ "<td style=\"width: 109.6px; height: 71.1px; text-align: center;\"><span style=\"color: #ffff00;\">"
				+ allFlights.get(index).getTerminal() + "</span></td>"
				+ "<td style=\"width: 111.2px; height: 71.1px; text-align: center;\"><span style=\"color: #ffff00;\">"
				+ allFlights.get(index).getStatus().toString() + "</span></td>" + "</tr>");
	}

	private void endOfLoopHtml(StringBuffer sb,int flightsFound) {
		sb.append("</tbody>"
				+"</table>"
				+"<p>"+flightsFound+" Flights has been found</p>");

	}

}
