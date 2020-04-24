
public class Demonstration {
	//Create a demonstration event	
	private String id;
	private String title;
	private double baseFee;
	private int maxAttendence;
	private int startTime;
	private int duration;

	public Demonstration(String id, String title, double baseFee, int maxAttendence, int startTime, int duration) {
		//Assign parameters to class variables in constructor.
		this.id = id;
		this.title = title;
		this.baseFee = baseFee;
		this.maxAttendence = maxAttendence;
		this.startTime = startTime;
		this.duration = duration;
		
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
	

}
