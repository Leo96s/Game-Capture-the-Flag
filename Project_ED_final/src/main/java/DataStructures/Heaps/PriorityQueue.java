package DataStructures.Heaps;

import Exceptions.EmptyCollectionException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * PriorityQueue demonstrates a priority queue using a Heap.
 */
public class PriorityQueue<T> extends
        ArrayHeap<PriorityQueueNode<T>> {

    /**
     * Creates an empty priority queue.
     */
    public PriorityQueue() {
        super();
    }

    /**
     * Adds the given element to this PriorityQueue.
     *
     * @param object the element to be added to the priority queue
     * @param priority the integer priority of the element to be added
     */
    public void addElement(T object, int priority) {
        PriorityQueueNode<T> node
                = new PriorityQueueNode<T>(object, priority);
        super.addElement(node);
    }

    /**
     * Removes the next highest priority element from this priority queue and
     * returns a reference to it.
     *
     * @return a reference to the next highest priority element in this queue
     * @throws Exceptions.EmptyCollectionException
     */
    public T removeNext() throws EmptyCollectionException {
        PriorityQueueNode<T> temp
                = (PriorityQueueNode<T>) super.removeMin();
        return temp.getElement();
    }
}
