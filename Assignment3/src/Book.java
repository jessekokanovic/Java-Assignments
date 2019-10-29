
public class Book {

	private String title;
	private String author;
	private int pages;
	private int pagesRead;
	
	public Book(String title, String author, int pages, int pagesRead) {
		//Assign the parameters entered by the user to our member variables so we can work with them in our methods.
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.pagesRead = pagesRead;
	}
	
	public String getTitle() {
		//Get the title of a book and return it as a string
		return this.title;
	}
	
	public String getAuthor() {
		//Get the author of a book and return it as a string
		return this.author;
	}
	
	public int getPages(){
		//Get the total number of pages of a book and return it as an integer
		return this.pages;
	}
	
	public int getPagesRead() {
		//Get the number of pages of a book that have been read and return it as an integer
		return this.pagesRead;
	}
	
	public void setPagesRead(int newPagesRead) {
		//Update the number of pages read for a book
		this.pagesRead = newPagesRead;
	}
	
}
