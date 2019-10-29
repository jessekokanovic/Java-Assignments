import javax.swing.JOptionPane;
import java.io.*;

public class BookCollection {

	private Book[] bookCollection; // initialize the array to hold the book objects.
	private int collectionLength;
	private String filePath;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookCollection collection = new BookCollection();
	}

	public BookCollection() {
		// A collection of Book objects stored in an array.

		this.filePath = "C:/Users/User/git/Java-Assignments/Assignment3/src/books.txt"; // the file path of the stored
																						// books, change here to match
																						// where it is saved.
		this.collectionLength = getCollectionLength(); // run the getCollectionLength method to get the initial number
														// of books in the collection
		this.bookCollection = loadBooks();

		// Display the collection
		displayCollection();
	}

	public int getCollectionLength() {
		// Count the number of lines in the books csv file to determine how many books
		// in the collection there are.
		// Do this by reading each line of the file, and adding 1 to a counter for each
		// book read.
		int lineNum = 0;
		BufferedReader inFile = null;
		try {
			inFile = new BufferedReader(new FileReader(this.filePath));
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
			inFile = new BufferedReader(new FileReader(this.filePath));
			String currentLine = inFile.readLine();
			while (currentLine != null) {
				String[] bookInfo = currentLine.split(","); // use the comma as the delimiter in the csv file to get
															// each individual bit of info for the book
				Book newBook = new Book(bookInfo[0], bookInfo[1], Integer.parseInt(bookInfo[2]),
						Integer.parseInt(bookInfo[3]));
				loadedCollection[lineNum] = newBook;
				lineNum++;
				currentLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return loadedCollection;
	}

	public void displayCollection() {
		// Loop over the collection array and format the book information into a string
		// readable by the user.

		String collection = "";
		int i = 0;
		while (i < this.collectionLength) {
			collection = collection + this.bookCollection[i].getTitle() + " by " + this.bookCollection[i].getAuthor()
					+ ", " + this.bookCollection[i].getPagesRead() + " pages read out of  " + this.bookCollection[i].getPagesRead()
					+ " pages.\n";
			i++;
		}

		JOptionPane.showMessageDialog(null,
				"Books in Collection: " + this.collectionLength + "\n" + collection);

	}

}
