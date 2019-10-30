import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class MusicLibrary {

	private int maxSongs;
	private Song[] songs; // this initializes an array of Song objects.
	private int currentNumSongs;
	private String filePath;

	public MusicLibrary(int maxSongs) {
		// Create the library class initializing arrays using the max number of songs
		// allowed
		this.maxSongs = maxSongs;
		this.songs = new Song[maxSongs];
		this.currentNumSongs = 0;
		this.filePath = "C:/Users/User/git/Java-Assignments/Week10-Tutorial/src/songs.txt"; // store path for text file to
																						// read and write to
		//Load the songs from the text file
		loadSongs();
		
		// string to hold and display menu options.
		String menu = "MusicLibrary v1.0\n";
		menu += "[1] Add song\n";
		menu += "[2] Display all songs\n";
		menu += "[3] Find song and play\n";

		String menuChoiceString = JOptionPane.showInputDialog(menu);
		// run this loop so long as the user provides an input
		while (menuChoiceString != null) {
			int menuChoiceInt = Integer.parseInt(menuChoiceString);

			// If the user chooses option 1, check to see if there is space in the array -
			// if there is run
			// the add song method, if not extend the size of the array.

			if (menuChoiceInt == 1) {
				if (this.currentNumSongs >= this.maxSongs) {
					// if there is no room in the array, run the method to extend it.
					extendMaxSongs();
				}
				addSong();
			} else if (menuChoiceInt == 2) {
				// display the songs.
				displaySongs();
			} else if (menuChoiceInt == 3) {
				// play the song
				playSong();
			} else {
				JOptionPane.showMessageDialog(null, "That wasn't a valid choice!");
			}
			menuChoiceString = JOptionPane.showInputDialog(menu);
		}
	}

	public void extendMaxSongs() {
		// Double the length of the songs object array
		Song[] extendedSongs = new Song[this.maxSongs * 2];
		int i = 0;
		while (i < this.maxSongs) {
			extendedSongs[i] = songs[i];
			i = +1;
		}
		this.songs = extendedSongs;
		this.maxSongs = extendedSongs.length;
	}

	public void addSong() {
		// get a song name and location from the user and create a song object that
		// exists in the songs list.
		String title = JOptionPane.showInputDialog("Enter a song title:");
		int i = 0;
		i = getIndex(title, i);
		if (i < this.currentNumSongs) {
			// if the new song already exists, make the user pick a different location.
			JOptionPane.showMessageDialog(null, "There is already a song titled '" + title + "'");
			String tempLocation = JOptionPane
					.showInputDialog("Enter a location other than " + this.songs[i].getLocation() + " to save song:");
			while (tempLocation == this.songs[i].getLocation()) {
				// this should make the user re-enter until the location changes but it doesn't
				// work so right now two songs with the same name and location can exist.
				tempLocation = JOptionPane.showInputDialog(
						"Enter a location other than " + this.songs[i].getLocation() + " to save song:");
			}
			Song newSong = new Song(title, tempLocation); // create a new song object and add it to the songs array.
			this.songs[this.currentNumSongs] = newSong;
			this.currentNumSongs += 1;

		} else {
			// else if the song doesn't already exist just take input from the user and
			// create a new song object.
			String location = JOptionPane.showInputDialog("Enter song location for '" + title + "'");
			Song newSong = new Song(title, location); // create a new song object and add it to the songs array.
			this.songs[this.currentNumSongs] = newSong;
			this.currentNumSongs += 1;
		}

	}

	public void displaySongs() {
		// display the name and location of each song object in the songs list.
		String message = "Song List:\n\n";
		int i = 0;
		while (i < this.currentNumSongs) {
			message += this.songs[i].getTitle() + "," + this.songs[i].getLocation() + "\n";
			i += 1;
		}
		JOptionPane.showMessageDialog(null, message);
	}

	public void playSong() {
		// find a song and play it.
		String targetTitle = JOptionPane.showInputDialog("Enter a song title to search");
		int i = 0;
		i = getIndex(targetTitle, i);
		if (i < this.currentNumSongs) {
			// ---------------------------------------------------------------
			// For ITP, you do not need to understand how the code segment below works.
			String os = System.getProperty("os.name").toLowerCase();
			String command;
			if (os.contains("windows"))
				command = "explorer ";
			else if (os.contains("linux"))
				command = "xdg-open ";
			else
				command = "open ";
			try {
				Runtime.getRuntime().exec(command + " \"" + this.songs[i].getLocation() + "\"");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unable to launch player");
			}
			// ---------------------------------------------------------------
		} else
			JOptionPane.showMessageDialog(null, "Could not find any matches for " + targetTitle);

	}

	public int getIndex(String title, int i) {
		// if the song already exists, find the index of it and return it
		while (i < this.currentNumSongs && !this.songs[i].getTitle().equalsIgnoreCase(title)) {
			i = +1;
		}
		return i;
	}

	public void loadSongs() {
		//read each line in from the text file, and use the information to create new song objects to store in the songs array.
		int lineNum = 0;
		BufferedReader inFile = null;
		try {
			inFile = new BufferedReader(new FileReader(this.filePath));
			String currentLine = inFile.readLine();
			while (currentLine != null) {
				String[] songInfo = currentLine.split(","); // use the comma as the delimiter in the csv file to get
															// each individual bit of info for the book
				Song newSong = new Song(songInfo[0], songInfo[1]);
				this.songs[lineNum] = newSong;
				lineNum++;
				this.currentNumSongs++;
				currentLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {

		MusicLibrary ml = new MusicLibrary(100);

	}

}
