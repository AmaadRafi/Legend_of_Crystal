//Jason Nichols-Allen Project5

package Project5;

public class ComputeFibonacci {
	
	public static long recFib(int n){
		
		if(n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else 
			return recFib(n-1) + recFib(n-2);
	}
	public static long nRecFib(int n){
		
		 if(n <= 1)
			 return n;
		
		 long result = 1;
		 long prev = 1;
		 
		 for(int i = 2; i < n; ++i){
			  long temp = result;
			  result += prev;
			  prev = temp;
		 }
		 
		 return result;
	}
}
