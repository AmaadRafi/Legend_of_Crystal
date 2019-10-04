package Project3;

import java.io.*;
import java.util.*;

public class ReadArtistList {

	private Scanner input;
	
	public ReadArtistList(){
		
	}
	public ArtistList readArtistFile(ArtistList artistLink){
		try {
			input = new Scanner(new File("p1artists.txt"));
		} catch (FileNotFoundException e) {
			
				System.out.println("The input file does not exist");
				System.exit(0);
			e.printStackTrace();
		}
		input.useDelimiter("\t|\r\n");
		
		while(input.hasNext()){
			int ID = input.nextInt();
			String name = input.next();
			artistLink.addNode(ID, name);
		}
		input.close();
		
		return artistLink;
	}
	public ArtistList readEditFile(ArtistList artistLink){
		
		try {
			input = new Scanner(new File("p2changes.txt"));
		} catch (FileNotFoundException e) {

			System.out.println("The input file does not exist");
			System.exit(0);
		e.printStackTrace();
			e.printStackTrace();
		}
		input.useDelimiter("\t|\r\n");
		
		while(input.hasNext()){
			String code = input.next();
			if(code.toUpperCase().charAt(0) == 'D'){
				int ID = input.nextInt();
				artistLink.delete(ID);
			}
			else if(code.toUpperCase().charAt(0) == 'A'){
				String name = input.next();
				artistLink.addNode(artistLink.getNumberOfEntries()+1, name);
				System.out.println("Added: "+artistLink.getFirstNode());
			}
			else
				System.out.println("Error reading change file.");
		}
		return artistLink;
	}
	public void closeFile(){
		input.close();
	}
	public ArrayList<ArtistList> readArtDatabase(ArtistList artistLink){
		
		ArrayList<ArtistList> artistDatabase = new ArrayList<>();
		
		try {
			input = new Scanner(new File("p1arts.txt"));
		} catch (FileNotFoundException e) {
			
				System.out.println("The input file does not exist");
				System.exit(0);
			e.printStackTrace();
		}
			while(input.useDelimiter("\t|\r\n").hasNext()){
				int artID = input.nextInt();
				String artName = input.next();
				int artistID = input.nextInt();
				String appraisal = input.nextLine().trim();
				
				int i = 0;
				boolean found = false;
				while(i <= artistLink.getNumberOfEntries() && !found){
				
					if(artistLink.get(i) == null){
						i++;
					}
					else{
						System.out.print("Searching for ID: "+artistID+"\t");
						System.out.println(artistLink.get(i));
						if(artistID == artistLink.get(i).getArtistID())
						{
							found = true;
							if(artistLink.get(i).hasArtStored())
							{
								artistLink.addNode(artistID, artistLink.get(i).getArtistName(), artID, artName, Integer.parseInt(appraisal));
								artistDatabase.add(artistLink);
							}
							else{
							artistLink.get(i).setArtID(artID);
							artistLink.get(i).setArtName(artName);
							artistLink.get(i).setAppraisal(Integer.parseInt(appraisal));
							artistDatabase.add(artistLink);
							}
						}
						i++;
					}
			}
			if(!found){
				artistLink.addNode(artistID, "Unkown", artID, artName, Integer.parseInt(appraisal));
				artistDatabase.add(artistLink);
			}
			
		}
			
		return artistDatabase;
	}
}
