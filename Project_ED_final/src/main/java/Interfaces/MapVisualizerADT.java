package Interfaces;

import Enums.TeamType;
import Map.Map;
import com.mxgraph.view.mxGraph;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Interface that assists the creation of the class {@link MapVisualizer.MapVisualizer}
 */
public interface MapVisualizerADT {
    /**
     * Allows for the display of the {@link Map} using {@link mxGraph}.
     * Takes an int value as a parameter and updates the roundLabel, so it shows the round of the {@link Game}
     *
     * @param round round of the game
     */
    void visualize(int round);

    /**
     * Updates the movesTextArea, so it shows the moves that were given
     *
     * @param moveDescription moves played
     */
    void updateMoves(String moveDescription);

    /**
     * This method highlights an edge between two vertices in a graph, according to the team color.
     *
     * @param start  The character representing the start vertex of the edge
     * @param target The character representing the end vertex of the edge
     * @param team   The enum value indicating the team of the edge (RED or BLUE)
     */
    void highlightEdge(char start, char target, TeamType team);
}