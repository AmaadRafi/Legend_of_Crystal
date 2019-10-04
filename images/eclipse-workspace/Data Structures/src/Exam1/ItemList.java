package Exam1;

class ItemList{
	
	private ItemNode firstNode;       
	private int numberOfEntries;

	public ItemList()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	public ItemNode getFirstNode(){
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
	public ItemNode get(int Index){
		
		ItemNode searchNode = firstNode;
		
		if(!isEmpty()){
		
			while(searchNode.getIndex() != Index){
			
				if(searchNode.getNext() == null){
					
					System.out.println("Item not found.");
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
	public void addNode(int itemID, String itemName){
		ItemNode newNode = new ItemNode(itemID, itemName, null);
		newNode.setNext(firstNode);                                
		firstNode = newNode;       
		numberOfEntries++;
	}
	public ItemNode delete(int ID){
		
		ItemNode current = firstNode;
		ItemNode previous = firstNode;
		
		while(current.getItemID() != ID){
			
			if(current.getNext() == null){
				System.out.println("Delete attempted: Item not found");
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
			//lowerEntryCount();
		}
		return current;
	}
	public void print(){
	
		for(int i = 0; i <= this.getNumberOfEntries(); i++){
			
			System.out.println(this.get(i));
		}
	}
	public class ItemNode extends Item
	{
		private ItemNode next; 
		private int index = 0;

		private ItemNode(int itemID, String itemName, ItemNode next)
		{
			super(itemID, itemName);
			this.next = next;
			this.index = numberOfEntries;
		} 
		public void setNext(ItemNode next){
			this.next = next;
		}
		public ItemNode getNext(){
			return next;
		}
		public int getIndex(){
			return index;
		}
		public String toString(){
			return "ID: "+super.getItemID()+ " Name: " + super.getItemName();
		}
	} 
}
