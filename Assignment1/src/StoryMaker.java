import javax.swing.JOptionPane;

public class StoryMaker {

	public static void main(String[] args) {
	//Method to take input from the user and construct a story
		
		//Declare and initialise String for storing a name. No other type could have been used, as multiple characters
		//were needed.
		String name = JOptionPane.showInputDialog("Please enter a name:");
		
		//Declare and initialise a double to store a dollar amount. Double is used to account for decimals in the number.
		//Int could not have been used as it would error with a decimal. A String could have been used but if the value
		//stored needed to be mathematically manipulated that would result in errors. If a character or string is given by the user
		//this assignment will error.
		double dollarAmount = Double.parseDouble(JOptionPane.showInputDialog("Please enter a dollar amount:"));
		
		//Declare and initialise integer variable to store a whole number. Int is used as you can only count ooshies in whole numbers.
		//A string could have been used, but would error if mathematically manipulated.
		//If a character or string is included in the input this assignment will fail.
		int number = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number:"));
		
		//Declare and initialise a string to store a word. A string is required to store multiple characters. 
		String verb = JOptionPane.showInputDialog("Please enter a verb:");

		//Declare and initialise a string to hold the story structure. Above variables are added to the story.
		String story = "Once upon a time, there was a very happy chap by the name of " + name + ". " + name
				+ " absolutely loved the lion king, BUT, more importantly, loved Lion King collectibles.\n"
				+ "So when woolworths started giving out Lion King ooshies, " + name
				+ " knew that they were going to spend their entire life savings of $" + dollarAmount
				+ " to get them all!\n" + "One day, on the hunt for the final ooshie in his collection of " + number
				+ " ooshies, and after spending the last of his money, " + name + " asked the woolworths cashier for it.\n"
				+ "'Sorry mate but we're all out of the ooshies.'\nAbsolutely heartbroken, " + name + " " + verb
				+ " home and threw away the entire ooshie collection.\n" + "From that day foward, " + name
				+ " shopped exclusively at Coles.";

		JOptionPane.showMessageDialog(null, story);

	}

}
