// Jason Nichols-Allen Exam 2

package Exam2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import Project4.Postfix;

public class Step1 {

	String strInput = "9.5 - 4 * 3 ^ 2 / 6 + 8 * 4";
	SymbolTable st = new SymbolTable(strInput);
	
	public Step1(){
		/*String s = Postfix2.convertToPostfix(st.getStrInfix());
		System.out.println(s);
		System.out.println(Postfix2.evaluatePostfix(s));*/
		try {
			PrintWriter out = new PrintWriter("out2a.txt");
			
			out.println("Jason Nichols-Allen\tExam2");
			out.println();
			out.println("Valid Expression = "+st.getStrExpression());
			out.println("Operator String = "+st.getStrOperator());
			out.println();
			out.println("\nSymbol Table");
			for(int i = 0; i < st.Table.size(); i++){
				
				out.println(st.Table.get(i));
			}
			out.println();
			out.println("\nVariable String = "+st.getStrVariable());
			out.println("Infix = "+st.getStrInfix());
			out.flush();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	public SymbolTable getSymbolTable(){
		return st;
	}
}
