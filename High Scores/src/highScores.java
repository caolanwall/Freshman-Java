import java.util.Scanner;

public class highScores {
	public static void main(String[] args0) {
		try {
			System.out.println("Enter how many scores do you want to maintain?");
			Scanner inputScanner = new Scanner(System.in);
			int lenght = inputScanner.nextInt();
			int[] highScores = new int[lenght];
			boolean exit = false;
			initialiseHighScores(highScores);
			printHighScores(highScores);
			while (!exit) {
				System.out.println("\nEnter a score or type 'exit'");
				if (inputScanner.hasNextInt()) {
					int newNumber = inputScanner.nextInt();
					if (higherThan(highScores, newNumber) == true) {
						insertScore(newNumber, highScores);
					} else {
						printHighScores(highScores);
					}
				} else if (inputScanner.hasNext("exit")) {
					System.out.println("Thank you");
					printHighScores(highScores);
					exit = true;
				} else {
					System.out.println("Invalid input");
					exit = true;
				}
			}
			inputScanner.close();
		} catch (NullPointerException exception) {
		} catch (java.util.NoSuchElementException exception) {
			System.out.println("No number entered.");
		}

	}

	public static void initialiseHighScores(int[] highScore) {
		for (int index = 0; index < highScore.length; index++) {
			highScore[index] = 0;
		}
	}

	public static void printHighScores(int[] highScores) {
		System.out.print("The high scores are ");
		for (int index = 0; index < highScores.length; index++) {
			System.out.print(highScores[index]);
			if (index < highScores.length - 1) {
				System.out.print(", ");
			}
		}

	}

	public static boolean higherThan(int[] highScores, int newNumber) {
		for (int index = 0; index < highScores.length; index++) {
			if (highScores[index] < newNumber) {
				return true;
			}
		}
		return false;

	}

	public static void insertScore(int newNumber, int[] array) {
		boolean exit = false;
		while (!exit) {
			for (int index = 0; index < array.length; index++) {
				if (newNumber > array[index]) {
					int finalValue = array.length - 1;
					for (int count = index; count < array.length - 1; count++) {
						array[finalValue] = array[finalValue - 1];
						finalValue--;

					}
					array[index] = newNumber;
					printHighScores(array);
					return;
				}
			}
		}
	}
}
