package DataStructures.Graph;

import DataStructures.Heaps.ArrayHeap;
import DataStructures.List.ArrayUnorderedList;
import DataStructures.Queue.LinkedQueue;
import DataStructures.Stack.LinkedStack;
import Exceptions.EmptyCollectionException;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * WeightedGraph represents a weighted graph implementation that implements the NetworkADT interface.
 *
 * @param <T> the type of elements stored in the vertices of the graph
 */
public class WeightedGraph<T> implements NetworkADT<T> {

    protected final int DEFAULT_CAPACITY = 10; // Default capacity of the graph
    protected int numVertices; // Number of vertices in the graph
    protected double[][] adjMatrix; // Adjacency matrix representation of the graph
    protected T[] vertices; // Array storing the values of vertices

    /**
     * Constructs an empty weighted graph with the default capacity.
     */
    public WeightedGraph() {
        numVertices = 0;
        this.adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    private void expandCapacity() {
        int newCapacity = adjMatrix.length * 2;
        double[][] newMatrix = new double[newCapacity][newCapacity];
        T[] newVertices = (T[]) new Object[newCapacity];

        for (int i = 0; i < numVertices; i++) {
            System.arraycopy(adjMatrix[i], 0, newMatrix[i], 0, numVertices);
        }
        System.arraycopy(vertices, 0, newVertices, 0, numVertices);

        adjMatrix = newMatrix;
        vertices = newVertices;
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        addEdge(getIndex(vertex1), getIndex(vertex2), weight);
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    private void addEdge(int index1, int index2, double weight) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = weight;
            adjMatrix[index2][index1] = weight;
        }
    }

    /**
     * Determines if an index is valid.
     *
     * @param index the index to be checked
     * @return true if the index is valid, false otherwise
     */
    public boolean indexIsValid(int index) {
        return ((index >= 0) && (index < adjMatrix.length));
    }

    public int getIndex(T vertex) {
        int index = -1;

        for (int i = 0; i < numVertices; i++) {
            if (vertex.equals(vertices[i])) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * Adds a vertex to the graph, expanding the capacity of the graph if
     * necessary. It also associates an object with the vertex.
     *
     * @param vertex the vertex to add to the graph
     */
    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = Double.POSITIVE_INFINITY;
            adjMatrix[i][numVertices] = Double.POSITIVE_INFINITY;
        }
        numVertices++;
    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        int startIndex = getIndex(vertex1);
        int targetIndex = getIndex(vertex2);

        if (startIndex == -1 || targetIndex == -1) {
            return Double.POSITIVE_INFINITY; // Vertex not found
        }

        double[] shortestDistances = new double[numVertices];
        boolean[] visited = new boolean[numVertices];

        // Initialize distances and previousVertices
        for (int i = 0; i < numVertices; i++) {
            shortestDistances[i] = Double.POSITIVE_INFINITY;
        }
        shortestDistances[startIndex] = 0;

        // Dijkstra's algorithm
        for (int i = 0; i < numVertices; i++) {
            // Find the unvisited vertex with the smallest distance
            int v = -1;
            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && (v == -1 || shortestDistances[j] < shortestDistances[v])) {
                    v = j;
                }
            }

            if (shortestDistances[v] == Double.POSITIVE_INFINITY) {
                break; // Unreachable vertices remain
            }

            visited[v] = true;

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[v][j] != Double.POSITIVE_INFINITY) {
                    double possibleNewDistance = shortestDistances[v] + adjMatrix[v][j];
                    if (possibleNewDistance < shortestDistances[j]) {
                        shortestDistances[j] = possibleNewDistance;
                    }
                }
            }
        }

        return shortestDistances[targetIndex];
    }

    /**
     * Removes a vertex from the graph
     *
     * @param vertex the vertex to remove to the graph
     */
    @Override
    public void removeVertex(T vertex) {
        int index = getIndex(vertex);

        if (indexIsValid(index)) {
            vertices[index] = null; // Mark the vertex as removed

            // Remove the edges connected to the vertex
            for (int i = 0; i < adjMatrix.length; i++) {
                adjMatrix[index][i] = Double.POSITIVE_INFINITY;
                adjMatrix[i][index] = Double.POSITIVE_INFINITY;
            }

            numVertices--; // Decrease the number of vertices
        }
    }

    /**
     * Removes an edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void removeEdge(T vertex1, T vertex2) {
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Removes an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    private void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = Double.POSITIVE_INFINITY;
            adjMatrix[index2][index1] = Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator iteratorBFS(T startVertex) {
        Iterator iteratorBFS = null;
        try {
            iteratorBFS = iteratorBFS(getIndex(startVertex));
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(WeightedGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iteratorBFS;
    }

    /**
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given index.
     *
     * @param startIndex the index to begin the search from
     * @return an iterator that performs a breadth first traversal
     * @throws Exceptions.EmptyCollectionException
     */
    private Iterator<T> iteratorBFS(int startIndex) throws EmptyCollectionException {
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);

            /**
             * Find all vertices adjacent to x that have not been visited and
             * queue them up
             */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] == Double.POSITIVE_INFINITY && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex) {
        Iterator iteratorDFS = null;
        try {
            iteratorDFS = iteratorDFS(getIndex(startVertex));
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(WeightedGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iteratorDFS;
    }

    /**
     * Returns an iterator that performs a depth first search traversal starting
     * at the given index.
     *
     * @param startIndex the index to begin the search traversal from
     * @return an iterator that performs a depth first traversal
     * @throws Exceptions.EmptyCollectionException
     */
    protected Iterator<T> iteratorDFS(int startIndex) throws EmptyCollectionException {
        Integer x;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;

            /**
             * Find a vertex adjacent to x that has not been visited and push it
             * on the stack
             */
            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjMatrix[x.intValue()][i] == Double.POSITIVE_INFINITY && !visited[i]) {
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }

        return resultList.iterator();
    }

    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        int startIndex = getIndex(startVertex);
        int targetIndex = getIndex(targetVertex);

        if (startIndex == -1 || targetIndex == -1) {
            return null; // Vertex not found
        }

        double[] shortestDistances = new double[numVertices];
        int[] previousVertices = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        // Initialize distances and previousVertices
        for (int i = 0; i < numVertices; i++) {
            shortestDistances[i] = Double.POSITIVE_INFINITY;
            previousVertices[i] = -1;
        }
        shortestDistances[startIndex] = 0;

        // Dijkstra's algorithm
        for (int i = 0; i < numVertices; i++) {
            // Find the unvisited vertex with the smallest distance
            int v = -1;
            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && (v == -1 || shortestDistances[j] < shortestDistances[v])) {
                    v = j;
                }
            }

            if (shortestDistances[v] == Double.POSITIVE_INFINITY) {
                break; // Unreachable vertices remain
            }

            visited[v] = true;

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[v][j] != Double.POSITIVE_INFINITY) {
                    double possibleNewDistance = shortestDistances[v] + adjMatrix[v][j];
                    if (possibleNewDistance < shortestDistances[j]) {
                        shortestDistances[j] = possibleNewDistance;
                        previousVertices[j] = v;
                    }
                }
            }
        }

        // Build the shortest path from startVertex to targetVertex
        ArrayUnorderedList<T> path = new ArrayUnorderedList<>();
        int currentVertex = targetIndex;
        while (currentVertex != -1) {
            path.addToFront(vertices[currentVertex]);
            currentVertex = previousVertices[currentVertex];
        }

        return path.iterator();
    }

    /**
     * Returns the index of the previous vertex on the shortest path to the current vertex.
     * This method is used in finding the shortest path in a weighted graph using Dijkstra's algorithm.
     *
     * @param startIndex   the index of the starting vertex
     * @param currentIndex the index of the current vertex
     * @param shortestPath an array containing the shortest distances to each vertex
     * @return the index of the previous vertex on the shortest path, or -1 if not found
     */
    private int getPreviousVertex(int startIndex, int currentIndex, double[] shortestPath) {
        for (int i = 0; i < numVertices; i++) {
            // Check if there is an edge from vertex i to the current vertex
            if (adjMatrix[i][currentIndex] != Double.POSITIVE_INFINITY) {
                // Check if the sum of the shortest distance to vertex i and the weight of the edge to the current vertex
                // equals the shortest distance to the current vertex
                if (shortestPath[i] + adjMatrix[i][currentIndex] == shortestPath[currentIndex]) {
                    return i; // Found the previous vertex on the shortest path
                }
            }
        }
        return -1; // No previous vertex found
    }

    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }

    @Override
    public boolean isConnected() {
        if (numVertices == 0) {
            return true;
        }

        // Initialize visited array
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        // Start DFS traversal from the first vertex
        Iterator<T> iterator;
        try {
            iterator = iteratorDFS(0);
            while (iterator.hasNext()) {
                T vertex = iterator.next();
                visited[getIndex(vertex)] = true;
            }

            // Check if all vertices have been visited
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i]) {
                    return false;
                }
            }

            if (!(adjMatrix[0][numVertices - 1] != 0)) {
                return false;
            }

        } catch (EmptyCollectionException ex) {
            Logger.getLogger(WeightedGraph.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public int size() {
        return numVertices;
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
     * Returns an array containing the indices of the vertices forming an edge with the specified weight,
     * where one vertex is visited and the other is not.
     *
     * @param weight  the weight of the edge
     * @param visited an array indicating whether each vertex has been visited
     * @return an array containing the indices of the vertices forming the edge, or an array with default values if no such edge is found
     */
    protected int[] getEdgeWithWeightOf(double weight, boolean[] visited) {
        int[] edge = new int[2];

        // Iterate through each visited vertex
        for (int i = 0; i < numVertices; i++) {
            if (visited[i]) {
                // Iterate through each unvisited vertex
                for (int j = 0; j < numVertices; j++) {
                    // Check if there is an edge between the visited vertex and the unvisited vertex with the specified weight
                    if (!visited[j] && adjMatrix[i][j] == weight) {
                        // Found an edge with the specified weight
                        edge[0] = i; // Index of the visited vertex
                        edge[1] = j; // Index of the unvisited vertex
                        return edge;
                    }
                }
            }
        }

        // Return an array with default values if no edge with the specified weight is found
        return edge;
    }

    /**
     * Returns a string representation of the graph.
     *
     * @return a string representation of the graph
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        // Append vertices
        result.append("Vertices: ");
        for (int i = 0; i < numVertices; i++) {
            result.append(vertices[i]);
            if (i < numVertices - 1) {
                result.append(", ");
            }
        }
        result.append("\n");

        // Append adjacency matrix with column letters
        result.append("Adjacency Matrix:\n");
        for (int i = -1; i < numVertices; i++) {
            if (i == -1) {
                // Print column letters
                for (int j = 0; j < numVertices; j++) {
                    result.append("  " + (char) ('a' + j));
                    if (j < numVertices - 1) {
                        result.append(" ");
                    }
                }
                result.append("\n");
            } else {
                for (int j = -1; j < numVertices; j++) {
                    if (j == -1) {
                        // Print row number
                        result.append((char) ('a' + i));
                    } else {
                        // Print adjacency value
                        if (adjMatrix[i][j] != Double.POSITIVE_INFINITY) {
                            result.append(adjMatrix[i][j]);
                        } else {
                            result.append("N.A");
                        }
                    }
                    if (j < numVertices - 1) {
                        result.append(" ");
                    }
                }
                result.append("\n");
            }
        }

        return result.toString();
    }
}