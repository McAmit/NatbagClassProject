package amitMaimon315855478;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class Program {
	
	ArrayList<Flight>arrivals,departures,allFlights;
	final static int ADD_ARRIVAL = 1;
	final static int ADD_DEPARTURE = 2;
	final static int SHOW_ARRIVALS = 3;
	final static int SHOW_DEPARTURES = 4;
	final static int EXIT_MENU = 5;

	public static void main(String[] args) throws UserExceptions, IOException {
		DateAndTime date1=new DateAndTime(2020, 8, 12, 4, 20);
		DateAndTime date2=new DateAndTime(2020, 9, 15, 4, 20);
		DateAndTime date3=new DateAndTime(2020, 9, 15, 4, 35);
		DateAndTime date4=new DateAndTime(2020, 9, 15, 7, 20);
		DateAndTime date5=new DateAndTime(2020, 10, 22, 4, 20);
		ControlRoom ctrl = new ControlRoom();
		Scanner scan = new Scanner(System.in);
		File departures = new File("C:/Checker/departures.txt");
		PrintWriter pw = new PrintWriter(departures);
		pw.close();
		System.out.println(
				" 1 -> for Adding an Arriving Flight \n 2-> for Adding a Departing Flight \n"
				+ " 3-> for Showing Arrivals \n 4-> for Showing Departures \n Any other key to quit.");
		ctrl.addArrival(new Arrival("El-Al", "Tel-Aviv", date5,"asd231245",3,4));
		ctrl.addArrival(new Arrival("El-Al","Tel-Aviv",date2,"ABC123",3,5));
		ctrl.addArrival(new Arrival("El-Al","Tel-Aviv",date3,"A2BC123",3,5));
		ctrl.addArrival(new Arrival("El-Al","Tel-Aviv",date1,"A3BC123",3,5));
		ctrl.addArrival(new Arrival("El-Al","Tel-Aviv",date4,"AB4C123",3,5));
		
		ctrl.showArrivals();
		
		Flight flu=new Arrival("El-Al","Tel-Aviv",date4,"AB4C123",3,5);


	}

	private static void SwitchMenu(int choice, ControlRoom ctrl, Scanner scan) throws UserExceptions {
		switch (choice) {
		case ADD_ARRIVAL:
			addArrival(scan, ctrl);
			break;
		case ADD_DEPARTURE:
			addDeparture(scan, ctrl);
			break;

		case SHOW_ARRIVALS:

			break;

		case SHOW_DEPARTURES:

			break;
		case EXIT_MENU:

		default:
			break;
		}

	}

	private static void addDeparture(Scanner scan, ControlRoom ctrl) throws UserExceptions {
		System.out.println("You chose to add a Departure flight: \n Insert company name:");
		ctrl.addDeparture(new Departure(addFlight(scan)));
		System.out.println("Departure has been added.");
	}

	private static void addArrival(Scanner scan, ControlRoom ctrl) throws UserExceptions {
		System.out.println("You chose to add an Arrival flight: \n Insert company name:");
		ctrl.addArrival(new Arrival(addFlight(scan)));
		System.out.println("Departure has been added.");
	}

	private static Flight addFlight(Scanner scan) throws UserExceptions {
		String company = scan.nextLine();
		System.out.println("Insert City");
		String city = scan.nextLine();
		System.out.println("Insert Date and Time: (Year Month Day Hour Minutes)");
		DateAndTime date = new DateAndTime(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(),
				scan.nextInt());
		System.out.println("Insert Flight Number:");
		String flightNum = scan.next();
		System.out.println("Terminal Num	ber:");
		int terminal = scan.nextInt();
		System.out.println("Insert Estimated Time of Arrival by hours");
		double eta = scan.nextDouble();
		return new Flight(company, city, date, flightNum, terminal, eta);
	}

	@Test
	public void testAddFlight() {

	}

}
