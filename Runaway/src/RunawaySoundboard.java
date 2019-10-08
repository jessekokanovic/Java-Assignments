import java.awt.event.KeyEvent;
import java.util.Scanner;

public class RunawaySoundboard {
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A) {
			System.out.println("A");
		}
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("S");
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			System.out.println("D");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String letter = input.next();
		System.out.println(letter);
	}

}
