package Flight;

public class Arrival extends Flight {

	private final String IN="Arriving: ";
	
	
	public Arrival(String company, String city, DateAndTime date, String flightNum, int terminal,
			int eta,eStatus stat) throws UserExceptions {
		super(company, city, date, flightNum, terminal, eta, stat);
		type="Arrival";
	}
	public Arrival(Flight fly) throws UserExceptions {
		super(fly);
	}
	
	public String toString() {
		return IN+super.toString();
	}
	
	

}
