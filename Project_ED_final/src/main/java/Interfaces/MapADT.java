package Interfaces;

import Map.Location;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Interface that assists the creation of the class {@link Map.Map}
 */
public interface MapADT {
    /**
     * Sets a flag in the map
     *
     * @param flag location of the flag
     */
    void setFlag(Location flag);

    /**
     * Returns the vertices of the map
     *
     * @return array of {@link Location} of the map
     */
    Location[] getVertices();

    /**
     * Returns an array of {@link Location} that are adjacent to the chosen {@link Location}
     *
     * @param location given location
     * @return array of {@link Location}
     */
    Location[] getAdjacentLocations(Location location);

    /**
     * Returns a formatted string that contains the map information
     *
     * @return formatted string that contains the map information
     */
    String toString();
}
