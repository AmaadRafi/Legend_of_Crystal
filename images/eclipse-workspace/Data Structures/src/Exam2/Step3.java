package Exam2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Step3 {

	public Step3(SymbolTable st){
		
		String s = infix2Postfix(st.getStrInfix());
	
		try {
			PrintWriter out = new PrintWriter("out2c.txt");
			
			out.println("Jason Nichols-Allen\tExam2");
			out.println();
			out.println("Postfix: "+s);
			out.println("Value: "+evaluate(s));
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String infix2Postfix(String infix){
	      Stack<Character> operatorStack = new Stack<Character>();
	      StringBuilder postfix = new StringBuilder();
	      int charCount = infix.length();
	      char topOfStack;

	      for (int index = 0; index < charCount; index++)
	      {
	         boolean finished = false;
	         char nextCharacter = infix.charAt(index);

	         if (Character.isLetter(nextCharacter))
	            postfix = postfix.append(nextCharacter);
	         else
	         {
	            switch (nextCharacter)
	            {
	               case '^':
	                  operatorStack.push(nextCharacter);
	                  break;

	               case '+': case '-': case '*': case '/':
	                  while (!finished && !operatorStack.isEmpty())
	                  {
	                     topOfStack = operatorStack.peek();

	                     if (getPrecedence(nextCharacter) <= getPrecedence(topOfStack))
	                     {
	                        postfix = postfix.append(topOfStack);
	                        operatorStack.pop();
	                     }
	                     else
	                        finished = true;
	                  } 
	                  operatorStack.push(nextCharacter);
	                  break;

	               case '(':
	                  operatorStack.push(nextCharacter);
	               break;

	               case ')':
	                  topOfStack = operatorStack.pop();
	                  while (topOfStack != '(')
	                  {
	                     postfix = postfix.append(topOfStack);
	                     topOfStack = operatorStack.pop();
	                  } 
	                  break;

	               default: break; 
	            } 
	         }
	      } 
	      while (!operatorStack.isEmpty())
	      {
	         topOfStack = operatorStack.pop();
	         postfix = postfix.append(topOfStack);
	      } 
	      return postfix.toString();
	   }
		private static int getPrecedence(char operator)
	   {
	      switch (operator)
	      {
	         case '(': case ')': return 0;
	         case '+': case '-': return 1;
	         case '*': case '/': return 2;
	         case '^':           return 3;
	      } 
	      return -1;
	   }
		 public static double evaluate(String postfix)
		   {
		      Stack<Double> valueStack = new Stack<Double>();
		      int charCount = postfix.length();

		      for (int index = 0; index < charCount; index++)
		      {
		         char nextCharacter = postfix.charAt(index);

		         switch(nextCharacter)
		         {
		            case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': 
		               valueStack.push(valueOf(nextCharacter));
		               break;

		            case '+': case '-': case '*': case '/': case '^':
		               Double second = valueStack.pop();
		               Double first = valueStack.pop();
		               Double result = compute(first, second, nextCharacter);
		               valueStack.push(result);
		               break;

		            default: break; 
		         } 
		      }
		      return (valueStack.peek()).doubleValue();
		   } 
		   private static double valueOf(char chr)
		   {
		      switch (chr)
		      {
		         case 'a': return 9.5;
		         case 'b': return 4.0;
		         case 'c': return 3.0;
		         case 'd': return 2.0;
		         case 'e': return 6.0;
		         case 'f': return 8.0;
		         case 'g': return 4.0;
		      } 
		      return 0; 
		   }
		   private static Double compute(Double first, Double second, char operator)
		   {
		      double result;

		      switch (operator)
		      {
		         case '+':
		            result = first.doubleValue() + second.doubleValue();
		            break;
		         case '-':
		            result = first.doubleValue() - second.doubleValue();
		            break;
		         case '*':
		            result = first.doubleValue() * second.doubleValue();
		             break;
		         case '/':
		            result = first.doubleValue() / second.doubleValue();
		            break;
		         case '^':
		            result = Math.pow(first.doubleValue(), second.doubleValue());
		            break;
		         default:   
		            result = 0;
		            break;
		      } 
		      return result;
		   } 
}
