import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Cipher {
	public static void main(String[] args) {
		try {
			String[] ORIGINAL_LETTERS = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
					"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " " };
			char[] ORIGINAL_LETTERS2 = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
					'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ' };
			String[] cipher = new String[27];
			boolean finished = false;

			while (!finished) {
				String inputString = JOptionPane.showInputDialog(null, "Enter in the message you want encrpytped");
				Scanner inputScanner = new Scanner(inputString);

				if (inputScanner.hasNextInt()) {
					System.out.println("Please enter a valid string");

				} else {
					createCipher(cipher, ORIGINAL_LETTERS);
					String[] finalEncrypted = encrypt(inputString, ORIGINAL_LETTERS2, cipher);
					String[] finalDecrypted = decrypt(finalEncrypted, cipher, ORIGINAL_LETTERS);
					printEncrypted(finalEncrypted);
					System.out.print("\n");
					// printCipher(cipher); I had this printing for testing.
					// System.out.print("\n");
					printDecrypted(finalDecrypted);
					System.out.print("\n");
				}

			}
		} catch (NullPointerException exception) {
		} catch (java.util.NoSuchElementException exception) {
			System.out.println("No number entered.");
		}
	}

	public static void createCipher(String[] cipher, String[] ORIGINAL_LETTERS) {
		String[] letters = new String[ORIGINAL_LETTERS.length];
		System.arraycopy(ORIGINAL_LETTERS, 0, letters, 0, ORIGINAL_LETTERS.length);
		Random randomNumber = new Random();
		for (int count = 0; count <= 26;) {
			int index = randomNumber.nextInt(27);
			if (letters[index] != "£") {
				cipher[count] = letters[index];
				letters[index] = "£";
				count++;
			}
		}
	}

	public static String[] encrypt(String inputString, char[] ORIGINAL_LETTERS2, String[] cipher) {
		String lowercaseString = inputString.toLowerCase();
		char[] characterArray = lowercaseString.toCharArray();
		int[] positionArray = new int[characterArray.length];
		String[] encrypted = new String[characterArray.length];
		int position = 0;
		for (int index = 0; index < ORIGINAL_LETTERS2.length && position < characterArray.length;) {
			if (characterArray[position] != ORIGINAL_LETTERS2[index]) {
				index++;
			} else {
				positionArray[position] = index;
				position++;
				index = 0;
			}

		}
		for (int count = 0; count < positionArray.length; count++) {
			int positionTwo = positionArray[count];
			encrypted[count] = cipher[positionTwo];

		}
		return encrypted;

	}

	public static String[] decrypt(String[] finalEncrypted, String[] cipher, String[] ORIGINAL_LETTERS) {
		int[] positionArray2 = new int[finalEncrypted.length];
		String[] decrypted = new String[finalEncrypted.length];
		int position = 0;
		for (int index = 0; index <= ORIGINAL_LETTERS.length - 1 && position <= finalEncrypted.length - 1;) {
			if (finalEncrypted[position] != cipher[index]) {
				index++;
			} else {
				positionArray2[position] = index;
				position++;
				index = 0;
			}
		}
		for (int count = 0; count < positionArray2.length; count++) {
			int positionTwo = positionArray2[count];
			decrypted[count] = ORIGINAL_LETTERS[positionTwo];
		}
		return decrypted;
	}

	public static void printEncrypted(String[] finalEncrypted) {
		System.out.print("Encrypted: ");
		for (int index = 0; index < finalEncrypted.length; index++) {
			System.out.print(finalEncrypted[index]);

		}

	}

	public static void printCipher(String[] cipher) {
		for (int index = 0; index < cipher.length; index++) {
			System.out.print(cipher[index]);
			if (index < cipher.length - 1) {
				System.out.print(", ");
			}
		}

	}

	public static void printDecrypted(String[] finalDecrypted) {
		System.out.print("Decrypted: ");
		for (int index = 0; index < finalDecrypted.length; index++) {
			System.out.print(finalDecrypted[index]);

		}

	}

}
