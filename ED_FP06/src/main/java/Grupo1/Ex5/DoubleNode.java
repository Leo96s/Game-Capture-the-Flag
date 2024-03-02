/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex5;

/**
 * Implementação de um nó duplamente encadeado utilizado em listas duplamente encadeadas.
 * @param <T> Tipo dos elementos armazenados no nó.
 * @version 1.0
 * @author Leona
 */
public class DoubleNode<T> {

    private T element;            // Dado armazenado no nó
    private DoubleNode<T> next;    // Referência para o próximo nó
    private DoubleNode<T> prev;    // Referência para o nó anterior

    /**
     * Construtor padrão que cria um nó com dados nulos e referências nulas.
     */
    public DoubleNode() {
        this.element = null;
        this.next = null;
        this.prev = null;
    }

    /**
     * Construtor que cria um nó com o dado especificado e referências nulas.
     * @param data Dado a ser armazenado no nó.
     */
    public DoubleNode(T data) {
        this.element = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * Obtém o elemento armazenado no nó.
     * @return Elemento armazenado no nó.
     */
    public T getElement() {
        return element;
    }

    /**
     * Define o elemento a ser armazenado no nó.
     * @param element Novo elemento a ser armazenado no nó.
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Obtém a referência para o próximo nó.
     * @return Referência para o próximo nó.
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Define a referência para o próximo nó.
     * @param next Novo nó a ser referenciado como próximo.
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Obtém a referência para o nó anterior.
     * @return Referência para o nó anterior.
     */
    public DoubleNode<T> getPrev() {
        return prev;
    }

    /**
     * Define a referência para o nó anterior.
     * @param prev Novo nó a ser referenciado como anterior.
     */
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    /**
     * Retorna uma representação em formato de string do nó, exibindo seus dados, próximo e anterior.
     * @return String representando o nó.
     */
    @Override
    public String toString() {
        return String.format("Node{data=%s, next=%s, prev=%s}", element, ((next != null) ? next.element : "null"), ((prev != null) ? prev.element : "null"));
    }
}
  
    

