/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Externos;

import Throws.EmptyCollectionException;
import Grupo1.Ex1.LinearNode;

/**
 *
 * @author Leona
 * @param <T>
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count;
    private LinearNode<T> top;

    /**
     * Metodo construtor da LinkedStack
     */
    public LinkedStack() {
        this.top = null;
        count = 0;
    }

    /**
     * Metodo para adicionar ao top da stack um novo elemento
     *
     * @param element
     */
    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        newNode.setNext(top);

        top = newNode;

        count++;
    }

    /**
     * Metodo para retirar o elemento do topo da stack
     *
     * @return Retorna o elemento retirado
     * @throws EmptyCollectionException
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A lista está vazia.");
        }
        T returnvalue = top.getElement();

        top = top.getNext();
        count--;

        return returnvalue;
    }

    /**
     * Metodo para apresentar o valor que esta no topo da stack
     *
     * @return Retorna o elemento
     * @throws EmptyCollectionException
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Vazio");
        }
        return top.getElement();
    }

    /**
     * Metodo para verificar se a stack esta vazia
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Metodo para retornar o tamanho da stack
     *
     * @return
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Metodo toString para imprimir os elementos da stack
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinearNode<T> current = top;

        sb.append("LinkedStack: ");

        while (current != null) {
            sb.append(current.getElement());
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }

        return sb.toString();
    }
}
