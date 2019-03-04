import javax.swing.JOptionPane;

public class Umbrella {
	public static void main(String[] args) {
		int answer = JOptionPane.showConfirmDialog(null, "Is it currently raining?");
		boolean isRaining = (answer == JOptionPane.YES_OPTION);
		boolean isNotRaining = (answer == JOptionPane.NO_OPTION); // Added NO_OPTION to ensure the cancel button would
																	// work.

		if (isRaining) {
			JOptionPane.showMessageDialog(null, "You should bring an umbrella and put it up!");
		} else if (isNotRaining) {
			int answer2 = JOptionPane.showConfirmDialog(null, "Does it look like it is going to rain?");
			boolean goingToRain = (answer2 == JOptionPane.YES_OPTION);
			boolean notGoingToRain = (answer2 == JOptionPane.NO_OPTION);

			if (goingToRain) {
				JOptionPane.showMessageDialog(null, "You should bring the umbrella!");
			} else if (notGoingToRain) {
				JOptionPane.showMessageDialog(null, "There is no need to bring the umbrella!");
			}
		}
	}
}