package Project3;

import java.util.*;

public class UpdateArtistList {

	ArtistList artistLink = new ArtistList();
	ArtistList artistLink2 = new ArtistList();
	ReadArtistList artistListFile = new ReadArtistList();
	ArrayList<ArtistList> artistDataBase = new ArrayList<>();
	
	public UpdateArtistList(){
		
		artistLink = artistListFile.readArtistFile(artistLink);
		artistLink = artistListFile.readEditFile(artistLink);
		artistListFile.closeFile();
		WriteArtistFile.writeFile(artistLink);
		artistLink.print();
		
		artistLink2 = artistListFile.readArtistFile(artistLink2);
		artistDataBase = artistListFile.readArtDatabase(artistLink2);
		
		artistListFile.closeFile();
		WriteArtistFile.writeFile(artistDataBase);
	}
}
