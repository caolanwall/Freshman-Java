
public class days {
	public static final int NUMBER_OF_DAYS = 12;

	public static void main(String[] args) {
		String dayName = null;
		for (int dayOfChirstmas = 1, lineOfSong = 12; dayOfChirstmas <= NUMBER_OF_DAYS; dayOfChirstmas++, lineOfSong--) {
			switch (dayOfChirstmas) {
			case 1:
				dayName = " first ";
				break;
			case 2:
				dayName = " second ";
				break;
			case 3:
				dayName = " third ";
				break;
			case 4:
				dayName = " fourth ";
				break;
			case 5:
				dayName = " fifth ";
				break;
			case 6:
				dayName = " sixt ";
				break;
			case 7:
				dayName = " sevent ";
				break;
			case 8:
				dayName = " eight ";
				break;
			case 9:
				dayName = " ninth ";
				break;
			case 10:
				dayName = " tenth ";
				break;
			case 11:
				dayName = " eleventh ";
				break;
			case 12:
				dayName = " twelfth ";
				break;
			}
			System.out.println("On the" + dayName + "day of Christmas");
			System.out.println("My true love sent to me:");
			switch (lineOfSong) {
			case 1:
				System.out.println("Twelve Drummers Drumming");
			case 2:
				System.out.println("Eleven Pipers Piping");
			case 3:
				System.out.println("Ten Lords a Leaping");
			case 4:
				System.out.println("Nine Ladies Dancing");
			case 5:
				System.out.println("Eight Maids a Milking");
			case 6:
				System.out.println("Seven Swans a Swimming");
			case 7:
				System.out.println("Six Geese a Laying");
			case 8:
				System.out.println("Five Golden Rings");
			case 9:
				System.out.println("Four Calling Birds");
			case 10:
				System.out.println("Three French Hens");
			case 11:
				System.out.print("Two Turtle Doves \nand ");
			case 12:
				System.out.println("a Partridge in a Pear Tree");
				break;
			}
		}
	}
}
