package project1;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();

        scanner.close();

        List<String> records = readFile(filename);

        calculateRainfall(records);
    }
    public static List<String> readFile(String file) {
        List < String > fileData = new ArrayList < String > ();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                fileData.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", file);
            e.printStackTrace();
        }
        return fileData;
    }
    public static void calculateRainfall(List<String> records){

        int total = 0;

        for(int i = 1; i < records.size(); i++){

          int value = Integer.parseInt(records.get(i));
          if(value == -999){
            break;
          }
          else if (value > 0){
            total += value;
          }
        }
        if(total > 0)
          System.out.println(total);
        else
          System.out.println("EMPTY");
    }
}
