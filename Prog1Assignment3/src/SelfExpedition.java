
public class SelfExpedition extends Expedition {
	//subclass that inherits expedition

	//new instance variables
	private String endStation;
	private String difficulty;
	
	public SelfExpedition(String expeditionID, String description, 
			  String startingStation, double[] ticketTypeCost,
			  String[] ticketTypeDesc, String endStation, String difficulty) {
		super(expeditionID, description, startingStation, ticketTypeCost, ticketTypeDesc);
		this.endStation = endStation;
		this.difficulty = difficulty;
	}
	
	public String getEndStation() {
		//Get the end station
		return this.endStation;
	}
	
	public String getDifficulty() {
		//Get the difficulty
		return this.difficulty;
	}
	
	@Override
	public void displayExpedition() {
		System.out.printf("%-14s%-2s%-12s\n", "Id", ":", getExpeditionID());
		System.out.printf("%-14s%-2s%-12s\n", "Description", ":", getDescription());
		System.out.printf("%-14s%-2s%-12s\n", "Start Station", ":", this.startingStation);
		System.out.printf("%-14s%-2s%-12s\n", "End Station", ":", this.endStation);
		System.out.printf("%-14s%-2s%-12s\n", "Difficulty", ":", this.difficulty);
		System.out.printf("%-14s%-2s%-5s%-2s%-5s\n", "Ticket Type", ":", "Cost", ":", "#Sold");
		System.out.println("--------------:------:------");
		for(int i=0;i < getNumTicketTypes();i++) {
			//for loop is used to account for different number of ticket types for different expeditions
			System.out.printf("%-14s%-2s$%-5s%-2s%-5s\n", this.ticketTypeDesc[i], ":", this.ticketTypeCost[i], ":", this.ticketTypeSold[i]);
		}		
	}

	@Override
	public void displayReceipt(int ticketTypeQty[]){
		double cost = 0;
		double total = 0;
		System.out.printf("%-14s%-2s%-12s\n", "Id", ":", getExpeditionID());
		System.out.printf("%-14s%-2s%-12s\n", "Description", ":", getDescription());
		System.out.printf("%-14s%-2s%-12s\n", "Start Station", ":", this.startingStation);
		System.out.printf("%-14s%-2s%-12s\n", "End Station", ":", this.endStation);
		System.out.printf("%-14s%-2s%-12s\n", "Difficulty", ":", this.difficulty);
		for(int i=0;i < getNumTicketTypes();i++) {
			//for loop is used to account for different number of ticket types for different expeditions
			cost = this.ticketTypeCost[i] * ticketTypeQty[i];
			total = total + cost;
			System.out.printf("%-14s%-2s%-2s%-2s$%-5s%-2s$%-5s\n", this.ticketTypeDesc[i], "*", ticketTypeQty[i], "@", this.ticketTypeCost[i], "=", cost);
		}
		System.out.printf("%-14s%-2s%-2s%-2s%-5s%-2s$%-5s\n", "Ticket Total", " ", " ", " "," ", " = ", total);
		
	}
}
