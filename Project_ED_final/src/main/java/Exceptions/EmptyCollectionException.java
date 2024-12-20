package Exceptions;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 *
 * Custom exception class representing an exception thrown when attempting to perform an operation on an empty collection.
 */
public class EmptyCollectionException extends Exception {

    /**
     * Constructs a new EmptyCollectionException with the specified detail message.
     * @param emptyList The detail message indicating that the collection is empty (which is saved for later retrieval by the getMessage() method).
     */
    public EmptyCollectionException(String emptyList) {
        // Call the superclass constructor with the specified detail message
        super(emptyList);
    }
}
