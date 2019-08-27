import javax.swing.JOptionPane;


public class Assignment1 {

	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("Please enter a name:");
		double dollarAmount = Double.parseDouble(JOptionPane.showInputDialog("Please enter a dollar amount:"));
		int number = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number:"));
		String verb = JOptionPane.showInputDialog("Please enter a verb:");
		
		String story = "Once upon a time, there was a very happy chap by the name of "+name+". "+name+" absolutely loved the lion king, BUT, more importantly, loved Lion King collectibles.\n"
				+ "So when woolworths started giving out Lion King ooshies, "+name+" knew that they were going to spend their entire life savings of $"+dollarAmount+" to get them all!\n"
				+ "One day, on the hunt for the final ooshie in his "+number+" total ooshies collection, "+name+" asked the woolworths cashier for it.\n"
				+ "'Sorry mate but we're all out of the ooshies.'\nAbsolutely heartbroken, "+name+" "+verb+" home and threw away the entire ooshie collection.\n"
				+ "From that day foward, "+name+" shopped at Coles exclusively.";
		
		JOptionPane.showMessageDialog(null, story);

	}

}
