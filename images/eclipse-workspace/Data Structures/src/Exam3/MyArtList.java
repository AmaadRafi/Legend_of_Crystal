package Exam3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MyArtList {
	
	private ArrayList<ArtistWork> list = new ArrayList<>();
	private ArrayList<Artist> artistList = new ArrayList<>();
	
	public MyArtList(String inputFile) {

		readFile(inputFile);
		Collections.sort(list);
	}
	public void readFile(String inputFile){
		
		Scanner input;
		
		try {
			input = new Scanner(new File("p7artists.txt"));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artistID = input.nextInt();
				String name = input.next();
				
				Artist newArtist = new Artist(artistID, name);
				artistList.add(newArtist);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			input = new Scanner(new File(inputFile));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artID = input.nextInt();
				String title = input.next();
				int artistID = input.nextInt();
				int appraisal = input.nextInt();
				String artistName = findName(artistID);
			
				ArtistWork newWork = new ArtistWork(artistID, artistName, artID, title, appraisal);
				list.add(newWork);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String findName(int artistID){
		
		return artistList.get(artistID-1).getArtistName();
	}
	public void print(String heading, String outFile){
		
		try {
			PrintWriter output = new PrintWriter(outFile);
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
