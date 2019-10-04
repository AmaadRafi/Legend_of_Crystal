//Jason Nichols-Allen Project5

package Project5;

public class ComputeFactorial {

	public static long recFact(int n){
		
		if(n == 0)
			return 1;
		else
			return n * recFact(n-1);
	}
	public static long nRecFact(int n){
		
		long result = n;
		
		for(int i = n-1; i > 0; i--){
			
			result *= i;
		}	
		return result;
	}
}
