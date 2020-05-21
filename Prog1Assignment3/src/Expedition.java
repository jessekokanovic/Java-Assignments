
// Expedition class models an expedition, as per assignment 3 specifications
public class Expedition {
	private String expeditionID; 
	private String description;
	protected String startingStation;

	protected double[] ticketTypeCost; // Holds the cost of each type of ticket
	protected String[] ticketTypeDesc; // Holds the description of each type of ticket
	protected int[] ticketTypeSold; // Records how many of each ticket type
									// have been sold.
	// Constructor for stage D
	public Expedition() {
	}
	
	// Constructor for stage A/B/C/D
	public Expedition(String expeditionID, String description, 
					  String startingStation, double[] ticketTypeCost,
					  String[] ticketTypeDesc) {
		// Set up relevant attributes here
		this.expeditionID = expeditionID;
		this.description = description;
		this.startingStation = startingStation;
		this.ticketTypeCost = ticketTypeCost;
		this.ticketTypeDesc = ticketTypeDesc;
		//set the default value of the number of tickets sold to zero
		this.ticketTypeSold = new int[getNumTicketTypes()];
		for(int i=0; i<getNumTicketTypes();i++) {
			ticketTypeSold[i] = 0;
		}
				
	}
			
	public String getExpeditionID() {
		return this.expeditionID;
	}
	
	public String getDescription() {
		return this.description;
	}

	// Returns the number of different ticket types
	public int getNumTicketTypes(){
		return this.ticketTypeDesc.length;
	}
	
	// Returns the description of ticket type at index i
	public String getTicketTypeDesc(int i) {
		return this.ticketTypeDesc[i];
	}

	// Displays booking receipt.
	// Accepts an array specifying the number of various ticket types required
	public void displayReceipt(int ticketTypeQty[]) {
		double cost = 0;
		double total = 0;
		System.out.printf("%-14s%-2s%-12s\n", "Id", ":", this.expeditionID);
		System.out.printf("%-14s%-2s%-12s\n", "Description", ":", this.description);
		System.out.printf("%-14s%-2s%-12s\n", "Start Station", ":", this.startingStation);
		for(int i=0;i < getNumTicketTypes();i++) {
			//for loop is used to account for different number of ticket types for different expeditions
			cost = this.ticketTypeCost[i] * ticketTypeQty[i];
			total = total + cost;
			System.out.printf("%-14s%-2s%-2s%-2s$%-5s%-2s$%-5s\n", this.ticketTypeDesc[i], "*", ticketTypeQty[i], "@", this.ticketTypeCost[i], "=", cost);
		}
		System.out.printf("%-14s%-2s%-2s%-2s%-5s%-2s$%-5s\n", "Ticket Total", " ", " ", " "," ", " = ", total);
	} 

	// Makes a booking. Returns true if booking is successful.
	// The method signature will need to be modified for stage D
	public boolean makeBooking(int[] ticketTypeQty){
		 if(ticketTypeQty.length == this.getNumTicketTypes()) {
			 //if the booking we are trying to make matches the tickets available
			 for(int i=0;i<getNumTicketTypes(); i++) {
				 this.ticketTypeSold[i] = ticketTypeQty[i];
			 }
			 return true;
		 }
		 else {
			 
			 return false;
		 }
	}
	
	// Attempts to refund a booking. Parameter specifies how many of each
	// type of ticket to refund. 
	// Returns false if refund can't be performed, true otherwise.
	// The method signature will need to be modified for stage D
	public boolean refundBooking(int[] refundTypeQty){
		boolean success = false;
		for(int i=0;i<getNumTicketTypes();i++) {
			if(refundTypeQty[i] <= this.ticketTypeSold[i]) {
				this.ticketTypeSold[i] = this.ticketTypeSold[i] - refundTypeQty[i];
				success = true;
			}
			else {
				success = false;
				break;
			}
		}
		return success;
	}
	
	// Display expedition details, including ticket types and associated costs
	public void displayExpedition() {
		System.out.printf("%-14s%-2s%-12s\n", "Id", ":", this.expeditionID);
		System.out.printf("%-14s%-2s%-12s\n", "Description", ":", this.description);
		System.out.printf("%-14s%-2s%-12s\n", "Start Station", ":", this.startingStation);
		System.out.printf("%-14s%-2s%-5s%-2s%-5s\n", "Ticket Type", ":", "Cost", ":", "#Sold");
		System.out.println("--------------:------:------");
		for(int i=0;i < getNumTicketTypes();i++) {
			//for loop is used to account for different number of ticket types for different expeditions
			System.out.printf("%-14s%-2s$%-5s%-2s%-5s\n", this.ticketTypeDesc[i], ":", this.ticketTypeCost[i], ":", this.ticketTypeSold[i]);
		}
	}
	
	// Stage D: writes out all expedition data to file
//	public void writeData(PrintWriter pw) {
//	}

	// Stage D: reads in all expedition data from file
//	public void readData(Scanner fileScanner) {
//	}	
}
