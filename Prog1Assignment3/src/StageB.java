// You must use this class as a base for your StageB/C/D class
// You can add additional attributes and methods if you wish
import java.util.Scanner;

public class StageB {
	private static int MAX_EXPD = 4;
	private static Expedition[] programme = new Expedition[MAX_EXPD];
	private static int numExpeditions = 0; // the current number of expeditions

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	   String selection;

	   // Stage D: attempt to load expedition data from a file
	   // loadData();
	   do {
		         // display menu options
		   System.out.println("   ***** Expedition Management System Menu *****");
		   System.out.println("A. Add New Expedition");
		   System.out.println("B. View Expedition");
		   System.out.println("C. List All Expeditions");
		   System.out.println("D. Sell Ticket");
		   System.out.println("E. Refund Ticket");		   
		   System.out.println("X. Exit");
		   System.out.println();

		   System.out.print("Enter selection: ");
		   selection = sc.nextLine();

		   System.out.println();

		            // process user's selection
		   switch (selection.toUpperCase()) {
		   	case "A":
		   		addNewExpedition();
		   		break;
		   	case "B":
		   		displayExpedition();
		   		break;
		   	case "C":
		        displayAllExpeditions();
		        break;       
		    case "D":
		        bookExpeditionTicket();
		        break;
		    case "E":
		        refundExpeditionTicket();
		        break;
		    case "X":
		        System.out.println("Exiting the program...");
		        break;
		    default:
		        System.out.println("Error - invalid selection!");
		   }
		   System.out.println();

	   } while (!selection.equalsIgnoreCase("X"));
	   // Stage D: attempt to save expedition data to a file
	   // saveData();
	   sc.close();
	}

	// If the programme array is not full, collect expedition details
	// from user, create new expedition object and store in programme array.
	// Display error message if array is full.
	private static void addNewExpedition() {
	}

	// A possibly useful helper method for determining
	// if an expedition with expeditionID of targetID is
	// stored in the system
	private static int findExpeditionPos(String targetID){
		for (int i = 0; i < numExpeditions; i++){
			if (programme[i].getExpeditionID().equals(targetID))
				return i;
		}
		return -1;
	}

	// Displays all expeditions
	private static void displayAllExpeditions() {
	}

	// Ask the user for an expeditionID and attempt to locate that expedition.
	// Displays located expedition, or an error message if not located
	private static void displayExpedition(){
	}

	// Attempts to book an expedition ticket for a user specified expedition ID.
	// Display error message if unable to book requested ticket for requested
	// expedition
	public static void bookExpeditionTicket() {
	}
	
	// Attempts to refund expedition tickets for a user specified expedition ID.
	// Display error message if unable to refund for requested
	// expedition
	public static void refundExpeditionTicket() {
	}
	
	// Stage D: loads all expedition data from a file
//	private static void loadData() {
//	}
	
	// Stage D: saves all expedition data to a file
//	private static void saveData() {
//	}
}