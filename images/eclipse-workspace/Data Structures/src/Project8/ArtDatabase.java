package Project8;

import java.io.*;
import java.util.*;

public class ArtDatabase {

	public ArrayList<Art> artList = new ArrayList<>();
	private Map<Integer,String> map = new TreeMap<Integer,String>();
	
	public ArtDatabase(String artistFile, String artFile) {

		readArtistFile(artistFile);
		readArtFile(artFile);
		Collections.sort(artList);
	}
	public void readArtistFile(String fileName){
		
		Scanner input;
		try {
			input = new Scanner(new File(fileName));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artistID = input.nextInt();
				String name = input.next();
				
				map.put(artistID, name);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void readArtFile(String fileName){
		
		Scanner input;
		try {
			input = new Scanner(new File(fileName));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artID = input.nextInt();
				String title = input.next();
				int artistID = input.nextInt();
				int appraisal = input.nextInt();
			
				Art newWork = new Art(artistID, artID, title, appraisal);
				newWork.setArtistName(map.get(artistID));
				artList.add(newWork);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void print(String heading, String outputName){
		
		try {
			PrintWriter output = new PrintWriter(outputName);
			output.println(heading);
			output.println();
			for(int i = 0; i < artList.size(); i++){
				
				output.println(artList.get(i));
			}
			output.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
