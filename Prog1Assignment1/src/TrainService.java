
public class TrainService {
	
	private String[] STATIONS;
	private int[] firstSeats = {48, 48, 48, 48, 48, 48};
	private int[] standardSeats = {70, 70, 70, 70,  70, 70};
	private int[] excursionSeats = {95, 95, 95, 95, 95, 95};
	private int startPoint;
	private int endPoint;
	private int trainClass;
	
	public TrainService(String[] STATIONS) {
		
		this.STATIONS = STATIONS;
	}
	
	public void listSeats() {
		//Lists the Seat Availability
		System.out.printf("%-14s %-14s %-14s %-14s\n", "Station", "First", "Standard", "Excursion");
		System.out.println("-----------------------------------------------------------------");
		for(int i = 0; i < STATIONS.length; i++) {
			System.out.printf("%-14s %-14d %-14d %-14d\n", STATIONS[i], firstSeats[i], standardSeats[i], excursionSeats[i]);
		}
	}
	
	public void setStart(int start){
		//sets the starting point of the booking
		this.startPoint = start;
	}
	
	public void setEnd(int end){
		//sets the end point of the booking
		this.startPoint = end;
	}
	
	public void setClass(int trainClass){
		//sets the starting point of the booking
		this.trainClass = trainClass;
	}

	public int checkSeats(int adults, int children) {
		//checks the availability of seats and return either 1 or 0
		if(this.trainClass == 1) {
			if(adults > firstSeats[this.startPoint]) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else if(this.trainClass == 2) {
			if((adults + children) > standardSeats[this.startPoint]) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else if(this.trainClass == 3) {
			if((adults + children) > excursionSeats[this.startPoint]) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return 0;
		}
	}
	
	public void adjustSeats(int adults, int children) {
		//Adjusts the number of available seats
		
		if(this.trainClass == 1) {
			for (int i = this.startPoint; i <= this.endPoint; i++) {
				this.firstSeats[i] = this.firstSeats[i] - adults;
			}
		}
		else if(this.trainClass == 2) {
			for (int i = this.startPoint; i <= this.endPoint; i++) {
				this.standardSeats[i] = this.standardSeats[i] - (adults + children);
			}
		}
		else if(this.trainClass == 3) {
			for (int i = this.startPoint; i <= this.endPoint; i++) {
				this.excursionSeats[i] = this.excursionSeats[i] - (adults + children);
			}
		}
	}

}
