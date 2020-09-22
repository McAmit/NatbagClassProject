package Flight;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import Flight.Flight.eStatus;

public class Program {
	
	ArrayList<Flight>arrivals,departures,allFlights;
	final static int ADD_ARRIVAL = 1;
	final static int ADD_DEPARTURE = 2;
	final static int SHOW_ARRIVALS = 3;
	final static int SHOW_DEPARTURES = 4;
	final static int SEARCH_ARRIVAL_BY_CITY=5;
	final static int SEARCH_ARRIVAL_DATE_TO_DATE=6;
	final static int SEARCH_ARRIVAL_DATE_TO_DATE_AND_CITY=7;
	final static int SEARCH_DEPARTURE_BY_CITY=8;
	final static int SEARCH_DEPARTURE_DATE_TO_DATE=9;
	final static int SEARCH_DEPARTURE_DATE_TO_DATE_AND_CITY=10;
	final static int WRITE=11;
	final static int READ=12;
	final static int EXIT_MENU = 15;//doesnt matter

	public static void main(String[] args) throws UserExceptions, IOException {
		ControlRoom ctrl = new ControlRoom();
		Scanner scan = new Scanner(System.in);
	//	File departures = new File("C:/Checker/departures.txt");
	//	PrintWriter pw = new PrintWriter(departures);
	//	pw.close();
		int choice;
		boolean isHtml= args.length > 0 && args[0].equalsIgnoreCase("html");
		if (isHtml) {
			boolean isDepartures= args.length > 1 && args[1].equalsIgnoreCase("Departure");
			String htmlPage;
			if (isDepartures) {
				htmlPage=ctrl.setHtmlPage(args, Departure.class.getSimpleName());	
			}
			else {
				htmlPage=ctrl.setHtmlPage(args, Arrival.class.getSimpleName());
			}
			System.out.println(htmlPage);
		} else {
			showMenu();
			boolean didHeExited=false;
			while (!didHeExited) {
				choice=scan.nextInt();
				SwitchMenu(choice, ctrl, scan,didHeExited);
				showMenu();
			}
		}
		
	}

	private static void SwitchMenu(int choice, ControlRoom ctrl, Scanner scan,boolean didHeExited) throws UserExceptions {
		switch (choice) {
		case ADD_ARRIVAL:
			
			addArrival(scan, ctrl);
			break;
		case ADD_DEPARTURE:
			addDeparture(scan, ctrl);
			break;

		case SHOW_ARRIVALS:
			ctrl.showArrivals();
			break;

		case SHOW_DEPARTURES:
			ctrl.showDepartures();
			break;
		case SEARCH_ARRIVAL_BY_CITY:
			searchArByCity(scan, ctrl);
			break;
		case SEARCH_ARRIVAL_DATE_TO_DATE:
			searchArByDate(scan, ctrl);
			break;
		case SEARCH_ARRIVAL_DATE_TO_DATE_AND_CITY:
			searchArByCityAndDate(scan, ctrl);
			break;
		case SEARCH_DEPARTURE_BY_CITY:
			searchDepByCity(scan, ctrl);
			break;
		case SEARCH_DEPARTURE_DATE_TO_DATE:
			searchDepByDate(scan, ctrl);
			break;
		case SEARCH_DEPARTURE_DATE_TO_DATE_AND_CITY:
			searchDepByCityAndDate(scan, ctrl);
			break;
		case WRITE:
			
			break;
		case READ:
			
			break;
		case EXIT_MENU:
			didHeExited=true;
		default:
			break;
		}

	}

	private static void addDeparture(Scanner scan, ControlRoom ctrl) throws UserExceptions {
		System.out.println("You chose to add a Departure flight: \n Insert company name:");
		ctrl.addFlight(new Departure(addFlight(scan)));
		System.out.println("Departure has been added.");
	}

	private static void addArrival(Scanner scan, ControlRoom ctrl) throws UserExceptions {
		System.out.println("You chose to add an Arrival flight: \n Insert company name:");
		ctrl.addFlight(new Arrival(addFlight(scan)));
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
		System.out.println("Terminal Number:");
		int terminal = scan.nextInt();
		System.out.println("Insert Estimated Time of Arrival by hours");
		double eta = scan.nextDouble();
		return new Flight(company, city, date, flightNum, terminal, eta,eStatus.OnTime);
	}
	private static void showMenu() {
		System.out.println(" 1 -> for Adding an Arriving Flight <-");
		System.out.println("2-> for Adding a Departing Flight <-");
		System.out.println("3-> for Showing All Arrivals <-");
		System.out.println("4-> for Showing All Departures <-");
		System.out.println("5-> to Search Arrivals By City <-");
		System.out.println("6-> to Search Arrivals By Date <-");
		System.out.println("7-> to Search Arrivals By both City and Date <-");
		System.out.println("8-> to Search Departures By City <-");
		System.out.println("9-> to Search Departures By Date <-");
		System.out.println("10-> to Search Departures By both City and Date <-");
		System.out.println("11-> to Save(write) all flights to txt file <-");
		System.out.println("12-> to load all flights from the file <-");
		System.out.println("*Any other key to Exit*");
	}
	private static void searchArByCity(Scanner scan,ControlRoom ctrl) {
		System.out.println("Enter A City name to search Arrivals with");
		String city=scan.next();
		ctrl.searchArrivalsByCity(city);
	}
	private static void searchArByDate(Scanner scan,ControlRoom ctrl) {
		System.out.println("Enter initial Year :");
		int year,month,day,toYear,toMonth,toDay;
		year=scan.nextInt();
		System.out.println("Enter initial Month");
		month=scan.nextInt();
		System.out.println("Enter initial Day");
		day=scan.nextInt();
		System.out.println("Enter final Year :");
		toYear=scan.nextInt();
		System.out.println("Enter final Month");
		toMonth=scan.nextInt();
		System.out.println("Enter final Day");
		toDay=scan.nextInt();
		try {
			DateAndTime date1=new DateAndTime(year, month, day);
			DateAndTime date2=new DateAndTime(toYear, toMonth, toDay);
			ctrl.searchArrivalsByDate(date1, date2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static void searchArByCityAndDate(Scanner scan,ControlRoom ctrl) {
		System.out.println("Enter A City name to search Arrivals with");
		String city=scan.next();
		System.out.println("Enter initial Year :");
		int year,month,day,toYear,toMonth,toDay;
		year=scan.nextInt();
		System.out.println("Enter initial Month");
		month=scan.nextInt();
		System.out.println("Enter initial Day");
		day=scan.nextInt();
		System.out.println("Enter final Year :");
		toYear=scan.nextInt();
		System.out.println("Enter final Month");
		toMonth=scan.nextInt();
		System.out.println("Enter final Day");
		toDay=scan.nextInt();
		try {
			DateAndTime date1=new DateAndTime(year, month, day);
			DateAndTime date2=new DateAndTime(toYear, toMonth, toDay);
			ctrl.searchArrivalsByDateAndCity(date1, date2, city);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static void searchDepByCity(Scanner scan,ControlRoom ctrl) {
		System.out.println("Enter A City name to search Departures with");
		String city=scan.next();
		ctrl.searchDeparturesByCity(city);
	}
	private static void searchDepByDate(Scanner scan,ControlRoom ctrl) {
		System.out.println("Enter initial Year :");
		int year,month,day,toYear,toMonth,toDay;
		year=scan.nextInt();
		System.out.println("Enter initial Month");
		month=scan.nextInt();
		System.out.println("Enter initial Day");
		day=scan.nextInt();
		System.out.println("Enter final Year :");
		toYear=scan.nextInt();
		System.out.println("Enter final Month");
		toMonth=scan.nextInt();
		System.out.println("Enter final Day");
		toDay=scan.nextInt();
		try {
			DateAndTime date1=new DateAndTime(year, month, day);
			DateAndTime date2=new DateAndTime(toYear, toMonth, toDay);
			ctrl.searchDeparturesByDate(date1, date2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static void searchDepByCityAndDate(Scanner scan,ControlRoom ctrl) throws UserExceptions {
		System.out.println("Enter A City name to search Departures with");
		String city=scan.next();
		System.out.println("Enter initial Year :");
		int year,month,day,toYear,toMonth,toDay;
		year=scan.nextInt();
		System.out.println("Enter initial Month");
		month=scan.nextInt();
		System.out.println("Enter initial Day");
		day=scan.nextInt();
		System.out.println("Enter final Year :");
		toYear=scan.nextInt();
		System.out.println("Enter final Month");
		toMonth=scan.nextInt();
		System.out.println("Enter final Day");
		toDay=scan.nextInt();
		try {
			DateAndTime date1=new DateAndTime(year, month, day);
			DateAndTime date2=new DateAndTime(toYear, toMonth, toDay);
			ctrl.searchDeparturesByDateAndCity(date1, date2, city);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Test
	public void testAddFlight() {

	}

}
