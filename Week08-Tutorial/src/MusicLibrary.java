import javax.swing.JOptionPane;

public class MusicLibrary {
	
	private int maxSongs;
	private Song[] songs; //this initializes an array of Song objects.
	private int currentNumSongs;
	
	public MusicLibrary(int maxSongs) {
		//Create the library class initializing arrays using the max number of songs allowed
		this.maxSongs = maxSongs;
		this.songs = new Song[maxSongs];
		this.currentNumSongs = 0;
		
		//Constant string to hold and display menu options.
		String menu = "MusicLibrary v1.0\n";
		menu += "[1] Add song\n";
		menu += "[2] Display all songs\n";
		menu += "[3] Find song and play\n";
		String menuChoiceString = JOptionPane.showInputDialog(menu);
	}
	
	
	public static void main(String[] args) {
		
	}

}
