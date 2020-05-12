
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
	}
			
	public String getExpeditionID() {
		return null;
	}

	// Returns the number of different ticket types
	public int getNumTicketTypes(){
		return 0;
	}
	
	// Returns the description of ticket type at index i
	public String getTicketTypeDesc(int i) {
		return null;
	}

	// Displays booking receipt.
	// Accepts an array specifying the number of various ticket types required
	public void displayReceipt(int ticketTypeQty[]) {
	} 

	// Makes a booking. Returns true if booking is successful.
	// The method signature will need to be modified for stage D
	public boolean makeBooking(int[] ticketTypeQty){
		return false;
	}
	
	// Attempts to refund a booking. Parameter specifies how many of each
	// type of ticket to refund. 
	// Returns false if refund can't be performed, true otherwise.
	// The method signature will need to be modified for stage D
	public boolean refundBooking(int[] refundTypeQty){
		return false;
	}
	
	// Display expedition details, including ticket types and associated costs
	public void displayExpedition() {
	}
	
	// Stage D: writes out all expedition data to file
//	public void writeData(PrintWriter pw) {
//	}

	// Stage D: reads in all expedition data from file
//	public void readData(Scanner fileScanner) {
//	}	
}