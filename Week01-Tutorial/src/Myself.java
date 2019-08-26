import javax.swing.JOptionPane;

public class Myself {
	public static void main(String[] args) {
//		Wijesinghe, G. (2019). MyApps Portal. [online] Rmit.instructure.com.
//		Available at: https://rmit.instructure.com/courses/56609/assignments/373780
//		[Accessed 26 Aug. 2019].

		//this is a program to display a message about myself
		String message;
		message = "";
		message = message + "Hello world!\n";
		message = message + "My hobbies are playing basketball, video games and learning guitar.\n";
		message = message + "I use programming as a way to automatically sort different file types into correct folders, and in an order of my choosing.\n"
				+ "This helpful for sorting music and movies by genre and artists.";
		JOptionPane.showMessageDialog(null, message);
	}
}

//What is a class? I always think of a class as a cookie cutter. Its a section of code that can be used to define an object, just how a cookie cutter cuts out the shape of the cookie.
//Classes being reusable make it easier for the programmer to write one section of code, then reference it throughout a project to create objects.

//What is a method? Methods are what define the functionality of an object. A class creates an object, and the methods within the class give it it's attributes. A method should usually accept
//a parameter, or multiple parameters to perform some operation. A standard method for a class is a constructor, which is usually the first method in a class and initialises the attributes
//of the object about to be created.

//What is a variable? A variable is a container for some bit of data; whether that be a number, a word, a letter etc. Referencing a variable by its name will allow for manipulation of the
//data stored within. Naming a variable should be describe exactly what it is - don't store a surname and call the variable X, call it surname. Naming schemes for variables usually involve using
//camelCase or under_scoring. 

//What is a code block? A code block encapsulates a group (or one) of statements between curly braces. Its a way of formatting code for ease of readability.

