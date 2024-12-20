package DataStructures.Graph;

import DataStructures.Heaps.ArrayHeap;
import DataStructures.List.ArrayUnorderedList;
import DataStructures.Queue.LinkedQueue;
import DataStructures.Stack.LinkedStack;
import Exceptions.EmptyCollectionException;
import Map.Map;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Class that contains a modified {@link WeightedGraph} that has some methods that help the construction of the {@link Map}
 * A modified graph is a weighted graph that implements {@link ModifiedGraphADT}
 *
 * @param <T> Generic that represents the vertex
 */
public class ModifiedGraph<T> extends WeightedGraph<T> implements ModifiedGraphADT<T> {

    /**
     * Constructor method that creates a modified {@link WeightedGraph} that has some methods that help the construction
     * of the {@link Map}
     * A modified graph is a weighted graph that implements {@link ModifiedGraphADT}
     */
    public ModifiedGraph() {
        //call the super constructor of the WeightedGraph
        super();
    }

    /**
     * Returns the number of edges in the graph
     *
     * @return the number of edges in the graph
     */
    public int getNumberOfEdges() {
        // initialize a variable to store the number of edges
        int numEdges = 0;

        // loop through the rows of the adjacency matrix
        for (int i = 0; i < numVertices; i++) {
            // loop through the columns of the adjacency matrix
            for (int j = 0; j < numVertices; j++) {
                // if the matrix element is not infinity, it means there is an edge
                if (adjMatrix[i][j] != Double.POSITIVE_INFINITY) {
                    // increment the number of edges
                    numEdges++;
                }
            }
        }

        // return the number of edges
        return numEdges;
    }

    /**
     * Returns the adjacency matrix of the graph
     *
     * @return the adjacency matrix of the graph
     */
    @Override
    public double[][] getAdjMatrix() {
        // return the adjacency matrix
        return adjMatrix;
    }

    /**
     * Returns the vertex at the given index
     *
     * @param index the index of the vertex
     * @return the vertex at the given index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T getVertex(int index) {
        // check the validity of the index
        if (index < 0 || index >= numVertices) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        // return the vertex at the index
        return vertices[index];
    }

    /**
     * Returns the index of the specified target vertex.
     *
     * @param target the target vertex
     * @return the index of the target vertex, or -1 if not found
     */
    public int getVertex(T target) {
        int index = -1;

        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(target)) {
                index = i;
            }
        }

        // return the vertex at the index
        return index;
    }

    /**
     * Sets the adjacency matrix of the graph.
     *
     * @param adjMatrix the adjacency matrix to set
     */
    @Override
    public void setAdjMatrix(double[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    /**
     * Sets the vertices of the graph.
     *
     * @param vertices the vertices to set
     */
    public void setVertices(T[] vertices) {
        this.vertices = vertices;
        numVertices = vertices.length;
    }

    /**
     * Returns the vertices of the graph.
     *
     * @return the vertices of the graph
     */
    @Override
    public T[] getVertices() {
        T[] newVertices = (T[]) new Object[numVertices];

        System.arraycopy(vertices, 0, newVertices, 0, numVertices);

        return newVertices;
    }

    /**
     * Sets the specified vertex at the given index.
     *
     * @param vertex the vertex to set
     * @param index the index to set the vertex at
     */
    public void setVertex(T vertex, int index) {
        vertices[index] = vertex;
    }

    /**
     * Returns a minimum spanning tree of the network.
     *
     * @return a minimum spanning tree of the network
     */
    public WeightedGraph mstNetwork() {
        int x, y;
        int index;
        double weight = 0;
        int[] edge = new int[2];
        ArrayHeap<Double> minHeap = new ArrayHeap<Double>();
        WeightedGraph<T> resultGraph = new WeightedGraph<T>();
        if (isEmpty() || !isConnected()) {
            return resultGraph;
        }
        resultGraph.adjMatrix = new double[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                resultGraph.adjMatrix[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        resultGraph.vertices = (T[]) (new Object[numVertices]);

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        edge[0] = 0;
        resultGraph.vertices[0] = this.vertices[0];
        resultGraph.numVertices++;
        visited[0] = true;
        /**
         * Add all edges, which are adjacent to the starting vertex, to the heap
         */
        for (int i = 0; i < numVertices; i++) {
            minHeap.addElement(new Double(adjMatrix[0][i]));
        }
        while ((resultGraph.size() < this.size()) && !minHeap.isEmpty()) {
            /**
             * Get the edge with the smallest weight that has exactly one vertex
             * already in the resultGraph
             */
            do {
                try {
                    weight = (minHeap.removeMin()).doubleValue();
                } catch (EmptyCollectionException e) {
                    throw new RuntimeException(e);
                }

                edge = getEdgeWithWeightOf(weight, visited);
            } while (!indexIsValid(edge[0]) || !indexIsValid(edge[1]));

            x = edge[0];
            y = edge[1];
            if (!visited[x]) {
                index = x;
            } else {
                index = y;
            }
            /**
             * Add the new edge and vertex to the resultGraph
             */
            resultGraph.vertices[index] = this.vertices[index];
            visited[index] = true;
            resultGraph.numVertices++;
            resultGraph.adjMatrix[x][y] = this.adjMatrix[x][y];
            resultGraph.adjMatrix[y][x] = this.adjMatrix[y][x];

            /**
             * Add all edges, that are adjacent to the newly added vertex, to
             * the heap
             */
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i] && (this.adjMatrix[i][index]
                        < Double.POSITIVE_INFINITY)) {
                    edge[0] = index;
                    // erro provavel
                    edge[1] = i;
                    minHeap.addElement(new Double(adjMatrix[index][i]));
                }
            }
        }
        return resultGraph;
    }

    /**
     * Returns an iterator over the minimum spanning tree network, considering a start and target vertex.
     *
     * @param startVertex the start vertex
     * @param targetVertex the target vertex
     * @return an iterator over the minimum spanning tree network
     */
    public Iterator<T> iteratorMstNetwork(T startVertex, T targetVertex) {
        WeightedGraph graph = mstNetwork();
        Iterator iterator = graph.iteratorShortestPath(startVertex, targetVertex);

        if (iterator == null) {
            System.out.println("There is no path possible. Shortest Path Algorithm was chosen");
            iterator = iteratorShortestPath(startVertex, targetVertex);
        }

        return iterator;
    }

    /**
     * Returns an iterator over the depth-first search traversal of the graph, considering a start and end vertex.
     *
     * @param startVertex the start vertex
     * @param endVertex the end vertex
     * @return an iterator over the depth-first search traversal
     */
    public Iterator<T> iteratorDFS(T startVertex, T endVertex) {
        Iterator<T> iteratorDFS = null;
        try {
            iteratorDFS = iteratorDFS(getIndex(startVertex), getIndex(endVertex));
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(WeightedGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iteratorDFS;
    }

    /**
     * Protected method to perform depth-first search traversal of the graph from a given start index to an end index.
     *
     * @param startIndex the start index
     * @param endIndex the end index
     * @return an iterator over the depth-first search traversal
     * @throws EmptyCollectionException if the collection is empty
     */
    protected Iterator<T> iteratorDFS(int startIndex, int endIndex) throws EmptyCollectionException {
        LinkedStack<Integer> traversalStack = new LinkedStack<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        boolean[] visited = new boolean[numVertices];

        if (!indexIsValid(startIndex) || !indexIsValid(endIndex)) {
            return resultList.iterator();
        }

        traversalStack.push(startIndex);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            int currentVertex = traversalStack.peek();
            boolean found = false;

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[currentVertex][i] != Double.POSITIVE_INFINITY && !visited[i]) {
                    traversalStack.push(i);
                    visited[i] = true;
                    resultList.addToRear(vertices[i]);
                    found = true;

                    if (i == endIndex) {
                        break;
                    }
                }
            }

            if (!found) {
                traversalStack.pop();
            }
        }

        return resultList.iterator();
    }
}
