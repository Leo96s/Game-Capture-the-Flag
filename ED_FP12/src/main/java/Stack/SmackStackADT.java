/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Stack;

import Throws.EmptyCollectionException;

/**
 *
 * @author Leona
 * @param <T>
 */
public interface SmackStackADT<T>  extends StackADT<T>{
    
    /**
     * Removes and returns the last element from this stack.
     *
     * @return T element removed from the last of the stack
     * @throws Throws.EmptyCollectionException
     */
    public T  Smack() throws EmptyCollectionException;
}
