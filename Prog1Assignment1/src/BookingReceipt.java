
public class BookingReceipt {
	
	private int firstAdult = 16;
	private int standardAdult = 11;
	private int standardChild = 6;
	private int excursionAdult = 8;
	private int excursionChild = 4;
	
	private int adultTicket;
	private int childTicket;
	private int adultCost;
	private int childCost;
	private int childDiscount;
	private double groupDiscount;
	private int bookingFee;
	private double total;
	
	public BookingReceipt(int adultTicket, int childTicket) {
		
		this.adultTicket = adultTicket;
		this.childTicket = childTicket;
	
	}
	
	public void calculateCosts(int distance, int adults, int children, int youngChildren) {
		//calculates correct cost
		
		this.adultCost = adults * (this.adultTicket * distance);
		this.childCost = children * (this.childTicket * distance);
		this.childDiscount = youngChildren * (this.childTicket * distance);
		this.bookingFee = (adults + children) * 5;
		this.total = (this.adultCost + this.childCost + this.bookingFee) - this.childDiscount - this.groupDiscount;
		this.groupDiscount = 0.1 * this.total;
		
	}
	
	public void printReceipt(String carriage, String startPoint, String endPoint, int numAdults, int numChildren, int youngChildren) {
		//Prints a formatted string
		
		System.out.printf("%-20s %-20s %-20s\n","", carriage,"");
		System.out.printf("%-20s %-20s %-20s\n",startPoint, "to",endPoint);
		System.out.println("------------------------------------------------------");
		System.out.printf("%-20s x%-20d $%-20d\n","Adults", numAdults, this.adultCost);
		System.out.printf("%-20s x%-20d $%-20d\n","Children", numChildren, this.childCost);
		System.out.printf("%-20s x%-20d-$%-20d\n", "Free Child", youngChildren, this.childDiscount);
		System.out.printf("%-20s x%-20d $%-20d\n", "Booking Fee",numAdults + numChildren, this.bookingFee);
		if((numAdults + numChildren) >=10) {
			System.out.printf("%-20s %-20s-$%-20.2f\n", "Group Discount", "10% Off", this.groupDiscount);
		}
		else {
			this.groupDiscount = 0;
		}
		System.out.println("------------------------------------------------------");
		System.out.printf("%-20s  %-20s $%-20.2f\n", "TOTAL", "", this.total);
		
	}
	
	

}
