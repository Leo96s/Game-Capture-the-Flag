package Map;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Class that allows the export of the game map {@link Map}
 */
public class ExportMap {
    // Defines the files that have the saved files
    private static final String adjMatrixFile = "files//adjMatrix";
    private static final String verticesFile = "files//vertices";
    private static final String typeFile = "files//type";
    private static final String edgeDensityFile = "files//edgeDensity";
    private static final String numberOfLocationsFile = "files//numberOfLocations";

    /**
     * Exports the given map
     *
     * @param map map to be saved
     */
    public static void exportMap(Map map) {
        // exports each component of the map to a different file
        exportVertices(map);
        exportAdjMatrix(map);
        exportType(map);
        exportEdgeDensity(map);
        exportNumberOfLocations(map);

        System.out.println("Files exported Successfully");
    }

    /**
     * Exports the adjacency matrix of the given map
     *
     * @param map map to be saved
     */
    private static void exportVertices(Map map) {
        try {
            // create a FileWriter object with the file name
            FileWriter output = new FileWriter(verticesFile);

            String string = "";

            // writes the vertices separated by a space
            for (int i = 0; i < map.getMap().size(); i++) {
                string += map.getMap().getVertex(i).getCharacter();
                if (i + 1 < map.getMap().size()) {
                    string += " ";
                }

            }

            output.write(string);

            output.close();
        } catch (IOException io) {

        }
    }

    /**
     * Exports the adjacency matrix of the given map
     *
     * @param map map to be saved
     */
    private static void exportAdjMatrix(Map map) {
        try {
            // create a FileWriter object with the file name
            FileWriter output = new FileWriter(adjMatrixFile);

            for (int i = 0; i < map.getMap().size(); i++) {
                for (int j = 0; j < map.getMap().size(); j++) {
                    // write each element of the matrix with a space
                    output.write(map.getMap().getAdjMatrix()[i][j] + "");
                    if (j + 1 < map.getMap().size()) {
                        output.write(" ");
                    }
                }
                // write a new line after each row
                output.write("\n");
            }

            output.close();
        } catch (IOException io) {
            // print an error message
            System.err.println("An error occurred while writing to the file.");
        }
    }

    /**
     * Exports the type of the given map
     *
     * @param map map to be saved
     */
    private static void exportType(Map map) {
        try {
            // create a FileWriter object with the file name
            FileWriter output = new FileWriter(typeFile);

            // writes the type in the file
            output.write(map.isUnidirectional() + "");

            output.close();
        } catch (IOException io) {
            // print an error message
            System.err.println("An error occurred while writing to the file.");
        }
    }

    /**
     * Exports the edge density of the given map
     *
     * @param map map to be saved
     */
    private static void exportEdgeDensity(Map map) {
        try {
            // create a FileWriter object with the file name
            FileWriter output = new FileWriter(edgeDensityFile);

            // writes the edge density in the file
            output.write(map.getEdgeDensity() + "");

            output.close();
        } catch (IOException io) {
            // print an error message
            System.err.println("An error occurred while writing to the file.");
        }
    }

    /**
     * Exports the number of locations from the given map
     *
     * @param map map to be saved
     */
    private static void exportNumberOfLocations(Map map) {
        try {
            // create a FileWriter object with the file name
            FileWriter output = new FileWriter(numberOfLocationsFile);

            // writes the number of locations in the file
            output.write(map.getNumberOfLocations() + "");

            output.close();
        } catch (IOException io) {
            // print an error message
            System.err.println("An error occurred while writing to the file.");
        }
    }
}