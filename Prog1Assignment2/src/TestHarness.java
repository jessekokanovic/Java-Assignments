
public class TestHarness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Max attendance needed to be set to 4 instead of three in order to test every case in testCases.pdf
		Demonstration d123 = new Demonstration("d123", "Inspect and prepare a heritage steam locomotive", 100.00,
				4, 10, 180);
		
		
		//test displaying details
		d123.displayDetails();
		
		//test discount application
		//no discount
		d123.calculateCost(0, 0, 0, 0);
		//concession want 90
		d123.calculateCost(1, 0, 0, 0);
		//frs want 80
		d123.calculateCost(0, 1, 0, 0);
		//arhs want 75
		d123.calculateCost(0, 0, 1, 0);
		//mhr want 0
		d123.calculateCost(0, 0, 0, 1);
		//all memberships want 0
		d123.calculateCost(1, 1, 1, 1);
		
		//add attendee with no discounts (calculate cost method can be performed first)
		int bookSuccessful = d123.bookReservation("E. Burnett", "0459196276", "d123", d123.calculateCost(0, 0, 0, 0));
		if (bookSuccessful == 1){
			System.out.println("Booking Confirmed!");
		}
		else {
			System.out.println("Booking unsuccessful.");
		}
		d123.displayDetails();
		
		//add second booking (Booking should be confirmed)
		bookSuccessful = d123.bookReservation("R. Sharma", "555-2277", "d123", d123.calculateCost(0, 0, 0, 0));
		if (bookSuccessful == 1){
			System.out.println("Booking Confirmed!");
		}
		else {
			System.out.println("Booking unsuccessful.");
		}
		d123.displayDetails();
		
		//add a third booking with ahrs membership (booking should be confirmed)
		bookSuccessful = d123.bookReservation("B. Jones", "555-1234", "d123", d123.calculateCost(0, 0, 1, 0));
		if (bookSuccessful == 1){
			System.out.println("Booking Confirmed!");
		}
		else {
			System.out.println("Booking unsuccessful.");
		}
		d123.displayDetails();
		
		//add a fourth booking with fsrs membership
		bookSuccessful = d123.bookReservation("K. Nguyen", "555-9999", "d123", d123.calculateCost(0, 1, 0, 0));
		if (bookSuccessful == 1){
			System.out.println("Booking Confirmed!");
		}
		else {
			System.out.println("Booking unsuccessful.");
		}
		d123.displayDetails();
		
		//add a fifth booking (this should be unsuccessful)
		bookSuccessful = d123.bookReservation("D. Vader", "555-6660", "d123", d123.calculateCost(1, 0, 0, 0));
		if (bookSuccessful == 1){
			System.out.println("Booking Confirmed!");
		}
		else {
			System.out.println("Booking unsuccessful.");
		}
		d123.displayDetails();
	}

}
