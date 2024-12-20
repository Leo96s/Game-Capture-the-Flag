/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.BinarySearchTree;

import Exceptions.ElementNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * ArrayBinarySearchTree implements a binary search tree using an array.
 * @param <T>
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T>
        implements BinarySearchTreeADT<T> {

    protected int height;
    protected int maxIndex;

    /**
     * Creates an empty binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Creates a binary search with the specified element as its root
     *
     * @param element the element that will become the root of the new tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 1;
        maxIndex = 0;
    }

    /**
     * Adds the specified object to this binary search tree in the appropriate
     * position according to its key value. Note that equal elements are added
     * to the right. Also note that the index of the left child of the current
     * index can be found by doubling the current index and adding 1. Finding
     * the index of the right child can be calculated by doubling the current
     * index and adding 2.
     *
     * @param element the element to be added to the search tree
     */
    public void addElement(T element) {
        if (tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }
        Comparable<T> tempelement = (Comparable<T>) element;
        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;
            while (!added) {
                if (tempelement.compareTo((tree[currentIndex])) < 0) {
                    /**
                     * go left
                     */
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    /**
                     * go right
                     */
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }
        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        if (isEmpty()) {
            throw new ElementNotFoundException("binary search tree");
        }

        T result = null;
        Comparable<T> targetComparable = (Comparable<T>) targetElement;
        int current = 0; // Start from the root
        int parent = -1; // Initialize parent index

        // Search for the target element
        while (tree[current] != null && !targetElement.equals(tree[current])) {
            parent = current;
            if (targetComparable.compareTo(tree[current]) < 0) {
                // Go left
                current = current * 2 + 1;
            } else {
                // Go right
                current = current * 2 + 2;
            }
        }

        if (tree[current] == null) {
            // Element not found
            throw new ElementNotFoundException("binary search tree");
        }

        result = tree[current]; // Store the element to be removed

        if (tree[current * 2 + 1] == null && tree[(current + 1) * 2] == null) {
            // Case 1: Node has no children
            tree[current] = null;
        } else if (tree[current * 2 + 1] != null && tree[(current + 1) * 2] == null) {
            // Case 2: Node has only left child
            tree[current] = tree[current * 2 + 1];
            tree[current * 2 + 1] = null;
        } else if (tree[current * 2 + 1] == null && tree[(current + 1) * 2] != null) {
            // Case 3: Node has only right child
            tree[current] = tree[(current + 1) * 2];
            tree[(current + 1) * 2] = null;
        } else {
            // Case 4: Node has both left and right children
            tree[current] = findAndRemoveMin(current * 2 + 2, current);
        }

        count--;

        return result;
    }

// Helper method to find and remove the minimum element in a subtree
    private T findAndRemoveMin(int current, int parent) {
        while (tree[current * 2 + 1] != null) {
            parent = current;
            current = current * 2 + 1;
        }

        T result = tree[current];

        if (tree[(current + 1) * 2] != null) {
            // Node has right child
            tree[current] = tree[(current + 1) * 2];
            tree[(current + 1) * 2] = null;
        } else {
            // Node has no children
            tree[parent * 2 + 1] = null;
        }

        return result;
    }

    // Updated replacement method
    protected T replacement(int node) {
        T result = null;

        if (tree[node * 2 + 1] == null && tree[(node + 1) * 2] == null) {
            result = null;
        } else if (tree[node * 2 + 1] != null && tree[(node + 1) * 2] == null) {
            result = tree[node * 2 + 1];
        } else if (tree[node * 2 + 1] == null && tree[(node + 1) * 2] != null) {
            result = tree[(node + 1) * 2];
        } else {
            int current = (node + 1) * 2;
            int parent = node;
            while (tree[current * 2 + 1] != null) {
                parent = current;
                current = current * 2 + 1;
            }

            if (tree[(node + 1) * 2] == tree[current]) {
                tree[current * 2 + 1] = tree[node * 2 + 1];
            } else {
                tree[parent * 2 + 1] = tree[(node + 1) * 2];
                tree[current * 2 + 1] = tree[node * 2 + 1];
            }

            result = tree[current];
        }

        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        try {
            while (contains(targetElement)) {
                removeElement(targetElement);
            }
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(ArrayBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public T removeMin() throws ElementNotFoundException {
        if (isEmpty()) {
            throw new ElementNotFoundException("binary search tree");
        }

        T min = findMin();
        removeElement(min);
        return min;
    }

    @Override
    public T removeMax() throws ElementNotFoundException {
        if (isEmpty()) {
            throw new ElementNotFoundException("binary search tree");
        }

        T max = findMax();
        removeElement(max);
        return max;
    }

    @Override
    public T findMin() {
        if (isEmpty()) {
            return null;
        }

        int current = 0;
        while (tree[current * 2 + 1] != null) {
            current = current * 2 + 1;
        }

        return tree[current];
    }

    @Override
    public T findMax() {
        if (isEmpty()) {
            return null;
        }

        int current = 0;
        while (tree[(current + 1) * 2] != null) {
            current = (current + 1) * 2;
        }

        return tree[current];
    }
}
