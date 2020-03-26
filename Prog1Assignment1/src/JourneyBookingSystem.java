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
		
		//Menu String Constant
		String MENU = "[1] Display Available Seats\n[2] Book Seats\n[3] Quit";
		
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
		System.out.println(MENU);
		int menuChoice = Integer.parseInt(console.nextLine());
		while (menuChoice != 3) {
			if (menuChoice == 1) {
				//Check Available Seats
				
				System.out.println("First: " + firstSeats + " seats available"
				+ "\nStandard: " + standardSeats + " seats available"
						+ "\nExcursion: " + excursionSeats + " seats available\n");
				System.out.println(MENU);
				menuChoice = Integer.parseInt(console.nextLine());
			}
			else if (menuChoice == 2) {
				// Make a booking
				
				System.out.println("Please select your carriage:\n[1] First\n[2] Standard\n[3] Excursion");
				int userChoice = Integer.parseInt(console.nextLine());
		
				//Determine pricing based on carriage type and passenger type/number 
				if(userChoice == 1) {
					System.out.println("How many adults? ($80)");
					numAdults = Integer.parseInt(console.nextLine());
					totalPrice = numAdults * FIRST_ADULT;	
					//Read out total price
					System.out.println(totalPrice);
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
				
				//generate and print the reciept
				
				//get the menu choice again
				
			}
		}
		System.exit(0);
	}

}
