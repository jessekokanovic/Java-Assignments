import javax.swing.JOptionPane;

public class MusicLibrary {

	private int maxSongs;
	private Song[] songs; // this initializes an array of Song objects.
	private int currentNumSongs;

	public MusicLibrary(int maxSongs) {
		// Create the library class initializing arrays using the max number of songs
		// allowed
		this.maxSongs = maxSongs;
		this.songs = new Song[maxSongs];
		this.currentNumSongs = 0;

		// string to hold and display menu options.
		String menu = "MusicLibrary v1.0\n";
		menu += "[1] Add song\n";
		menu += "[2] Display all songs\n";
		menu += "[3] Find song and play\n";

		String menuChoiceString = JOptionPane.showInputDialog(menu);
		// run this loop so long as the user provides an input
		while (menuChoiceString != null) {
			int menuChoiceInt = Integer.parseInt(menuChoiceString);

			// If the user chooses option 1, check to see if there is space in the array - if there is run
			// the add song method, if not extend the size of the array.

			if (menuChoiceInt == 1) {
				if (this.currentNumSongs >= this.maxSongs) {
					//if there is no room in the array, run the method to extend it.
					extendMaxSongs();
				}
				
				addSong();
			}

			menuChoiceString = JOptionPane.showInputDialog(menu);
		}

	}

	public void extendMaxSongs() {
		//Double the length of the songs object array
		Song[] extendedSongs = new Song[this.maxSongs*2];
		int i = 0;
		while (i < this.maxSongs) {
			extendedSongs[i] = songs[i];
			i=+1;
		}
		this.songs = extendedSongs;
		this.maxSongs = extendedSongs.length;
	}
	
	public void addSong() {
		String title = JOptionPane.showInputDialog("Enter a song title:");
		int i = 0;
		i = getIndex(title, i);
		if (i < this.currentNumSongs) {
			//if the new song already exists, make the user pick a different location.
			JOptionPane.showMessageDialog(null, "There is already a song titled '" + title + "'");
			String tempLocation = JOptionPane.showInputDialog("Enter a location other than " + this.songs[i].getLocation() + " to save song:");
			while (tempLocation ==  this.songs[i].getLocation()) {
				tempLocation = JOptionPane.showInputDialog("Enter a location other than " + this.songs[i].getLocation() + " to save song:");
			}
			Song newSong = new Song(title, tempLocation); //create a new song object and add it to the songs array.
			this.songs[this.currentNumSongs] = newSong;
			this.currentNumSongs +=1;
			
		}
		else {
			//else if the song doesn't already exist just take input from the user and create a new song object.
			String location = JOptionPane.showInputDialog("Enter song location for '" + title + "'");
			Song newSong = new Song(title, location); //create a new song object and add it to the songs array.
			this.songs[this.currentNumSongs] = newSong;
			this.currentNumSongs +=1;
		}
		
	}
	
	public int getIndex(String title, int i) {
		//if the song already exists, find the index of it and return it
		while (i < this.currentNumSongs && !this.songs[i].getTitle().equalsIgnoreCase(title)) {
			i =+ 1;
		}
		return i;
	}

	public static void main(String[] args) {

	}

}
