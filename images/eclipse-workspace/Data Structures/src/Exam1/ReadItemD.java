package Exam1; 

import java.io.*;
import java.util.*;

public class ReadItemD {
	
	private static ArrayList<ItemD> itemArray = new ArrayList<ItemD>();

	public ReadItemD(){
		
		readItemFile();
	}
	public static ArrayList<ItemD> readItemFile(){
		Scanner input = null;
		try {
			input = new Scanner(new File("items.txt"));
		} catch (FileNotFoundException e) {
			
				System.out.println("The input file does not exist");
				System.exit(0);
			e.printStackTrace();
		}
		
		while(input.useDelimiter("[,\n]").hasNext()){
			int itemNumber = input.nextInt();
			String itemName = input.next();
			ItemD newItem = new ItemD(itemNumber, itemName.trim(), false);
		
			itemArray.add(newItem);
		}
		input.close();
		
		return itemArray;
	}
}
