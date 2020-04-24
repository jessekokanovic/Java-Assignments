
public class Demonstration {
	//Create a demonstration event	
	private String id;
	private String title;
	private double baseFee;
	private int maxAttendence;
	private int startTime;
	private int duration;
	//private int[] attendees;

	public Demonstration(String id, String title, double baseFee, int maxAttendence, int startTime, int duration) {
		//Assign parameters to class variables in constructor.
		this.id = id;
		this.title = title;
		this.baseFee = baseFee;
		this.maxAttendence = maxAttendence;
		this.startTime = startTime;
		this.duration = duration;
		//this.attendees = new int[maxAttendence];
		
	}
	
	public void displayDetails(){
		//Display the event details
		System.out.printf("%-10s%-10s%-10s\n","", this.title, "");
		System.out.println("*********************************************************************");
		System.out.printf("%-20s%-20s%-20s\n", "", "EVENT ID:", this.id);
		System.out.printf("%-20s%-20s$%-20.2f\n", "", "BASE FEE:",this.baseFee);
		System.out.printf("%-20s%-20s%-20s\n", "", "MAX ATTENDENCE:", this.maxAttendence);
		System.out.printf("%-20s%-20s%-20s\n", "", "START TIME:", this.startTime + " (24 Hour Time)");
		System.out.printf("%-20s%-20s%-20s\n", "", "DURATION:", this.duration + " Minutes");		
	}
	
	public void calculateCost(int concession, int frs, int arhs) {
		//Calculate the correct cost based on what discount the reservation qualifies for, 0 for no 1 for yes
		if(arhs == 1) {
			//Discount by 25%
			System.out.println("Cost: $" + this.baseFee* 0.75);
		}
		else if(frs == 1){
			//discount 20%
			System.out.println("Cost: $" + this.baseFee* 0.80);
		}
		else if(concession == 1) {
			//discount 10%
			System.out.println("Cost: $" + this.baseFee* 0.90);
		}
		else {
			System.out.println(this.baseFee);
		}
		
		
		
		
	}

}
