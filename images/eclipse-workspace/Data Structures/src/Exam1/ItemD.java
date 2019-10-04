package Exam1;

public class ItemD extends Item{
	
	boolean deleteByte = false;
	
	public ItemD(int itemNumber, String itemName, boolean deleteByte)
	{
		super(itemNumber, itemName);
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
		return "Item: "+super.getItemID() + " Name: " + super.getItemName() + "    " +"Delete?: "+deleteByte;
	}
}
