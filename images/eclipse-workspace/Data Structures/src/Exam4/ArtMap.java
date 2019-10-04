package Exam4;

import java.io.*;
import java.util.*;

public class ArtMap {
	
		private Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		
		public ArtMap(String fileName) {

			readFile(fileName);
		}
		public void readFile(String fileName)
		{
			Scanner input;
			try {
				input = new Scanner(new File(fileName));
			
				while(input.useDelimiter("\t|\r\n").hasNext()){
					
					int artID = input.nextInt();
					String title = input.next();
					int artistID = input.nextInt();
					int appraisal = input.nextInt();
					
					map.put(artID, artistID);
				}
				input.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		public int getID(int searchKey){
			
			return map.get(searchKey);
		}
}
