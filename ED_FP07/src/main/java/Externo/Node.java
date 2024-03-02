/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Externo;

/**
 *
 * @author Leona
 */
public class Node<T> {

    private T data;
    private Node<T> next; // a link to another Node object

    
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

    
    @Override
    public String toString() {
        return String.format("Node{data=%s, next=%s}", data, ((next != null) ? next.data : "null"));
}
    
    
}
