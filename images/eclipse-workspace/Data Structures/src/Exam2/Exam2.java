// Jason Nichols-Allen Exam 2

package Exam2;

public class Exam2 {

	public static void main(String[] args) {
	
		Step1 s1 = new Step1();
		Step2 s2 = new Step2();
		Step3 s3 = new Step3(s1.getSymbolTable());
	}
}
