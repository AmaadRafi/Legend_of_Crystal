//Jason Nichols-Allen Project 5

package Project4;
import java.io.*;
import java.util.*;

public class Project4 {

	public static void main(String[] args){
		
		printResult();
	}
	public static ArrayList<String[]> readInput(String inputFile){
		
		ArrayList<String[]> dataArray = new ArrayList<>();
		
		File readFile = new File(inputFile);
		try {
			Scanner input = new Scanner(readFile);
	
			while(input.hasNextLine()){
				
				String lineData = input.nextLine();
				String[] chars = lineData.split("\\s|(?<=[()])|(?=\\b[()])");
			
				dataArray.add(chars);
			}
		} catch (FileNotFoundException e) {
			System.out.print("The file "+readFile.getName()+" does not exist. ");
			System.exit(1);
		}
		return dataArray;
	}
	public static ArrayList<String[]> convert(ArrayList<String[]> charArray){
		
		for(int i = 0; i < charArray.size(); i++){
			
			for(int j = 0; j < charArray.get(i).length; j++){
			
				if(Character.isDigit(charArray.get(i)[j].charAt(0))){
					
					switch(charArray.get(i)[j]){
					case "2": charArray.get(i)[j] = "a";
					break;
					case "3": charArray.get(i)[j] = "b";
					break;
					case "4": charArray.get(i)[j] = "c";
					break;
					case "5": charArray.get(i)[j] = "d";
					break;
					case "6": charArray.get(i)[j] = "e";
					break;
					case "0": charArray.get(i)[j] = "f";
					break;
					case "1": charArray.get(i)[j] = "g";
					break;
					case "8": charArray.get(i)[j] = "h";
					break;
					default: System.out.println("invald");
					break;
					}
				}
			}
		}
		return charArray;
	}
	public static ArrayList<String[]> deepCopy(ArrayList<String[]> oldArray){
		
			ArrayList<String[]> newArray = new ArrayList<String[]>();
			
			for(String[] s: oldArray){
				
				String[] newS = Arrays.copyOf(s, s.length);
				newArray.add(newS);
			}
		return newArray;
	}
	public static void populateTable(ArrayList<String[]> inputData, ArrayList<String[]> prefixData, PrintWriter output){
		for(int i = 0; i < prefixData.size(); i++){
			
			String input = Arrays.toString(inputData.get(i)).replaceAll("\\[|\\]|\\s|\\,", "");
			String pre = Arrays.toString(prefixData.get(i)).replaceAll("\\[|\\]|\\s|\\,", "");
			String post = Postfix.convertToPostfix(Arrays.toString(prefixData.get(i)));
			double result = Postfix.evaluatePostfix(post);
			
			System.out.println(String.format("%-20s%-3s%-21s%-3s%-18s%-3s%.2f",input,"|", pre,"|", post,"|", result));
			output.println(String.format("%-20s%-3s%-21s%-3s%-18s%-3s%.2f",input,"|", pre,"|", post,"|", result));
		}
	}
	public static void printResult(){
		
		try {
			PrintWriter output = new PrintWriter("p4out.txt");
			
			System.out.println(String.format("%-23s%-24s%-21s%s","Input", "Prefix", "Postfix", "Result"));
			System.out.println("----------------------------------------------------------------------------------");
			output.println(String.format("%-23s%-24s%-21s%s","Input", "Prefix", "Postfix", "Result"));
			output.println("----------------------------------------------------------------------------------");
			
			ArrayList<String[]> inputData = readInput("p4in.txt");
			ArrayList<String[]> prefixData = new ArrayList<>(deepCopy(inputData));
			
			convert(prefixData);
			populateTable(inputData, prefixData, output);
		
			output.flush();
		} catch (FileNotFoundException e) {
			System.out.println("Program Terminated");
			e.printStackTrace();
		}
	}
}

