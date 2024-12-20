package DataStructures.Graph;

import java.util.Iterator;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Interface that contains the modifications which assist the creation of {@link Map}
 *
 * @param <T> Generic that represents the vertex
 */
public interface ModifiedGraphADT<T> extends NetworkADT<T> {

    /**
     * Returns the number of edges in the graph
     *
     * @return the number of edges in the graph
     */
    int getNumberOfEdges();

    /**
     * Returns the adjacency matrix of the graph
     *
     * @return the adjacency matrix of the graph
     */
    double[][] getAdjMatrix();

    /**
     * Returns the vertex at the given index
     *
     * @param index the index of the vertex
     * @return the vertex at the given index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    /**
     * Returns the vertex at the specified index.
     *
     * @param index the index of the vertex
     * @return the vertex at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T getVertex(int index);

    /**
     * Returns the index of the specified target vertex.
     *
     * @param target the target vertex
     * @return the index of the target vertex, or -1 if not found
     */
    int getVertex(T target);

    /**
     * Returns an array of the vertices in the graph.
     *
     * @return an array of the vertices in the graph
     */
    T[] getVertices();

    /**
     * Sets the adjacency matrix of the graph.
     *
     * @param adjMatrix the adjacency matrix to set
     */
    void setAdjMatrix(double[][] adjMatrix);

    /**
     * Sets the vertices of the graph.
     *
     * @param vertices the vertices to set
     */
    void setVertices(T[] vertices);

    /**
     * Sets the specified vertex at the given index.
     *
     * @param vertex the vertex to set
     * @param index the index to set the vertex at
     */
    void setVertex(T vertex, int index);

    /**
     * Returns an iterator over the minimum spanning tree network, considering a start and target vertex.
     *
     * @param startVertex the start vertex
     * @param targetVertex the target vertex
     * @return an iterator over the minimum spanning tree network
     */
    Iterator<T> iteratorMstNetwork(T startVertex, T targetVertex);

    /**
     * Returns an iterator over the depth-first search traversal of the graph, considering a start and end vertex.
     *
     * @param startVertex the start vertex
     * @param endVertex the end vertex
     * @return an iterator over the depth-first search traversal
     */
    Iterator iteratorDFS(T startVertex, T endVertex);
}
