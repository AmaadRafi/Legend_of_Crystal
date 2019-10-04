package Exam4;

import java.io.*;
import java.util.*;

public class MyArtists {

	public ArrayList<ArtistNode> myArtistNodes = new ArrayList<>();
	private Map<Integer,ArtistNode> map = new TreeMap<Integer,ArtistNode>();
	
	public MyArtists(String inputFile) {
		
		readFile(inputFile);
	}
	public void readFile(String fileName)
	{
		Scanner input;
		try {
			input = new Scanner(new File(fileName));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artistID = input.nextInt();
				String name = input.next();

				ArtistNode newArtist = new ArtistNode(artistID, name);
				myArtistNodes.add(newArtist);
				
				map.put(artistID, newArtist);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ArtistNode getID(int searchKey){
		
		return map.get(searchKey);
	}
	public void print(String heading, String outputName){
		
		try {
			PrintWriter output = new PrintWriter(outputName);
			output.println(heading);
			output.println();
			for(int i = myArtistNodes.size()-1; i >= 0; i--){
				
				output.println(myArtistNodes.get(i));
			}
			output.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void print(){
		
		for(int i = myArtistNodes.size()-1; i >= 0; i--){
			
			System.out.println(myArtistNodes.get(i));
		}
	}

}
