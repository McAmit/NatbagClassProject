package amitMaimon315855478;

public class Arrival extends Flight {

	private final String IN="Arriving:";
	
	
	public Arrival(String company, String city, DateAndTime date, String flightTime, String flightNum, int terminal,
			int eta) throws UserExceptions {
		super(company, city, date, flightTime, flightNum, terminal, eta);
	}
	
	public String toString() {
		return IN+super.toString();
	}
	
	

}
