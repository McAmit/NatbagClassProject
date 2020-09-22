package Tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Flight.Flight;
import Flight.Flight.eStatus;
import Flight.DateAndTime;
import Flight.UserExceptions;


class ProgramTest {

	@Test
	public void testCompany() throws UserExceptions {
		DateAndTime genericDate=new DateAndTime(2020, 12, 22);
		Flight tested=new Flight("El-Al", "Rome", genericDate, "Er213E", 3, 4, eStatus.OnTime);
		assertEquals("El-Al", tested.getCompany());
		
	}
	@Test
	public void testCity() throws UserExceptions{
		DateAndTime genericDate=new DateAndTime(2020, 12, 22);
		Flight tested=new Flight("El-Al", "Rome", genericDate, "Er213E", 3, 4, eStatus.OnTime);
		assertEquals("Rome", tested.getCity());
	}

}
