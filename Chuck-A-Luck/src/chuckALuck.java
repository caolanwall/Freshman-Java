import java.util.Scanner;



public class chuckALuck {

	public static final int TRIPLE = 1;
	public static final int FIELD = 2;
	public static final int HIGH = 3;
	public static final int LOW = 4;

	public static void main(String[] args) {
		boolean quit = false;
		int bet = 0;
		Wallet playerWallet = new Wallet();
		System.out.println("How cash do you have to put into your wallet?");
		Scanner inputScanner = new Scanner(System.in);
		double wallet = inputScanner.nextDouble();
		playerWallet.put(wallet);
		while (!quit && playerWallet.check() != 0) {
			System.out.println("Please enter the type of bet you would like to make. (Triple, Field, High, Low) or type 'quit'");
			String betType = inputScanner.next();
			if (betType.contains("Triple") || betType.contains("triple")) {
				bet = TRIPLE;
				resolveBet(playerWallet, bet);
			} else if (betType.contains("Field") || betType.contains("field")) {
				bet = FIELD;
				resolveBet(playerWallet, bet);
			} else if (betType.contains("High") || betType.contains("high")) {
				bet = HIGH;
				resolveBet(playerWallet, bet);
			} else if (betType.contains("Low") || betType.contains("low")) {
				bet = LOW;
				resolveBet(playerWallet, bet);
			} else if (betType.contains("quit") || betType.contains("Quit")) {
				quit = true;
			} else
				System.out.println("Invalid bet type.");
		}
		System.out.println("You started with €" + wallet + ". You now have €" + playerWallet.check());
	}

	public static void resolveBet(Wallet playerWallet, int bet) {
		int total = 0;
		boolean triple = false;
		double payout = 0;
		System.out.println("You have €" + playerWallet.check() + " in your wallet.\nHow much would you like to bet?");
		Scanner betScanner = new Scanner(System.in);
		double betAmount = betScanner.nextDouble();
		if (betAmount <= playerWallet.check()) {
			Dice dice = new Dice();
			int roll1 = dice.roll();
			int roll2 = dice.roll();
			int roll3 = dice.roll();
			total = roll1 + roll2 + roll3;
			if (roll1 == roll2 && roll1 == roll3 && roll1 != 1 && roll1 != 6 && bet == TRIPLE) {
				payout = betAmount * 30;
				System.out.println("Congratulations! You win €" + payout);
				triple = true;
				playerWallet.put(payout);
			} else if (roll1 == roll2 && roll1 == roll3 && (roll1 == 1 || roll1 == 6) && bet == TRIPLE) {
				System.out.println("Unlucky! It was all " + roll1 + "'s so the house wins!");
				playerWallet.get(betAmount);
			} else if ((total > 8 || total > 12) && bet == FIELD) {
				System.out.println("Congratulations! You win €" + betAmount);
				playerWallet.put(betAmount);
			} else if (total > 10 && triple == false && bet == HIGH) {
				System.out.println("Congratulations! You win €" + betAmount);
				playerWallet.put(betAmount);
			} else if (total < 11 && triple == false && bet == LOW) {
				System.out.println("Congratulations! You win €" + betAmount);
				playerWallet.put(betAmount);
			} else {
				System.out.println("Unlucky! The house wins!");
				playerWallet.get(betAmount);
			}
			//System.out.println(roll1 + " " + roll2 + " " + roll3);
		} else {
			System.out.println("You dont have enough money to bet");
		}
	}
}
