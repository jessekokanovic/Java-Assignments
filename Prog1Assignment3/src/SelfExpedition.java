
public class SelfExpedition extends Expedition {
	//subclass that inherits expedition

	//new instance variables
	private String endStation;
	private String difficulty;
	
	public SelfExpedition(String expeditionID, String description, 
			  String startingStation, double[] ticketTypeCost,
			  String[] ticketTypeDesc, String endStation, String difficulty) {
		super(expeditionID, description, startingStation, ticketTypeCost, ticketTypeDesc);
		this.endStation = endStation;
		this.difficulty = difficulty;
	}
	
	public String getEndStation() {
		//Get the end station
		return this.endStation;
	}
	
	public String getDifficulty() {
		//Get the difficulty
		return this.difficulty;
	}
}
