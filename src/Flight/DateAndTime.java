package Flight;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Date;

public class DateAndTime implements Comparable<DateAndTime> {

	private LocalDateTime date;
	private final int MAX_YEAR = 2022, MIN_YEAR = 1900, DAY = 1, MONTH = 1;
	private final int MAX_HOUR = 24, MaxMinute = 60;
	private final int MIN_HOUR = 0, MinMinute = 0;
	private int monthLength, year, month, day, hour, minute;

	public DateAndTime(int year, int month, int dayOfMonth, int hour, int minute) throws UserExceptions {
		checkExceptions(year, month, dayOfMonth, hour, minute);
		date = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
		monthLength = YearMonth.of(year, month).lengthOfMonth();
		this.day = dayOfMonth;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
	}
	public DateAndTime(int year,int month,int day) throws UserExceptions {
		if (year > MAX_YEAR || year < MIN_YEAR)
			throw new UserExceptions("Year Invalid");
		if (month < 1 || month > 12) 
			throw new UserExceptions("Month Invalid");
		monthLength = YearMonth.of(year, month).lengthOfMonth();
		if (day > monthLength || day < 1)
			throw new UserExceptions("Day Invalid");
		this.year=year;
		this.month=month;
		this.day=day;
		hour=MIN_HOUR;
		minute=MinMinute;
		monthLength = YearMonth.of(year, month).lengthOfMonth();
		date = LocalDateTime.of(year, month, day, hour, minute);
		
	}

	public DateAndTime(String dateLine, String timeLine) throws NumberFormatException, UserExceptions {//unused
		String[] dateArr, timeArr;
		dateArr = dateLine.split("/");
		timeArr = timeLine.split(":");
		checkExceptions(Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[0]),
				Integer.parseInt(timeArr[0]), Integer.parseInt(timeArr[1]));
		year = Integer.parseInt(dateArr[2]);
		month = Integer.parseInt(dateArr[1]);
		monthLength = YearMonth.of(year, month).lengthOfMonth();
		day = Integer.parseInt(dateArr[0]);
		hour = Integer.parseInt(timeArr[0]);
		minute = Integer.parseInt(timeArr[1]);
	}

	private void checkExceptions(int year, int month, int dayOfMonth, int hour, int minute) throws UserExceptions {
		if (year > MAX_YEAR || year < MIN_YEAR)
			throw new UserExceptions("Year Invalid");
		if (month < 1 || month > 12) 
			throw new UserExceptions("Month Invalid");
		monthLength = YearMonth.of(year, month).lengthOfMonth();
		if (dayOfMonth > monthLength || dayOfMonth < 1)
			throw new UserExceptions("Day Invalid");
		if (hour > MAX_HOUR || hour < 0)
			throw new UserExceptions("Time Invalid");
		if (minute > MaxMinute || minute < 0)
			throw new UserExceptions("Time Invalid");
	}

	public DateAndTime(DateAndTime copy) throws UserExceptions {
		this(copy.year, copy.month, copy.day, copy.hour, copy.minute);
	}

	public String toString() {
		return date.toString();
	}

	public String getDate() {
		return year + "/" + month + "/" + day;
	}
	public String showDateInPage() {
		return year + "/" + month + "/" + day+"\n"+hour+":"+minute;
	}

	public String getTime() {
		return hour + ":" + minute;
	}
	public boolean isBetweenTwoDates(DateAndTime from,DateAndTime until) {

		return this.compareTo(from)*until.compareTo(this)>=0;
	}

	@Override
	public int compareTo(DateAndTime comparedDate) {
		if(year!=comparedDate.getYear()) {
				return year-comparedDate.getYear();
		} else {
			if(month!=comparedDate.getMonth()) {
					return month-comparedDate.getMonth();
			} else {
				if(day!=comparedDate.getDay()) {
						return day-comparedDate.getDay();
				} else {
					if(hour!=comparedDate.getHour()) {
							return hour-comparedDate.getHour();

					} else {
						return minute-comparedDate.getMinute();
					}
				}
			}
				
		}
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}
	public String getDayInWeek() {
		switch (date.getDayOfWeek().getValue()) {
		case 1:
			return "Sunday";
		case 2:
			return "Monday";
		case 3:
			return "Tuesday";
		case 4:
			return "Wednesday";
		case 5:
			return "Thursday";
		case 6:
			return "Friday";
		case 7:
			return "Saturday";

		}
		return "Monday";// default
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

}
