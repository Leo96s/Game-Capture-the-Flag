package Menus;

import DataStructures.List.OrderedLinkedList;
import DataStructures.Queue.LinkedQueue;
import Enums.AlgorithmType;
import Exceptions.NonComparableElementException;

import java.util.Scanner;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * This class provides methods to input and validate algorithms for bots in a game.
 */
public class InputAlgorithm {

    /**
     * Gets a queue of algorithms based on the number of bots.
     *
     * @param numBots the number of bots.
     * @return a queue of AlgorithmType representing the chosen algorithms for bots.
     */
    public static LinkedQueue<AlgorithmType> getAlgorithms(int numBots) {
        OrderedLinkedList<AlgorithmType> remainingAlgorithms = new OrderedLinkedList<>();

        try {
            // Add available algorithms to the list
            remainingAlgorithms.add(AlgorithmType.MST);
            remainingAlgorithms.add(AlgorithmType.SHORTEST_PATH);
            remainingAlgorithms.add(AlgorithmType.DFS);
            remainingAlgorithms.add(AlgorithmType.DEFENSE);
        } catch (NonComparableElementException e) {
            // In case of non-comparable elements, throw a RuntimeException
            throw new RuntimeException(e);
        }

        LinkedQueue<AlgorithmType> algorithms = new LinkedQueue<>();

        // Keep adding algorithms until the queue size matches the number of bots
        while (algorithms.size() != numBots) {
            AlgorithmType algorithmType = inputAlgorithm();

            // Check if there are remaining algorithms to choose from
            if (!remainingAlgorithms.isEmpty()) {
                // If the chosen algorithm is valid and exists in remainingAlgorithms list, enqueue it
                if (remainingAlgorithms.contains(algorithmType)) {
                    algorithms.enqueue(algorithmType);
                    remainingAlgorithms.remove(algorithmType); // Remove the chosen algorithm from remainingAlgorithms
                } else {
                    System.out.println("Repeated Algorithm"); // Inform the user if the algorithm is already chosen
                }
            } else {
                algorithms.enqueue(algorithmType); // Enqueue the algorithm without checking for repetition
            }
        }

        return algorithms;
    }

    /**
     * Prompts the user to input an algorithm and validates the input.
     *
     * @return the AlgorithmType representing the chosen algorithm.
     */
    private static AlgorithmType inputAlgorithm() {
        String algorithm = null;
        boolean valid = false;

        // Keep prompting the user until a valid algorithm is entered
        while (!valid) {
            System.out.println("Introduce an algorithm: (SHORTEST_PATH/MST/DFS/DEFENSE)");
            Scanner scanner = new Scanner(System.in);

            algorithm = scanner.nextLine().toUpperCase(); // Read user input and convert to uppercase

            // Validate the entered algorithm
            if (!isAlgorithmValid(algorithm)) {
                System.out.println("Illegal algorithm");
            } else {
                valid = true; // Set valid to true to exit the loop
            }
        }

        return AlgorithmType.valueOf(algorithm); // Convert the string input to corresponding AlgorithmType
    }

    /**
     * Checks if the input algorithm is valid.
     *
     * @param algorithm the algorithm to check.
     * @return true if the algorithm is valid, otherwise false.
     */
    private static boolean isAlgorithmValid(String algorithm) {
        boolean valid = false;

        // Check if the input algorithm matches one of the valid AlgorithmType values
        switch (algorithm) {
            case "SHORTEST_PATH":
                valid = true;
                break;
            case "MST":
                valid = true;
                break;
            case "DFS":
                valid = true;
                break;
            case "DEFENSE":
                valid = true;
                break;
            default:
                valid = false;
                break;
        }

        return valid;
    }
}
