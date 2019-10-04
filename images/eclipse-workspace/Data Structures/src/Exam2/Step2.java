package Exam2;

import java.io.PrintWriter;
import java.util.*;

public class Step2 {

	String myName = "Jason Nichols-Allen";
	
	Stack<Character> cStack = new Stack<Character>();
	Stack<Double> dStack = new Stack<Double>();
	Stack<Variable> vStack = new Stack<Variable>();
	char chA = 'A', chB = 'B', chC = 'C', chD = 'D';
	double dA = 93.7, dB = 7, dC = 10, dD = 6;
	
	public Step2(){
		
		try {
			PrintWriter out = new PrintWriter("out2b.txt");
				cStack.push('A');
				cStack.push('B');
				cStack.push('C');
				out.println(myName + " " + "Exam2_Part2");
				print(cStack, out);
				cStack.push('D');
				print(cStack, out);
				for(int i = 0; i <= 5; i++){
					try {
						out.println("Character Popped: "+cStack.pop());
					} catch (Exception e) {
						out.println("Stack is empty.  Nothing to pop!");
						out.println("Character Popped: "+null);
						out.println();
					}
				}
				dStack.push(dA);
				dStack.push(dC);
				print(dStack, out);
				vStack.push(new Variable(chA, dA));
				vStack.push(new Variable(chB, dB));
				vStack.push(new Variable(chC, dC));
				print(vStack, out);
				out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void print(Stack stack, PrintWriter out){
		
		ArrayList<String> array = new ArrayList<>(stack.print());
		
		for(int i = 0; i < array.size(); i++){
			out.println(array.get(i));
		}
		out.println("\n");
			
	}
	
}
