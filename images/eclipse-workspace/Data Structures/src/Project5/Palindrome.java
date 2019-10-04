//Jason Nichols-Allen Project5

package Project5;

public class Palindrome {

	public static boolean recPal(String s){
		
		return recPal(s, 0, s.length()-1);
	}
	public static boolean recPal(String s, int low, int high){
		
		if(high <= low)
			return true;
		else if(s.charAt(low) != s.charAt(high))
			return false;
		else
			return recPal(s,low+1,high-1);
	}
	public static boolean nRecPal(String s){
	    int i1 = 0;
	    int i2 = s.length() - 1;
	    while (i2 > i1) {
	        if (s.charAt(i1) != s.charAt(i2)) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;
	}
}
