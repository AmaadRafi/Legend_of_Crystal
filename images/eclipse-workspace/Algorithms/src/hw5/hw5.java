package hw5;

public class hw5 {
	
	public static void main(String[] args) {
		
		color[] colors = new color[5];
		
		color newColor1 = new color(1, "blue");
		color newColor2 = new color(3, "red");
		color newColor3 = new color(4, "blue");
		color newColor4 = new color(6, "yellow");
		color newColor5 = new color(9, "red");
		
		colors[0] = newColor1;
		colors[1] = newColor2;
		colors[2] = newColor3;
		colors[3] = newColor4;
		colors[4] = newColor5;
		//color newColor6 = new color(1, "red");
		
	    //initialize all variables
        int reader = 0;
        int low = 0;
        int high = colors.length - 1;
 
        while(reader <= high){
            /*
              input always holds a permutation of the original data with input(0..(lo-1)) =0, input(lo..(reader-1))=1, input(reader..hi) is
              untouched, and input((hi+1)..(input.length-1)) = 2
            */
            if(colors[reader].getName() == "red"){
                /*When element at reader is 0, swap
                element at reader with element at index
                low and increment reader and low*/
                swap(colors, reader, low);
                reader++;
                low++;
            }
            else if(colors[reader].getName() == "blue"){
                /* if element at reader is just
                increment reader by 1 */
                reader++;
            }
            else if(colors[reader].getName() == "yellow"){
                /* If element at reader is 2, swap
                 element at reader with element at
                 high and decrease high by 1 */
                swap(colors, reader, high);
                high--;
            }
            else{
               System.out.println("Bad input");
               break;
            }
        }
        
        for(int i = 0; i < colors.length; i++) {
        	
        	System.out.print(colors[i].getKey() +"-" + colors[i].getName() + " ");
        }
 
	}
	public static void swap(color[] input, int i, int j){
        color temp =  input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
