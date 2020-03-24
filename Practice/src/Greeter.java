import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Greeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 2;
		JOptionPane.showMessageDialog(null, w);
		
		String a = "a,b,3";
		String[] b = a.split(",");
		System.out.print(b[0] + b[1]);
		
		int lineNum = 0;
		BufferedReader inFile = null;
		try {
			inFile = new BufferedReader(new FileReader("C:/Users/User/Desktop/a.txt"));
			String currentLine = inFile.readLine();
			while (currentLine != null) {
				lineNum++;
				System.out.println(currentLine);
				currentLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
