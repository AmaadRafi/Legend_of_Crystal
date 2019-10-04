// Jason Nichols-Allen

package Exam2;

public class Variable {

	char variable;
	double value;
	
	public Variable(char variable, double value){
		
		this.variable = variable;
		this.value = value;
	}
	public char getVariable(){
		
		return variable;
	}
	public double getValue(){
		
		return value;
	}
	public void setVariable(char variable){
		
		this.variable = variable;
	}
	public String toString(){
		
		return variable + " " + value;
	}
}
