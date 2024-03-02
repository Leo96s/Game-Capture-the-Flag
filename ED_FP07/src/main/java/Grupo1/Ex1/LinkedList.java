/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex1;

import Externo.Node;
import Throws.ElementNotFoundException;
import Throws.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementação de uma lista encadeada simples.
 *
 * @param <T> Tipo dos elementos armazenados na lista.
 * @version 1.0
 * @author Leona
 */
public class LinkedList<T> {

    private Node<T> front; // Referência para o primeiro nó da lista
    private Node<T> rear;  // Referência para o último nó da lista

    /**
     * Construtor padrão que cria uma lista encadeada vazia.
     */
    public LinkedList() {
    }

    /**
     * Adiciona um novo elemento no início da lista.
     *
     * @param data Elemento a ser adicionado na lista.
     */
    public void add(T data) {
        Node<T> newNode = new Node<T>(data); // Cria um novo nó com o dado especificado
        Node<T> oldFront = front;             // Armazena a referência para o antigo primeiro nó

        if (front == null) {
            newNode.setNext(rear);
        } else {
            newNode.setNext(oldFront);
        }

        front = newNode; // Atualiza a referência para o primeiro nó
    }

    /**
     * Remove a primeira ocorrência do elemento especificado da lista.
     *
     * @param element Elemento a ser removido da lista.
     * @return Elemento removido.
     * @throws EmptyCollectionException Se a lista estiver vazia.
     * @throws ElementNotFoundException Se o elemento não for encontrado na
     * lista.
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (front == null) {
            throw new EmptyCollectionException("A lista está vazia.");
        }

        boolean found = false;
        Node<T> previous = null;
        Node<T> current = front;

        while (current != null && !found) {
            if (element.equals(current.getData())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            throw new ElementNotFoundException("Element not found");
        }

        if (previous == null) {
            // O elemento a ser removido está na frente da lista
            front = current.getNext();
        } else {
            // O elemento a ser removido está em algum lugar no meio ou no final da lista
            previous.setNext(current.getNext());
        }

        return current.getData(); // Retorna o elemento removido
    }

    /**
     * Converte a lista encadeada para uma representação de string.
     *
     * @return Representação em string da lista.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList{");
        if (front == null) {
            System.out.println("List is empty!");
        } else {
            sb.append(front);
        }
        return sb.toString();
    }

    /**
     * Imprime os elementos da lista de maneira recursiva.
     */
    public void printList() {
        printListRecursive(front);
    }

    /**
     * Método auxiliar recursivo para imprimir os elementos da lista.
     *
     * @param node Nó atual sendo processado.
     */
    private void printListRecursive(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        printListRecursive(node.getNext());
    }

    /**
     * Inverte a ordem dos elementos na lista.
     */
    public void reverse() {
        front = reverseRecursive(front);
    }

    /**
     * Método auxiliar recursivo para inverter a ordem dos elementos na lista.
     *
     * @param current Nó atual sendo processado.
     * @return Novo nó de cabeça da lista invertida.
     */
    private Node<T> reverseRecursive(Node<T> current) {
        // Caso base: se a lista estiver vazia ou se atingirmos o último nó
        if (current == null || current.getNext() == null) {
            return current;
        }

        // Inverte a parte restante da lista
        Node<T> reversedList = reverseRecursive(current.getNext());

        // Atualiza os ponteiros para inverter a lista
        current.getNext().setNext(current);
        current.setNext(null);

        return reversedList;
    }
}
