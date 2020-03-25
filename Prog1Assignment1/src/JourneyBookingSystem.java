import java.util.Scanner;

public class JourneyBookingSystem {
	
	public static void main(String[] args) {
		//Books seats on the train carriages and produces a receipt.
		
		//Define pricing as constant integers 
		int FIRST_ADULT = 80;
		int STANDARD_ADULT = 55;
		int STANDARD_CHILD = 30;
		int EXCURSION_ADULT = 40;
		int EXCURSION_CHILD = 20;
		
		//Create initial values for available seats and number of passengers
		int firstSeats = 48;
		int standardSeats = 70;
		int excursionSeats = 95;
		int numAdults;
		int numChildren;
		int youngChildren;
		int totalPrice;
		
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Castlemaine-Moolort booking service!");
		System.out.println("Please select your carriage:\n[1] First: " + firstSeats + " seats available"
				+ "\n[2] Standard: " + standardSeats + " seats available"
						+ "\n[3] Excursion: " + excursionSeats + " seats available");
		int userChoice = Integer.parseInt(console.nextLine());
		
		//determine pricing 
		if(userChoice == 1) {
			System.out.println("How many adults?");
			numAdults = Integer.parseInt(console.nextLine());
			totalPrice = numAdults * FIRST_ADULT;	
		}
		else if(userChoice == 2) {
			System.out.println("How many adults?");
			numAdults = Integer.parseInt(console.nextLine());
			System.out.println("How many children? (Under 14)");
			numChildren = Integer.parseInt(console.nextLine());
			System.out.println("How many of these children are under 3 years old?");
			youngChildren = Integer.parseInt(console.nextLine());
			totalPrice = ((numChildren - youngChildren) * STANDARD_CHILD) + (numAdults * STANDARD_ADULT);
			
		}
		else if(userChoice == 3) {
			System.out.println("How many adults?");
			numAdults = Integer.parseInt(console.nextLine());
			System.out.println("How many children? (Under 14)");
			numChildren = Integer.parseInt(console.nextLine());
			System.out.println("How many of these children are under 3 years old?");
			youngChildren = Integer.parseInt(console.nextLine());
			totalPrice = ((numChildren - youngChildren) * EXCURSION_CHILD) + (numAdults * EXCURSION_ADULT);
			
		}
		

	}

}
