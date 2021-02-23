import java.util.*;
			import java.io.*;

		import java.util.Scanner;

		public class test {
		     public static void main(String[] args) {
		          Scanner sc = new Scanner (System.in);
		          String day, trainType;
		          int numPeople;

		          System.out.print("Enter the day [Sat/Sun/Wed/Fri]: ");
		          day = sc.nextLine();

		          System.out.print("Enter the type of train [Steam/Diesel]: ");
		          trainType = sc.nextLine();

		          System.out.print("Enter the number of people [1..4]: ");
		          numPeople = sc.nextInt();

		          // Complete this section of the program in the text box below
		          // Do NOT rewrite any of the code shown above or below! 
		          // You are NOT permitted to declare additional variables or 
		          // alter the value stored in the given variables by the 
		          // above code. You can assume valid data will be entered.
		          
		          if(day == "Sat" || day == "Sun") {
		        	  if(trainType == "Steam") {
		        		  System.out.printf("Cost = $%.2f", 2200.00 + (150.00 * numPeople));
		        	  }
		        	  else {
		        		  System.out.printf("Cost = $%.2f", 1600.00 + (150.00 * numPeople));
		        	  }
		          }
		          else if(day == "Wed") {
		        	  if(trainType == "Steam") {
		        		  System.out.printf("Cost = $%.2f", 2000.00 + (100.00 * numPeople));
		        	  }
		        	  else {
		        		  System.out.printf("Cost = $%.2f", 1200.00 + (100.00 * numPeople));
		        	  }
		          }
		          else if(day == "Fri"){
		        	  if(trainType == "Steam") {
		        		  System.out.printf("Cost = $%.2f", 2100.00 + (130.00 * numPeople));
		        	  }
		        	  else {
		        		  System.out.printf("Cost = $%.2f", 1400.00 + (130.00 * numPeople));
		        	  }
		          }
		          
		     }
		     public static void temperatureStats(int monthlyTemperatures[][],
                 int startMonth,
                 int endMonth,
                 int targetRange){
	    	 	// Your code goes here
		    	
		    	int[] ranges = new int[endMonth - startMonth + 1];
		    	double averageRange = 0;
		    	for(int i = startMonth; i <= endMonth + 1; i++) {
		    		ranges[i] = monthlyTemperatures[0][i] - monthlyTemperatures[1][i];
		    		averageRange = averageRange + ranges[i];
		    		
		    	}
		    	System.out.printf("%.2f", averageRange/2);
		    	int maxValue = 0;
		    	String inRange = "yes";
		    	for(int i=0; i < ranges.length;i++) {
		    		if(ranges[i] > maxValue) {
		    			maxValue = ranges[i];
		    		}
		    		if(ranges[i] > targetRange) {
		    			inRange = "no";
		    		}
		    	}
		    	 System.out.printf("f", maxValue);
		    	 System.out.printf(inRange);

		     	}
		}
		
		// assume that the class definition below already exists: 
		public abstract class RollingStock {
		     private String stockID;             // ID of rolling stock
		     private String railYard;            // The 'home' rail yard
		     private double kmSinceCheck;        // The number of Km travelled since
		                                         // the last wheel check


		     // Complete this section of the program in the text box below
		     // Do NOT rewrite any of the code shown above or below!
		     
		     public RollingStock(String stockID, String railYard) {
		    	 this.stockID = stockID;
		    	 this.railYard = railYard;
		     }
		     
		     public double getKmSinceCheck() {
		    	 return kmSinceCheck;
		     }
		     
		     public void setKmSinceCheck(double km) {
		    	 kmSinceCheck = km;
		     }
		     
		     public abstract boolean checkWheels();
		    	 
		     
		     // getter for stockID
		     public String getStockID(){
		          return stockID;
		     }
		     
		     // helper method which allows rolling stock details 
		     // to be printed to screen    
		     public void printDetails() {
		          System.out.println("Stock ID: " + stockID);
		          System.out.println("Rail Yard: " + railYard);
		          System.out.println("KM since wheel check: " + kmSinceCheck);
		     }
		}
		
		class Carriage extends RollingStock{
			private String seatClass;
			private int numSeats;
			private String railYard;
			
			public Carriage(String stockID, String railYard, String seatClass, int numSeats) {
				super(stockID, railYard);
				this.seatClass = seatClass;
				this.numSeats = numSeats;	
				this.railYard = railYard;
			}
			
			public boolean checkWheels() {
				if(getKmSinceCheck() > 200000) {
					return true;
				}
				else {
					return false;
				}
			}
			@Override
			public void printDetails() {
		          System.out.println("Stock ID: " + getStockID());
		          System.out.println("Rail Yard: " + this.railYard);
		          System.out.println("KM since wheel check: " + getKmSinceCheck());
		          System.out.println("Number of seats: " + this.numSeats);
		     }
		}
		
		class Locomotive extends RollingStock{
			private int daysInService;
			private int tractiveEffort;
			private String railYard;
			
			public Locomotive(String stockID, String railYard, int tractiveEffort) {
				super(stockID, railYard);
				this.tractiveEffort = tractiveEffort;
				this.daysInService = 0;	
				this.railYard = railYard;
			}
			
			public void incrementDaysOfService(int numDays) {
				this.daysInService = this.daysInService + numDays;
			}
			
			public boolean checkWheels() {
				if(getKmSinceCheck() > 100000 || this.daysInService >= 180) {
					return true;
				}
				else {
					return false;
				}
			}
			
			@Override
			public void printDetails() {
		          System.out.println("Stock ID: " + getStockID());
		          System.out.println("Rail Yard: " + this.railYard);
		          System.out.println("KM since wheel check: " + getKmSinceCheck());
		          System.out.println("Days in Service: " + this.daysInService);
		          System.out.println("Tractive Effort: " + this.tractiveEffort);
		}
			
			
			public class RollingStockMaintenance {
			     public static void main(String[] args) {
			          RollingStock rollingStock[] = new RollingStock[40];

			          // assume code here adds an unknown number of
			          // references to a mix of Locomotive and Carriage
			          // objects to the rollingStock array. You do NOT
			          // need to write code to do this

			          // Your code would go here
			     }
			}
		}
		
		
		
		