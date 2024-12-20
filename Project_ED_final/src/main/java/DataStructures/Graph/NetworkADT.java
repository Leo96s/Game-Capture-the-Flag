package DataStructures.Graph;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * NetworkADT defines the interface to a network.
 *
 * @param <T>
 */
public interface NetworkADT<T> extends GraphADT<T> {

    /**
     * Inserts an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight the weight
     */
    void addEdge(T vertex1, T vertex2, double weight);

    /**
     * Returns the weight of the shortest path in this network.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the weight of the shortest path in this network
     */
    double shortestPathWeight(T vertex1, T vertex2);
}
