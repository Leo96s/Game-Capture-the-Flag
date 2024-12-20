package Exceptions;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 *
 * Custom exception class representing an exception thrown when an element is not comparable.
 */
public class NonComparableElementException extends Exception {

    /**
     * Constructs a new NonComparableElementException with the specified detail message.
     * @param elementIsNotComparable The detail message indicating that the element is not comparable (which is saved for later retrieval by the getMessage() method).
     */
    public NonComparableElementException(String elementIsNotComparable) {
        // Call the superclass constructor with the specified detail message
        super(elementIsNotComparable);

        // Throw an UnsupportedOperationException as this constructor's body is generated automatically and should not be used
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
