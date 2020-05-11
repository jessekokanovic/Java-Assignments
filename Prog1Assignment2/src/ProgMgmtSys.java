import java.util.Scanner;

public class ProgMgmtSys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String MENU = "[1] Add an event\n"
				+ "[2] View specifc event\n"
				+ "[3] View all events\n"
				+ "[4] View event statistics\n"
				+ "[5] Add attendee reservation\n"
				+ "[6] Cancel reservation\n"
				+ "[7] Exit\n";
		
		//Determines the max number of events that the system will handle
		int numEvents = 5;
		
		String[][] eventAttendees = new String[numEvents][2];  
		String[][] events;
		int currentNumEvents;
		events = new String[numEvents][7];
		//populate the arrays with all 0's so that I don't have to deal with null
		for(int i = 0; i < numEvents;i++) {
			for(int j = 0; j < 7;j++) {
				events[i][j] = "0";
			}
		}
		
		currentNumEvents = 0;
		
		Scanner console = new Scanner(System.in);
		
		//Get the menu selection from the user and perform the associated action
		System.out.println(MENU);
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
					String id = console.nextLine();
					events[0][0] = id;
					eventAttendees[0][0] = id;
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
					events[0][6] = "0";
					currentNumEvents++;
					
					System.out.println(events[0][0]);
				}
				else {
					//Add a new event if there exists a first event already
					System.out.println("Enter event ID:");
					events[currentNumEvents + 1][0] = console.nextLine();
					String id = console.nextLine();
					events[currentNumEvents + 1][0] = id;
					eventAttendees[currentNumEvents + 1][0] = id;
					System.out.println("Enter event title:");
					events[currentNumEvents + 1][1] = console.nextLine();
					System.out.println("Enter event base fee:");
					events[currentNumEvents + 1][2]= console.nextLine();
					System.out.println("Enter maximum attendance:");
					events[currentNumEvents + 1][3] = console.nextLine();
					System.out.println("Enter start time:");
					events[currentNumEvents + 1][4]= console.nextLine();
					System.out.println("Enter duration:");
					events[currentNumEvents + 1][5]= console.nextLine();
					events[currentNumEvents + 1][6] = "0";
					currentNumEvents++;
				}
				
				//Get a new menu selection from the user
				System.out.println(MENU);
				menuChoice = Integer.parseInt(console.nextLine());
			}
			else if(menuChoice == 2) {
				//Display the details of a specific event	
				System.out.println("Enter the event ID of the demonstration you would like to see:");
				String idToDisplay = console.nextLine();
				int selectedEvent = 0;
				int foundEvent = 0;
				for(int i = 0; i < numEvents;i++) {
					//Loop over the array to find the event that matches the input ID
					if(idToDisplay.equals(events[i][0])){
						foundEvent = 1;
						selectedEvent = i;
					}
				}
				System.out.println(selectedEvent);
				if(foundEvent == 1) {
				//make a demonstration object and use methods in Demonstration.java to display details
				Demonstration displayEvent = new Demonstration(events[selectedEvent][0], events[selectedEvent][1], Integer.parseInt(events[selectedEvent][2]), 
						Integer.parseInt(events[selectedEvent][3]), Integer.parseInt(events[selectedEvent][4]), Integer.parseInt(events[selectedEvent][5]));
				displayEvent.displayDetails();
				System.out.printf("%-20s%-20s%-20s\n", "", "AVAILABLE SEATS:", Integer.parseInt(events[selectedEvent][3]) - Integer.parseInt(events[selectedEvent][6]));
				}
				else if (foundEvent == 0){
					//Let the user know that nothing could be displayed 
					System.out.println("No event found!");
				}
				//Get a new menu selection from the user
				System.out.println(MENU);
				menuChoice = Integer.parseInt(console.nextLine());
			}
			else if(menuChoice == 3) {
				//display the details for all the events
				for(int i = 0; i < numEvents;i++) {
					if(events[i][0].equals("0")) {
						//if the event id is empty (equal to 0) do nothing
						continue;
					}
					else{
						//create a demonstration object and print the details
						Demonstration displayEvent = new Demonstration(events[i][0], events[i][1], Integer.parseInt(events[i][2]), 
								Integer.parseInt(events[i][3]), Integer.parseInt(events[i][4]), Integer.parseInt(events[i][5]));
						displayEvent.displayDetails();
						System.out.printf("%-20s%-20s%-20s\n", "", "AVAILABLE SEATS:", Integer.parseInt(events[i][3]) - Integer.parseInt(events[i][6]));
					}
					
					//Get a new menu selection from the user
					System.out.println(MENU);
					menuChoice = Integer.parseInt(console.nextLine());	
				}
			}
			else if(menuChoice == 4) {
				//Calculate and view event statistics
			}
			else if(menuChoice == 5) {
				//Book a reservation for the specified event
				
				
			}
		}
		
	}

}
