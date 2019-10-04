package project3;
import java.util.*;

public class DjikstrasOG<VertexType> {
	
	private Graph<VertexType> graph;
    private Set<VertexType> notVisited;
    private Map<VertexType, Integer> distance;

    private Map<VertexType, String> actions;

	public DjikstrasOG(Graph<VertexType> graph) {
		this.graph = graph;
		distance = new HashMap<VertexType, Integer>();
		run(graph.vertexArray.get(0));
	}
	public void run(VertexType source) {
		
		Initialize(source);
		for(int i = 0; notVisited.size() > 0; i++) {
            VertexType vertex = getMinimum(notVisited);
            notVisited.remove(vertex);
            findMinimalDistances(vertex);
            System.out.println(vertex.toString() + " " + distance.get(vertex));
            
        }
	}
	public void Initialize(VertexType source) {
		
		notVisited = graph.getVertices();
		actions = new HashMap<>();
		for(VertexType vertex : notVisited) {
			
			distance.put(vertex, Integer.MAX_VALUE);
		}
		distance.put(source, 0);
		
	}
	private void findMinimalDistances(VertexType vertex) {
		
       Set<VertexType> neighbors = graph.getNeighbors(vertex);
   
       for (VertexType target : neighbors) {
    	   	int newDistance = newDistance(vertex, target);
            if (getDistance(target) > newDistance) {
                distance.put(target, newDistance);
                actions.put(target, graph.getLabel(vertex, target));
            }
        }

    }
	private VertexType getMinimum(Set<VertexType> vertexes) {
        VertexType minimum = null;
        for (VertexType vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getDistance(vertex) < getDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }
	private int newDistance(VertexType vertex, VertexType target) {
		
		return getDistance(vertex) + graph.getWeight(vertex, target);
	}
	private int getDistance(VertexType destination) {
        Integer thisDistance = distance.get(destination);
      
        return thisDistance;
    }
	public void print(VertexType target) {
		 {
			
			
		}
	}
}
