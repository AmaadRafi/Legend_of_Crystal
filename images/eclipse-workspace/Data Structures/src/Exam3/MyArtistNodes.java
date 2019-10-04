package Exam3;

import java.io.*;
import java.util.*;

public class MyArtistNodes {

	public ArrayList<ArtistNode> myArtistNodes = new ArrayList<>();
	
	public MyArtistNodes(String inputFile) {

		Scanner input;
		
		try {
			input = new Scanner(new File(inputFile));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artistID = input.nextInt();
				String name = input.next();
				
				ArtistNode newArtist = new ArtistNode(artistID, name);
				myArtistNodes.add(newArtist);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ArtistNode indexOfArtistID(int artistID){
		
		return myArtistNodes.get(artistID-1);
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
