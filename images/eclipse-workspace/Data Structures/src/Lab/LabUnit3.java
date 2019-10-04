package Lab;
import java.io.*;
import java.util.*;

public class LabUnit3 {
	
	public static void main(String[] args) {

		DoubleLink<Name> list = readFile();
		writeFile(list);
	}
	public static DoubleLink<Name> readFile()
	{
		DoubleLink<Name> list = new DoubleLink<>();
	
		Scanner input;
		try {
			input = new Scanner(new File("p6Name.txt"));
		
			while(input.useDelimiter("\t|\r\n").hasNext()){
				
				String first = input.next();
				String last = input.next();
				
				Name newName = new Name(first, last);
		
				list.add(newName);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void writeFile(DoubleLink<Name> list){
		
		try {
			PrintWriter output = new PrintWriter("lab20170315.txt");
			output.println("Jason Nichols-Allen\tLinkedSortLab\r\n");
			output.print(list.toString());
			output.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
