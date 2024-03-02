/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex2;

import Externo.DoubleNode;
import Throws.ElementNotFoundException;
import Throws.EmptyCollectionException;

/**
 * Classe que representa uma lista duplamente encadeada.
 *
 * @param <T> Tipo dos elementos armazenados na lista.
 */
public class DoublyLinkedList<T> {

    private DoubleNode<T> front; // Referência ao primeiro nó da lista
    private DoubleNode<T> rear;  // Referência ao último nó da lista

    /**
     * Construtor da classe, inicializa as referências front e rear como nulas.
     */
    public DoublyLinkedList() {
        front = rear = null;
    }

    /**
     * Adiciona um elemento à lista, criando um novo nó e ajustando as
     * referências.
     *
     * @param data Elemento a ser adicionado.
     */
    public void add(T data) {
        DoubleNode<T> newNode = new DoubleNode<>(data);

        // Configura 'next' e 'prev' usando o operador condicional ternário
        newNode.setNext((front != null) ? front : rear);
        newNode.setPrev((front != null) ? null : rear);

        if (front != null) {
            front.setPrev(newNode);
        }

        front = newNode;

        if (rear == null) {
            rear = newNode;
        }
    }

    /**
     * Remove um elemento específico da lista, ajustando as referências do
     * próximo e do anterior.
     *
     * @param element Elemento a ser removido.
     * @return Elemento removido.
     * @throws EmptyCollectionException Se a lista estiver vazia.
     * @throws ElementNotFoundException Se o elemento não for encontrado.
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (front == null) {
            throw new EmptyCollectionException("A lista está vazia.");
        }
        DoubleNode<T> current = front;

        while (current != null) {
            if (element.equals(current.getElement())) {
                DoubleNode<T> nextNode = current.getNext();
                DoubleNode<T> previous = current.getPrev();

                if (current == front) {
                    front = nextNode;
                    if (front != null) {
                        front.setPrev(null);
                    }
                } else {
                    previous.setNext(nextNode);
                    if (current == rear) {
                        rear = previous;
                    } else {
                        nextNode.setPrev(previous);
                    }
                }

                return current.getElement();
            }
            current = current.getNext();
        }
        throw new ElementNotFoundException("Element not found");
    }

    /**
     * Converte a lista duplamente encadeada para uma representação de string.
     *
     * @return Representação em string da lista.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode<T> current = front;

        sb.append("DoublyLinkedList{");
        while (current != null) {
            sb.append(current.toString());
            if (current.getNext() != null) {
                sb.append(" <-> ");
            }
            current = current.getNext();
        }

        sb.append("}");
        return sb.toString();
    }

    /**
     * Método recursivo para imprimir todos os elementos da lista a partir do
     * primeiro nó.
     */
    public void printFromHead() {
        printFromHeadRecursive(front);
    }

    /**
     * Método auxiliar recursivo para imprimir todos os elementos da lista a
     * partir do primeiro nó.
     *
     * @param node Nó atual sendo processado.
     */
    private void printFromHeadRecursive(DoubleNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getElement() + " ");
        printFromHeadRecursive(node.getNext());
    }

    /**
     * Método recursivo para imprimir todos os elementos da lista a partir do
     * último nó.
     */
    public void printFromTail() {
        printFromTailRecursive(rear);
    }

    /**
     * Método auxiliar recursivo para imprimir todos os elementos da lista a
     * partir do último nó.
     *
     * @param node Nó atual sendo processado.
     */
    private void printFromTailRecursive(DoubleNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getElement() + " ");
        printFromTailRecursive(node.getPrev());
    }

    /**
     * Método recursivo para substituir todas as ocorrências de existingElement
     * por newElement.
     *
     * @param existingElement Elemento a ser substituído.
     * @param newElement Elemento que substituirá o existingElement.
     */
    public void replace(T existingElement, T newElement) {
        replaceRecursive(front, existingElement, newElement);
    }

    /**
     * Método auxiliar recursivo para substituir todas as ocorrências de
     * existingElement por newElement.
     *
     * @param node Nó atual sendo processado.
     * @param existingElement Elemento a ser substituído.
     * @param newElement Elemento que substituirá o existingElement.
     */
    private void replaceRecursive(DoubleNode<T> node, T existingElement, T newElement) {
        if (node == null) {
            return;
        }

        if (node.getElement().equals(existingElement)) {
            node.setElement(newElement);
        }

        replaceRecursive(node.getNext(), existingElement, newElement);
    }
}
