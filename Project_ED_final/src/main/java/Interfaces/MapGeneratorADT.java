package Interfaces;

import DataStructures.Graph.ModifiedGraphADT;
import Map.Location;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Interface to assist the creation of the {@link Map.MapGenerator}
 */
public interface MapGeneratorADT {
    /**
     * Generates the locations of the map.
     */
    void generateLocations();

    /**
     * Generates the edges of the map.
     * Each edge has a random weight between 1 and 15.
     * The number of edges is determined by the edge density.
     */
    void generateEdges();

    /**
     * Checks if the edge density is valid
     *
     * @param density edge density
     * @return true if density is valid, false otherwise
     */
    boolean isDensityValid(double density);

    /**
     * Returns the graph of map the generated. This graph implements {@link ModifiedGraphADT}
     *
     * @return graph of map the generated
     */
    ModifiedGraphADT<Location> getMap();

    /**
     * Returns a formatted string that contains the map information
     *
     * @return formatted string that contains the map information
     */
    @Override
    String toString();
}
