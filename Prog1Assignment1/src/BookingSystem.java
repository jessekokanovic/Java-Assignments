import java.util.Scanner;

public class BookingSystem {
	
	private int numAdults;
	private int numChildren;
	private int youngChildren;
	private String[] STATIONS = {"Castlemaine", "Campbell", "Guildford", "Strangway", "Newstead", "Moolort"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BookingSystem booking = new BookingSystem();

	}
	
	public BookingSystem() {
		//Gathers booking information for a train ride
		
		Scanner console = new Scanner(System.in);
		String MENU = "\n[1] Display Available Seats\n[2] Book Seats\n[3] Quit";
		TrainService trainService = new TrainService(STATIONS);

		System.out.println("Welcome to the Castlemaine-Moolort booking service!");
		System.out.println(MENU);
		int menuChoice = Integer.parseInt(console.nextLine());
		while (menuChoice != 3) {
			if (menuChoice == 1) {
				//Check Available Seats
				trainService.listSeats();
				System.out.println(MENU);
				menuChoice = Integer.parseInt(console.nextLine());
			}
			else if (menuChoice == 2) {
				// Make a booking
				System.out.println("\nPlease select your carriage:\n[1] First\n[2] Standard\n[3] Excursion");
				int userChoice = Integer.parseInt(console.nextLine());
				System.out.println("\nPlease select your starting point:");
				for(int i = 0; i < STATIONS.length;i++) {
					System.out.printf("[%d] %s\n", i, STATIONS[i]);
				}
				int startPoint = Integer.parseInt(console.nextLine());
				System.out.println("\nPlease select your end point:");
				for(int i = 0; i < STATIONS.length;i++) {
					System.out.printf("[%d] %s\n", i, STATIONS[i]);
				}
				int endPoint = Integer.parseInt(console.nextLine());

				//Determine pricing based on carriage type and passenger type/number 
				if(userChoice == 1) {
					System.out.println("How many adults?");
					numAdults = Integer.parseInt(console.nextLine());
					
					if(numAdults > firstSeats[startPoint]) {
					//determine if the booking can be accepted or not
						System.out.println("No seats available!");
					}
					else {
						//Calculate cost, print receipt, adjust available seats
						printReceipt(STATIONS, 1, numAdults, 0, 0, startPoint, endPoint);
						//Adjust available seats for every station between the starting point and the end point. 
						for (int i = startPoint; i <= endPoint; i++) {
							firstSeats[i] = firstSeats[i] - numAdults;
						}
					}	
				}
				else if(userChoice == 2) {
					System.out.println("How many adults?");
					numAdults = Integer.parseInt(console.nextLine());
					System.out.println("How many Children (<18)?");
					numChildren = Integer.parseInt(console.nextLine());
					System.out.println("How many of these children are under 3 years old?");
					youngChildren = Integer.parseInt(console.nextLine());
					
					if((numAdults + numChildren) > standardSeats[startPoint]) {
					//determine if the booking can be accepted or not
						System.out.println("No seats available!");
					}
					else {
						//Calculate cost, print receipt, adjust available seats
						printReceipt(STATIONS, 2, numAdults, numChildren, youngChildren, startPoint, endPoint);
						//Adjust available seats for every station between the starting point and the end point. 
						for (int i = startPoint; i <= endPoint; i++) {
							standardSeats[i] = standardSeats[i] - (numAdults + numChildren);
						}
					}	
				}
				else if(userChoice == 3) {
					System.out.println("How many adults?");
					numAdults = Integer.parseInt(console.nextLine());
					System.out.println("How many Children (<18)?");
					numChildren = Integer.parseInt(console.nextLine());
					System.out.println("How many of these children are under 3 years old?");
					youngChildren = Integer.parseInt(console.nextLine());
					
					if((numAdults + numChildren) > excursionSeats[startPoint]) {
					//determine if the booking can be accepted or not
						System.out.println("No seats available!");
					}
					else {
						//Calculate cost, print receipt, adjust available seats
						printReceipt(STATIONS, 3, numAdults, numChildren, youngChildren, startPoint, endPoint);
						//Adjust available seats for every station between the starting point and the end point. 
						for (int i = startPoint; i <= endPoint; i++) {
							excursionSeats[i] = excursionSeats[i] - (numAdults + numChildren);
						}
					}	
				}
				//get the menu choice again
				System.out.println(MENU);
				menuChoice = Integer.parseInt(console.nextLine());
			}
		}
		System.exit(0);
		
	}
}
		

