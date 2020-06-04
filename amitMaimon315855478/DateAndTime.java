package amitMaimon315855478;

import java.time.LocalDateTime;
import java.time.YearMonth;

public class DateAndTime {

	private LocalDateTime date;
	private final int MAX_YEAR = 2021, MIN_YEAR = 1900, DAY = 1, MONTH = 1;
	private final int MAX_HOUR = 23, MaxMinute = 59;

	public DateAndTime(int year, int month, int dayOfMonth, int hour, int minute) throws UserExceptions {
		if (year > MAX_YEAR || year < MIN_YEAR)
			throw new UserExceptions("Year Invalid");
		if (month < 1 || month > 12) {
			int monthLength = YearMonth.of(year, month).lengthOfMonth();
			throw new UserExceptions("Month Invalid");
		}
		if (dayOfMonth > MAX_YEAR || dayOfMonth < MIN_YEAR)
			throw new UserExceptions("Day Invalid");
		if (hour > 24 || hour < 0)
			throw new UserExceptions("Time Invalid");
		if (minute > 60 || minute < 0)
			throw new UserExceptions("Time Invalid");
		
		date=LocalDateTime.of( year,  month,  dayOfMonth,  hour,  minute);

	}
	
	public String toString() {
		return date.toString();
	}

}
