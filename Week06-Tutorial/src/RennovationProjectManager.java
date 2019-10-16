import javax.swing.JOptionPane;

public class RennovationProjectManager {

	public static void main(String[] args) {
		double wallArea = 0, cost, height, length, costPerSqm;
		int selection;
		String tempInput, wallNames;
		String menu = "Menu:\n";
		menu += "1. Calculate paint required for a wall\n"; // string to hold menu selections
		menu += "2. Calculate paint required for project";
		tempInput = JOptionPane.showInputDialog(menu); // get the menu selection from the user

		// Initialise an object so that we may call methods.
		RennovationProjectManager house;
		house = new RennovationProjectManager();

		// This loop continues to run as long as the user supplies another menu option,
		// program will exit if no option is supplied.
		while (tempInput != null) {
			selection = Integer.parseInt(tempInput); // parse the selection as an integer.
			// if the user selects 1, calculate the paint required for a wall.
			// get the height, length, name and cost/sqm from the user and calculate total
			// dollars,
			if (selection == 1) {

				house.calculateWall();
			}
			// if the user selects 2, calculate the paint required for a whole project.
			// get the height, length, name and cost for each wall and add them together
			else if (selection == 2) {
				house.calculateProject();
			}
			// if 1 or 2 is not input, display error message.
			else {
				JOptionPane.showMessageDialog(null, "Invalid choice!");
			}

			// get another menu selection from the user
			tempInput = JOptionPane.showInputDialog(menu);
		}
	}

	public void calculateWall() {
		// Take a cost per square meter and measurements for a wall, and calculate the
		// total cost.
		double costPerSqm = Double.parseDouble(JOptionPane.showInputDialog("Enter cost per sq.m ($)"));
		String tempInput = JOptionPane.showInputDialog("Enter a wall name");
		double height = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall height (m)"));
		double length = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall length (m)"));
		double wallArea = height * length;
		double cost = wallArea * costPerSqm;
		JOptionPane.showMessageDialog(null,
				"Cost to paint " + tempInput + " wall of " + wallArea + " sq.m. is $" + cost);
	}

	public void calculateProject() {
		// Take a cost per square meter and measurements for multiple walls, and
		// calculate the total cost.
		double costPerSqm = Double.parseDouble(JOptionPane.showInputDialog("Enter cost per sq.m ($)"));
		String wallNames = "";
		double wallArea = 0;
		double cost = 0;
		String tempInput = JOptionPane.showInputDialog("Enter a wall name (cancel to finish)");
		// continuously get inputs from the user and total the heights and lengths for
		// each wall.
		// no input will continue the program.
		while (tempInput != null) {
			double height = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall height (m)"));
			double length = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall length (m)"));
			wallArea += height * length;
			wallNames += tempInput + ", ";
			tempInput = JOptionPane.showInputDialog("Enter a wall name (cancel to finish)");
		}
		cost = wallArea * costPerSqm;
		JOptionPane.showMessageDialog(null,
				"Cost to paint " + wallNames + "wall(s) of " + wallArea + " sq.m. is $" + cost);
	}
}
