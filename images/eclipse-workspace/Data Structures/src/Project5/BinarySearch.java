//Jason Nichols-Allen Project5

package Project5;

public class BinarySearch {
	
	public static int recBinarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;
		
		return recBinarySearch(list, key, low, high);
	}
	public static int recBinarySearch(int[] list, int key, int low, int high) {
		if (low > high)
			return -1;
		
		int mid = (low + high) / 2;
		
		if (key < list[mid])
			return recBinarySearch(list, key, low, mid - 1);
		else if (key == list[mid])
			return mid;
		else
			return recBinarySearch(list, key, mid + 1, high);
	}
	public static int nRecBinarySearch(int[] list, int key){
		
		    int low = 0;
		    int high = list.length -1;
		    int mid = 0;
		    
		    while (low<=high) {
		        mid = (low+high) / 2;
		        if (list[mid] > key) 
		            high = mid - 1;
		        else if (list[mid] < key) 
		            low = mid + 1;
		        else 
		            return mid;
		    }
		    return -1;
	}
}

