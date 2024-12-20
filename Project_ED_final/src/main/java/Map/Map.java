package Map;

import DataStructures.Graph.ModifiedGraph;
import DataStructures.Graph.UnidirectionalModifiedGraph;
import Interfaces.MapADT;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Map class created for the capture the flag game
 */
public class Map extends MapGenerator implements MapADT {
    /**
     * Constructor that creates a map with the type of paths (unidirectional or bidirectional), density of edges and the
     * number of locations given
     *
     * @param unidirectional    type of paths
     * @param edgeDensity       density of edges
     * @param numberOfLocations number of locations in the map
     */
    public Map(boolean unidirectional, double edgeDensity, int numberOfLocations) {
        super(edgeDensity, numberOfLocations, unidirectional);
    }

    /**
     * Constructor that creates a map with the type of paths (unidirectional or bidirectional), density of edges, the
     * number of locations, adjacency matrix and vertices. It's useful for creating a map equal to a previous one, like
     * when importing or exporting
     *
     * @param adjMatrix         adjacency matrix of the graph
     * @param vertices          vertices of the graph
     * @param unidirectional    type of paths
     * @param edgeDensity       density of edges
     * @param numberOfLocations number of locations in the map
     */
    public Map(double[][] adjMatrix, Location[] vertices, boolean unidirectional, double edgeDensity, int numberOfLocations) {
        super(edgeDensity, numberOfLocations, unidirectional);

        // Creates an instance of a different graph depending on whether the type of the map
        if (unidirectional) {
            map = new UnidirectionalModifiedGraph<Location>();
        } else {
            map = new ModifiedGraph<Location>();
        }

        map.setVertices(vertices);
        map.setAdjMatrix(adjMatrix);
    }

    /**
     * Returns the vertices of the map
     *
     * @return array of {@link Location} of the map
     */
    public Location[] getVertices() {
        // get the array of Objects
        Object[] objects = map.getVertices();
        // create a new array of Locations
        Location[] locations = new Location[objects.length];

        // cast each element and copy to the new array
        for (int i = 0; i < objects.length; i++) {
            locations[i] = (Location) objects[i];
        }

        return locations;
    }

    /**
     * Sets a flag in the map
     *
     * @param flag location of the flag
     */
    public void setFlag(Location flag) {
        int index = -1;

        // gets the index of the location to add the flag
        for (int i = 0; i < map.size(); i++) {
            if (flag.equals(getVertices()[i])) {
                index = i;
            }
        }

        // swaps the current vertex with the flag
        map.setVertex(flag, index);
    }

    /**
     * Returns an array of {@link Location} that are adjacent to the chosen {@link Location}
     *
     * @param location given location
     * @return array of {@link Location}
     */
    public Location[] getAdjacentLocations(Location location) {
        // gets the index of the location on the map
        int vertexIndex = getMap().getVertex(location);

        if (vertexIndex == -1) {
            // if the vertex is not found
            return null;
        }

        // creates an array of locations
        Location[] locations = new Location[getMap().size()];

        int count = 0;

        // adds the vertices adjacent to the given to the array
        for (int j = 0; j < getMap().size(); j++) {
            if (getMap().getAdjMatrix()[vertexIndex][j] != Double.POSITIVE_INFINITY) {
                if (vertexIndex != j) {
                    locations[count++] = getVertices()[j];
                }
            }
        }

        // removes the null locations from the array
        Location[] newLocations = new Location[count];
        System.arraycopy(locations, 0, newLocations, 0, count);

        return newLocations;
    }
}