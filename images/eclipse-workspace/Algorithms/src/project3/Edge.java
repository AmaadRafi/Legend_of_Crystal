package project3;
import java.util.Objects;

/**
 * Author: acbart@udel.edu
 * Updated: 3/21/2019
 * Description: A simple implementation of a hashable Edge type. Given two
 * vertices, an Edge can be constructed. Two Edges with the same vertices can
 * be considered equal, making this class suitable as the key for a Map.
*/
class Edge<VertexType> {
    private final VertexType left;
    private final VertexType right;

    /**
     * Create a new Edge from two Vertices.
     * 
     * @param left The first vertex
     * @param right The second vertex
     */
    public Edge(VertexType left, VertexType right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Determines if two Edges are equal. The edges must be equal and have
     * the same starting and ending nodes. If you swap the order, they will
     * not be equal!
     * 
     * @param o Any other object to compare against.
     * @return Whether the objects are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(left, edge.left) &&
                Objects.equals(right, edge.right);
    }

    /**
     * Calculates a Hash for the Edge, based on its vertices.
     * @return int A valid hashcode for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
