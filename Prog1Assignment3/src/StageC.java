// You must use this class as a base for your StageB/C/D class
// You can add additional attributes and methods if you wish

import java.util.Scanner;

public class StageC {
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
		
		//check if there is space for a new expedition
		if(numExpeditions < MAX_EXPD) {
			//if there is space for one, add a new expedition
			System.out.println("Type of Expedition:\n[1]Self\n[2]Group");
			int expeditionType = Integer.parseInt(sc.nextLine());
			System.out.println("Expedition ID: ");
			String newID = sc.nextLine();
			System.out.println("Description: ");
			String newDescription = sc.nextLine();
			System.out.println("Starting Station: ");
			String newStart = sc.nextLine();
			System.out.println("Number of ticket types: ");
			int numTypes = Integer.parseInt(sc.nextLine());
			double[] newCosts = new double[numTypes];
			System.out.println("Cost of tickets:");
			for(int i=0; i<numTypes; i++) {
				newCosts[i] = Double.parseDouble(sc.nextLine());
			}
			String[] newTickets = new String[numTypes];
			System.out.println("Ticket Descriptions: ");
			for(int i=0; i<numTypes; i++) {
				newTickets[i] = sc.nextLine();
			}
			if(expeditionType == 1) {
				//add a new self expedition
				System.out.println("End Station: ");
				String endStation = sc.nextLine();
				System.out.println("Difficulty: ");
				String difficulty = sc.nextLine();
				SelfExpedition newExpedition = new SelfExpedition(newID, newDescription, 
						newStart, newCosts, newTickets, endStation, difficulty);
				programme[numExpeditions] = newExpedition;

			}
			else if(expeditionType == 2){
				//add a new group expedition
				System.out.println("Bureau: ");
				String bureau = sc.nextLine();
				System.out.println("Bureau Phone: ");
				String bureauNum = sc.nextLine();
				System.out.println("Max Group Size: ");
				int maxGroupSize = Integer.parseInt(sc.nextLine());
				System.out.println("Number of Activities: ");
				int numActivities = Integer.parseInt(sc.nextLine());
				String[] activities = new String[numActivities];
				System.out.println("Activity Names: ");
				for(int i=0;i<numActivities;i++) {
					activities[i] = sc.nextLine();
				}
				GroupExpedition newExpedition = new GroupExpedition(newID, newDescription, 
						newStart, newCosts, newTickets, bureau, bureauNum, maxGroupSize, activities);
				programme[numExpeditions] = newExpedition;
			}
			
			
			numExpeditions++;
		}
		else {
			//else we return an error message
			System.out.println("Maximum number of expeditions already reached!");
		}
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
		for(int i=0; i<numExpeditions; i++) {
			programme[i].displayExpedition();
		}	
	}

	// Ask the user for an expeditionID and attempt to locate that expedition.
	// Displays located expedition, or an error message if not located
	private static void displayExpedition(){
		System.out.println("Enter ID: ");
		String targetID = sc.nextLine();
		int idFound = findExpeditionPos(targetID);
		if(idFound == -1) {
			System.out.println("Expedition not found");
		}
		else {
			programme[idFound].displayExpedition();
		}
	}

	// Attempts to book an expedition ticket for a user specified expedition ID.
	// Display error message if unable to book requested ticket for requested
	// expedition
	public static void bookExpeditionTicket() {
		System.out.println("Expedition ID for booking: ");
		String targetID = sc.nextLine();
		int idFound = findExpeditionPos(targetID);
		if(idFound == -1) {
			System.out.println("Expedition not found");
		}
		else {
			int bookingLength = programme[idFound].ticketTypeDesc.length;
			int[] bookingTypeQty = new int[bookingLength];
			for(int i=0; i < bookingLength; i++) {
				System.out.println("Number of " + programme[idFound].getTicketTypeDesc(i) + " tickets:");
				bookingTypeQty[i] = Integer.parseInt(sc.nextLine());
			}
			if(programme[idFound].makeBooking(bookingTypeQty)) {
				System.out.println("Booking Successful!");
				programme[idFound].displayReceipt(bookingTypeQty);
			}
			else {
				System.out.println("Booking Unsuccessful");
			}
		}
		
	}
	
	// Attempts to refund expedition tickets for a user specified expedition ID.
	// Display error message if unable to refund for requested
	// expedition
	public static void refundExpeditionTicket() {
		System.out.println("Expedition ID for refund: ");
		String targetID = sc.nextLine();
		int idFound = findExpeditionPos(targetID);
		if(idFound == -1) {
			System.out.println("Expedition not found");
		}
		else {
			int refundLength = programme[idFound].ticketTypeDesc.length;
			int[] refundTypeQty = new int[refundLength];
			for(int i=0; i < refundLength; i++) {
				System.out.println("Number of " + programme[idFound].getTicketTypeDesc(i) + " tickets:");
				refundTypeQty[i] = Integer.parseInt(sc.nextLine());
			}
			if(programme[idFound].refundBooking(refundTypeQty)) {
				System.out.println("Refund Successful!");
				programme[idFound].displayReceipt(refundTypeQty);
			}
			else {
				System.out.println("Refund Unsuccessful");
			}
		}
		
		
	}
	
	// Stage D: loads all expedition data from a file
//	private static void loadData() {
//	}
	
	// Stage D: saves all expedition data to a file
//	private static void saveData() {
//	}
}
