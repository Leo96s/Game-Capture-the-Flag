/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;

import Throws.EmptyCollectionException;

/**
 * Uma implementação da interface SmackStackADT usando um array.
 * @param <T> O tipo dos elementos armazenados na pilha.
 * @version 1.0
 * @author Leona
 */
public class SmackStack<T> extends ArrayStack<T> implements SmackStackADT<T> {

    /**
     * Construtor padrão que cria uma SmackStack com capacidade inicial padrão.
     */
    public SmackStack() {
    }

    /**
     * Construtor que cria uma SmackStack com a capacidade inicial especificada.
     * @param initialCapacity A capacidade inicial da pilha.
     */
    public SmackStack(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public T Smack() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        
        T smackedElement = getStack()[0];
        T[] newArray = (T[]) (new Object[this.size()]);
        
        for( int i= 1; i <  this.size(); i++){
            newArray[i - 1] = this.getStack()[i];
        }
        
        this.setTop(this.size() -1);
        this.setStack(newArray);
        return smackedElement;
    }
 }
    
    
    

