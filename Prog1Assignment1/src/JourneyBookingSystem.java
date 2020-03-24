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
		System.out.println("Please select your carriage:\n[F]irst: " + firstSeats + " seats available"
				+ "\n[S]tandard: " + standardSeats + " seats available"
						+ "\n[E]xcursion: " + excursionSeats + " seats available\n");
		String userChoice = console.nextLine().toLowerCase();
		
		//determine pricing based on user choice
		if(userChoice == "f") {
			System.out.println("How many adults?");
			numAdults = Integer.parseInt(console.nextLine());
			totalPrice = numAdults * FIRST_ADULT;
			
		}
		
		

	}

}
