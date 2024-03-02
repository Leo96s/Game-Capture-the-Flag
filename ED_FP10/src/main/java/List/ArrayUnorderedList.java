/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package List;

import java.util.NoSuchElementException;

/**
 *
 * @author Leona
 * @param <T>
 */
public class ArrayUnorderedList<T> extends List<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList(int initialValue) {
        super(initialValue);
    }

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
            throw new NoSuchElementException("List");
        }

        for (int i = size(); i > index; i--) {
            list[i] = list[i - 1];
        }

        list[index + 1] = element;
        rear++;
        modCount++;
    }
}
