package project3;
import java.util.*;

public class Djikstras<VertexType> {
	
	private Graph<VertexType> graph;
    private Set<VertexType> notVisited;
    private Set<VertexType> visited;
    private Map<VertexType, Integer> distances;
    private Map<VertexType, VertexType> actions;

	public Djikstras(Graph<VertexType> graph) {
		this.graph = graph;
		distances = new HashMap<VertexType, Integer>();
		run(graph.vertexArray.get(0));
	}
	public void run(VertexType source) {
		
		Initialize(source);
		for(int i = 0; notVisited.size() > 0; i++) {
            VertexType vertex = getMinimum(notVisited);
            notVisited.remove(vertex);
            visited.add(vertex);
            calculateNeighbors(vertex);
        }
		VertexType target = graph.vertexArray.get(graph.vertexArray.size() - 1);
		print(target);
	}
	public void Initialize(VertexType source) {
		
		notVisited = graph.getVertices();
		actions = new HashMap<>();
		visited = new HashSet<>();
		for(VertexType vertex : notVisited) {
			
			distances.put(vertex, Integer.MAX_VALUE);
		}
		distances.put(source, 0);	
	}
	private void calculateNeighbors(VertexType vertex) {
		
       Set<VertexType> neighbors = graph.getNeighbors(vertex);
       Object[] neighborArry = neighbors.toArray();
   
       for (int i = 0; i < neighborArry.length; i++) {
    	   @SuppressWarnings("unchecked")
		VertexType neighbor = (VertexType)neighborArry[i];
    	   
    	   if(!visited.contains(neighbor)) {
	    	   	int newDistance = newDistance(vertex, neighbor);
	            if (getDistance(neighbor) > newDistance) {
	                distances.put(neighbor, newDistance);
	                actions.put(neighbor, vertex);
	            }
    	   }
        }

    }
	private VertexType getMinimum(Set<VertexType> vertexes) {
		Object[] vertArray;
		vertArray = vertexes.toArray();
        @SuppressWarnings("unchecked")
		VertexType minimum = (VertexType)vertArray[0];
       
        for (int i = 1; i < vertArray.length; i++) {
        		
        		@SuppressWarnings("unchecked")
				VertexType vertex = (VertexType)vertArray[i];
                if (getDistance(vertex) < getDistance(minimum)) {
                    minimum = vertex;
                }
        }
        return minimum;
    }
	private int newDistance(VertexType vertex, VertexType target) {
		
		return getDistance(vertex) + graph.getWeight(vertex, target);
	}
	private int getDistance(VertexType destination) {
        Integer thisDistance = distances.get(destination);
      
        return thisDistance;
    }
	void print(VertexType target) {
		
		VertexType nextMove = target;
		StringBuilder sb = new StringBuilder();
        while (actions.get(nextMove) != null) {
        	VertexType previousMove = nextMove;
        	nextMove = actions.get(nextMove);
            sb.append(graph.getLabel(nextMove, previousMove));
        }
        System.out.println(sb.reverse());
        
	}
}
