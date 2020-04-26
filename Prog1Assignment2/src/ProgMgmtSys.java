import java.util.Scanner;

public class ProgMgmtSys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String MENU = "[1] Add an event"
				+ "[2] View specifc event\n"
				+ "[3] View all events\n"
				+ "[4] View event statistics\n"
				+ "[5] Add attendee reservation\n"
				+ "[6] Cancel reservation\n"
				+ "[7] Exit\n";
		
		//Determines the max number of events that the system will handle
		int numEvents = 5;
		
		String[][] events;
		int currentNumEvents;
		events = new String[numEvents][7];
		currentNumEvents = 0;
		
		Scanner console = new Scanner(System.in);
		
		//Get the menu selection from the user and perform the associated action
		int menuChoice = Integer.parseInt(console.nextLine());
		while(menuChoice != 7) {
			if(menuChoice == 1) {
				//check if there is space to add a new event and add it, otherwise tell the user there is no space.
				if(currentNumEvents >= numEvents) {
					//Check if the array is full and let the user know
					System.out.println("You cannot add another event!");	
				}
				else if(currentNumEvents == 0){
					//Add the first event to the array
					System.out.println("Enter event ID:");
					events[0][0] = console.nextLine();
					System.out.println("Enter event title:");
					events[0][1] = console.nextLine();
					System.out.println("Enter event base fee:");
					events[0][2]= console.nextLine();
					System.out.println("Enter maximum attendance:");
					events[0][3] = console.nextLine();
					System.out.println("Enter start time:");
					events[0][4]= console.nextLine();
					System.out.println("Enter duration:");
					events[0][5]= console.nextLine();
					events[0][7] = "0";
					currentNumEvents++;
				}
				else {
					//Add a new event if there exists a first event already
					System.out.println("Enter event ID:");
					events[currentNumEvents + 1][0] = console.nextLine();
					System.out.println("Enter event title:");
					events[currentNumEvents + 1][1] = console.nextLine();
					System.out.println("Enter event base fee:");
					events[currentNumEvents + 1][2]= console.nextLine();
					System.out.println("Enter maximum attendance:");
					events[currentNumEvents + 1][3] = console.nextLine();
					System.out.println("Enter start time:");
					events[currentNumEvents + 1][5]= console.nextLine();
					System.out.println("Enter duration:");
					events[currentNumEvents + 1][6]= console.nextLine();
					events[currentNumEvents + 1][7] = "0";
					currentNumEvents++;
				}
				
				menuChoice = Integer.parseInt(console.nextLine());
			}
			else if(menuChoice == 2) {
				//Display the details of a specific event	
				System.out.println("Enter the event ID of the demonstration you would like to see:");
				String idToDisplay = console.nextLine();
				
			}
		}
		
	}

}
