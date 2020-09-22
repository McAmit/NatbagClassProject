package Flight;

import java.io.PrintWriter;
import java.util.Scanner;


public class Flight implements Comparable<Flight> {

	public static enum eStatus {OnTime,Canceled,Delayed};
	protected eStatus status;
	protected String company,type;
	protected String city;
	protected DateAndTime date,landingTime;
	protected int terminal;
	protected String flightNum,dayInWeek;
	protected double eta;//Estimated Time of Arrival

	public Flight(String company, String city, DateAndTime date, String flightNum, int terminal,double eta,eStatus status) throws UserExceptions {
		this.company = company;
		this.city = city;
		this.date = new DateAndTime(date);
		this.flightNum = flightNum;
		this.terminal = terminal;
		this.eta=eta;
		this.status=status;
		dayInWeek=this.date.getDayInWeek();
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
		status=eStatus.OnTime;
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
		this(fly.getCompany(),fly.getCity(),fly.getDateAndTime(),fly.getFlightNum(),fly.getTerminal(),fly.getEta(),fly.getStatus());
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
	public eStatus getStatus() {
		return status;
	}
	public void setStatus(eStatus status) {
		this.status = status;
	}
	public String getDayInWeek() {
		return dayInWeek;
	}
	
}
