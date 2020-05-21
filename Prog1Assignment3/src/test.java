
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String expeditionID = "e123";
		String description = "Open Garden";
		String startingStation = "Castlemaine";
		
		// Testing with 3 ticket types: Adult ($12), Child ($6), Concession ($8)
		double [] ticketTypeCost = { 12.00, 6.00, 8.00};
		String [] ticketTypeDesc = {"Adult", "Child", "Concession"};		
		
		Expedition expedition = new Expedition(expeditionID, description, 
						startingStation,ticketTypeCost,ticketTypeDesc);
		expedition.displayExpedition();

	}

}
