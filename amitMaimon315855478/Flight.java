package amitMaimon315855478;

public class Flight {

	private String company;
	private String city;
	private DateAndTime date;
	private int terminal;
	private String flightNum;
	private int eta;//Estimated Time of Arrival

	public Flight(String company, String city, DateAndTime date, String flightTime, String flightNum, int terminal,int eta) throws UserExceptions {
		this.company = company;
		this.city = city;
		this.date = new DateAndTime(date);
		this.flightNum = flightNum;
		this.terminal = terminal;
		this.eta=eta;
	}
	public DateAndTime getDateAndTime() {
		return date;
	}
}
