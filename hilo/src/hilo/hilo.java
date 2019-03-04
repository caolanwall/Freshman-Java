package hilo;

import java.util.Random;
import java.util.Scanner;

public class hilo {
	public static final int NUMBER_FOR_WIN = 4;

	public static void main(String[] args) {
		Random randomNumber = new Random();
		int winCount = 0;
		int oldCard = randomNumber.nextInt(13);
		boolean exit = false;
		String[] Suit = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		while (!exit) {
			int card = randomNumber.nextInt(13);
			System.out.println("Curent Card is " + Suit[oldCard] + "\n" + "Enter higher(hi), lower(lo) or equal(eq)");
			Scanner inputScanner = new Scanner(System.in);
			String answer = inputScanner.next();

			switch (answer) {

			case "hi":

				if (oldCard < card) {
					winCount++;
				} else {
					exit = true;
				}
				break;
			case "lo":

				if (oldCard > card) {
					winCount++;
				} else {
					exit = true;
				}
				break;
			case "eq":
				if (oldCard == card) {
					winCount++;
				} else {
					exit = true;
				}
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
			oldCard = card;
			if (winCount == NUMBER_FOR_WIN) {
				exit = true;
				System.out.println("The card is " + Suit[card] + "\n" + "Congratulations, you have won!");
			} else if (exit) {
				System.out.println("The card is " + Suit[card] + "\n" + "Better Luck Next time!");
			}

		}
	}
}
