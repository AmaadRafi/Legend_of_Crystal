package Exam4;

import java.io.*;
import java.util.Scanner;

public class MyArtWorks {

	MyArtists artists = new MyArtists("exam4Artists.txt");
	
	public MyArtWorks(String inputFile) {
	
		Scanner input;
		try {
			input = new Scanner(new File(inputFile));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artID = input.nextInt();
				String title = input.next();
				int artistID = input.nextInt();
				int appraisal = input.nextInt();
			
				Art newWork = new Art(artistID, artID, title, appraisal);
				artists.getID(artistID).add(newWork);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void print(int ID){
			System.out.println();
			System.out.println(artists.myArtistNodes.get(ID));
			System.out.println(artists.myArtistNodes.get(ID).printList());
	}
	public void print(String heading, String outputName){
		
		try {
			PrintWriter output = new PrintWriter(outputName);
			output.println(heading);
			output.println();
			for(int i = 0; i < artists.myArtistNodes.size(); i++){
				
				output.println(artists.myArtistNodes.get(i));
				output.println(artists.myArtistNodes.get(i).printList());
			}
			output.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
