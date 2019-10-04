package project2;
import java.util.*;
import java.io.*;

public class Project2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        scanner.close();

        List<String> records = readFile(filename);
        createCowDatabase(records);
      
    }
    public static void createCowDatabase(List<String> records) {
    	
    	List<Cow> cowList = new ArrayList<>();
       
        for(int i = 0; i <  records.size(); i++){
        	String[] tokens = records.get(i).split(" ");
        	
        	int cowID = Integer.parseInt(tokens[0]);
        	char actionCode = tokens[1].charAt(0);
        	int actionValue = Integer.parseInt(tokens[2]);
        	int timeStamp = Integer.parseInt(tokens[3]);
        	
        	Cow updateCow = cowList.stream().filter(Cow -> cowID == Cow.getCowID()).findFirst().orElse(null);
        	
        	if(updateCow != null){
        		updateCow.doAction(actionCode, actionValue);
        	}
        	else {
        		Cow newCow = new Cow(cowID, actionCode, actionValue, timeStamp);
        		cowList.add(newCow);
        	}
        }
        Collections.sort(cowList, new SortByLowest().thenComparing(new SortByCurrent()).thenComparing(new SortByMilking()));
        printList(cowList);
    }
    
    public static List<String> readFile(String file) {
        List < String > fileData = new ArrayList < String > ();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int numberOfRecords = Integer.parseInt(line);
            for(int i = 0; i < numberOfRecords; i++) {
            	line = reader.readLine();
                fileData.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", file);
            e.printStackTrace();
        }
        return fileData;
    }
    public static void printList(List<Cow> cowList) {
    	
    	for(int i = 0; i < cowList.size(); i++) {
    		
    		Cow currentCow = cowList.get(i);
    		if(currentCow.getNumMilkings() == 0 || currentCow.getCurrentWeight() == 0) {
    			
    		}
    		else {
        		System.out.println(currentCow);
    		}
    	}
    }
    static class SortByCurrent implements Comparator<Cow>
    {
        public int compare(Cow o1, Cow o2)
        {
            return o1.getCurrentWeight() - o2.getCurrentWeight();
        }
    }
    static class SortByLowest implements Comparator<Cow>
    {
        public int compare(Cow o1, Cow o2)
        {
            return o1.getLowestWeight() - o2.getLowestWeight();
        }
    }
    static class SortByMilking implements Comparator<Cow>
    {
        public int compare(Cow o1, Cow o2)
        {
        	return o1.getAverageMilking() - o2.getAverageMilking();
        }
    }
}
