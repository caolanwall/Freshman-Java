import java.util.Scanner;

public class RationalNumbers {
	public static void main(String[] args) {
		boolean finished = false;
		int noOfRational = 0;
		Rational firstRational = null;
		Rational secondRational = null;
		String userInput;
		Scanner inputScanner = new Scanner(System.in);
		inputScanner.useDelimiter("/");
		while (!finished) {
			if (noOfRational == 0) {
				System.out.println(
						"Enter your first rational number in the form 'numerator/demoninator' or  'numerator' or enter 'Quit'");
			} else if (noOfRational == 1) {
				System.out.println(
						"Enter your second rational number in the form 'numerator/demoninator' or enter 'Quit'");
			}
			userInput = inputScanner.nextLine();
			if (userInput.equalsIgnoreCase("quit")) {
				System.out.print("Goodbye");
				finished = true;
			} else if (userInput.matches("[0-9]+")) {
				int num1 = Integer.parseInt(userInput);
				if (noOfRational == 0) {
					firstRational = new Rational(num1);
					noOfRational++;
				} else if (noOfRational == 1) {
					secondRational = new Rational(num1);
					noOfRational++;
				}
			} else if (userInput.contains("/")) {
				int slash = userInput.indexOf("/");
				int num = Integer.parseInt(userInput.substring(0, slash));
				int den = Integer.parseInt(userInput.substring(slash + 1, userInput.length()));
				if (den == 0) {
					throw new IllegalArgumentException("Denominator cannot be zero");
				}
				if (den == 0) {
					System.out.println("The denominator can't be 0");
					return;
				}
				if (noOfRational == 0) {
					firstRational = new Rational(num, den);
					noOfRational++;
				} else if (noOfRational == 1) {
					secondRational = new Rational(num, den);
					noOfRational++;
					System.out.println(firstRational + " + " + secondRational + " = "
							+ firstRational.simplify(firstRational.add(secondRational)));
					System.out.println(firstRational + " - " + secondRational + " = "
							+ firstRational.simplify(firstRational.subtract(secondRational)));
					System.out.println(firstRational + " / " + secondRational + " = "
							+ firstRational.simplify(firstRational.divide(secondRational)));
					System.out.println(firstRational + " * " + secondRational + " = "
							+ firstRational.simplify(firstRational.multiply(secondRational)));
					if (firstRational.equals(secondRational)) {
						System.out.println(firstRational + " is equal to " + secondRational);
					} else {
						System.out.println(firstRational + " is not equal to " + secondRational);
					}
					if (firstRational.isLessThan(secondRational)) {
						System.out.println(firstRational + " is less than " + secondRational);
					} else {
						System.out.println(firstRational + " is not less than " + secondRational);
					}
					noOfRational = 0;
				}

			} else {
				System.out.println("Invalid Input. Please enter values in the correct format.");
			}
		}

	}
}
