package amitMaimon315855478;

public class Departure extends Flight {
	
	private final String OUT="Departuring:"; 

	public Departure(String company, String city, DateAndTime date, String flightTime, String flightNum, int terminal,
			int eta) throws UserExceptions {
		super(company, city, date, flightTime, flightNum, terminal, eta);
	}

	public String toString() {
		return OUT+super.toString();
	}

}
