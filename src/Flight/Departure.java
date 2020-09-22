package Flight;

public class Departure extends Flight {
	
	private final String OUT="Departuring: "; 

	public Departure(String company, String city, DateAndTime date, String flightNum, int terminal,
			int eta,eStatus stat) throws UserExceptions {
		super(company, city, date, flightNum, terminal, eta,stat);
		type="Departure";
	}
	public Departure(Flight fly) throws UserExceptions {
		super(fly);
	}

	public String toString() {
		return OUT+super.toString();
	}

}
