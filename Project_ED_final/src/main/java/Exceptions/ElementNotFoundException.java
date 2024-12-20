package Exceptions;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Custom exception class representing an exception thrown when an element is not found.
 */
public class ElementNotFoundException extends Exception {

    /**
     * Constructs a new ElementNotFoundException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public ElementNotFoundException(String message) {
        super(message);
    }
}
