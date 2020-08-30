package amitMaimon315855478;

import java.io.PrintWriter;
import java.util.Scanner;


public class Flight implements Comparable<Flight> {

	
	protected String company,type;
	protected String city;
	protected DateAndTime date,landingTime;
	protected int terminal;
	protected String flightNum;
	protected double eta;//Estimated Time of Arrival

	public Flight(String company, String city, DateAndTime date, String flightNum, int terminal,double eta) throws UserExceptions {
		this.company = company;
		this.city = city;
		this.date = new DateAndTime(date);
		this.flightNum = flightNum;
		this.terminal = terminal;
		this.eta=eta;
		type="Generic";
	}
	public Flight(Scanner scan) throws NumberFormatException, UserExceptions {
		String str=scan.nextLine();
		String strArr[]=str.split(", ");
		this.city=strArr[0];
		this.date=new DateAndTime(strArr[1],strArr[2]);
		this.flightNum=strArr[3];
		this.terminal=Integer.parseInt(strArr[4]);
		this.eta=Double.parseDouble(strArr[5]);
	}
	public void save(PrintWriter pw) {
		pw.print(city+ ", ");
		pw.print(date.getDate()+", ");
		pw.print(date.getTime()+", ");
		pw.print(flightNum+", ");
		pw.print(terminal+", ");
		pw.print(eta+", ");
		pw.print("\n");
	}
	
	
	
	public Flight(Flight fly) throws UserExceptions { // copy constructor
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
	@Override
	public int compareTo(Flight comparedFlight) {
		return date.compareTo(comparedFlight.getDateAndTime());
	}
	public String toString() {
		return city+", " +date+", Flight Number:"+flightNum+", From Terminal: "+terminal+", ";
	}
	public String getType() {
		return type;
	}
}
