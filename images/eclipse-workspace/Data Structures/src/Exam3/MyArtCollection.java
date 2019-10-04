package Exam3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyArtCollection {

	MyArtistNodes artists = new MyArtistNodes("p7artists.txt");
	
	public MyArtCollection(String inputFile) {
	
		Scanner input;
		try {
			input = new Scanner(new File(inputFile));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artID = input.nextInt();
				String title = input.next();
				int artistID = input.nextInt();
				int appraisal = input.nextInt();
			
				Art newWork = new Art(artistID, artID, title, appraisal);
				artists.indexOfArtistID(artistID).add(newWork);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		print();
	}
	public void print(){
		System.out.println();
		for(int i = artists.myArtistNodes.size()-1; i >= 0; i--){
			
			System.out.println(artists.myArtistNodes.get(i));
			System.out.println(artists.myArtistNodes.get(i).printList());
		}
	}
	public void print(String heading, String outputName){
		
		try {
			PrintWriter output = new PrintWriter(outputName);
			output.println(heading);
			output.println();
			for(int i = artists.myArtistNodes.size()-1; i >= 0; i--){
				
				output.println(artists.myArtistNodes.get(i));
				output.println(artists.myArtistNodes.get(i).printList());
			}
			output.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
