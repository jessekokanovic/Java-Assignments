import java.util.Scanner;

public class JourneyBookingSystem {
	
	public static void main(String[] args) {
		//Books seats on the train carriages
	
		//Menu String Constant
		String MENU = "\n[1] Display Available Seats\n[2] Book Seats\n[3] Quit";
		
		//Create initial values for available seats and number of passengers
		int[] firstSeats = {48, 48, 48, 48, 48};
		int[] standardSeats = {70, 70, 70, 70,  70};
		int[] excursionSeats = {95, 95, 95, 95, 95};
		int numAdults;
		int numChildren;
		int youngChildren;
		
		String[] STATIONS = {"Castlemaine", "Campbell", "Guildford", "Strangway", "Newstead", "Moolort"};
		
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
				System.out.println("\nPlease select your carriage:\n[1] First\n[2] Standard\n[3] Excursion");
				int userChoice = Integer.parseInt(console.nextLine());
		
				//Determine pricing based on carriage type and passenger type/number 
				if(userChoice == 1) {
					System.out.println("How many adults?");
					numAdults = Integer.parseInt(console.nextLine());
					
					if(numAdults > firstSeats) {
					//determine if the booking can be accepted or not
						System.out.println("No seats available!");
					}
					else {
						//Calculate cost, print receipt, adjust available seats
						
						printReceipt(1, numAdults, 0, 0);
						firstSeats = firstSeats - numAdults;
					}	

				}
				else if(userChoice == 2) {
					System.out.println("How many adults?");
					numAdults = Integer.parseInt(console.nextLine());
					System.out.println("How many Children (<18)?");
					numChildren = Integer.parseInt(console.nextLine());
					System.out.println("How many of these children are under 3 years old?");
					youngChildren = Integer.parseInt(console.nextLine());
					
					if((numAdults + numChildren) > standardSeats) {
					//determine if the booking can be accepted or not
						System.out.println("No seats available!");
					}
					else {
						//Calculate cost, print receipt, adjust available seats
					
						printReceipt(2, numAdults, numChildren, youngChildren);
						standardSeats = standardSeats - (numAdults + numChildren);
					}	
				}
				else if(userChoice == 3) {
					System.out.println("How many adults?");
					numAdults = Integer.parseInt(console.nextLine());
					System.out.println("How many Children (<18)?");
					numChildren = Integer.parseInt(console.nextLine());
					System.out.println("How many of these children are under 3 years old?");
					youngChildren = Integer.parseInt(console.nextLine());
					
					if((numAdults + numChildren) > excursionSeats) {
					//determine if the booking can be accepted or not
						System.out.println("No seats available!");
					}
					else {
						//Calculate cost, print receipt, adjust available seats
						
						printReceipt(3, numAdults, numChildren, youngChildren);
						excursionSeats = excursionSeats - (numAdults + numChildren);

						
					}	
				}
				
				//get the menu choice again
				System.out.println(MENU);
				menuChoice = Integer.parseInt(console.nextLine());
				
			}
		}
		System.exit(0);
	}

	
	public static void printReceipt(int trainClass, int numAdults, int numChildren, int youngChildren)  {
		//Calculate costs and show on receipt
		
		//Define pricing as constant integers 
		int FIRST_ADULT = 80;
		int STANDARD_ADULT = 55;
		int STANDARD_CHILD = 30;
		int EXCURSION_ADULT = 40;
		int EXCURSION_CHILD = 20;
		int adultCost =0;
		int childCost = 0;
		int childDiscount = 0;
		String carriage = "";
		
		if (trainClass == 1) {
			adultCost = numAdults * FIRST_ADULT;
			carriage = "First Class";
		}
		else if(trainClass == 2) {
			adultCost = numAdults * STANDARD_ADULT;
			childCost = numChildren * STANDARD_CHILD;
			childDiscount = youngChildren * STANDARD_CHILD;
			carriage = "Standard Class";
		}
		else if(trainClass == 3) {
			adultCost = numAdults * EXCURSION_ADULT;
			childCost = numChildren * EXCURSION_CHILD;
			childDiscount = youngChildren * EXCURSION_CHILD;
			carriage = "Excursion Class";
		}
		
		System.out.printf("%-6s %-6s %-6s\n","", carriage,"");
		System.out.println("------------------------------");
		System.out.printf("%-10s x%-10d $%-8d\n","Adults", numAdults, adultCost);
		System.out.printf("%-10s x%-10d $%-8d\n","Children", numChildren, childCost);
		System.out.printf("%-10s x%-10d-$%-8d\n", "Free Child", youngChildren, childDiscount);
		System.out.printf("%-10s  %-10s $%-8d\n", "TOTAL", "", adultCost + childCost - childDiscount);
		
	}

}
