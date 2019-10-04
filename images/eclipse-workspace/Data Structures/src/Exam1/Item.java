package Exam1;

public class Item
{
	private int itemNumber;
	private String itemName;

	public Item(int itemNumber, String itemName)
	{
		this.itemNumber = itemNumber;
		this.itemName = itemName;
	}
	public int getItemID()
	{
		return itemNumber;
	}
	public String getItemName()
	{
		return itemName;
	}
	public void setItemID(int itemNumber)
	{
		this.itemNumber = itemNumber;
	}
	public void getItemName(String itemName)
	{
		this.itemName = itemName;
	}
	
	public String toString()
	{
		return itemName+" "+itemNumber;
	}
}

