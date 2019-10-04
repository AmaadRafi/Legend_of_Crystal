package project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project3 {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner("pl.txt");
        String filename = scanner.next();
        scanner.close();

        List<String> records = readFile(filename);
        Graph<String> gameBoard = createGraph(records);
        //System.out.println();
        //System.out.println(gameBoard.toString());
        Djikstras<String> findPath = new Djikstras(gameBoard);
    }
	
	public static List<String> readFile(String file) {
        List < String > fileData = new ArrayList < String > ();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                fileData.add(line);
                //System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", file);
            e.printStackTrace();
        }
        return fileData;
    }
    public static Graph<String> createGraph(List<String> records){
    	
    	List<Entry> entries = new ArrayList<>();
    	Graph<String> newGraph = new Graph<String>();
        
        for(int i = 1; i <  records.size(); i++){
        	String[] tokens = records.get(i).split(" ", 3);
        	
        	int weight = Integer.parseInt(tokens[0]);
        	String actions = tokens[1];
        	String name = tokens[2];
        	
        	Entry newEntry = new Entry(weight, actions, name);
        	entries.add(newEntry);
        	if(newGraph.getVertices().contains(newEntry.getName())) {
        		String newName = newEntry.getName() + i;
        		newEntry.setName(newName);
        	}
        	newGraph.addVertex(newEntry.getName());
        }
        for(int i = 0; i < entries.size(); i++){
        	
        	Entry currentEntry = entries.get(i);
        	int edgeWeight = 0;
        	
        	if(currentEntry.isA()){
        		Entry nextEntry = entries.get(i + 1);
        		edgeWeight = nextEntry.getWeight() + 1;
        		newGraph.addDirectedEdge(currentEntry.getName(), nextEntry.getName(), edgeWeight, "A");
        		if(i > 0) {
        			//newGraph.addDirectedEdge(nextEntry.getName(), currentEntry.getName(), 5, "R");
        		}
        	}
        	if(currentEntry.isF()){
        		Entry previousEntry = entries.get(i - 1);
        		edgeWeight = (int)((Math.ceil(previousEntry.getWeight()/3.0)) + 1.0);
        		newGraph.addDirectedEdge(currentEntry.getName(), previousEntry.getName(), edgeWeight, "F");
        		if(i > 0) {
        			//newGraph.addDirectedEdge(previousEntry.getName(), currentEntry.getName(), 5, "R");
        		}
        	}
        	if(currentEntry.isL()){
        		Entry nextEntry = entries.get(i + 4);
        		edgeWeight = nextEntry.getWeight() + 10;
        		newGraph.addDirectedEdge(currentEntry.getName(), nextEntry.getName(), edgeWeight, "L");
        		if(i > 0) {
        			newGraph.addDirectedEdge(nextEntry.getName(), currentEntry.getName(), 5, "");
        		}
        	}
        	if(currentEntry.isT()){
        		Entry nextEntry = entries.get(i + 7);
        		edgeWeight = nextEntry.getWeight() + 20;
        		newGraph.addDirectedEdge(currentEntry.getName(), nextEntry.getName(), edgeWeight, "T");
        		if(i > 0) {
        			newGraph.addDirectedEdge(nextEntry.getName(), currentEntry.getName(), 5, "");
        		}
        	}
        		
        }
        return newGraph;	
    }
}

