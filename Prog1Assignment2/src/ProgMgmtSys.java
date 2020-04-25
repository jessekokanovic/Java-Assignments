import java.util.Scanner;

public class ProgMgmtSys {
	//Program for managing demonstrations
	private String[][] demonstrations;
	
	public  ProgMgmtSys(int numDemos) {
		//construct an array to hold the information for each demonstration
		this.demonstrations = new String[numDemos][6];
	}

	public static void main(String[] args) {
		//Run the management system
		String MENU = "[1] View specifc event\n"
				+ "[2] View all events\n"
				+ "[3] View event statistics\n"
				+ "[4] Add attendee reservation\n"
				+"[5] Cancel reservation\n"
				+"[6] Exit\n";
		
		//Determines the max number of events that the system will handle
		int numEvents = 5;
		
		Scanner console = new Scanner(System.in);
		ProgMgmtSys mgmtSys = new ProgMgmtSys(numEvents);
		
		//Get the menu selection from the user and perform the associated action
		int menuChoice = Integer.parseInt(console.nextLine());
		while(menuChoice != 6) {
			if(menuChoice == 1) {
				
			}
		}

	}

}
