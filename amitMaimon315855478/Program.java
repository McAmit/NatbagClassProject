package amitMaimon315855478;

import java.util.Scanner;

public class Program {

	final static int ADD_ARRIVAL = 1;
	final static int ADD_DEPARTURE = 2;
	final static int SHOW_ARRIVALS = 3;
	final static int SHOW_DEPARTURES = 4;
	final static int EXIT_MENU = 5;


	public static void main(String[] args) throws UserExceptions {
		ControlRoom ctrl=new ControlRoom();
		Scanner scan= new Scanner(System.in);
		int choice;
		do {
			choice=scan.nextInt();
			SwitchMenu(choice,ctrl,scan);
		} while (choice!=-1);
			
		
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

	private static void addArrival(Scanner scan,ControlRoom ctrl) throws UserExceptions {
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
		System.out.println("Terminal Number:");
		int terminal = scan.nextInt();
		System.out.println("Insert Estimated Time of Arrival by hours");
		double eta = scan.nextDouble();
		return new Flight(company, city, date, flightNum, terminal, eta);
	}
	@Test
	public void testAddFlight() {
		
	}

}
