package Project3;

import java.io.*;
import java.util.ArrayList;

public class WriteArtistFile {

	public WriteArtistFile(){
		
	}
	public static void writeFile(ArtistList artistLink){
		
		try {
			PrintWriter output = new PrintWriter("p3artists.txt");
			output.println("Method 3: Jason Nichols-Allen\n\n" + "Total Entries: " + artistLink.getNumberOfEntries()+"\n");
			for(int i = 0; i <= artistLink.getNumberOfEntries(); i++){
				
				output.println(artistLink.get(i));
			}
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void writeFile(ArrayList<ArtistList> artistDataBase){
		
		try {
			PrintWriter output = new PrintWriter("p3artists_arts.txt");
			output.println("Method 3: Jason Nichols-Allen\n\n" + "Total Entries: " + artistDataBase.size()+"\n");
			for(int i = 0; i < artistDataBase.size(); i++)
			{
				ArtistList artist = artistDataBase.get(i);
					System.out.println(artist.get(i));
					output.println(artist.get(i));
				
			}
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
