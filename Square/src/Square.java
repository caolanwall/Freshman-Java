import java.util.Calendar;

public class Square {
	public static final int MAX_AGE = 123;

	public static void main(String[] args) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int age = 0; age < MAX_AGE; age++) {
			int ageSquared = age * age;
			int birthYear = ageSquared - age;
			if (ageSquared - age == birthYear && birthYear > (year - MAX_AGE) && birthYear < year) {
				System.out.println("If you were born in " + birthYear + ", you would be " + age + " in " + ageSquared);
				// using println so it will show multiple answers on different lines
			}
		}
	}
}