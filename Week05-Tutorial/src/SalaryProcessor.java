import javax.swing.JOptionPane;

public class SalaryProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] salaries; //empty array
		String[] jobs;
		int arraySize = Integer.parseInt(JOptionPane.showInputDialog("How many salaries?")); //get the size of the array from the user.
		//test to see if user is entering a positive number.
		while(arraySize < 0) {
			arraySize = Integer.parseInt(JOptionPane.showInputDialog("Please enter a postive integer:"));
		}
		
		salaries = new double[arraySize]; //initialise array with size determined by user
		jobs = new  String[arraySize];
		//Get the job names and salaries from the user.
		int i = 0;
		while(i < arraySize) {
			jobs[i] = JOptionPane.showInputDialog("Enter the Job:");
			salaries[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter the salary:"));
			i++;
		}
		
		//Calculate average salary by looping through the array and adding the salary values
		double totalSalary = 0;
		i = 0;
		while(i < arraySize) {
			totalSalary = totalSalary + salaries[i];
			i++;
		}
		
		//Total salary value divided by number of. You could round this value if you wanted to.
		double averageSalary = totalSalary/arraySize;	
		
		//Sort in ascending order using selection method.
		//Method obtained using https://www.youtube.com/watch?v=cqh8nQwuKNE by Joe James as a guide.
		i = 0;
		int j = 0;
		double minValue = 0; //minimum value in the array
		int minIndex = 0; //index of the minimum value in the array
		double swappedSalary = 0; //store a salary value temporarily so that we can exchange places in array
		String swappedJob; //store the string we need to swap places with
		
		
		//outer loop which will loop over the entire array. This assigns the first element in the array as the 
		//initial minimum value to be tested against the other elements.
		while(i < arraySize) {
			minValue = salaries[i];
			minIndex = i;
			j = i;
			//inner loop will determine if we have the correct minimum value by comparing the current minimum value against the next 
			//element (j) in the array. If the element is smaller, is is assigned as the new minimum.
			//this while loop only loops over values that haven't been sorted already.
			while(j < arraySize) {
				if(salaries[j] < minValue) {
					minValue = salaries[j];
					minIndex = j;
				}
				j++;
			}
			//if the minimum value found above is smaller than the current position in the array (i from the outer loop) swap the two values.
			if(minValue < salaries[i]) {
				swappedSalary = salaries[i];
				salaries[i] = salaries[minIndex];
				salaries[minIndex] = swappedSalary;
				swappedJob = jobs[i];
				jobs[i] = jobs[minIndex];
				jobs[minIndex] = swappedJob;
			}
			i++;		
		}
		
		
		//Loop over the array and print the information.
		i = 0;
		double salaryDifference;
		while (i < arraySize) {
			salaryDifference = salaries[i] - averageSalary;
			System.out.println("Salary for job " + jobs[i] + " is $" + salaries[i] + " which is $" + salaryDifference + " from the average.");
			i = i + 1;
		}
	}

}


//To resize an array without using another method I guess you could just make a new array of the correct size and fill it with the values from the old one.
//If concatenating arrays are a thing, you could make a new empty array and add it to the old one to extend it.
//For my assignment 2, I might just extend this tutorial to include a few more selective statements (option for the user to choose to sort)
//and refactor the sorting method into its own method. 