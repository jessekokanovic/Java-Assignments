
public class Demonstration {
	//Create a demonstration event	
	private String id;
	private String title;
	private double baseFee;
	private int maxAttendance;
	private int startTime;
	private int duration;
	private String[][] attendees;
	private int currentAttendance;

	public Demonstration(String id, String title, double baseFee, int maxAttendance, int startTime, int duration) {
		//Assign parameters to class variables in constructor.
		this.id = id;
		this.title = title;
		this.baseFee = baseFee;
		this.maxAttendance = maxAttendance;
		this.startTime = startTime;
		this.duration = duration;
		this.attendees = new String[maxAttendance][4];
		this.currentAttendance = 0;
		
	}
	
	public void displayDetails(){
		//Display the event details
		System.out.printf("%-10s%-10s%-10s\n","", this.title, "");
		System.out.println("*********************************************************************");
		System.out.printf("%-20s%-20s%-20s\n", "", "EVENT ID:", this.id);
		System.out.printf("%-20s%-20s$%-20.2f\n", "", "BASE FEE:",this.baseFee);
		System.out.printf("%-20s%-20s%-20s\n", "", "MAX ATTENDANCE:", this.maxAttendance);
		System.out.printf("%-20s%-20s%-20s\n", "", "AVAILABLE SEATS:", this.maxAttendance - this.currentAttendance);
		System.out.printf("%-20s%-20s%-20s\n", "", "START TIME:", this.startTime + " (24 Hour Time)");
		System.out.printf("%-20s%-20s%-20s\n", "", "DURATION:", this.duration + " Minutes");		
	}
	
	public double calculateCost(int concession, int frs, int arhs, int mhr) {
		//Calculate the correct cost based on what discount the reservation qualifies for, 0 for no 1 for yes
		if(mhr == 1) {
			//free attendance
			//System.out.println("Cost: $0");
			return 0;
		}
		else if(arhs == 1) {
			//Discount by 25%
			//System.out.println("Cost: $" + this.baseFee* 0.75);
			return this.baseFee* 0.75;
		}
		else if(frs == 1){
			//discount 20%
			//System.out.println("Cost: $" + this.baseFee* 0.80);
			return this.baseFee* 0.80;
		}
		else if(concession == 1) {
			//discount 10%
			//System.out.println("Cost: $" + this.baseFee* 0.90);
			return this.baseFee* 0.90;
		}
		else {
			//System.out.println("Cost: $" + this.baseFee);
			return this.baseFee;
		}
		
	}

	public int bookReservation(String name, String mobile, String id, double cost) {
		//Reserve a place in the demonstration for an attendee
		if(this.currentAttendance < this.maxAttendance) {
			this.attendees[this.currentAttendance][0] = name;
			this.attendees[this.currentAttendance][1] = mobile;
			this.attendees[this.currentAttendance][2] = id;
			this.attendees[this.currentAttendance][3] = Double.toString(cost);
			
			//print a tabulated receipt
			//System.out.printf("%-10s%-10s%-10s\n", "", "MHR Shows", "");
			//System.out.println("********************************");
			//System.out.printf("%10s%10s\n", "Name:", name);
			//System.out.printf("%10s%10s\n", "Mobile:", mobile);
			//System.out.printf("%10s%10s\n", "Show ID:", id);
			//System.out.printf("%10s%10s\n", "Cost:", "$" + cost);
			
			this.currentAttendance++;
			return 1;
		}
		else {
			//System.out.println("Max attendance already reached!");
			return 0;
		}
	}
	
	public int cancelReservation(String name) {
		//Cancels a reservation if the name exists in the bookings
		for(int i = 0;i < this.maxAttendance;i++ ) {
			if(name== this.attendees[i][0]) {
				this.attendees[i][0] = null;
				this.attendees[i][1] = null ;
				this.attendees[i][2] = null;
				this.attendees[i][3] = null;
				this.currentAttendance--;
				return 1;
			}
		}
		return 0;
	}

}
