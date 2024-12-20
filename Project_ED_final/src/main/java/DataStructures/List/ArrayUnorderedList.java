/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.List;

import java.util.NoSuchElementException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * ArrayUnorderedList represents an unordered list implemented using an array.
 *
 * @param <T> the type of elements stored in the list
 */
public class ArrayUnorderedList<T> extends List<T> implements UnorderedListADT<T> {

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialValue the initial capacity of the list
     */
    public ArrayUnorderedList(int initialValue) {
        super(initialValue);
    }

    /**
     * Constructs an empty list with the default initial capacity.
     */
    public ArrayUnorderedList() {
        super();
    }

    @Override
    public void addToFront(T element) {
        if (size() == list.length) {
            super.expandCapacity();
        }

        // Desloca os elementos para abrir espaço para o novo elemento
        for (int i = rear; i > 0; i--) {
            list[i] = list[i - 1];
        }

        // Insere o novo elemento na frente
        list[0] = element;
        rear++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        if (size() == list.length) {
            super.expandCapacity();
        }

        // Adiciona o novo elemento no final
        list[rear] = element;
        rear++;
        modCount++;
    }

    @Override
   public void addAfter(T target, T element) {
        if (size() == list.length) {
            expandCapacity();
        }

        int index = find(target);

        if (index == NOT_FOUND) {
            throw new NoSuchElementException("DataStructures/List");
        }

        for (int i = size(); i > index; i--) {
            list[i] = list[i - 1];
        }

        list[index + 1] = element;
        rear++;
        modCount++;
    }
}
