package Exam3;

import java.io.*;
import java.util.*;

public class MyArtistList {

	public ArrayList<Artist> list = new ArrayList<>();
	
	public MyArtistList(String fileName) {

		File inputFile = new File(fileName);
		readFile(inputFile);
	}
	public void readFile(File inputFile){
		
		Scanner input;
		try {
			input = new Scanner(new File("p7artists.txt"));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artistID = input.nextInt();
				String name = input.next();
				
				Artist newArtist = new Artist(artistID, name);
				list.add(newArtist);
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
			for(int i = 0; i < list.size(); i++){
				
				output.println(list.get(i));
			}
			output.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
