
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String expeditionID = "e123";
		String description = "Open Garden";
		String startingStation = "Castlemaine";
		
		String endStation = "Flinders";
		String difficulty = "Medium";
		
		String bureau = "Hello World";
		String bureauNum = "0459196276";
		String[] activities = {"Swim", "Rock Climb", "Tea Party"};
		int maxSize = 20;

		// Testing with 3 ticket types: Adult ($12), Child ($6), Concession ($8)
		double [] ticketTypeCost = { 12.00, 6.00, 8.00};
		String [] ticketTypeDesc = {"Adult", "Child", "Concession"};	
	
	//TEST SELF EXPEDITION SUBCLASS
		
		SelfExpedition expedition = new SelfExpedition(expeditionID, description, 
						startingStation,ticketTypeCost,ticketTypeDesc,endStation, difficulty);
		expedition.displayExpedition();
		
		// Request booking for 2 adults, 3 children, 1 concession
		int [] bookTypeQty = {2, 3, 1};
		if (expedition.makeBooking(bookTypeQty)) {
			System.out.println("Booking successful");
			expedition.displayReceipt(bookTypeQty);
		}
		else 
			System.out.println("Booking unsuccessful");
		expedition.displayExpedition();
		System.out.println();
		
		// Request refund for 1 adult, 2 children, 0 concessions
		int [] refundTypeQty = {1, 2, 0};
		if (expedition.refundBooking(refundTypeQty)) {
			System.out.println("Refund of 1 adult, 2 children successful");
			expedition.displayReceipt(refundTypeQty);
		}
		else
			System.out.println("Refund of 1 adult, 2 children unsuccessful");
		expedition.displayExpedition();
		System.out.println();

		// Request refund for 0 adults, 2 children, 0 concessions
		int [] refundTypeQty2 = {0, 2, 0};
		if (expedition.refundBooking(refundTypeQty2)) {
			System.out.println("Refund of 2 children successful");
			expedition.displayReceipt(refundTypeQty2);
		}
		else
			System.out.println("Refund of 2 children unsuccessful");
		expedition.displayExpedition();
		
	//TEST FOR GROUP EXPEDITION SUB CLASS
		GroupExpedition expedition2 = new GroupExpedition(expeditionID, description, 
				startingStation,ticketTypeCost,ticketTypeDesc,bureau, bureauNum, maxSize, activities);
		expedition.displayExpedition();

		// Request booking for 2 adults, 3 children, 1 concession
		//int [] bookTypeQty = {2, 3, 1};
		if (expedition2.makeBooking(bookTypeQty)) {
			System.out.println("Booking successful");
			expedition2.displayReceipt(bookTypeQty);
		}
		else 
			System.out.println("Booking unsuccessful");
		expedition2.displayExpedition();
		System.out.println();
		
		// Request refund for 1 adult, 2 children, 0 concessions
		//int [] refundTypeQty = {1, 2, 0};
		if (expedition2.refundBooking(refundTypeQty)) {
			System.out.println("Refund of 1 adult, 2 children successful");
			expedition2.displayReceipt(refundTypeQty);
		}
		else
			System.out.println("Refund of 1 adult, 2 children unsuccessful");
		expedition2.displayExpedition();
		System.out.println();
		
		// Request refund for 0 adults, 2 children, 0 concessions
		//int [] refundTypeQty2 = {0, 2, 0};
		if (expedition2.refundBooking(refundTypeQty2)) {
			System.out.println("Refund of 2 children successful");
			expedition2.displayReceipt(refundTypeQty2);
		}
		else
			System.out.println("Refund of 2 children unsuccessful");
		expedition2.displayExpedition();
				
	}

}
