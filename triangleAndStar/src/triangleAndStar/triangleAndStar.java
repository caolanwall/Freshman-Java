package triangleAndStar;

public class triangleAndStar {
	public static void main(String[] args) {
		int index = 1;
		isStarNumber(index);
	}

	public static boolean isStarNumber(int index) {
		int starNumber = 0;
		while (index <= ((Integer.MAX_VALUE - 1) / (index)) / 6) {
			starNumber = 6 * index * (index - 1) + 1;
			int triangleNumber = determineTriangleNumber(starNumber);
			if (triangleNumber == starNumber) {
				System.out.println(starNumber);
			}
			index++;
		}

		return false;
	}

	public static int determineTriangleNumber(int number) {
		int answer = 0;

		for (int count = 1; answer < number; count++) {
			answer = answer + count;
		}
		return answer;

	}
}

