package amitMaimon315855478;

public class Flight {


	private String company;
	private String city;
	private DateAndTime date,landingTime;
	private int terminal;
	private String flightNum;
	private double eta;//Estimated Time of Arrival

	public Flight(String company, String city, DateAndTime date, String flightNum, int terminal,double eta) throws UserExceptions {
		this.company = company;
		this.city = city;
		this.date = new DateAndTime(date);
		this.flightNum = flightNum;
		this.terminal = terminal;
		this.eta=eta;
	}
	public Flight(Flight fly) throws UserExceptions {
		this(fly.getCompany(),fly.getCity(),fly.getDateAndTime(),fly.getFlightNum(),fly.getTerminal(),fly.getEta());
	}
	public DateAndTime getDateAndTime() {
		return date;
	}
	public String getCompany() {
		return company;
	}
	public String getCity() {
		return city;
	}

	public int getTerminal() {
		return terminal;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public double getEta() {
		return eta;
	}
}
