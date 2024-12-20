package MapVisualizer;

import Enums.TeamType;
import Interfaces.MapVisualizerADT;
import Map.Location;
import Map.Map;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import javax.swing.*;
import java.awt.*;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Class that extends the JFrame class to create a graphical user interface for visualizing the map created for the
 * Capture The Flag Game. This map is created in {@link Map}
 */
public class MapVisualizer extends JFrame implements MapVisualizerADT {
    /**
     * RED_TEAM, BLUE_TEAM, DEFAULT, CONTESTED, and FONT are static final constants that define the fill and font colors
     * for the locations on the map.
     */
    private static final String RED_TEAM = "fillColor=#ff3333";
    private static final String BLUE_TEAM = "fillColor=#33bbff";
    private static final String DEFAULT = "fillColor=#b3b3b3";
    private static final String CONTESTED = "fillColor=#ffa31a";
    private static final String FONT = ";strokeColor=black;fontColor=black";

    // instance of {@link mxGraphComponent} that displays the graph of the map on the frame
    private mxGraphComponent graphComponent;

    // instance of {@link JFrame} that represents the main window of the application
    private final JFrame frame;
    // instance of {@link JLabel} that shows the current round of the game
    private final JLabel roundLabel;
    // instance of {@link JTextArea} that shows the moves made by the players
    private final JTextArea movesTextArea;
    // instance of {@link JScrollPane} that allows scrolling the text area
    private final JScrollPane movesScrollPane;
    // array of Object that stores the vertices of the graph
    private Object[] vertices;
    // instance of {@link mxGraph} that represents the graph of the map
    private mxGraph graph;
    // instance of {@link Map} that contains the data of the map
    private Map map;

    /**
     * Contructor of MapVisualizer that takes a {@link Map} object as a parameter and initializes the fields of the class.
     * It also sets up the frame, the label, and the text area with their properties and layouts.
     *
     * @param map instance of {@link Map} that contains the data of the map
     */
    public MapVisualizer(Map map) {
        // Creates a frame
        frame = new JFrame("Game Map");

        // Set up the round Label To Show the Round
        roundLabel = new JLabel();
        roundLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize as needed

        // Set up the area that shows the moves
        movesTextArea = new JTextArea(50, 80);
        movesTextArea.setEditable(false); // Readonly
        movesTextArea.setFont(new Font("Consolas", Font.PLAIN, 12)); // Customize as needed
        movesScrollPane = new JScrollPane(movesTextArea);

        // Add the movesScrollPane and RoundLabel to the frame
        frame.getContentPane().add(movesScrollPane, BorderLayout.EAST);  // Add to the left side
        frame.getContentPane().add(roundLabel, BorderLayout.PAGE_START); // Add the label to the top of the frame

        // Configures the frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Set up the map instance
        this.map = map;
    }

    /**
     * Allows for the display of the {@link Map} using {@link mxGraph}.
     * Takes an int value as a parameter and updates the roundLabel, so it shows the round of the {@link Game}
     *
     * @param round round of the game
     */
    public void visualize(int round) {
        // Remove the old graph component if it exists
        if (graphComponent != null) {
            frame.getContentPane().remove(graphComponent);
        }

        // Create a graph instance
        graph = new mxGraph();

        // Defines the parent for the graph
        Object parent = graph.getDefaultParent();

        //Create a layout instance
        mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);

        // Define the vertices
        vertices = new Object[map.getMap().size()];

        // Begin a transaction on the graph model
        graph.getModel().beginUpdate();

        graph.setGridSize(40);

        // Get the adjacency matrix from the map
        double[][] adjMatrix = map.getMap().getAdjMatrix();

        try {
            // Inserts the vertices of the map into the graph
            for (int i = 0; i < vertices.length; i++) {
                // Extracts a vertex from the map
                Location vertex = map.getMap().getVertex(i);

                // Defines the color of the vertex based on the team
                String color = DEFAULT;
                switch (vertex.getTeamType()) {
                    case RED -> color = RED_TEAM;
                    case BLUE -> color = BLUE_TEAM;
                    case DEFAULT -> color = DEFAULT;
                    case CONTESTED -> color = CONTESTED;
                }

                // Checks if the vertex is a flag
                if (!vertex.isFlag()) {
                    // Add a normal vertex to the graph
                    vertices[i] = graph.insertVertex(parent, vertex.getCharacter() + "", vertex, 100, 100, 50, 50, color + FONT);
                } else {
                    // Add a vertex that is a flag
                    switch ((vertex).getTeamType()) {
                        case BLUE ->
                                vertices[i] = graph.insertVertex(parent, vertex.getCharacter() + "", vertex, 100, 100,
                                        100, 100, BLUE_TEAM + FONT);
                        case RED ->
                                vertices[i] = graph.insertVertex(parent, vertex.getCharacter() + "", vertex, 100, 100,
                                        100, 100, RED_TEAM + FONT);
                    }
                }

                // Add the edges according to the adjacency matrix
                for (int j = 0; j < vertices.length; j++) {
                    if (adjMatrix[i][j] != Double.POSITIVE_INFINITY) {
                        Object[] existingEdges = graph.getEdgesBetween(vertices[i], vertices[j]);
                        if (existingEdges.length == 0 && !map.isUnidirectional()) {
                            graph.insertEdge(parent, null, adjMatrix[i][j] + " km", vertices[i], vertices[j]);
                        } else {
                            graph.insertEdge(parent, null, adjMatrix[i][j] + " km", vertices[i], vertices[j]);
                        }
                    }
                    if (map.isUnidirectional()) {
                        if (i != j && adjMatrix[j][i] != Double.POSITIVE_INFINITY) {
                            graph.insertEdge(parent, null, adjMatrix[j][i] + " km", vertices[j], vertices[i]);
                        }
                    }
                }
            }

            // Sets the style of the vertices
            graph.getStylesheet().getDefaultVertexStyle().put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
            graph.getStylesheet().getDefaultVertexStyle().put(mxConstants.STYLE_FONTSIZE, "15");

            // Sets a different style of edge if the map is bidirectional
            if (!map.isUnidirectional()) {
                graph.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_ENDARROW, "false");
            }

            // Configures the graph so it's not editable
            graph.setCellsEditable(false);
            graph.setCellsMovable(false);
            graph.setCellsResizable(false);
            graph.setCellsSelectable(false);
            graph.setEnabled(false);
        } finally {
            // Ends the transaction on the graph model
            graph.getModel().endUpdate();
        }

        // Apply the layout to the graph
        layout.execute(graph.getDefaultParent());

        // Create a graph component and add it to the frame
        graphComponent = new mxGraphComponent(graph);

        // Configures the graphComponent
        graphComponent.setConnectable(false);
        graphComponent.setAutoScroll(false);
        graphComponent.setCenterZoom(true);

        // Defines how the zoom on the graph works
        double size = vertices.length;
        if (size <= 5) {
            graphComponent.zoomIn();
        }
        while (size > 5) {
            if (size > 10) {
                size = size - 2;
            }else {
                size = size - 5;
            }
            graphComponent.zoomOut();
        }

        // Adds the new graphComponent to the JFrame
        frame.getContentPane().add(graphComponent);
        // Refreshes the JFrame
        frame.revalidate();
        // Updates the roundLabel with the round number
        roundLabel.setText("Round" + round);
    }

    /**
     * Updates the movesTextArea, so it shows the moves that were given
     *
     * @param moveDescription moves played
     */
    public void updateMoves(String moveDescription) {
        movesTextArea.append(moveDescription + "\n");
        JScrollBar vertical = movesScrollPane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }

    /**
     * Returns the Object corresponding to the string given
     *
     * @param vertex string that contains the character of the vertex
     * @return vertex found
     */
    private Object getVertex(String vertex) {
        mxCell cell = null;
        for (int i = 0; i < vertices.length; i++) {
            cell = (mxCell) vertices[i];
            if (vertex.equals(cell.getId())) {
                break;
            }
        }
        if (cell == null) {
            throw new IllegalArgumentException("Vertex Not Found");
        }

        return cell;
    }

    /**
     * This method highlights an edge between two vertices in a graph, according to the team color.
     *
     * @param start  The character representing the start vertex of the edge
     * @param target The character representing the end vertex of the edge
     * @param team   The enum value indicating the team of the edge (RED or BLUE)
     */
    public void highlightEdge(char start, char target, TeamType team) {
        // Checks the directionality of the graph
        boolean directed = map.isUnidirectional();
        // Begin a transaction on the graph model
        graph.getModel().beginUpdate();

        // Declare a variable to store the color code
        String color = null;
        // Assign the color code according to the team
        switch (team) {
            case RED -> color = "#ff3333"; // Red color for RED team
            case BLUE -> color = "#33bbff"; // Blue color for a BLUE team
        }

        try {
            // Get the edges between the start and target vertices, considering the directionality of the graph
            Object[] edges = graph.getEdgesBetween(getVertex(start + ""), getVertex(target + ""), directed);

            // If there is at least one edge
            if (edges.length > 0) {
                // Configures an edge between the two according to the team color
                graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, color, new Object[]{edges[0]});
                graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, "3", new Object[]{edges[0]});
                graph.setCellStyles(mxConstants.STYLE_FONTSIZE, "20", new Object[]{edges[0]});
                graph.setCellStyles(mxConstants.STYLE_FONTCOLOR, color, new Object[]{edges[0]});
            }
        } finally {
            // End the transaction on the graph model
            graph.getModel().endUpdate();
        }
    }
}