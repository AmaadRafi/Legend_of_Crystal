package project3;
import java.util.*;

/**
 * Author: acbart@udel.edu
 * Updated: 3/21/2019
 * Description: A simple implementation of an Adjacency List representation
 * of a Directed Graph with edge weights and labels. Edge attributes are stored
 * in the Graph instead of the Edge in order to keep Edge hashing simple.
*/
public class Graph<VertexType> {
    private Set<VertexType> vertices;
    private Map<Edge<VertexType>, Integer> weights;
    private Map<Edge<VertexType>, String> labels;
    private Map<VertexType, Set<VertexType>> neighbors;
    public List<VertexType> vertexArray;

    /**
     * Create a new, empty Graph.
     */
    public Graph(){
        vertices = new HashSet<>();
        weights = new HashMap<>();
        labels = new HashMap<>();
        neighbors = new HashMap<>();
        vertexArray = new ArrayList<>();
    }
    
    /**
     * Adds the vertex if it is new (otherwise does nothing). Note that this
     * vertex will not be connected to anything.
     * 
     * @param vertex The vertex to be added.
     */
    public void addVertex(VertexType vertex) {
        if(!neighbors.containsKey(vertex)) {
            neighbors.put(vertex, new HashSet<>());
            vertexArray.add(vertex);
        }
        vertices.add(vertex);
    }

    /**
     * Adds a new directed edge to the graph between the two vertices with
     * the given weight and label.
     * 
     * @param left The origin vertex.
     * @param right The destination vertex.
     * @param weight The weight for this edge.
     * @param label The desired label for this edge.
     */
    public void addDirectedEdge(VertexType left, VertexType right,
                                int weight, String label) {
        // Keep track of both vertices, in case they're new
        addVertex(left);
        addVertex(right);
        // Actually build the neighbor connection
        neighbors.get(left).add(right);
        // Keep track of edge attributes
        Edge<VertexType> edge = new Edge<VertexType>(left, right);
        weights.put(edge, weight);
        labels.put(edge, label);
    }

    /**
     * Provides the entire set of vertices for the graph.
     * 
     * @return All the vertices in the graph.
     */
    public Set<VertexType> getVertices() {
        return vertices;
    }

    /**
     * Provides all vertices that are connected to the given vertex.
     * 
     * @param origin The vertex to find the neighbors of.
     * @return Any vertices that are connected to the given vertex.
     */
    public Set<VertexType> getNeighbors(VertexType origin) {
        return neighbors.get(origin);
    }

    /**
     * Retrieve the weight of the given Edge in the graph.
     * 
     * @param edge The edge to get the weight of.
     * @return The weight of the edge.
     */
    public int getWeight(Edge<VertexType> edge) {
        return weights.get(edge);
    }
    
    /**
     * Retrieve the weight of the edge associated with the left and right
     * vertex. An error will occur if the edge does not exist.
     * 
     * @param left The origin vertex
     * @param right The destination vertex
     * @return The weight of the vertices' edge.
     */
    public int getWeight(VertexType left, VertexType right) {
        Edge<VertexType> e = new Edge<VertexType>(left, right);
        return getWeight(e);
    }
    
    /**
     * Retrieve the label of the given Edge in the graph.
     * 
     * @param edge The edge to get the label of.
     * @return The label of the edge.
     */
    public String getLabel(Edge<VertexType> e) {
        return labels.get(e);
    }
    
    /**
     * Retrieve the label of the edge associated with the left and right
     * vertex. An error will occur if the edge does not exist.
     * 
     * @param left The origin vertex
     * @param right The destination vertex
     * @return The label of the vertices' edge.
     */
    public String getLabel(VertexType left, VertexType right) {
        Edge<VertexType> e = new Edge<VertexType>(left, right);
        return getLabel(e);
    }
    
    /**
     * Create a simple representation of the graph as an adjacency list:
     *   [Vertex 1] -> (Neighbor 1, Neighbor 2, ...)
     *   [Vertex 2] -> (Neighbor 1, ...)
     *   ...
     * 
     * @return A string representation of the graph.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (VertexType v: vertices) {
            sb.append("["+v.toString()+"]");
            List<String> neighborStrings = new ArrayList<String>();
            List<Integer> neighborWeights = new ArrayList<Integer>();
            for (VertexType n: neighbors.get(v)) {
                neighborStrings.add(n.toString());
                neighborWeights.add(getWeight(v,n));
            }
            sb.append(" -> (");
            for(int i = 0; i < neighborStrings.size(); i++) {
            	
            	sb.append(neighborStrings.get(i).toString() + " " + neighborWeights.get(i));
            	if((i+1) != neighborStrings.size())
            	sb.append(", ");
            	
            }
            sb.append(")");
            sb.append("\n");
        }
        return sb.toString();
    }
    public String printVertices() {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < vertexArray.size(); i++) {
    		
    		sb.append(vertexArray.get(i).toString());
    		sb.append("\n");
    		
    	}
    	return sb.toString();
    }


}
