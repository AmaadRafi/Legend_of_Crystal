// Jason Nichols-Allen  CIS 211

package Project2;

import java.io.*;
import java.util.*;

class ArtistA extends Artist{

	int numberOfEntries = 0;
	
	public ArtistA(int artistID, String artistName)
	{
		super(artistID, artistName);
	}
	public int getNumberOfEntries(){
		return numberOfEntries;
	}
	public String toString()
	{
		return "ID: "+super.getArtistID() + " Name: " + super.getArtistName();
	}
}
class Method1{
	
	private Scanner input;
	private ArrayList<ArtistA> array = new ArrayList<>();
	long startTime, stopTime, elapsedTime;
	
	public Method1(){
		
		System.out.println("\nStarting "+Method1.class.getName()+"\n");
		
		startTime = System.nanoTime();
		readFile();
		editFile();
		writeFile();
		
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
	}
	public void readFile(){
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
			array.add(new ArtistA(ID, name));
		}
		input.close();
	}
	public void add(String name){
		
		ArtistA newArtist = new ArtistA(array.size()+1, name);
		array.add(newArtist);
		System.out.println("Added: "+array.get(array.size()-1));
		
	}
	public void delete(int ID){
		boolean found = false;
		for(int i = 0; i < array.size(); i++){
		if(ID == (array.get(i).getArtistID())) {
			found = true;
			System.out.println("Deleted: "+array.get(i));
			array.remove(i);
			}
		}
		if(!found){
			System.out.println("Entry not found");
		}
	}
	public void editFile(){
		try {
			input = new Scanner(new File("p2changes.txt"));
		} catch (FileNotFoundException e) {
			
				System.out.println("The input file does not exist");
				System.exit(0);
			e.printStackTrace();
		}
		input.useDelimiter("\t|\r\n");
		
		while(input.hasNext()){
			String code = input.next();
			if(code.toUpperCase().charAt(0) == 'D'){
				int ID = input.nextInt();
				delete(ID);
			}
			else if(code.toUpperCase().charAt(0) == 'A'){
				String name = input.next();
				add(name);
			}
			else
				System.out.println("Error reading change file.");
		}
	}
	public void writeFile(){
		
		try {
			PrintWriter output = new PrintWriter("p2artists2a.txt");
			output.println("Method 1: Jason Nichols-Allen\n\n" + "Total Entries: " + array.size()+"\n");
			for(int i = 0; i < array.size(); i++){
				
				output.println(array.get(i));
			}
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void printTime(){
		
		System.out.println("\n"+Method1.class.getName() + ": ElapsedTime = "+elapsedTime);
	}
}
 
