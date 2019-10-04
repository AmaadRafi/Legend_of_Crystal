// Jason Nichols-Allen  CIS 211

package Project2;

import java.io.*;
import java.util.*;

class ArtistD extends Artist{

	private boolean deleteByte;
	
	public ArtistD(int artistID, String artistName, boolean deleteByte)
	{
		super(artistID, artistName);
		this.deleteByte = deleteByte;
	}
	public void setDeleteByte(boolean deleteByte)
	{
		this.deleteByte = deleteByte;
	}
	public boolean getDeleteByte()
	{
		return deleteByte;
	}
	public String toString()
	{
		return "ID: "+super.getArtistID() + " Name: " + super.getArtistName() + "    " +"Delete?: "+deleteByte;
	}
}
class Method2{
	
	private Scanner input;
	private ArrayList<ArtistD> array = new ArrayList<>();
	long startTime, stopTime, elapsedTime;
	
	public Method2(){
		
		System.out.println("\nStarting "+Method2.class.getName()+"\n");
		
		startTime = System.nanoTime();
		readFile();
		editFile();
		deleteRecords();
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
			array.add(new ArtistD(ID, name, false));
		}
		input.close();
	}
	public void add(String name){
		
		ArtistD newArtist = new ArtistD(array.size()+1, name, false);
		array.add(newArtist);
		System.out.println("Added: "+array.get(array.size()-1));
		
	}
	public void delete(int ID){
		boolean found = false;
		for(int i = 0; i < array.size(); i++){
		if(ID == (array.get(i).getArtistID())) {
			found = true;
			array.get(i).setDeleteByte(found);
			System.out.println("Deleted: "+array.get(i));
			}
		}
		if(!found){
			System.out.println("Entry not found");
		}
	}
	public void deleteRecords(){
		
		for(int i = 0; i < array.size(); i++){
			if(array.get(i).getDeleteByte() == true)
				array.remove(i);
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
			PrintWriter output = new PrintWriter("p2artists2b.txt");
			output.println("Method 2: Jason Nichols-Allen\n\n" + "Total Entries: " + array.size()+"\n");
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
		
		System.out.println(Method2.class.getName() + ": ElapsedTime = "+elapsedTime);
	}
}
 