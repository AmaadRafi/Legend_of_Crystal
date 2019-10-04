package Exam1;

import java.io.*;
import java.util.*;

public class Exam1 {

	public static void main(String[] args) {
		step1();
		step2();
		step3();
	}
	public static void step1(){
		
		Item[] itemArray = new Item[10];
		ArrayList<Item> itemList = new ArrayList<>();
		Scanner input = readInputFile();
		int numberOfEntries = 0;
		
		int i = 0;
		while(input.useDelimiter("[,\n]").hasNext()){
			int itemNumber = input.nextInt();
			String itemName = input.next();
			Item newItem = new Item(itemNumber, itemName.trim());
			
			itemArray[i] = newItem;
			itemList.add(newItem);
			i++;
			numberOfEntries = i;
		}
		
		input.close();
		input = readChangeFile();
	
		while(input.useDelimiter(",|\r\n").hasNext()){
			String code = input.next();
			if(code.toUpperCase().charAt(0) == 'D'){
				int ID = input.nextInt();
				delete(itemList, ID);
				delete(itemArray, ID, numberOfEntries);
				numberOfEntries--;
			}
			else if(code.toUpperCase().charAt(0) == 'A'){
				int ID = input.nextInt();
				String name = input.next();
				add(itemList, ID, name.trim());
				add(itemArray, ID, name.trim(), numberOfEntries);
				numberOfEntries++;
			}
			else
				System.out.println("Error reading change file.");
		}
		input.close();
		writeFile(itemList, itemArray, numberOfEntries, "ex1out1.txt");
	}
	public static void step2(){
		
		//ReadItemD readItem = new ReadItemD();
		ArrayList<ItemD> itemArrayList = ReadItemD.readItemFile();
		
		writeFile(itemArrayList, "ex1out2.txt");
		Scanner input = readChangeFile();
		
		while(input.useDelimiter(",|\r\n").hasNext()){
			String code = input.next();
			if(code.toUpperCase().charAt(0) == 'D'){
				int ID = input.nextInt();
				delete(itemArrayList, ID, false);
			}
			else if(code.toUpperCase().charAt(0) == 'A'){
				int ID = input.nextInt();
				String name = input.next();
				add(itemArrayList, ID, name.trim(), false);
			}
			else
				System.out.println("Error reading change file.");
		}
		input.close();
		writeFile(itemArrayList, "ex1out2.txt");
	}
	public static void step3(){
		
		ItemList itemList = new ItemList();
		Scanner input = readInputFile();
		
		input.useDelimiter("[,\n]");
		
		while(input.hasNext()){
			int ID = input.nextInt();
			String name = input.next();
			itemList.addNode(ID, name);
		}
		input.close();
		
		writeFile(itemList, "ex1out3.txt");
		input = readChangeFile();
		
		while(input.useDelimiter(",|\r\n").hasNext()){
			String code = input.next();
			if(code.toUpperCase().charAt(0) == 'D'){
				int ID = input.nextInt();
				itemList.delete(ID);
			}
			else if(code.toUpperCase().charAt(0) == 'A'){
				int ID = input.nextInt();
				String name = input.next();
				itemList.addNode(ID, name);
			}
			else
				System.out.println("Error reading change file.");
		}
		writeFile(itemList, "ex1out3.txt");
		
		input.close();
	}
	public static Scanner readInputFile(){
		
		Scanner input = null;
		try {
			input = new Scanner(new File("items.txt"));
		} catch (FileNotFoundException e) {
			
				System.out.println("The input file does not exist");
				System.exit(0);
			e.printStackTrace();
		}
		return input;
	}
	public static Scanner readChangeFile(){
		Scanner input = null;
		try {
			input = new Scanner(new File("changes.txt"));
		} catch (FileNotFoundException e) {
			
				System.out.println("The input file does not exist");
				System.exit(0);
			e.printStackTrace();
		}
		
		return input;
	}
	public static void delete(ArrayList<Item> array, int ID){
		boolean found = false;
		for(int i = 0; i < array.size(); i++){
			if(ID == (array.get(i).getItemID())) {
			found = true;
			array.remove(i);
			}
		}
		if(!found){
			System.out.println("Entry not found");
		}
	}
	public static void delete(Item[] array, int ID, int numberOfEntries){
		boolean found = false;
		int lastIndex = numberOfEntries - 1;
		
		for(int i = 0; i < numberOfEntries; i++){
			if(ID == (array[i].getItemID())) {
			found = true;
			
			array[i] = array[lastIndex];
			array[lastIndex] = null;
			break;
			}
		}
		if(!found){
			System.out.println("Entry not found");
		}
	}
	public static void delete(ArrayList<ItemD> array, int ID, boolean found)
	{
		found = false;
		for(int i = 0; i < array.size(); i++){
		if(ID == (array.get(i).getItemID())) {
			found = true;
			array.get(i).setDeleteByte(found);
			}
		}
		if(!found){
			System.out.println("Entry not found");
		}
	}
	public static void add(ArrayList<Item> array, int ID, String name){
		
		Item newItem = new Item(ID, name);
		array.add(newItem);
	}
	public static void add(ArrayList<ItemD> array, int ID, String name, boolean found){
		
		ItemD newItem = new ItemD(ID, name, found);
		array.add(newItem);
	}
	public static void add(Item[] array, int ID, String name, int numberOfEntries){
		
		Item newItem = new Item(ID, name);
		array[numberOfEntries] = newItem;
	}
	public static void writeFile(ArrayList<Item> arrayList, Item[] array, int numberOfEntries, String fileName){
	
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream( new File(fileName),true));
			output.println("\nMethod 1: Jason Nichols-Allen\n\n");
			for(int i = numberOfEntries-1; i >= 0; i--){
				output.println(array[i].toString());
			}
			output.println();
			System.out.println();
			for(int i = 0; i < arrayList.size(); i++){
				output.println(arrayList.get(i));
			}
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void writeFile(ArrayList<ItemD> arrayList, String fileName){
		
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream( new File(fileName),true));
			output.println("\nMethod 2: Jason Nichols-Allen\n\n");
		
			for(int i = 0; i < arrayList.size(); i++){
				output.println(arrayList.get(i));
			}
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void writeFile(ItemList itemLink, String fileName){
		
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream( new File(fileName),true));
			output.println("\nMethod 3: Jason Nichols-Allen\n\n");
			for(int i = 0; i < itemLink.getNumberOfEntries(); i++){
				
				output.println(itemLink.get(i));
			}
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
