import javax.swing.JOptionPane;
import java.io.*;

public class BookCollection {

	private Book[] bookCollection; // initialize the array to hold the book objects.
	private int collectionLength;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public BookCollection() {
		// A collection of Book objects stored in an array.

		this.collectionLength = getCollectionLength(); // run the getCollectionLength method to get the initial number
														// of books in the collection

	}

	public int getCollectionLength() {
		// Count the number of lines in the books csv file to determine how many books
		// in the collection there are.
		// Do this by reading each line of the file, and adding 1 to a counter for each
		// book read.
		int lineNum = 0;
		BufferedReader inFile = null;
		try {
			inFile = new BufferedReader(new FileReader("books.csv"));
			String currentLine = inFile.readLine();
			while (currentLine != null) {
				lineNum++;
				currentLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lineNum;
	}

	public Book[] loadBooks() {

		BufferedReader inFile = null;
		try {
			inFile = new BufferedReader(new FileReader("books.csv"));
			String currentLine = inFile.readLine();
			while (currentLine != null) {
				
				
				currentLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
