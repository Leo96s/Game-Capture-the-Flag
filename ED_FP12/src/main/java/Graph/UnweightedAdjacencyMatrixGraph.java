/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import List.ArrayUnorderedList;
import Queue.LinkedQueue;
import Stack.LinkedStack;
import Throws.EmptyCollectionException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 *
 * Graph represents an adjacency matrix implementation of a graph.
 */
public class UnweightedAdjacencyMatrixGraph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices; // number of vertices in the graph
    protected boolean[][] adjMatrix; // adjacency matrix
    protected T[] vertices; // values of vertices

    /**
     * Creates an empty graph.
     */
    public UnweightedAdjacencyMatrixGraph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    public void expandCapacity() {
        int newCapacity = adjMatrix.length * 2;
        boolean[][] newAdjMatrix = new boolean[newCapacity][newCapacity];
        T[] newVertices = (T[]) new Object[newCapacity];

        // Copy the old matrix to the new one
        for (int i = 0; i < numVertices; i++) {
            System.arraycopy(adjMatrix[i], 0, newAdjMatrix[i], 0, numVertices);
        }

        // Copy the old vertices to the new array
        System.arraycopy(vertices, 0, newVertices, 0, numVertices);

        adjMatrix = newAdjMatrix;
        vertices = newVertices;
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    private int getIndex(T vertex) {
        int index = 0;
        for (int i = 0; i < numVertices; i++) {
            if (vertex.equals(vertices[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    private void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    private boolean indexIsValid(int index) {
        return ((index >= 0) && (index < adjMatrix.length));
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
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    /**
     * Removes a vortex from the graph
     *
     * @param vertex
     */
    @Override
    public void removeVertex(T vertex) {
        int index = getIndex(vertex);

        if (indexIsValid(index)) {
            vertices[index] = null;

            for (int i = 0; i <= numVertices; i++) {
                adjMatrix[index][i] = false;
                adjMatrix[i][index] = false;
            }
            numVertices--;
        }

    }

    /**
     * Removes an edge between two vertices of the graph.
     *
     * @param vertex1
     * @param vertex2
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
    public void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
        }
    }

    /**
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given index.
     *
     * @param startIndex the index to begin the search from
     * @return an iterator that performs a breadth first traversal
     * @throws Throws.EmptyCollectionException
     */
    private Iterator<T> iteratorBFS(int startIndex) throws EmptyCollectionException {
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
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
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    /**
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given index.
     *
     * @param startIndex the index to begin the search from
     * @return an iterator that performs a breadth first traversal
     */
    @Override
    public Iterator<T> iteratorBFS(T startIndex) {
        Iterator iteratorBFS = null;
        try {
            iteratorBFS = iteratorBFS(getIndex(startIndex));
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(UnweightedAdjacencyMatrixGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iteratorBFS;
    }

    /**
     * Returns an iterator that performs a depth first search traversal starting
     * at the given index.
     *
     * @param startIndex the index to begin the search traversal from
     * @return an iterator that performs a depth first traversal
     */
    private Iterator<T> iteratorDFS(int startIndex) throws EmptyCollectionException {
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
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
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

    /**
     * Returns an iterator that performs a depth first search traversal starting
     * at the given index.
     *
     * @param startIndex the index to begin the search traversal from
     * @return an iterator that performs a depth first traversal
     */
    @Override
    public Iterator<T> iteratorDFS(T startIndex) {
        Iterator iteratorDFS = null;
        try {
            iteratorDFS = iteratorDFS(getIndex(startIndex));
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(UnweightedAdjacencyMatrixGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iteratorDFS;
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

            if (!(adjMatrix[0][numVertices - 1] == true)) {
                return false;
            }

        } catch (EmptyCollectionException ex) {
            Logger.getLogger(UnweightedAdjacencyMatrixGraph.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }


    @Override
    public int size() {
        return numVertices;
    }
}
