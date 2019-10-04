// Jason Nichols-Allen Exam 2

package Exam2;

import java.util.ArrayList;
import java.util.Arrays;

public class SymbolTable {

	private String strExpression;
	private String strOperator;
	private String strVariable;
	private String strInfix;
	ArrayList<Variable> Table = new ArrayList<>();
	
	public SymbolTable(String strExpression){
		
		scan(strExpression);
	}
	public String getStrExpression() {
		return strExpression;
	}
	public String getStrOperator() {
		return strOperator;
	}
	public String getStrVariable() {
		return strVariable;
	}
	public String getStrInfix() {
		return strInfix;
	}
	public String scan(String strExpression){
		
		String[] splitArray = new String[strExpression.length()];
		ArrayList<String> varArray = new ArrayList<>();
		ArrayList<String> opArray = new ArrayList<>();
		ArrayList<String> infixArray = new ArrayList<>();
		
		splitArray = strExpression.split("\\s");
		
		for(int i = 0; i < splitArray.length; i++){
			
				if(Character.isDigit(splitArray[i].charAt(0))){
					
					varArray.add(splitArray[i]);
					Table.add(new Variable('n', Double.parseDouble(splitArray[i])));
				}
				else
					opArray.add(splitArray[i]);
				
				switch(splitArray[i]){
				case "9.5": infixArray.add("a");
				break;
				case "4": infixArray.add("b");
				break;
				case "3": infixArray.add("c");
				break;
				case "2": infixArray.add("d");
				break;
				case "6": infixArray.add("e");
				break;
				case "8": infixArray.add("f");
				break;
				case "4.0": infixArray.add("g"); 
				break;
				default: infixArray.add(splitArray[i]);
				break;
			}
		}
		
		this.strExpression = Arrays.toString(splitArray).replaceAll("\\[|\\]|\\s|\\,", "");
		strOperator = Arrays.toString(opArray.toArray()).replaceAll("\\[|\\]|\\s|\\,", "");
		strVariable = buildTable(varArray);
		strInfix = Arrays.toString(infixArray.toArray()).replaceAll("\\[|\\]|\\s|\\,", "");

		return this.strExpression;
	}
	public String buildTable(ArrayList<String> varArray){
		
		for(int i = 0; i < varArray.size(); i++){
				switch(varArray.get(i)){
				case "9.5": if(Table.get(i).value == Double.parseDouble(varArray.get(i)))
					Table.get(i).variable = 'A';
				varArray.set(i, "A");
				break;
				case "4": if(Table.get(i).value == Double.parseDouble(varArray.get(i)))
					Table.get(i).variable = 'B';
				varArray.set(i, "B");
				break;
				case "3": if(Table.get(i).value == Double.parseDouble(varArray.get(i)))
					Table.get(i).variable = 'C';
				varArray.set(i, "C");
				break;
				case "2": if(Table.get(i).value == Double.parseDouble(varArray.get(i)))
					Table.get(i).variable = 'D';
				varArray.set(i, "D"); 
				break;
				case "6": if(Table.get(i).value == Double.parseDouble(varArray.get(i)))
					Table.get(i).variable = 'E';
				varArray.set(i, "E"); 
				break;
				case "8": if(Table.get(i).value == Double.parseDouble(varArray.get(i)))
					Table.get(i).variable = 'F';
				varArray.set(i, "F");
				break;
				case "4.0": if(Table.get(i).value == Double.parseDouble(varArray.get(i)))
					Table.get(i).variable = 'G';
				varArray.set(i, "G"); 
				break;
				default: System.out.println("invald");
				break;
			}
		}
		return Arrays.toString(varArray.toArray()).replaceAll("\\[|\\]|\\s|\\,", "");
	}
	
	
	
}
