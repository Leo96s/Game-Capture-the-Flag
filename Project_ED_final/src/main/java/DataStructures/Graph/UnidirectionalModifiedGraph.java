package DataStructures.Graph;

import DataStructures.Heaps.ArrayHeap;
import DataStructures.List.ArrayUnorderedList;
import DataStructures.Stack.LinkedStack;
import Exceptions.EmptyCollectionException;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Class that contains a unidirectional {@link ModifiedGraph}
 *
 * @param <T> Generic that represents the vertex
 */
public class UnidirectionalModifiedGraph<T> extends ModifiedGraph<T> {

    /**
     * Constructor method that creates a unidirectional modified graph
     * A unidirectional modified graph is a modified graph that only allows one-way edges
     */
    public UnidirectionalModifiedGraph() {
        // call the super constructor of the modified graph
        super();
    }

    /**
     * Inserts an edge between two vertices of the graph
     * The edge is only added from the first vertex to the second vertex, not the other way around
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight  the weight of the edge
     */
    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        // get the indices of the vertices
        int index1 = getIndex(vertex1);
        int index2 = getIndex(vertex2);
        // call the private helper method to add the edge
        addEdge(index1, index2, weight);
    }

    /**
     * Inserts an edge between two vertices of the graph
     * The edge is only added from the first index to the second index, not the other way around
     *
     * @param index1 the first index
     * @param index2 the second index
     * @param weight the weight of the edge
     */
    private void addEdge(int index1, int index2, double weight) {
        // check the validity of the indices
        if (indexIsValid(index1) && indexIsValid(index2)) {
            // set the matrix element at the indices to the weight
            adjMatrix[index1][index2] = weight;
        }
    }

    /**
     * Removes an edge between two vertices of the graph
     * The edge is only removed from the first vertex to the second vertex, not the other way around
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void removeEdge(T vertex1, T vertex2) {
        // get the indices of the vertices
        int index1 = getIndex(vertex1);
        int index2 = getIndex(vertex2);
        // call the private helper method to remove the edge
        removeEdge(index1, index2);
    }

    /**
     * Removes an edge between two vertices of the graph
     * The edge is only removed from the first index to the second index, not the other way around
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    private void removeEdge(int index1, int index2) {
        // check the validity of the indices
        if (indexIsValid(index1) && indexIsValid(index2)) {
            // set the matrix element at the indices to infinity
            adjMatrix[index1][index2] = Double.POSITIVE_INFINITY;
        }
    }

    /**
     * Returns a minimum spanning tree of the network.
     * A minimum spanning tree is a subgraph that connects all the vertices with the minimum total weight
     *
     * @return a minimum spanning tree of the network
     */
    public UnidirectionalModifiedGraph<T> mstNetwork() {
        // create variables to store the indices and weight of the edges
        int x, y;
        int index;
        double weight = 0;
        int[] edge = new int[2];

        // create a min heap to store the weights of the edges
        ArrayHeap<Double> minHeap = new ArrayHeap<>();
        // create a result graph to store the minimum spanning tree
        UnidirectionalModifiedGraph<T> resultGraph = new UnidirectionalModifiedGraph<>();

        // if the graph is empty or not connected, return the empty result graph
        if (isEmpty() || !isConnected()) {
            return resultGraph;
        }

        // initialize the adjacency matrix of the result graph with infinity
        resultGraph.adjMatrix = new double[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                resultGraph.adjMatrix[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        // initialize the vertices array of the result graph
        resultGraph.vertices = (T[]) (new Object[numVertices]);

        // create a boolean array to mark the visited vertices
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        // start from the first vertex
        edge[0] = 0;
        // add the first vertex to the result graph
        resultGraph.vertices[0] = this.vertices[0];
        resultGraph.numVertices++;
        // mark the first vertex as visited
        visited[0] = true;

        // Add all edges, which are adjacent to the starting vertex, to the heap
        for (int i = 0; i < numVertices; i++) {
            // add the weight of the edge to the heap
            minHeap.addElement(new Double(adjMatrix[0][i]));
        }

        // loop until the result graph has the same size as this graph or the heap is empty
        while ((resultGraph.size() < this.size()) && !minHeap.isEmpty()) {
            // Get the edge with the smallest weight that has exactly one vertex already in the resultGraph
            do {
                // remove the smallest weight from the heap
                try {
                    weight = (minHeap.removeMin()).doubleValue();
                } catch (EmptyCollectionException e) {
                    throw new RuntimeException(e);
                }

                // get the indices of the vertices that form the edge with the weight
                edge = getEdgeWithWeightOf(weight, visited);
                // repeat until the indices are valid
            } while (!indexIsValid(edge[0]) || !indexIsValid(edge[1]));

            // assign the indices to x and y
            x = edge[0];
            y = edge[1];

            // if x is not visited, set index to x, otherwise set index to y
            if (!visited[x]) {
                index = x;
            } else {
                index = y;
            }

            // add the vertex at the index to the result graph
            resultGraph.vertices[index] = this.vertices[index];
            // mark the vertex as visited
            visited[index] = true;
            // increment the number of vertices in the result graph
            resultGraph.numVertices++;
            // add the edge to the result graph
            resultGraph.adjMatrix[x][y] = this.adjMatrix[x][y];
            resultGraph.adjMatrix[y][x] = this.adjMatrix[y][x];

            // add all the edges that are adjacent to the new vertex to the heap
            for (int i = 0; i < numVertices; i++) {
                // if the vertex is not visited and the edge weight is not infinity
                if (!visited[i] && (this.adjMatrix[i][index]
                        < Double.POSITIVE_INFINITY)) {
                    // set the edge indices to the new vertex and the adjacent vertex
                    edge[0] = index;
                    // erro provavel
                    edge[1] = i;

                    // add the weight of the edge to the heap
                    minHeap.addElement(new Double(adjMatrix[index][i]));
                }
            }
        }

        // return the result graph
        return resultGraph;
    }

    /**
     * Returns the indices of the vertices that form an edge with the given weight
     * The edge must have one vertex that is visited and one vertex that is not visited
     *
     * @param weight  the weight of the edge
     * @param visited the boolean array that indicates the visited vertices
     * @return the indices of the vertices that form the edge
     */
    protected int[] getEdgeWithWeightOf(double weight, boolean[] visited) {
        // create an array to store the indices
        int[] edge = new int[2];

        // loop through the vertices
        for (int i = 0; i < numVertices; i++) {
            // if the vertex is visited
            if (visited[i]) {
                // loop through the adjacent vertices
                for (int j = 0; j < numVertices; j++) {
                    // if the vertex is not visited and the edge weight is equal to the given weight
                    if (!visited[j] && adjMatrix[i][j] == weight) {
                        // set the edge indices to i and j
                        edge[0] = i;
                        edge[1] = j;

                        // return the edge
                        return edge;
                    }
                }
            }
        }

        // return the edge
        return edge;
    }

    @Override
    protected Iterator<T> iteratorDFS(int startIndex) throws EmptyCollectionException {
        Integer x;
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
            x = traversalStack.pop(); // Change peek to pop

            // Iterate through the outgoing edges of vertex x
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] != Double.POSITIVE_INFINITY && !visited[i]) {
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                }
            }
        }

        return resultList.iterator();
    }

    /**
     * Returns true if the graph is connected, false otherwise
     * A graph is connected if there is a path between any pair of vertices
     *
     * @return true if the graph is connected, false otherwise
     */
    @Override
    public boolean isConnected() {
        // if the graph has no vertices, it is connected
        if (numVertices == 0) {
            return true;
        }

        // initialize a boolean array to mark the visited vertices
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        // start a depth-first search traversal from the first vertex
        Iterator<T> iterator;
        try {
            iterator = this.iteratorDFS(0);
            while (iterator.hasNext()) {
                // get the next vertex in the traversal
                T vertex = iterator.next();
                // mark the vertex as visited
                visited[getIndex(vertex)] = true;
            }

            // Check if all vertices have been visited
            for (int i = 0; i < numVertices; i++) {
                // if any vertex is not visited, the graph is not connected
                if (!visited[i]) {
                    return false;
                }
            }
        } catch (EmptyCollectionException ex) {
            // handle the exception
            Logger.getLogger(WeightedGraph.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        // if all the checks pass, the graph is connected
        return true;
    }

    /**
     * Returns an iterator that traverses the minimum spanning tree (MST) network from the specified start vertex to the target vertex.
     * If there is no path in the MST network between the start and target vertices, the shortest path algorithm is used instead.
     *
     * @param startVertex  the starting vertex
     * @param targetVertex the target vertex
     * @return an iterator that traverses the MST network from the start to target vertex
     */
    public Iterator<T> iteratorMstNetwork(T startVertex, T targetVertex) {
        // Obtain the minimum spanning tree (MST) network
        UnidirectionalModifiedGraph<T> graph = mstNetwork();

        // Obtain an iterator for the shortest path in the MST network from startVertex to targetVertex
        Iterator iterator = graph.iteratorShortestPath(startVertex, targetVertex);

        // If there is no path in the MST network between the start and target vertices
        if (iterator == null) {
            // Use the shortest path algorithm instead
            iterator = iteratorShortestPath(startVertex, targetVertex);
        }

        return iterator;
    }
}