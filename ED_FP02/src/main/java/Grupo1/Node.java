/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1;

/**
 *
 * @author Leona
 */
public class Node<T> {

    private T data;
    private Node<T> next; // a link to another Node object
    private Node<T> prev;
    
    public Node(){
          this.data = null;
          this.next = null;
    }
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
    

    @Override
    public String toString() {
        return String.format("Node{data=%s, next=%s, prev=%s}", data, ((next != null) ? next.data : "null"), ((prev != null) ? prev.data : "null"));
}
    
    
}
