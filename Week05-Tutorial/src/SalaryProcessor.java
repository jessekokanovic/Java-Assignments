import javax.swing.JOptionPane;

public class SalaryProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] salaries; // Step 1: Declare name and type of array and its elements
		String[] jobs;
		int arraySize = Integer.parseInt(JOptionPane.showInputDialog("How many salaries?"));
		while(arraySize < 0) {
			arraySize = Integer.parseInt(JOptionPane.showInputDialog("Please enter a postive integer:"));
		}
		
		salaries = new double[arraySize]; // Step 2: Create and assign compatible array with 3 elements
		jobs = new  String[arraySize];
		int i = 0;
		while(i < arraySize) {
			jobs[i] = JOptionPane.showInputDialog("Enter the Job:");
			salaries[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter the salary:"));
			i++;
		}
		
		
		// Loop goes through indices 0, 1, 2
		i = 0;
		while (i < arraySize) {
		// Retrieve and display value at i (current element)
			System.out.println("Salary for job " + jobs[i] + " is $" + salaries[i]);
			i = i + 1;
		}
	}

}
