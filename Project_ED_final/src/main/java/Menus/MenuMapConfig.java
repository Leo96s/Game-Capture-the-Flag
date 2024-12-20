package Menus;

import Map.ExportMap;
import Map.ImportMap;
import Map.*;
import MapVisualizer.MapVisualizer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * This abstract class provides menu options for configuring the map.
 */
public abstract class MenuMapConfig {

    private Map map;
    private int numberOfLocations;
    private boolean isUnidirectional;
    private double densityOfEdges;

    /**
     * Constructor for MenuMapConfig class.
     */
    public MenuMapConfig() {
        map = null;
    }

    /**
     * Method to configure the map by providing options to import an existing map or create a new one.
     *
     * @throws IOException if an I/O error occurs.
     */
    protected void mapConfig() throws IOException {
        System.out.println("Starting a new game...");
        int choice = -1;

        do {
            System.out.println("---------------------------------------------");
            System.out.println("Map Configurations");
            System.out.println("1. Import Map");
            System.out.println("2. New Map");
            System.out.println("3. Visualize Map");
            System.out.println("4. Re-roll map");
            System.out.println("5. Save Map");
            System.out.println("6. Exit");
            System.out.println("---------------------------------------------");
            System.out.print("Enter your choice: ");

            try {
                choice = new Scanner(System.in).nextInt();
            } catch (InputMismatchException ie) {
                System.out.println("Invalid Input");
                mapConfig();
            }

            switch (choice) {
                case 1:
                    map = importMap();
                    break;
                case 2:
                    newMap();
                    break;
                case 3:
                    if (getMap() != null) {
                        visualizeMap();
                    } else {
                        System.out.println("Please create a new map or import one first");
                    }
                    break;
                case 4:
                    if (getMap() != null) {
                        reroll();
                    } else {
                        System.out.println("Please create a new map or import one first");
                    }
                    break;
                case 5:
                    if (getMap() != null) {
                        saveMap();
                    } else {
                        System.out.println("Please create a new map or import one first");
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 6);
    }

    /**
     * Method to import a map from an external source.
     *
     * @return the imported map.
     * @throws IOException if an I/O error occurs.
     */
    private Map importMap() throws IOException {
        System.out.println("Importing map...");
        map = ImportMap.importMap();
        densityOfEdges = ImportMap.importEdgeDensity();
        isUnidirectional = ImportMap.importType();
        numberOfLocations = ImportMap.importNumberOfLocations();

        return map;
    }

    /**
     * Method to save the current map.
     *
     * @throws IOException if an I/O error occurs.
     */
    protected void saveMap() throws IOException {
        System.out.println("Saving map...");
        ExportMap.exportMap(map);
    }

    /**
     * Method to create a new map.
     *
     * @throws IOException if an I/O error occurs.
     */
    protected void newMap() throws IOException {
        numberOfLocations = boardLength();
        isUnidirectional = typePaths();
        densityOfEdges = densityOfEdges();
        generateMap();
    }

    /**
     * Method to generate a new map with specified configurations.
     */
    protected void generateMap() {
        map = new Map(isUnidirectional, densityOfEdges, numberOfLocations);
        map.generateLocations();
        map.generateEdges();

        System.out.println("New map generating...");
    }

    /**
     * Restores the map to default, without flags or bots
     */
    protected void restoreMap() {
        Map mapRestored = new Map(map.getMap().getAdjMatrix(), restoreLocations(), isUnidirectional, densityOfEdges, numberOfLocations);

        map = mapRestored;

        System.out.println("Map getting Restored...");
    }

    /**
     * Restores the locations of the current map to default
     *
     * @return array of locations in the map
     */
    private Location[] restoreLocations() {
        Location[] oldLocations = map.getVertices();

        Location[] locationsRestored = new Location[oldLocations.length];

        for (int i = 0; i < oldLocations.length; i++) {
            locationsRestored[i] = new Location(oldLocations[i].getCharacter());
        }

        return locationsRestored;
    }

    /**
     * Method to visualize the current map.
     */
    protected void visualizeMap() {
        MapVisualizer mapVisualizer = new MapVisualizer(map);
        mapVisualizer.visualize(0);
    }

    /**
     * Method to reroll the map.
     */
    protected void reroll() {
        generateMap();
    }

    /**
     * Method to input and validate the board length for the new map.
     *
     * @return the chosen board length.
     * @throws IOException if an I/O error occurs.
     */
    private int boardLength() throws IOException {
        int numberOfLocations = 0;

        do {
            try {
                System.out.println("Choose the board length: (Suggested between 10 and 30)");
                numberOfLocations = new Scanner(System.in).nextInt();

                if (numberOfLocations < 5) {
                    System.out.println("Invalid input. Please enter a value greater than or equal to 1.");
                } else if (numberOfLocations > 30) {
                    System.out.println("Invalid input. Please enter a value less than or equal to 30.");
                }
            } catch (InputMismatchException ie) {
                System.out.println("Invalid type of input");
            }
        } while (numberOfLocations < 1 || numberOfLocations > 30);

        System.out.println("Assigning size to map...");
        return numberOfLocations;
    }

    /**
     * Method to input and validate the type of paths for the new map.
     *
     * @return true if the paths are unidirectional, false if bidirectional.
     * @throws IOException if an I/O error occurs.
     */
    private boolean typePaths() throws IOException {
        boolean flag = false;
        boolean isUnidirectional = false;
        do {
            System.out.println("Choose the type of generated paths: (Unidirectional or Bidirectional)");
            String type = new Scanner(System.in).next().toLowerCase();

            switch (type) {
                case "bidirectional":
                    flag = true;
                    isUnidirectional = false;
                    break;
                case "unidirectional":
                    flag = true;
                    isUnidirectional = true;
                    break;
                default:
                    System.out.println("Invalid type of path");
                    break;
            }

        } while (!flag);

        System.out.println("Assign type paths to map...");
        return isUnidirectional;
    }

    /**
     * Method to input and validate the density of edges for the new map.
     *
     * @return the chosen density of edges.
     * @throws IOException if an I/O error occurs.
     */
    private double densityOfEdges() throws IOException {
        String string = null;
        double densityOfEdges = 0;

        do {
            try {
                System.out.println("Choose the density of edges: (Suggested between 0.5 and 1)");
                string = new Scanner(System.in).next();

                densityOfEdges = Double.parseDouble(string);

                if (densityOfEdges < 0.1 || densityOfEdges > 1) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ne) {
                System.out.println("Invalid input. Please enter a value between 0.1 and 1.");
            }
        } while (densityOfEdges < 0.1 || densityOfEdges > 1);

        System.out.println("Assign density of edges to map...");
        return densityOfEdges;
    }

    /**
     * Getter for map.
     *
     * @return the current map.
     */
    public Map getMap() {
        return map;
    }

    /**
     * Setter for map.
     *
     * @param map the map to set.
     */
    public void setMap(Map map) {
        this.map = map;
    }
}
