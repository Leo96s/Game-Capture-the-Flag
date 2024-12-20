package DataStructures.Stack;

import Exceptions.EmptyCollectionException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Represents a stack implemented using an array.
 *
 * @param <T> the type of elements stored in the stack
 */
public class ArrayStack<T> implements StackADT<T> {

    /**
     * constant to represente the value that the stack is expanded by
     */
    private final int EXPAND_VALUE = 2;
    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 2;
    /**
     * int that represents both the number of elements and the next available
     * position in the array
     */
    private int top;
    /**
     * array of generic elements to represent the stack
     */
    private T[] stack;

    /**
     * Creates an empty stack using the specified capacity.
     *
     * @param initialCapacity represents the specified capacity
     */
    public ArrayStack(int initialCapacity) {
        top = 0;
        
        if (initialCapacity > 0) {
            stack = (T[]) (new Object[initialCapacity]);
        } else {
            stack = (T[]) (new Object[DEFAULT_CAPACITY]);
        }
    }

    @Override
    public int size() {
        return top;
    }

    private void expandCapacity() {
        T[] newArray = (T[]) (new Object[top * EXPAND_VALUE]);

        System.arraycopy(stack, 0, newArray, 0, top);

        stack = newArray;
    }

    /**
     * Retrieves the index of the top element in the stack.
     *
     * @return the index of the top element in the stack
     */
    public int getTop() {
        return top;
    }

    /**
     * Sets the index of the top element in the stack.
     *
     * @param top the index of the top element to set
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * Retrieves the array representing the stack.
     *
     * @return the array representing the stack
     */
    public T[] getStack() {
        return stack;
    }

    /**
     * Sets the array representing the stack.
     *
     * @param stack the array representing the stack to set
     */
    public void setStack(T[] stack) {
        this.stack = stack;
    }

    /**
     * Retrieves the element at the specified index in the stack.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index in the stack
     */
    public T getElement(int index){
        return stack[index];
    }
    
    /**
     * Adds the specified element to the top of this stack, expanding the
     * capacity of the stack array if necessary.
     *
     * @param element generic element to be pushed onto stack
     */
    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }

        stack[top] = element;
        top++;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to
     * it. Throws an EmptyCollectionException if the stack is empty.
     *
     * @return T element removed from top of stack
     * @throws EmptyCollectionException if a pop is attempted on empty stack
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }

        top--;
        T result = stack[top];
        stack[top] = null;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack. The element
     * is not removed from the stack. Throws an EmptyCollectionException if the
     * stack is empty.
     *
     * @return T element on top of stack
     * @throws EmptyCollectionException if a peek is attempted on empty stack
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }

        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i;
        sb.append("Stack{");
        
        for (i = top - 1; i >= 0; i--) {
            sb.append(stack[i].toString());
            if (i != 0) {
                sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }
}
