/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex2;

/**
 * Classe que representa um nó em uma lista duplamente encadeada.
 *
 * @param <T> Tipo do elemento no nó.
 */
public class DoubleNode<T> {

    private T element;
    private DoubleNode<T> next; // um link para outro objeto DoubleNode
    private DoubleNode<T> prev;

    /**
     * Construtor padrão do nó.
     */
    public DoubleNode() {
        this.element = null;
        this.next = null;
    }

    /**
     * Construtor do nó com um elemento.
     *
     * @param data Elemento a ser armazenado no nó.
     */
    public DoubleNode(T data) {
        this.element = data;
        this.next = null;
    }

    /**
     * Obtém o elemento do nó.
     *
     * @return Elemento do nó.
     */
    public T getElement() {
        return element;
    }

    /**
     * Define o elemento do nó.
     *
     * @param element Novo elemento a ser definido no nó.
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Obtém o próximo nó na lista.
     *
     * @return Próximo nó na lista.
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Define o próximo nó na lista.
     *
     * @param next Novo nó a ser definido como próximo na lista.
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Obtém o nó anterior na lista.
     *
     * @return Nó anterior na lista.
     */
    public DoubleNode<T> getPrev() {
        return prev;
    }

    /**
     * Define o nó anterior na lista.
     *
     * @param prev Novo nó a ser definido como anterior na lista.
     */
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    /**
     * Representação em formato de string do nó.
     *
     * @return String que representa o nó.
     */
    @Override
    public String toString() {
        return String.format("Node{data=%s, next=%s, prev=%s}", element, ((next != null) ? next.element : "null"), ((prev != null) ? prev.element : "null"));
    }

}
