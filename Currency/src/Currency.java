import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Currency {
	public static final int OLD_PENNIES_TO_NEW_PENNIES = 67;
	public static final int SHILLINGS_TO_OLD_PENNIES= 12;
	public static final int OLD_POUND_TO_SHILLINGS = 20;
	public static final int NEW_PENNIES_TO_POUNDS = 100;
		public static void main(String [] args) {
			String input = JOptionPane.showInputDialog("Enter the number of Pounds, Shillings and Pennies, seperated by spaces:");
			Scanner inputScanner = new Scanner( input );
			int oldPounds = inputScanner.nextInt();
			int shillings = inputScanner.nextInt();
			int oldPennies = inputScanner.nextInt();
			inputScanner.close();
			DecimalFormat formatter = new DecimalFormat("0.00");
	
			int newPenny = (OLD_PENNIES_TO_NEW_PENNIES * oldPennies) + (SHILLINGS_TO_OLD_PENNIES * OLD_PENNIES_TO_NEW_PENNIES * shillings)
					+ (OLD_POUND_TO_SHILLINGS * OLD_PENNIES_TO_NEW_PENNIES * SHILLINGS_TO_OLD_PENNIES * oldPounds);
			double newPound = ((double) newPenny) / NEW_PENNIES_TO_POUNDS;
			JOptionPane.showMessageDialog(
					null, oldPounds + " old pounds, " + shillings + " shillings and " + oldPennies + " old pennies = £" +  formatter.format(newPound));
			}
		}
