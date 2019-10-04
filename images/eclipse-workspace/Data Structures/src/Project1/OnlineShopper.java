package Project1;

import java.io.*;
import java.util.*;

import Project2.Artist;

public class OnlineShopper
{
    public static void main (String [] args) throws Exception
    {
    	String outputFile = "p1artists_out1.txt";
    	String artistInputFile = "p1Artists.txt";
    	String artistDataInputFile = "p1arts.txt";
    	String artistDataOutputFile = "p1arts_out.txt";
    	Scanner input = readFile(artistInputFile);
    	
    	BagInterface <Artist> artistList = new ArrayBag<Artist>();
    	BagInterface <Artist> artistDatabase = new ArrayBag<Artist>();
    	
    	int totalAppraisalValue = 0;
    	int totalArtists = 0;
    	int totalArtworks = 0;
    	
		while(input.hasNext())
    	{
			try{
				int id = input.nextInt();
				String name = input.next();
	    		artistList.add(new Artist(id, name));
			} catch(InputMismatchException e){
				System.out.println("Invalid format for input file.  Please check the record.");
				System.exit(0);
				e.printStackTrace();
			}
    	}
		input.close();
		Artist[] artists = populateArray(artistList);
	
		input = readFile(artistDataInputFile);
		
		while(input.useDelimiter("\t|\r\n").hasNext())
		{
			try{
				int artID = input.nextInt();
				String title = input.next();
				int artistID = input.nextInt();
				String appraisedValue = input.nextLine();
				String artistName = null;
				
				for(int i = 0; i < artists.length; i++)
				{
					if(artistID == artists[i].getArtistID()){
						artistName = artists[i].getArtistName();
						totalArtists++;
						break;
					}else{
						artistName = "Unknown Artist";
					}
				}
				ArtistShopper newArtist = new ArtistShopper(artID, title, artistName, artistID, appraisedValue);
				totalAppraisalValue += newArtist.convertAppraisal();
				artistDatabase.add(newArtist);
				}
			catch(InputMismatchException e){
				System.out.println("Invalid format for input file.  Please check the record.");
				System.exit(0);
				e.printStackTrace();
			}
			totalArtworks++;
		}
		writeFile(outputFile, artistList);
		writeFile(artistDataOutputFile, artistDatabase, totalAppraisalValue, totalArtworks, totalArtists);
		
    } // end main
    
	public static Scanner readFile(String fileName)
	{
		File inputFile = new File(fileName);
		Scanner input;
		try {
			input = new Scanner(inputFile);
			return input;
		} catch (FileNotFoundException e) {
			
				System.out.println("The input file does not exist");
				System.exit(0);
			e.printStackTrace();
			return null;
		}
	}
	public static void writeFile(String fileName, BagInterface<?> bag)
	{
		try(PrintWriter output = new PrintWriter(fileName);)
		{
			while(!bag.isEmpty())
			{
				output.println(bag.remove());
			}
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void writeFile(String fileName, BagInterface<?> bag, 
			int totalAppraisalValue, int totalArtworks, int totalArtists)
	{
		try(PrintWriter output = new PrintWriter(fileName);)
		{
			while(!bag.isEmpty())
			{
				output.println(bag.remove());
			}
			output.println("\nTotal appraisal value is: " + totalAppraisalValue + 
					"\nThe total artworks is: " + totalArtworks + "\nTotal artists is: " + totalArtists);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Artist[] populateArray(BagInterface <Artist> artistList)
	{
		Object[] temp = artistList.toArray();
		Artist[] artists = new Artist[temp.length];
		
		for(int i = 0; i < artists.length; i++)
		{
			artists[i] = (Artist)temp[i];
		}
		return artists;
	}
}
class ArtistShopper extends Artist
{
	private int artID;
	private String title;
	private String appraisedValue;
	
	public ArtistShopper(int artistID, String artistName)
	{
		super(artistID, artistName);
	}
	public ArtistShopper(int artID, String title, String artistName, int artistID, String appraisedValue)
	{
		super(artistID, artistName);
		this.title = title;
		this.artID = artID;
		this.appraisedValue = appraisedValue;
	}
	
	public String toString()
	{
		return artID+" "+title+" "+super.getArtistName()+" "+super.getArtistID()+" "+appraisedValue+" ";
	
	}
	public int convertAppraisal()
	{
		String s = appraisedValue.trim();
		int value = Integer.parseInt(s);
		return value;
	}
}