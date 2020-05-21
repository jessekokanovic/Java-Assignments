
public class GroupExpedition extends Expedition {
	
	private String bureau;
	private String bureauNum;
	private int maxGroupSize;
	private String[] activites;
	private int groupSize;
	
	
	public GroupExpedition(String expeditionID, String description, 
			  String startingStation, double[] ticketTypeCost,
			  String[] ticketTypeDesc, String bureau, String bureauNum, int maxGroupSize, String[] activities) {
		super(expeditionID, description, startingStation, ticketTypeCost, ticketTypeDesc);
		this.bureau = bureau;
		this.bureauNum = bureauNum;
		this.maxGroupSize = maxGroupSize;
		this.activites = activities;
		this.groupSize = 0;
	}
	
	public int getNumActivities() {
		return this.activites.length;
	}
	
	@Override
	public void displayExpedition() {
		System.out.printf("%-14s%-2s%-12s\n", "Id", ":", getExpeditionID());
		System.out.printf("%-14s%-2s%-12s\n", "Description", ":", getDescription());
		System.out.printf("%-14s%-2s%-12s\n", "Bureau", ":", this.bureau);
		System.out.printf("%-14s%-2s%-12s\n", "Bureau Phone", ":", this.bureauNum);
		System.out.printf("%-14s%-2s%-12s\n", "Start Station", ":", this.startingStation);
		System.out.printf("%-14s%-2s%-12s\n", "Activities", ":", this.activites[0]);
		for(int i=1; i<getNumActivities();i++) {
			System.out.printf("%-14s%-2s%-12s\n", "          ", ":", this.activites[i]);
		}
		System.out.printf("%-14s%-2s%-5s%-2s%-5s\n", "Ticket Type", ":", "Cost", ":", "#Sold");
		System.out.println("--------------:------:------");
		for(int i=0;i < getNumTicketTypes();i++) {
			//for loop is used to account for different number of ticket types for different expeditions
			System.out.printf("%-14s%-2s$%-5s%-2s%-5s\n", this.ticketTypeDesc[i], ":", this.ticketTypeCost[i], ":", this.ticketTypeSold[i]);
		}
	}
	
	@Override
	public void displayReceipt(int ticketTypeQty[]) {
		double cost = 0;
		double total = 0;
		System.out.printf("%-14s%-2s%-12s\n", "Id", ":", getExpeditionID());
		System.out.printf("%-14s%-2s%-12s\n", "Description", ":", getDescription());
		System.out.printf("%-14s%-2s%-12s\n", "Bureau", ":", this.bureau);
		System.out.printf("%-14s%-2s%-12s\n", "Bureau Phone", ":", this.bureauNum);
		System.out.printf("%-14s%-2s%-12s\n", "Start Station", ":", this.startingStation);
		System.out.printf("%-14s%-2s%-12s\n", "Activities", ":", this.activites[0]);
		for(int i=1; i<getNumActivities();i++) {
			System.out.printf("%-14s%-2s%-12s\n", "          ", ":", this.activites[i]);
		}
		for(int i=0;i < getNumTicketTypes();i++) {
			//for loop is used to account for different number of ticket types for different expeditions
			cost = this.ticketTypeCost[i] * ticketTypeQty[i];
			total = total + cost;
			System.out.printf("%-14s%-2s%-2s%-2s$%-5s%-2s$%-5s\n", this.ticketTypeDesc[i], "*", ticketTypeQty[i], "@", this.ticketTypeCost[i], "=", cost);
		}
		System.out.printf("%-14s%-2s%-2s%-2s%-5s%-2s$%-5s\n", "Ticket Total", " ", " ", " "," ", " = ", total);
	}
	
	@Override
	public boolean makeBooking(int[] ticketTypeQty) {
		//we must check that the total booking party doesn't exceed the max number of people allowed
		for(int i=0; i<getNumTicketTypes();i++) {
			//sum the ints in the array to get the total size of the booking party
			this.groupSize = this.groupSize + ticketTypeQty[i];
		}
		if(this.groupSize <= this.maxGroupSize) {
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
		else {
			return false;
		}
	}

}
