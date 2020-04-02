
public class TrainService {
	
	private String[] STATIONS;
	private int[] firstSeats = {48, 48, 48, 48, 48, 48};
	private int[] standardSeats = {70, 70, 70, 70,  70, 70};
	private int[] excursionSeats = {95, 95, 95, 95, 95, 95};
	
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

}
