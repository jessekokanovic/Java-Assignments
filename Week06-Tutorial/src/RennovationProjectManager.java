import javax.swing.JOptionPane;

public class RennovationProjectManager {

	public static void main(String[] args) {
		double wallArea = 0, cost, height, length, costPerSqm;
		int selection;
		String tempInput, wallNames;
		String menu = "Menu:\n";
		menu += "1. Calculate paint required for a wall\n";	//string to hold menu selections
		menu += "2. Calculate paint required for project";
		tempInput = JOptionPane.showInputDialog(menu);	//get the menu selection from the user 
		
		//This loop continues to run as long as the user supplies another menu option, program will exit if no option is supplied.
		while (tempInput != null) {
			selection = Integer.parseInt(tempInput);	//parse the selection as an integer.
			//if the user selects 1, calculate the paint required for a wall.
			//get the height, length, name and cost/sqm from the user and calculate total dollars,
			if (selection == 1) {
				costPerSqm = Double.parseDouble(JOptionPane.showInputDialog("Enter cost per sq.m ($)"));
				tempInput = JOptionPane.showInputDialog("Enter a wall name");
				height = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall height (m)"));
				length = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall length (m)"));
				wallArea = height * length;
				cost = wallArea * costPerSqm;
				JOptionPane.showMessageDialog(null,
						"Cost to paint " + tempInput + " wall of " + wallArea + " sq.m. is $" + cost);
			} 
			//if the user selects 2, calculate the paint required for a whole project.
			//get the height, length, name and cost for each wall and add them together
			else if (selection == 2) {
				costPerSqm = Double.parseDouble(JOptionPane.showInputDialog("Enter cost per sq.m ($)")); 
				wallNames = "";
				wallArea = 0;
				cost = 0;
				tempInput = JOptionPane.showInputDialog("Enter a wall name (cancel to finish)");
				//continuously get inputs from the user and total the heights and lengths for each wall.
				//no input will continue the program.
				while (tempInput != null) {
					height = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall height (m)"));
					length = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall length (m)"));
					wallArea += height * length;
					wallNames += tempInput + ", ";
					tempInput = JOptionPane.showInputDialog("Enter a wall name (cancel to finish)");
				}
				cost = wallArea * costPerSqm;
				JOptionPane.showMessageDialog(null,
						"Cost to paint " + wallNames + "wall(s) of " + wallArea + " sq.m. is $" + cost);
			}
			//if 1 or 2 is not input, display error message.
			else {
				JOptionPane.showMessageDialog(null, "Invalid choice!");
			}
			
			//get another menu selection from the user
			tempInput = JOptionPane.showInputDialog(menu);
		}
	}
}
