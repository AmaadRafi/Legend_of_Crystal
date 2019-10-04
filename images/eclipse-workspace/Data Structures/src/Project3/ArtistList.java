package Project3;

class ArtistList{
	
	private ArtistNode firstNode;       
	private int numberOfEntries;

	public ArtistList()
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
	public ArtistNode get(int Index){
		
		ArtistNode searchNode = firstNode;
		
		if(!isEmpty()){
		
			while(searchNode.getIndex() != Index){
			
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
	public void addNode(int artistID, String artistName, int artID, String artName, int appraisal){
		ArtistNode newNode = new ArtistNode(artistID, artistName, artID, artName, appraisal, null);
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
	public void print(){
	
		for(int i = 0; i <= this.getNumberOfEntries(); i++){
			
			System.out.println(this.get(i));
		}
	}
	public class ArtistNode extends Artist
	{
		private ArtistNode next;
		private int index;

		private ArtistNode(int artistID, String artistName, ArtistNode next)
		{
			super(artistID, artistName);
			this.next = next;
			this.index = numberOfEntries;
		}
		private ArtistNode(int artistID, String artistName, int artID, String artName, int appraisal, ArtistNode next)
		{
			super(artistID, artistName);
			this.next = next;
			this.index = numberOfEntries;
			this.setArtID(artID);
			this.setArtName(artName);
			this.setAppraisal(appraisal);
		} 
		public void setNext(ArtistNode next){
			this.next = next;
		}
		public ArtistNode getNext(){
			return next;
		}
		public int getIndex(){
			return index;
		}
		public boolean hasArtStored(){
			
			if(this.getArtID() != 0)
			return true;
			
			return false;
		}
		public String toString(){
			return String.format("%-15s%-22s%-20s%-40s%-10s","ID: "+this.getArtistID(),"Artist: "
			+this.getArtistName(),"Art ID: "+this.getArtID(),"Title: "+this.getArtName(),"Value: "+this.getAppraisal());
		}
	} 
}
