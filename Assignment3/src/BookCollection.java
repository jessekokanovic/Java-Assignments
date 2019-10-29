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
		this.bookCollection = loadBooks(); // load the information from the csv file into book objects stored in this
											// list.

		String menu = "[1] Display Collection\n[2] Add Book\n[3] Update Pages Read\n[4] Save Collection and Close";

		String userChoiceString = JOptionPane.showInputDialog(menu);
		while (userChoiceString != null) {
			int userChoice = Integer.parseInt(userChoiceString);
			if (userChoice == 1) {
				// List the information of the books in the collection by running the
				// displayCollection method.
				JOptionPane.showMessageDialog(null,
						"Number of Books: " + this.collectionLength + "\n" + displayCollection());

			} else if (userChoice == 2) {
				//add a new book to the collection
				addBook();
			} else if (userChoice == 3) {

			} else if (userChoice == 4) {

			} else {
				// If none of the correct menu options are selected display an error message.
				JOptionPane.showMessageDialog(null, "Please enter a valid option");
			}

			userChoiceString = JOptionPane.showInputDialog(menu);
		}

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

	public String displayCollection() {
		// Loop over the collection array and format the book information into a string
		// readable by the user.

		String collection = "";
		int i = 0;
		while (i < this.collectionLength) {
			collection = collection + "[" + (i + 1) + "] " + this.bookCollection[i].getTitle() + " by "
					+ this.bookCollection[i].getAuthor() + ", " + this.bookCollection[i].getPagesRead()
					+ " pages read out of " + this.bookCollection[i].getPages() + ".\n";
			i++;
		}
		return collection;
	}

	public void addBook() {
		// Ask the user for the title, author, pages, and default the pages read to
		// zero. Extend the bookCollection list by 1.

		// Extend the collection list by 1 by creating a temporary list that is one
		// larger, filling it with information and then storing it in our main list
		// variable.
		Book[] extendedCollection = new Book[this.collectionLength + 1];
		int i = 0;
		while(i < this.collectionLength) {
			extendedCollection[i] = this.bookCollection[i];
			i++;
		}
		this.bookCollection = extendedCollection;
		this.collectionLength = extendedCollection.length;
		
		//now that we have extended the list, we can add an extra book object to it by getting the info from the user.
		String title = JOptionPane.showInputDialog("Enter the title");
		String author = JOptionPane.showInputDialog("Enter the Author:");
		int numPages = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of pages:"));
		Book newBook = new Book(title, author, numPages, 0);
		this.bookCollection[this.collectionLength - 1] = newBook;
		
	}

}
