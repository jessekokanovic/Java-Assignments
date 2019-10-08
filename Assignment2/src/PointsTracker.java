import javax.swing.JOptionPane;

public class PointsTracker {

	public static void main(String[] args) {

		// Initialize variable for player name and empty array structures for games and
		// points scored.
		String player = JOptionPane.showInputDialog("What is the Player's name?");
		int numberOfGames = Integer.parseInt(JOptionPane.showInputDialog("How many games did they play?"));
		while (numberOfGames < 0) {
			// Make sure the user is entering a positive integer as you can't play a
			// negative number of basketball games.
			numberOfGames = Integer.parseInt(JOptionPane.showInputDialog("Please enter a positive integer:"));
		}
		// Initialize arrays to hold the game date and points scored, and make them
		// equal in length to the number of games played.
		int pointsScored[];
		String gameDate[];
		pointsScored = new int[numberOfGames];
		gameDate = new String[numberOfGames];

		// Populate the arrays with data retrieved from the user.
		int i = 0;
		// loop over the array the numberOfGames times, ask the user to enter
		// information for both the date and points scored.
		while (i < numberOfGames) {
			gameDate[i] = JOptionPane.showInputDialog("Enter the game date (dd/mm):");
			pointsScored[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter the points scored:"));
			i++;
		}

		// Calculate the average points scored by summing the pointsScored array and
		// dividing by numberOfGames.
		i = 0;
		int totalPoints = 0; // contains the summation of the pointsScored array.
		// loop over the array and add the current value to the totalPoints variable.
		while (i < numberOfGames) {
			totalPoints = totalPoints + pointsScored[i];
			i++;
		}
		// calculate average points, double is used to account for
		// decimal places in average points.
		double averagePoints = totalPoints / numberOfGames;
		
		//loop over the arrays and print the points scored on each date.
		i = 0;
		while (i < numberOfGames) {
			System.out.println("Points scored for" + player + ":\n" + pointsScored[i] + " points on " + gameDate[i]);
			i++;
		}
		//Print the average points.
		System.out.println("Over " + numberOfGames + " games, " + player + " averaged " + averagePoints + " points per game.");
	}

}
