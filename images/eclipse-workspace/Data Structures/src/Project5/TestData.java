//Jason Nichols-Allen Project5

package Project5;

import java.util.Arrays;

public class TestData {

	private int value;
	private int[] values;
	private double recResult;
	private double itResult;
	private boolean recBool;
	private boolean itBool;
	private String str;
	private long elapsedTime;
	private long recElapsedTime;

	public TestData(int value){
		this.value = value;
	}
	public TestData(String str){
		this.str = str;
	}
	public TestData(int[] values, int value){
		
		this.value = value;
		printBin(values, value);
	}
	public void print(Runnable func1, Runnable func2){
		
		long recStartTime = System.nanoTime();
		func1.run();
		long recStopTime = System.nanoTime();
		
		long startTime = System.nanoTime();
		func2.run();
		long stopTime = System.nanoTime();
		
		this.recElapsedTime = recStopTime-recStartTime;
		this.elapsedTime = stopTime-startTime;
	
		System.out.println("Recursive: "+(recElapsedTime)+" Non-Resursive: "+(elapsedTime)+"\n");
	}
	public void printFib(int n){
		
		long recStartTime = System.nanoTime();
		recResult = ComputeFibonacci.recFib(n);
		long recStopTime = System.nanoTime();
		
		long startTime = System.nanoTime();
		itResult = ComputeFibonacci.nRecFib(n);
		long stopTime = System.nanoTime();
		
		this.recElapsedTime = recStopTime-recStartTime;
		this.elapsedTime = stopTime-startTime;
	
		System.out.println("Recursive: "+(recElapsedTime)+" Non-Resursive: "+(elapsedTime)+"\n");
	}
	public void printFact(int n){
		
		long recStartTime = System.nanoTime();
		recResult = ComputeFactorial.recFact(n);
		long recStopTime = System.nanoTime();
		
		long startTime = System.nanoTime();
		itResult = ComputeFactorial.nRecFact(n);
		long stopTime = System.nanoTime();
		
		this.recElapsedTime = recStopTime-recStartTime;
		this.elapsedTime = stopTime-startTime;
	
		System.out.println("Recursive: "+(recElapsedTime)+" Non-Resursive: "+(elapsedTime)+"\n");
	}
	public void printPal(String n){
		
		long recStartTime = System.nanoTime();
		recBool = Palindrome.recPal(n);
		long recStopTime = System.nanoTime();
		
		long startTime = System.nanoTime();
		itBool = Palindrome.nRecPal(n);
		long stopTime = System.nanoTime();
		
		this.recElapsedTime = recStopTime-recStartTime;
		this.elapsedTime = stopTime-startTime;
	
		System.out.println("Recursive: "+(recElapsedTime)+" Non-Resursive: "+(elapsedTime)+"\n");
	}
	public void printBin(int[] array, int n){
		
		long recStartTime = System.nanoTime();
		recResult = BinarySearch.recBinarySearch(array, n);
		long recStopTime = System.nanoTime();
		
		long startTime = System.nanoTime();
		itResult = BinarySearch.nRecBinarySearch(array, n);
		long stopTime = System.nanoTime();
		
		this.recElapsedTime = recStopTime-recStartTime;
		this.elapsedTime = stopTime-startTime;
	
		System.out.println("Recursive: "+(recElapsedTime)+" Non-Resursive: "+(elapsedTime)+"\n");
	}
	public int getValue() {
		return value;
	}
	public String getStr() {
		return str;
	}
	public long getElapsedTime() {
		return elapsedTime;
	}
	public long getRecElapsedTime() {
		return recElapsedTime;
	}
	public double getRecResult() {
		return recResult;
	}
	public double getItResult() {
		return itResult;
	}
	public boolean getRecBool() {
		return recBool;
	}
	public boolean getItBool() {
		return itBool;
	}
}
