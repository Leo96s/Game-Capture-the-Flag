/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataStructures.List;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * UnorderedListADT is an interface that extends ListADT and defines additional operations specific to unordered lists.
 *
 * @param <T> the type of elements stored in the unordered list
 */
public interface UnorderedListADT<T> extends ListADT<T>{
        /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     */
    public void addToFront(T element);
    
    public void addToRear(T element);
    
    public void addAfter(T target, T element);
}
