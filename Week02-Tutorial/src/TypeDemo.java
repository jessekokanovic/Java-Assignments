
public class TypeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numberOfSteps;
		byte eightBitNumber;
		short sixteenBitNumber;
		long sixtyFourBitNumber;
		float mass;
		double velocity;
		boolean motorOn;
		char key;

		// Assigning largest values for integer variables
		numberOfSteps = 2147483647;
		eightBitNumber = 127;
		sixteenBitNumber = 32767;
		sixtyFourBitNumber = 2 ^ 64 - 1;
		// Assigning compatible data for other variables
		mass = 98.52f;
		velocity = 60.25;
		motorOn = false;
		key = 'a';

		// Print out variables
		String types = "Number of Steps: " + numberOfSteps + "\n8 Bit number: " + eightBitNumber + "\n16 Bit Number: "
				+ sixteenBitNumber + "\n64 Bit Number: " + sixtyFourBitNumber + "\nMass: " + mass + "\nVelocity: "
				+ velocity + "\nMotor on: " + motorOn + "\nKey: " + key;
		System.out.println(types);

		// Increment or assign new values
		numberOfSteps++;
		eightBitNumber++;
		sixteenBitNumber++;
		sixtyFourBitNumber++;
		mass++;
		velocity++;
		motorOn = true;
		key = 'f';

		// need to reassign types string with new values
		types = "Number of Steps: " + numberOfSteps + "\n8 Bit number: " + eightBitNumber + "\n16 Bit Number: "
				+ sixteenBitNumber + "\n64 Bit Number: " + sixtyFourBitNumber + "\nMass: " + mass + "\nVelocity: "
				+ velocity + "\nMotor on: " + motorOn + "\nKey: " + key;

		// Print new variables
		System.out.println("After assigning new values:");
		System.out.println(types);

	}

}
