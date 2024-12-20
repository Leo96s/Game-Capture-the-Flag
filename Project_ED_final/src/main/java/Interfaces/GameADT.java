package Interfaces;

import Bot.Bot;
import DataStructures.Queue.LinkedQueue;
import Map.Map;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Interface created to assist the creation of the Game {@link Game}
 */
public interface GameADT {
    /**
     * Initializes the game by setting up the map, flags, and bots.
     *
     * @param startingPlayer The player who starts the game.
     */
    void initialize(String startingPlayer);

    /**
     * Starts the game loop.
     *
     * @param startingPlayer The player who starts the game.
     */
    void start(String startingPlayer);

    /**
     * Visualizes the bot's move on the map and updates the game status.
     * Highlights the edge between the previous and current location of the bot.
     *
     * @param currentBot The bot whose move is to be visualized.
     */
    void moveVisualizer(Bot currentBot);

    /**
     * Adds a new bot to the game.
     *
     * @param bot The bot to be added to the game.
     */
    void addBot(Bot bot);

    /**
     * Gets the map associated with the game.
     *
     * @return The map object.
     */
    Map getMap();

    /**
     * Gets the number of red team bots in the game.
     *
     * @return The number of red team bots.
     */
    int getRedBots();

    /**
     * Gets the number of blue team bots in the game.
     *
     * @return The number of blue team bots.
     */
    int getBlueBots();

    /**
     * Gets the queue of bots currently in the game.
     *
     * @return The queue of bots.
     */
    LinkedQueue<Bot> getBots();
}
