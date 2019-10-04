//Jason Nichols-Allen Project5

package Project5;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Project5 {

	public static void main (String[] args){
		
		printToFile();
		
	}		
	public static void printToFile(){
		
		ArrayList<TestData> factData = new ArrayList<>();
		ArrayList<TestData> fibData = new ArrayList<>();
		ArrayList<TestData> palData = new ArrayList<>();
		ArrayList<TestData> binData = new ArrayList<>();
		
		runTests(factData,fibData,palData,binData);
		
		try {
			PrintWriter out = new PrintWriter("p5Out(JasonNicholsAllen.txt");
			
			out.println("Value\trecResult\titResult\trecTime\titTime");
			for(int i = 0; i < factData.size(); i++){
				out.println(factData.get(i).getValue()+"\t"+factData.get(i).getRecResult()+"\t"+factData.get(i).getItResult()+"\t"
				+factData.get(i).getRecElapsedTime()+"\t"+factData.get(i).getElapsedTime());
			}
			out.println("Value\trecResult\titResult\trecTime\titTime");
			for(int i = 0; i < fibData.size(); i++){
				out.println(fibData.get(i).getValue()+"\t"+fibData.get(i).getRecResult()+"\t"+fibData.get(i).getItResult()+"\t"
				+fibData.get(i).getRecElapsedTime()+"\t"+fibData.get(i).getElapsedTime());
			}
			out.println("Value\trecResult\titResult\trecTime\titTime");
			for(int i = 0; i < palData.size(); i++){
				out.println(palData.get(i).getStr()+"\t"+palData.get(i).getRecBool()+"\t"+palData.get(i).getItBool()+"\t"
				+palData.get(i).getRecElapsedTime()+"\t"+palData.get(i).getElapsedTime());			}
			out.println("Value\trecIndex\titIndex\trecTime\titTime");
			for(int i = 0; i < binData.size(); i++){
				out.println(binData.get(i).getValue()+"\t"+binData.get(i).getRecResult()+"\t"+binData.get(i).getItResult()+"\t"
				+binData.get(i).getRecElapsedTime()+"\t"+binData.get(i).getElapsedTime());
			}
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void runTests(ArrayList<TestData> factData, ArrayList<TestData> fibData, ArrayList<TestData> palData, ArrayList<TestData> binData){
		
		int[] testNums = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40};
		int[] searchNums = new int[1000];
		int[] searchNumsTest = {3,44,237,576,33,478,875,636,712,5,222,158,923,58,63,355,95,27,800,12};
		String[] s = {"aba", "abba", "abnba", "abnnba", "abntnba", "abnttnba", "abntvtnba", "abntvvtnba", "abntvdvtnba", "abntvddvtnba"};
		
		for(int i: testNums){
			System.out.println("Testing Factorial: "+i);
			TestData t = new TestData(i);
			t.printFact(i);
			factData.add(t);
		}
		for (int i : testNums) {
			TestData t = new TestData(i);
			System.out.println("Testing Fibonacci: "+i);
			t.printFib(i);
			fibData.add(t);
		}
		for (String i: s) {
			TestData t = new TestData(i);
			System.out.println("Testing Palindrome: "+i);
			t.printPal(i);
			palData.add(t);
		}
		for(int i = 0; i < searchNums.length; i++){
			
			searchNums[i] = (int)(Math.random()*1000);
		}
		
		Arrays.sort(searchNums);
		for (int i: searchNumsTest){
			System.out.println("Testing BinarySearch: "+i);
			TestData t = new TestData(searchNums, i);
			binData.add(t);
		}
		//System.out.println(Arrays.toString(searchNums));
	}
}
