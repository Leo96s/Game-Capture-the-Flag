/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataStructures.List;

import Exceptions.NonComparableElementException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * OrderedListADT is an interface that extends ListADT and defines additional operations specific to ordered lists.
 *
 * @param <T> the type of elements stored in the ordered list
 */
public interface OrderedListADT<T> extends ListADT<T> {

    /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     * @throws Exceptions.NonComparableElementException
     */
    public void add(T element) throws NonComparableElementException;
}
