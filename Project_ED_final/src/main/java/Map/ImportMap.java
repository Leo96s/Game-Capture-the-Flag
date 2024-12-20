package Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Class that allows the import of the game map {@link Map}
 */
public class ImportMap {
    // Defines the files that have the saved files
    private static final String adjMatrixFile = "files//adjMatrix";
    private static final String verticesFile = "files//vertices";
    private static final String typeFile = "files//type";
    private static final String edgeDensityFile = "files//edgeDensity";
    private static final String numberOfLocationsFile = "files//numberOfLocations";

    /**
     * Imports a map {@link Map} saved in the files
     *
     * @return map imported
     */
    public static Map importMap() {
        // imports the map attributes
        double[][] adjMatrix = importAdjMatrix();
        Location[] vertices = importVertices();
        boolean type = importType();
        double edgeDensity = importEdgeDensity();
        int numberOfLocations = importNumberOfLocations();

        // creates a new map
        Map map = new Map(adjMatrix, vertices, type, edgeDensity, numberOfLocations);

        System.out.println("Files imported Successfully");
        return map;
    }

    /**
     * Returns the vertices of the saved map
     *
     * @return vertices of the saved map
     */
    private static Location[] importVertices() {
        Location[] vertices = null;
        try {
            // create a FileReader object with the file name
            FileReader input = new FileReader(verticesFile);

            // create a BufferedReader object to read the file line by line
            BufferedReader reader = new BufferedReader(input);

            // read the first and only line of the file
            String line = reader.readLine();

            // close the reader and the input
            reader.close();
            input.close();

            // split the line by space to get the vertices
            String[] temp = line.split(" ");

            // create a Character array with the same length as the String array
            vertices = new Location[temp.length];

            // loop through the String array and convert each element to a Character
            for (int i = 0; i < temp.length; i++) {
                Location l = new Location(temp[i].charAt(0));
                vertices[i] = l;
            }
        } catch (IOException io) {
            // print an error message
            System.err.println("An error occurred while reading the file.");
        }
        return vertices;
    }

    /**
     * Returns the adjacency matrix of the saved map
     *
     * @return adjacency matrix of the saved map
     */
    private static double[][] importAdjMatrix() {
        double[][] adjMatrix = null;
        try {
            // create a FileReader object with the file name
            FileReader input = new FileReader(adjMatrixFile);

            // create a BufferedReader object to read the file line by line
            BufferedReader reader = new BufferedReader(input);

            // initialize a variable to store the current line number
            int i = 0;

            // read the file until the end
            String line;
            while ((line = reader.readLine()) != null) {
                // split the line by space to get the matrix elements
                String[] elements = line.split(" ");

                // create a double array with the same length as the String array
                double[] row = new double[elements.length];

                // loop through the elements and convert them to double
                for (int j = 0; j < elements.length; j++) {
                    // convert the element to a double
                    double element = Double.parseDouble(elements[j]);

                    // store the element in the row array
                    row[j] = element;
                }

                // if the adjacency matrix is null, initialize it with the row length
                if (adjMatrix == null) {
                    adjMatrix = new double[row.length][row.length];
                }

                // store the row array in the adjacency matrix
                adjMatrix[i] = row;

                // increment the line number
                i++;
            }

            // close the reader and the input
            reader.close();
            input.close();
        } catch (IOException io) {
            // print an error message
            System.err.println("An error occurred while reading the file.");
        }
        return adjMatrix;
    }

    /**
     * Returns the boolean that define whether the map saved is unidirectional
     *
     * @return boolean that define whether the map saved is unidirectional
     */
    public static boolean importType() {
        boolean unidirectional = false;
        try {
            // create a FileWriter object with the file name
            FileReader input = new FileReader(typeFile);

            // create a BufferedReader object to read the file line by line
            BufferedReader reader = new BufferedReader(input);

            // parse the boolean from the string
            unidirectional = Boolean.parseBoolean(reader.readLine());

            reader.close();
            input.close();
        } catch (IOException io) {
            // print an error message
            System.err.println("An error occurred while writing to the file.");
        }

        return unidirectional;
    }

    /**
     * Returns the edge density from the map saved
     *
     * @return edge density
     */
    public static double importEdgeDensity() {
        double edgeDensity = 0;
        try {
            // create a FileWriter object with the file name
            FileReader input = new FileReader(edgeDensityFile);

            // create a BufferedReader object to read the file line by line
            BufferedReader reader = new BufferedReader(input);

            // parse the double from the string
            edgeDensity = Double.parseDouble(reader.readLine());

            reader.close();
            input.close();
        } catch (IOException io) {
            // print an error message
            System.err.println("An error occurred while writing to the file.");
        }

        return edgeDensity;
    }

    /**
     * Returns the number of locations from the map saved
     *
     * @return number of locations
     */
    public static int importNumberOfLocations() {
        int importNumberOfLocations = 0;
        try {
            // create a FileWriter object with the file name
            FileReader input = new FileReader(numberOfLocationsFile);

            // create a BufferedReader object to read the file line by line
            BufferedReader reader = new BufferedReader(input);

            // parse the integer from the string
            importNumberOfLocations = Integer.parseInt(reader.readLine());

            reader.close();
            input.close();
        } catch (IOException io) {
            // print an error message
            System.err.println("An error occurred while writing to the file.");
        }

        return importNumberOfLocations;
    }
}