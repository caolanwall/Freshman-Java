package incrementalStats;

import java.util.Scanner;

public class incrementalStats {
	public static void main(String[] args) {

		boolean exit = false;
		double previousAverage = 0;
		double finalAverage = 0;
		double number = 0;
		double variance = 0;
		double previousVariance = 0;
		System.out.println("Enter a number (or type 'exit'):");

		while (!exit) {
			Scanner inputScanner = new Scanner(System.in);
			if (inputScanner.hasNextDouble()) {
				double currentNumber = inputScanner.nextDouble();
				number++;
				finalAverage = previousAverage + (currentNumber - previousAverage) / number;
				variance = ((previousVariance * (number - 1))
						+ ((currentNumber - previousAverage) * (currentNumber - finalAverage))) / number;
				previousAverage = finalAverage;
				previousVariance = variance;
				System.out.println("So far the average is: " + finalAverage + " and the variance is: " + variance);
				System.out.println("Enter a  new number (or type 'exit'):");
			} else if (inputScanner.hasNext("exit")) {
				exit = true;
				System.out.println("Goodbye");
			} else {
				System.out.println("Please enter a valid number.");
			}
		}
	}
}