package Project7;

import java.io.*;
import java.util.*;

public class Project7 {

	public static void main (String[] args) {
		
		DoubleLink<Artist> list = readFile();
		writeFile(list);
	}
	public static DoubleLink<Artist> readFile()
	{
		DoubleLink<Artist> list = new DoubleLink<>();
		ArrayList<Artist> artistList = new ArrayList<>();
	
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
			
			input = new Scanner(new File("p7arts.txt"));
			
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				int artID = input.nextInt();
				String title = input.next();
				int artistID = input.nextInt();
				int appraisal = input.nextInt();
				
				Artist newArt = new Artist(artistList.get(artistID-1).getArtistID(),artistList.get(artistID-1).getArtistName());
				newArt.setArtName(title);
				newArt.setArtID(artID);
				newArt.setAppraisal(appraisal);
				
				list.add(newArt);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void writeFile(DoubleLink<Artist> list){
		
		try {
			PrintWriter output = new PrintWriter("p7out(JasonNicholsAllen).txt");
			output.println("Jason Nichols-Allen\tProject 6\r\n");
			output.print(list.toString());
			output.flush();
			System.out.println(list.toString() + "\nsize: " + list.getSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
