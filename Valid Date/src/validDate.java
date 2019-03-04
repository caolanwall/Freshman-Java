import java.util.Scanner;
import java.lang.Math;
import javax.swing.JOptionPane;

public class validDate {
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;

	public static void main(String args[]) {
		try
		{
			String input = JOptionPane.showInputDialog("Enter a date in the format DD/MM/YYYY");
			Scanner inputScanner = new Scanner(input);
			inputScanner.useDelimiter("/");
			int day = inputScanner.nextInt();
			int month = inputScanner.nextInt();
			int year = inputScanner.nextInt();
			inputScanner.close();
			System.out.println(day + "/" + month + "/" + year);
			
			if (isDateValid(day, month, year)) {
				JOptionPane.showMessageDialog(null, dayOfTheWeek(day, month, year) + ", the " + day + numberEnding(day)
						+ " of " + monthName(month) + " " + year);
			} else if (dayInMonth(day, month) < day) {
				JOptionPane.showMessageDialog(null, day + "/" + month + "/" + year + " is an invalid date \nThere are "
						+ dayInMonth(day, month) + " days in " + monthName(month),
						"Error", JOptionPane.ERROR_MESSAGE);
			} else if (month > NUMBER_OF_MONTHS) {
				JOptionPane.showMessageDialog(null, day + "/" + month + "/" + year + " is an invalid date \nThere are "
						+ NUMBER_OF_MONTHS + " months in a year" ,
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, day + "/" + month + "/" + year + " is an invalid date",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (NullPointerException exception)
		{
		}
		catch (java.util.NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "No date entered.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static String numberEnding(int day) {
		String numberEnding = null;
		switch (day) {
		case 1:
		case 21:
		case 31:
			numberEnding = "st";
			break;
		case 2:
		case 22:
			numberEnding = "nd";
			break;
		case 3:
		case 23:
			numberEnding = "rd";
			break;
		default:
			numberEnding = "th";
			break;
		}
		return numberEnding;
	}

	public static String monthName(int month) {
		String monthName = null;
		switch (month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "Februaury";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		default:
			monthName = "December";
			break;
		}
		return monthName;
	}

	public static String dayOfTheWeek(int day, int month, int year) {
		String dayName = null;
		int Y = year;
		if (month == 1 || month == 2) {
			Y = year - 1;
		}
		int c = Y / 100;
		int y = Y - (c * 100);
		int w = (int) (((day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + Math.floor(y / 4)
						+ Math.floor(c) / 4) - 2 * c) % 7);
		if (w < 0) {
			w = w + 7;
		}
		switch (w) {
		case 0:
			dayName = "Sunday";
			break;
		case 1:
			dayName = "Monday";
			break;
		case 2:
			dayName = "Tuesday";
			break;
		case 3:
			dayName = "Wednesday";
			break;
		case 4:
			dayName = "Thursday";
			break;
		case 5:
			dayName = "Friday";
			break;
		default:
			dayName = "Saturday";
			break;
		}
		return dayName;
	}

	public static int dayInMonth(int year, int month) {
		int daysInMonth = 0;
		switch (month) { // I used the DaysInTheMonth code from week 8 on blackboard.
		case 2:
			boolean isLeapYear = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
			daysInMonth = isLeapYear ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR : DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			daysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			daysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return daysInMonth;
	}

	public static boolean isDateValid(int day, int month, int year) {
		return ((day <= dayInMonth(year, month)) && (day >= 1) && (year >= 0) && (month <= NUMBER_OF_MONTHS)
				&& (month >= 1));
	}
}
