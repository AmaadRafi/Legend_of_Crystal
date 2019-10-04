package Project2;

import java.io.*;
import java.util.*;

class ArtistL{
	
	private ArtistNode firstNode;       
	private int numberOfEntries;

	public ArtistL()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	public ArtistNode getFirstNode(){
		return firstNode;
	}
	public int getNumberOfEntries(){
		return numberOfEntries;
	}
	public void lowerEntryCount(){
		numberOfEntries--;
	}
	public boolean isEmpty(){
		
		if(firstNode == null)
			return true;
		else
			return false;
	}
	public ArtistNode get(int ID){
		
		ArtistNode searchNode = firstNode;
		
		if(!isEmpty()){
		
			while(searchNode.getArtistID() != ID){
			
				if(searchNode.getNext() == null){
					
					//System.out.println("Artist not found.");
					return null;
				} 
				else {
					searchNode = searchNode.getNext();
				}
			}
		} 
		else {
			
			System.out.println("The list is empty.");
		}
		return searchNode;
	}
	public void addNode(int artistID, String artistName){
		ArtistNode newNode = new ArtistNode(artistID, artistName, null);
		newNode.setNext(firstNode);                                
		firstNode = newNode;       
		numberOfEntries++;
	}
	public ArtistNode delete(int ID){
		
		ArtistNode current = firstNode;
		ArtistNode previous = firstNode;
		
		while(current.getArtistID() != ID){
			
			if(current.getNext() == null){
				System.out.println("Delete attempted: Artist not found");
				return null;
			}
			else {
					previous = current;
					current = current.getNext();
				}
		}
		if(current == firstNode){
			
			firstNode = firstNode.getNext();
			
		} else {
			previous.setNext(current.getNext());
			lowerEntryCount();
		}
		return current;
	}
	public class ArtistNode extends Artist
	{
		private ArtistNode next; 

		private ArtistNode(int artistID, String artistName, ArtistNode next)
		{
			super(artistID, artistName);
			this.next = next;
		} 
		public void setNext(ArtistNode next){
			this.next = next;
		}
		public ArtistNode getNext(){
			return next;
		}
		public String toString(){
			return "ID: "+this.getArtistID() + " Name: " + this.getArtistName();
		}
	} 
}
class Method3{
	
	private Scanner input;
	private ArtistL artistLink = new ArtistL();
	long startTime, stopTime, elapsedTime;
	
	public Method3(){
		
		System.out.println("\nStarting "+Method3.class.getName()+"\n");
		
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
			artistLink.addNode(ID, name);
		}
		input.close();
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
				Artist deleted = artistLink.delete(ID);
				System.out.println("Deleted: "+deleted);
			}
			else if(code.toUpperCase().charAt(0) == 'A'){
				String name = input.next();
				artistLink.addNode(artistLink.getNumberOfEntries()+1, name);
				System.out.println("Added: "+artistLink.getFirstNode());
			}
			else
				System.out.println("Error reading change file.");
		}
	}
	public void writeFile(){
		
		try {
			PrintWriter output = new PrintWriter("p2artists2c.txt");
			output.println("Method 3: Jason Nichols-Allen\n\n" + "Total Entries: " + artistLink.getNumberOfEntries()+"\n");
			for(int i = 1; i <= artistLink.getNumberOfEntries(); i++){
				
				output.println(artistLink.get(i));
			}
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void printTime(){
		
		System.out.println(Method3.class.getName() + ": ElapsedTime = "+elapsedTime);
	}
}
 