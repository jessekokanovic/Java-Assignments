import javax.swing.JOptionPane;

public class MusicLibraryW7 {

	private int maxNumSongs;
	private String[] songTitles;
	private String[] songLocations;
	private int currentNumSongs;

	public MusicLibraryW7(int maxSongs) {
		//constructor to initialise arrays and call class method depending on user input. 
		this.maxNumSongs = maxSongs;
		this.songTitles = new String[maxNumSongs];
		this.songLocations = new String[maxNumSongs];
		this.currentNumSongs = 0;

		String menu = "MusicLibrary v1.0\n";
		menu += "[1] Add song\n";
		menu += "[2] Display all songs\n";
		menu += "[3] Find song and play\n";
		String menuChoiceString = JOptionPane.showInputDialog(menu);
		while (menuChoiceString != null) {
			int menuChoiceInt = Integer.parseInt(menuChoiceString);
			if (menuChoiceInt == 1) {

				addSong();

			} else if (menuChoiceInt == 2) {

				displaySongs();
				// Code continues on next page...
			} else if (menuChoiceInt == 3) {

				playSong();
			} else
				JOptionPane.showMessageDialog(null, "That wasn't a valid choice!");

			menuChoiceString = JOptionPane.showInputDialog(menu);
		}
	}
	

	public static void main(String[] args) {
	// create a new music library object and gather the max number of songs from the user.
		MusicLibraryW7 ml;
		int maxSongs = Integer.parseInt(JOptionPane.showInputDialog("Enter the maximum number of songs"));
		ml = new MusicLibraryW7(maxSongs);

	}

	public void addSong() {
		
		// if the user tries to add a new song more than max number, extend the array by doubling it.
		if(this.currentNumSongs >= this.maxNumSongs) {
			String[] extendedSongTitles = new String[this.maxNumSongs*2];
			String[] extendedSongLocations = new String[extendedSongTitles.length];
			int i = 0;
			while (i < this.maxNumSongs) {
				extendedSongTitles[i] = this.songTitles[i];
				extendedSongLocations[i] = this.songLocations[i];
				i+=1;
			}
			this.songTitles = extendedSongTitles;
			this.songLocations = extendedSongLocations;
			this.maxNumSongs = extendedSongTitles.length;
		}
			
			//get the title and location of the song and add it to the array.
			String title = JOptionPane.showInputDialog("Enter a song title");
			int i = 0;
			i = getIndex(title, i);
			if (i < this.currentNumSongs) {
				JOptionPane.showMessageDialog(null, "There is already a song titled '" + title + "'");
				String tempLocation = JOptionPane.showInputDialog("Enter a location other than " + this.songLocations[i] + " to save song:");
				
				int check = 0;
				//this should loop until the user puts in a different location but it just continues regardless, i can't figure out why. In its current state
				//this will add a duplicate if the user enters the same location.
				while(check == 0) {
					 if (tempLocation == this.songLocations[i]) {
						 tempLocation = JOptionPane.showInputDialog("Enter a location other than " + this.songLocations[i] + " to save song:");
					 }
					 else {
						 check = 1;
					 }
				}
				this.songTitles[this.currentNumSongs] = title;
				this.songLocations[this.currentNumSongs] = tempLocation;
				this.currentNumSongs += 1;
			
			}
			else {
				String location = JOptionPane.showInputDialog("Enter song location for '" + title + "'");
				this.songTitles[this.currentNumSongs] = title;
				this.songLocations[this.currentNumSongs] = location;
				this.currentNumSongs += 1;
			}
		}

	public int getIndex(String title, int i) {
		//method for the repeated while loop to get the index of the song title.
		while (i < this.currentNumSongs && !this.songTitles[i].equalsIgnoreCase(title)) {
			i =+ 1;
		}
		return i;
	}
	
	public void displaySongs() {
		//list the song and locations
		String message = "Song List:\n\n";
		int i = 0;
		while (i < this.currentNumSongs) {
			message += this.songTitles[i] + "," + this.songLocations[i] + "\n";
			i += 1;
		}
		JOptionPane.showMessageDialog(null, message);

	}

	public void playSong() {

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
				Runtime.getRuntime().exec(command + " \"" + this.songLocations[i] + "\"");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unable to launch player");
			}
			// ---------------------------------------------------------------
		} else
			JOptionPane.showMessageDialog(null, "Could not find any matches for " + targetTitle);

	}
}
