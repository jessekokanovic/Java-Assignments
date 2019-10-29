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
		this.bookCollection = loadBooks();
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
		// Read each line in the csv and split the string by the delimiter. Use this
		// information to create a new book object that is added to a list of book
		// objects. Return this book object so that it may be used.

		Book[] loadedCollection = new Book[this.collectionLength];
		int lineNum = 0;
		BufferedReader inFile = null;
		try {
			inFile = new BufferedReader(new FileReader("books.csv"));
			String currentLine = inFile.readLine();
			while (currentLine != null) {
				String[] bookInfo = currentLine.split(","); // use the comma as the delimiter in the csv file to get
															// each individual bit of info for the book
				Book newBook = new Book(bookInfo[0], bookInfo[1], Integer.parseInt(bookInfo[2]),
						Integer.parseInt(bookInfo[3]));
				loadedCollection[lineNum] = newBook;
				currentLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return loadedCollection;
	}

	public void showBooks() {
		// Loop over the collection array and format the book information into a string
		// readable by the user.
		String collection;

	}

}
