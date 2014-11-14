/* Date.java */
package homework;

public class Date {

  /* Put your private data fields here. */
  private static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private static int[] totalDaysInMonth  = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
  
  private int month;
  private int day;
  private int year;
  
  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
	  this.createDate(month, day, year);
  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
	 String[] date = s.split("/");
	 if (date.length == 3) {
		 this.createDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
	 } else {
		 System.out.println("invalid date format");
		 System.exit(0);
	 }
  }
  
  private void createDate(int month, int day, int year) {
	  if (Date.isValidDate(month, day, year)) {
		  this.month = month;
		  this.day = day;
		  this.year = year;
	  } else {
		  System.out.println("invalid date");
		  System.out.println("month in the range 1...12.");
		  System.out.println("day is between 1 and the number of days in the given month.");
		  System.out.println("years prior to A.D. 1 are NOT valid.");
		  System.exit(0);
	  }
  }
  
  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
	boolean result = false;
	
	if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
		result = true;
	}
	
    return result;
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
	int result = daysInMonth[month - 1];
	
	if (month == 2) {
		result = result + (Date.isLeapYear(year) ? 1 : 0);
	}
	
    return result;
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
	boolean result = false;
	
	if (0 < month && 13 > month  && year > 0 && day > 0) {
		result = day <= daysInMonth(month, year);
	}
	
    return result;                        // replace this line with your solution
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
	return String.format("%s/%s/%s", this.month, this.day, this.year);  
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
	boolean result = false;
	
	int flag = this.year - d.getYear();
	if (flag == 0) {
		flag = this.month - d.getMonth();
		if (flag == 0) {
			flag = this.day - d.getDay();
		}
	}
	
	if (flag < 0) {
		result = true;
	}
	
    return result;
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
	  boolean result = false;
		
	  int flag = this.year - d.getYear();
	  if (flag == 0) {
		  flag = this.month - d.getMonth();
		  if (flag == 0) {
			  flag = this.day - d.getDay();
		  }
	  }
		
	  if (flag > 0) {
		  result = true;
	  }
		
	  return result;
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
    int result = this.getDay() + Date.totalDaysInMonth[this.month - 1];
    
    if (this.month >= 2) {
    	result = result + (Date.isLeapYear(this.year) ? 1 : 0);
    }
    
	return result;
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
	int result = this.dayInYear() - d.dayInYear();
	int begin  = d.getYear();
	int end    = this.year;
	
	boolean flag = false;
	
	if (this.getYear() < d.getYear()) {
		begin = this.getYear();
		end   = d.getYear();
		result = -result;
		flag = true;
	}
	
	while (begin < end) {
		result += 365;
		
		if (Date.isLeapYear(begin)) {
			result ++;
		}
		
		begin ++;
	}
	
	if (flag) {
		result = -result;
	}
	
    return result;
  }
  
  public int getMonth() {
	  return this.month;
  }
  
  public int getDay() {
	  return this.day;
  }
  
  public int getYear() {
	  return this.year;
  }
  
  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */

    System.out.println("\nTesting before and after.");
 
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d2.dayInYear());
    System.out.println(d1.dayInYear());
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
