/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex4;

import Interfaces.QueueADT;
import Throws.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Leona
 * @param <Q>
 */
public class MessagerEncoder<Q extends QueueADT> {

    private final Q queue;
    private final String key;
    private int keyIndex;
    
    /**
     * Metodo construtor da MessagerEncoder
     * @param key
     * @param queue 
     */
    public MessagerEncoder(String key,Q queue) {
        this.queue = queue;
        this.key = key;
        this.keyIndex = 0;
    }
    
    /**
     * Obtém o valor do deslocamento com base na chave.
     * @return O valor do deslocamento
     */
    public int shiftBy() {
        String[] keys = key.split(" ");
        if (keyIndex == keys.length) {
            keyIndex = 0;
        }
        int shift = Integer.parseInt(keys[keyIndex]);
        keyIndex++;
        return shift;
    }

    /**
     * Codifica a mensagem e adiciona os caracteres à fila.
     * 
     * @param message A mensagem a ser codificada.
     */
    public void encodeMessage(String message) {
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = shiftBy();
                char base = Character.isLowerCase(c) ? 'a' : 'A'; // Determine the base ('a' or 'A') based on case
                c = (char) (base + (c - base + shift) % 26);
            }
            queue.enqueue(c);
        }
        keyIndex = 0;
    }

    /**
     * Descodifica a mensagem e adiciona os caracteres à fila.
     * 
     * @param message A mensagem a ser descodificada.
     */
    public void decodeMessage(String message) {
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = shiftBy();
                char base = Character.isLowerCase(c) ? 'a' : 'A'; // Determine the base ('a' or 'A') based on case
                c = (char) (base + (c - base - shift + 26) % 26); // Apply the reverse shift
            }
            queue.enqueue(c);
        }
        keyIndex = 0;
    }

    /**
     * Converte a fila para uma representação de string.
     * 
     * @return Uma representação de string da fila.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < queue.size()) {
            try {
                sb.append(queue.dequeue());

            } catch (EmptyCollectionException ex) {
                Logger.getLogger(MessagerEncoder.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        return sb.toString();
    }
}
