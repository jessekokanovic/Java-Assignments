import javax.swing.JOptionPane;


public class CPT120GradeMaker {

	public static void main(String[] args) {
		
		/*
		 * String name = JOptionPane.showInputDialog("Enter your name"); int age =
		 * Integer.parseInt(JOptionPane.showInputDialog("Enter your age")); double
		 * height =
		 * Double.parseDouble(JOptionPane.showInputDialog("Enter your height (m)"));
		 * double weight =
		 * Double.parseDouble(JOptionPane.showInputDialog("Enter your weight (Kg)"));
		 * double bmi = weight / (height * height); JOptionPane.showMessageDialog(null,
		 * "Hello " + name + "!"); JOptionPane.showMessageDialog(null, "You are " + age
		 * + " and your body mass index is " + bmi + ".");
		 */
		
		
		// Double is being used so a decimal can input from the user to account for half marks. Using an int
		//wouldn't allow us to do that. Using a string wouldn't let us perform calculations with the input.
		double iieTotal = Double.parseDouble(JOptionPane.showInputDialog("Enter your IIE total:"));
		double assignmentTotal = Double.parseDouble(JOptionPane.showInputDialog("Enter your assignment total:"));
		double examTotal = Double.parseDouble(JOptionPane.showInputDialog("Enter your exam total:"));
		
		//find the non-exam total, if it is larger than 50, set the value of the variable to 50.
		double nonExamTotal = iieTotal + assignmentTotal;
		if(nonExamTotal > 50){
			nonExamTotal = 50;
		}
		
		long finalMark = java.lang.Math.round(nonExamTotal + examTotal);
		String grade;
		
		if (finalMark >= 0 && finalMark <= 49) {
			grade = "NN";		
		}
		else if(finalMark >= 50 && finalMark <= 59) {
			grade = "PA";
		}
		else if(finalMark >= 60 && finalMark <= 69){
			grade = "CR";
		}
		else if(finalMark >= 70 && finalMark <= 79){
			grade = "DI";
		}
		else {
			grade = "HD";
		}
		
		JOptionPane.showMessageDialog(null, finalMark + " " + grade);
		
		

	}

}
