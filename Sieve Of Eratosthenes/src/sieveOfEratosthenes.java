import java.util.Scanner;

public class sieveOfEratosthenes {
	public static final int START = 2;

	public static void main(String[] args) {
		try {
			System.out.println("Enter an int:");
			Scanner inputScanner = new Scanner(System.in);
			int end = inputScanner.nextInt();
			if (end <= 100 && end > 2) {
				int range = end - START;
				int sequence[] = new int[range + 1];
				String sequence2[] = new String[range + 1];
				int position = 0;
				createSequence(range, sequence, sequence2);
				nonCrossedOutSubseqToString(sequence);
				System.out.print("\n");
				sieve(sequence, position, end, sequence2);
				nonCrossedOutSubseqToString(sequence);
			} else {
				System.out.println("Please enter an integer greater than 2 and less than 100!");
			}
		} catch (Exception e) {
			System.out.println("Please enter an integer greater than 2 and less than 100!");
		}
	}

	public static int[] createSequence(int range, int[] sequence, String sequence2[]) {
		for (int index = 0; index <= range; index++) {
			sequence[index] = START + index;
		}
		for (int index = 0; index <= range; index++) {
			sequence2[index] = "[" + Integer.toString(START + index) + "]";
		}
		return sequence;
	}

	public static void sieve(int[] sequence, int position, int end, String[] sequence2) {
		for (position = 0; position < (int) Math.sqrt(end); position++) {
			if (sequence[position] != 0) {
				crossOutHigherNumber(sequence, position, end);
				sequenceToString(sequence, sequence2);
				System.out.print("\n");
			}
		}
	}

	public static void crossOutHigherNumber(int[] sequence, int position, int end) {
		int actualNumber = position + START;
		int number = 0;
		number = (actualNumber) * 2;
		while (number <= end) {
			sequence[number - START] = 0;
			number = number + actualNumber;
		}
	}

	public static void sequenceToString(int[] sequence, String[] sequence2) {
		for (int index = 0; index < sequence.length; index++) {
			if (sequence[index] != 0) {
				System.out.print(sequence[index]);
				if (index < sequence.length - 1) {
					System.out.print(", ");
				}
			} else {
				System.out.print(sequence2[index]);
				if (index < sequence.length - 1) {
					System.out.print(", ");
				}
			}
		}

	}

	public static void nonCrossedOutSubseqToString(int[] sequence) {
		for (int index = 0; index < sequence.length; index++) {
			if (sequence[index] != 0) {
				if (index > 0) {
					System.out.print(", ");
				}
				System.out.print(sequence[index]);
			}
		}
	}
}
