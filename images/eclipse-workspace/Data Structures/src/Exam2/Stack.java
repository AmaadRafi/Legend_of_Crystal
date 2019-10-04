package Exam2;

import java.util.*;

public class Stack<T> {

	private T[] stack;
	private int stackPointer;
	private static final int SIZE = 100;
	
	public Stack(){
		
		@SuppressWarnings("unchecked")
	      T[] tempStack = (T[])new Object[SIZE];
	      stack = tempStack;
	      stackPointer = SIZE;
	}
	public void push(T newEntry){
		
		stack[stackPointer -1] = newEntry;
		stackPointer--;
	}
	public T pop(){
		
		if (isEmpty())
			throw new EmptyStackException();
		else
		{
			T topOfStack = stack[stackPointer];
			stack[stackPointer] = null;
			stackPointer++; 
         return topOfStack;
		}
	}
	public T peek(){
		return stack[stackPointer];
	}
	public boolean isEmpty(){
		
		return stackPointer == 100;
	}
	
	public String toString(){
		
		return Arrays.toString(stack);
	}
	public ArrayList<String> print(){
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("SP\tValue");
		for(int i = 0; i < stack.length; i++){
			
			if(stack[i] != null)
				array.add(i + "\t" + stack[i]);
		}
		return array;
	}
}


