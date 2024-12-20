package Map;

import DataStructures.Graph.*;
import Interfaces.MapGeneratorADT;

import java.util.Random;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Map class created for Generation of the capture the flag game
 */
public abstract class MapGenerator implements MapGeneratorADT {
    // defines the density of edges
    private final double edgeDensity;
    // defines the number of locations in the map
    private final int numberOfLocations;
    // instance of a map
    protected ModifiedGraphADT<Location> map;
    // defines if the map is unidirectional or bidirectional
    private final boolean unidirectional;

    /**
     * Constructor method that creates a map
     *
     * @param edgeDensity       density of edges
     * @param numberOfLocations number of locations in the map
     * @param unidirectional    type of paths
     * @throws IllegalArgumentException if edgeDensity is not between 0 and 1, or numberOfLocations is not positive
     */
    public MapGenerator(double edgeDensity, int numberOfLocations, boolean unidirectional) {
        // check the validity of the parameters
        if (edgeDensity < 0 || edgeDensity > 1) {
            throw new IllegalArgumentException("Edge density must be between 0 and 1");
        }
        if (numberOfLocations <= 0) {
            throw new IllegalArgumentException("Number of locations must be positive");
        }

        // assign the parameters to the fields
        this.edgeDensity = edgeDensity;
        this.numberOfLocations = numberOfLocations;
        this.unidirectional = unidirectional;

        // creates an instance of the specified type
        if (unidirectional) {
            map = new UnidirectionalModifiedGraph<>();
        } else {
            map = new ModifiedGraph<>();
        }
    }

    /**
     * Generates the locations of the map
     * Each {@link Location} is represented by a character
     */
    public void generateLocations() {
        // loop through the number of locations
        for (int i = 0; i < numberOfLocations; i++) {
            // convert the index to a character
            char c = (char) ('A' + i);
            // add the character as a vertex to the map
            Location l = new Location(c);
            map.addVertex(l);
        }
    }

    /**
     * Generates the edges of the map.
     * Each edge has a random weight between 1 and 15.
     * The number of edges is determined by the edge density.
     */
    public void generateEdges() {
        // calculate the minimum number of edges based on the edge density
        double minNumEdges = (map.size() * (map.size() - 1)) * edgeDensity;
        // create a random object
        Random random = new Random();
        // create a flag to indicate when the generation is finished
        boolean finished = false;

        // create a variable to store the current number of edges
        int num = 0;
        // loop until finished
        while (!finished) {
            // loop until the minimum number of edges is reached
            while (num != minNumEdges) {
                // generate two random indices for the vertices
                int index1 = random.nextInt(map.size());
                int index2 = random.nextInt(map.size());
                // generate a random weight for the edge
                int weight = random.nextInt(15) + 1;

                // add the edge to the map
                map.addEdge(map.getVertex(index1), map.getVertex(index2), weight);

                // increment the number of edges
                num++;
            }

            //checks if all edges were added
            num = map.getNumberOfEdges();
            // if the number of edges is equal or greater than the minimum, set the flag to true
            if (num >= minNumEdges) {
                if (map.isConnected()) {
                    finished = true;
                } else {
                    // generates a new map if the edge configuration is not good
                    if (unidirectional) {
                        map = new UnidirectionalModifiedGraph<>();
                    } else {
                        map = new ModifiedGraph<>();
                    }
                    num = 0;
                    this.generateLocations();
                }
            }
        }
    }

    /**
     * Checks if the edge density is valid
     *
     * @param density edge density
     * @return true if density is valid, false otherwise
     */
    public boolean isDensityValid(double density) {
        // get the current number of edges
        int numEdges = map.getNumberOfEdges();

        // calculate the minimum number of edges based on the density
        double minNumEdges = (map.size() * (map.size() - 1)) * density;

        // return true if the current number of edges is equal or greater than the minimum, false otherwise
        return numEdges >= minNumEdges;
    }

    /**
     * Returns the type of map
     *
     * @return true if unidirectional else false
     */
    public boolean isUnidirectional() {
        return unidirectional;
    }

    /**
     * Returns the graph of map the generated. This graph implements {@link ModifiedGraphADT}
     *
     * @return graph of map the generated
     */
    public ModifiedGraphADT<Location> getMap() {
        return map;
    }

    /**
     * Returns the edge density
     *
     * @return edge density
     */
    public double getEdgeDensity() {
        return edgeDensity;
    }

    /**
     * Returns the number of bots
     *
     * @return number of bots
     */
    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    /**
     * Returns a formatted string that contains the map information
     *
     * @return formatted string that contains the map information
     */
    @Override
    public String toString() {
        return map.toString();
    }
}
