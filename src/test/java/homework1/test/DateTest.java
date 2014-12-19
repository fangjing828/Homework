package homework1.test;

import homework1.Date;

import org.junit.*;
public class DateTest {
	@Test
	public void testIsLeap() {
		Assert.assertEquals(false, Date.isLeapYear(1800));
		Assert.assertEquals(false, Date.isLeapYear(1900));
		Assert.assertEquals(true, Date.isLeapYear(1600));
		Assert.assertEquals(true, Date.isLeapYear(2000));
	}
	
	@Test
	public void testDaysInMonth() {
		Assert.assertEquals(31, Date.daysInMonth(1, 1800));
		Assert.assertEquals(28, Date.daysInMonth(2, 1800));
		Assert.assertEquals(29, Date.daysInMonth(2, 2000));
		Assert.assertEquals(31, Date.daysInMonth(3, 1800));
		Assert.assertEquals(30, Date.daysInMonth(4, 1800));
		Assert.assertEquals(31, Date.daysInMonth(5, 1800));
		Assert.assertEquals(30, Date.daysInMonth(6, 1800));
		Assert.assertEquals(31, Date.daysInMonth(7, 1800));
		Assert.assertEquals(31, Date.daysInMonth(8, 1800));
		Assert.assertEquals(30, Date.daysInMonth(9, 1800));
		Assert.assertEquals(31, Date.daysInMonth(10, 1800));
		Assert.assertEquals(30, Date.daysInMonth(11, 1800));
		Assert.assertEquals(31, Date.daysInMonth(12, 1800));
	}
	
	@Test
	public void testIsValidDate() {
		Assert.assertEquals(true, Date.isValidDate(1, 31, 1800));
		Assert.assertEquals(true, Date.isValidDate(2, 28, 1800));
		Assert.assertEquals(true, Date.isValidDate(2, 29, 2000));
		Assert.assertEquals(false, Date.isValidDate(2, 30, 2000));
		Assert.assertEquals(false, Date.isValidDate(2, 29, 1800));
		Assert.assertEquals(false, Date.isValidDate(0, 29, 2000));
		Assert.assertEquals(false, Date.isValidDate(0, 0, 2000));
		Assert.assertEquals(false, Date.isValidDate(0, -1, 2000));
		Assert.assertEquals(false, Date.isValidDate(-1, 29, 2000));
		Assert.assertEquals(false, Date.isValidDate(14, 29, 2000));
		Assert.assertEquals(false, Date.isValidDate(13, 29, 2000));
		Assert.assertEquals(false, Date.isValidDate(1, 31, 0));
		Assert.assertEquals(false, Date.isValidDate(1, 31, -1));
	}
	
	@Test
	public void testDate() {
	    Assert.assertEquals("1/1/1", (new Date(1, 1, 1)).toString());
	    Assert.assertEquals("1/21/1", (new Date(1, 21, 1)).toString());
	    Assert.assertEquals("12/31/1975", (new Date(12, 31, 1975)).toString());
	    
	    Assert.assertEquals("2/4/2", (new Date("2/4/2")).toString());
	    Assert.assertEquals("2/29/2000", (new Date("2/29/2000")).toString());
	    Assert.assertEquals("2/29/1904", (new Date("2/29/1904")).toString());
	}
	
	@Test
	public void testDayInYear() {
		Date d1 = new Date(12, 31, 1975);
	    Date d2 = new Date("1/1/1976");
	    Date d3 = new Date("1/2/1976");
	    Date d4 = new Date("2/1/1976");
	    Date d5 = new Date("3/1/1976");
	    Date d6 = new Date("3/1/1975");
	    Assert.assertEquals(365, d1.dayInYear());
	    Assert.assertEquals(1, d2.dayInYear());
	    Assert.assertEquals(2, d3.dayInYear());
	    Assert.assertEquals(32, d4.dayInYear());
	    Assert.assertEquals(61, d5.dayInYear());
	    Assert.assertEquals(60, d6.dayInYear());
	}
	
	@Test
	public void testCompare() {
	    Date d1 = new Date(12, 31, 1975);
	    Date d2 = new Date("1/1/1976");
	    Date d3 = new Date("1/2/1976");

	    Assert.assertEquals(true, d2.isAfter(d1));
	    Assert.assertEquals(true, d3.isAfter(d2));
	    Assert.assertEquals(false, d1.isAfter(d1));
	    Assert.assertEquals(false, d1.isAfter(d2));
	    Assert.assertEquals(false, d2.isAfter(d3));
	   
	    Assert.assertEquals(false, d2.isBefore(d1));
	    Assert.assertEquals(false, d3.isBefore(d2));
	    Assert.assertEquals(false, d1.isBefore(d1));
	    Assert.assertEquals(true, d1.isBefore(d2));
	    Assert.assertEquals(true, d2.isBefore(d3));
	}
	
	@Test
	public void testDiff() {
		Date d1 = new Date(12, 31, 1975);
	    Date d2 = new Date("1/1/1976");
	    Date d3 = new Date("1/2/1976");
	    Date d4 = new Date("2/27/1977");
	    Date d5 = new Date("8/31/2110");
	    
	    Assert.assertEquals(0, d1.difference(d1));
	    Assert.assertEquals(1, d2.difference(d1));
	    Assert.assertEquals(2, d3.difference(d1));
	    Assert.assertEquals(-422, d3.difference(d4));
	    Assert.assertEquals(48762, d5.difference(d4));
	}
}