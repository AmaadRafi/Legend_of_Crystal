package Exam3;

public class ArtistNode extends Artist {
		
	    private ArtNode firstNode;
	    private ArtNode lastNode;
	    private int totalEntries;
	    private int totalValue;
	     
	    public ArtistNode(int artistID, String artistName){
	    	super(artistID, artistName);
	        totalEntries = 0;
	        firstNode = null;
	        lastNode = null;
	    }
	    public void add(Art artWork){
	    	
	    	totalValue += artWork.getAppraisal();
	    	
	    	if (totalEntries==0)
    	    {
    	        firstNode = new ArtNode(artWork, null, null);
    	        lastNode = firstNode;
    	        totalEntries++;
    	        return;
    	    }
		    else
		    {
		        if (artWork.compareTo(firstNode.getElement()) < 0)
		        {
		            ArtNode newNode = new ArtNode(artWork, firstNode, null);
		           
		            firstNode.setPrev(newNode);
		            firstNode = newNode;
		            totalEntries++;
		            return;
		        }
		        else
		        {
		            ArtNode current = firstNode.getNext();
		            while (current != null)
		            {
		                if (artWork.compareTo(current.getElement()) <= 0)
		                {
		                    ArtNode newNode = new ArtNode(artWork, current, current.getPrev());
		                    
		                    current.getPrev().setNext(newNode);
		                    current.setPrev(newNode);
		                    totalEntries++;
		                    return;
		                }
		                current = current.getNext();
		            }
		            ArtNode newNode = new ArtNode(artWork, null, lastNode);
		            lastNode.setNext(newNode);
		            lastNode = newNode;
		            totalEntries++;
		            return;
		        }
		    }
	    }
	    public boolean isEmpty(){
	    	return firstNode == null;
	    }
	    public int getTotalValue(){
	    	return totalValue;
	    }
	    public int getTotalEntries(){
	    	return totalEntries;
	    }
	    public String printList(){
	    	  
	        String result = "";
	        ArtNode current = firstNode;
	        
	        while (current != null)
	        {
	            result += "" + current.getElement().toString() + "\r\n";
	            current = current.getNext();
	        }
	        return result;
	    }
	    public String toString()
	    {
	    	return String.format("%-15s%-22s%-20s%-40s","ID: "+this.getArtistID(),"Artist: "
					+this.getArtistName(),"Entries: "+totalEntries,"Total Value: "+totalValue);
	    }
	    private class ArtNode extends Art{
	        Art element;
	        ArtNode next;
	        ArtNode prev;
	        
	        public ArtNode(Art element, ArtNode next, ArtNode prev) {
	        	super();
	            this.element = element;
	            this.next = next;
	            this.prev = prev;
	        }
			public ArtNode getPrev() {
				return prev;
			}
			public ArtNode getNext() {
				return next;
			}
			public void setPrev(ArtNode prev) {
				this.prev = prev;
			}
			 public void setNext(ArtNode next){
		        this.next = next;
		    }
			public Art getElement() {
				return element;
			}
			public void setElement(Art element) {
				this.element = element;
			}
	   }
}
