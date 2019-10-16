import javax.swing.JOptionPane;

public class MusicLibraryW7 {

	private int maxNumSongs;
	private String[] songTitles;
	private String[] songLocations;
	private int currentNumSongs;

	public MusicLibraryW7() {

		this.maxNumSongs = 3;
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

		MusicLibraryW7 ml;
		ml = new MusicLibraryW7();

	}

	public void addSong() {
		if (this.currentNumSongs < this.maxNumSongs) {
			String title = JOptionPane.showInputDialog("Enter a song title");
			int i = 0;
			while (i < this.currentNumSongs && !this.songTitles[i].equalsIgnoreCase(title))
				i += 1;
			if (i < this.currentNumSongs)
				JOptionPane.showMessageDialog(null, "There is already a song titled '" + title + "'");
			else {
				String location = JOptionPane.showInputDialog("Enter song location for '" + title + "'");
				this.songTitles[this.currentNumSongs] = title;
				this.songLocations[this.currentNumSongs] = location;
				this.currentNumSongs += 1;
			}
		}
		JOptionPane.showMessageDialog(null, "Oops! Looks like you have no more room for new songs");

	}

	public void displaySongs() {

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
		while (i < this.currentNumSongs && !this.songTitles[i].equalsIgnoreCase(targetTitle))
			i += 1;

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
