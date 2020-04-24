
public class TestHarness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demonstration d123 = new Demonstration("d123", "Inspect and prepare a heritage steam locomotive", 100.00,
				3, 10, 180);
		
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
		
		
		
	}

}
