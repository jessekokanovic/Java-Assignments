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

	}

	public static void main(String[] args) {

	}

}
