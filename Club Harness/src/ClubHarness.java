import java.util.Scanner;
public class ClubHarness {

	public static void main(String[] args) {
		try {
			System.out.println(
					"Enter whether you would like to:\nAdd a new harness (add)\nRemove a harness (remove)\nRecord a safety check (check)\nLoan a harness to a member (loan)\nReturn a harness which was used by a club member (return)");
			Scanner inputScanner = new Scanner(System.in);
			String choice = inputScanner.next();
			if (choice.equalsIgnoreCase("add")) {
				System.out.println(
						"Please enter the make, model number, the name of the instructor who last checked the harness (seperated by commas)");
				inputScanner.useDelimiter(",");
				String make = inputScanner.next();
				int modelNumber = inputScanner.nextInt();
				String lastCheck = inputScanner.next();
				Harness harness = new Harness(make, modelNumber, lastCheck);
				System.out.println("Sucess");
			} else if (choice.equalsIgnoreCase("remove")) {
				Harness harness;
				System.out.println(
						"Please enter the make and model number of the harness you want to remove (seperated by commas)");
				inputScanner.useDelimiter(",");
				String make = inputScanner.next();
				int modelNumber = inputScanner.nextInt();
				// harness.removeHarness(make, modelNumber);

			} else if (choice.equalsIgnoreCase("check")) {
				Harness harness = null;
				System.out.println(
						"Please enter the make, model number, the name of the instructor checked the harness (seperated by commas)");
				inputScanner.useDelimiter(",");
				String make = inputScanner.next();
				int modelNumber = inputScanner.nextInt();
				String lastCheck = inputScanner.next();
				harness.checkHarness(lastCheck);
			} else if (choice.equalsIgnoreCase("loan")) {
				System.out.println(
						"Please enter the make, model number, the name of the club member (seperated by commas)");
				inputScanner.useDelimiter(",");
				String make = inputScanner.next();
				int modelNumber = inputScanner.nextInt();
				String member = inputScanner.next();
				// Harness harness = harness.findHarness(make, modelNumber);

			} else if (choice.equalsIgnoreCase("reurn")) {
				System.out.println("Please enter the make and model number (seperated by commas)");
				inputScanner.useDelimiter(",");
				String make = inputScanner.next();
				int modelNumber = inputScanner.nextInt();
				// Harness harness = harness.returnHarness(make, modelNumber);
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
}
