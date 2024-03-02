/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Node;

/**
 *
 * @author Leona
 * @param <T>
 */
public class DoubleNode<T> {

    private T element;
    private DoubleNode<T> next; // a link to another DoubleNode object
    private DoubleNode<T> prev;
    
    public DoubleNode(){
          this.element = null;
          this.next = null;
    }
    public DoubleNode(T data) {
        this.element = data;
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return String.format("Node{data=%s, next=%s, prev=%s}", element, ((next != null) ? next.element : "null"), ((prev != null) ? prev.element : "null"));
}
    
    
}
