
public class SalaryProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] salaries; // Step 1: Declare name and type of array and its elements
		salaries = new double[3]; // Step 2: Create and assign compatible array with 3 elements
		salaries[0] = 80000.0; // Assign value to first element
		salaries[1] = 100000.0; // Assign value to second element
		salaries[2] = 70000.0; // Assign value to third (last) element
		
		// Loop goes through indices 0, 1, 2
		int i = 0;
		while (i < 3) {
		// Retrieve and display value at i (current element)
			System.out.println("Salary at element " + i + " is $" + salaries[i]);
			i = i + 1;
		}
	}

}
