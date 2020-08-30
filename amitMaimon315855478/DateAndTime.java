package amitMaimon315855478;

import java.time.LocalDateTime;
import java.time.YearMonth;

public class DateAndTime implements Comparable<DateAndTime> {

	private LocalDateTime date;
	private final int MAX_YEAR = 2021, MIN_YEAR = 1900, DAY = 1, MONTH = 1;
	private final int MAX_HOUR = 23, MaxMinute = 59;
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

	public DateAndTime(String dateLine, String timeLine) throws NumberFormatException, UserExceptions {
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
		if (hour > 24 || hour < 0)
			throw new UserExceptions("Time Invalid");
		if (minute > 60 || minute < 0)
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

	public String getTime() {
		return hour + ":" + minute;
	}

	@Override
	public int compareTo(DateAndTime comparedDate) {
		if(year!=comparedDate.getYear()) {
			if(year<comparedDate.getYear())
				return 1;
			else
				return 0;
		} else {
			if(month!=comparedDate.getMonth()) {
				if(month<comparedDate.getMonth())
					return 1;
				else
					return 0;
			} else {
				if(day!=comparedDate.getDay()) {
					if(day<comparedDate.getDay())
						return 1;
					else
						return 0;
				} else {
					if(hour!=comparedDate.getHour()) {
						if(hour<comparedDate.getHour())
							return 1;
						else
							return 0;
					} else {
						if(minute<comparedDate.getMinute())
							return 1;
						else
							return 0;
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

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

}
