package Game;

import Bot.Bot;
import DataStructures.Queue.LinkedQueue;
import Enums.AlgorithmType;
import Enums.TeamType;
import Exceptions.EmptyCollectionException;
import Interfaces.GameADT;
import Map.*;
import MapVisualizer.MapVisualizer;

import java.util.Iterator;
import java.util.Random;

import static Menus.InputAlgorithm.getAlgorithms;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Class representing the game environment and logic.
 */
public class Game implements GameADT {
    private Map map; // The map on which the game is played
    private MapVisualizer mapVisualizer; // Visualizer for the map
    private int redBots; // Number of red team bots
    private int blueBots; // Number of blue team bots
    private final Location flagRed; // Location of the red team flag
    private final Location flagBlue; // Location of the blue team flag
    private LinkedQueue<Bot> bots; // Queue containing all the bots in the game
    private static int round = 1; // Current round of the game
    private boolean gameOver; // Indicates if the game is over

    /**
     * Constructs a new Game instance with the given parameters.
     *
     * @param map      The map on which the game will be played.
     * @param flag1    The character representing the location of the red team flag.
     * @param flag2    The character representing the location of the blue team flag.
     * @param redBots  Number of red team bots.
     * @param blueBots Number of blue team bots.
     */
    public Game(Map map, char flag1, char flag2, int redBots, int blueBots) {
        this.map = map;
        this.redBots = redBots;
        this.blueBots = blueBots;
        this.bots = new LinkedQueue<>();
        this.flagRed = new Location(flag1, TeamType.RED);
        this.flagBlue = new Location(flag2, TeamType.BLUE);
        this.gameOver = false;
    }

    /**
     * Initializes the game by setting up the map, flags, and bots.
     *
     * @param startingPlayer The player who starts the game.
     */
    public void initialize(String startingPlayer) {
        map.setFlag(flagRed);
        map.setFlag(flagBlue);

        int countRed = 0;
        int countBlue = 0;

        // Choose algorithms for bots
        System.out.println("Algorithms for bots" + "\t" + startingPlayer + ": ");
        LinkedQueue<AlgorithmType> redAlgorithms = getAlgorithms(redBots);
        System.out.println("Algorithms for bots" + "\t" + (startingPlayer.equals("player1") ? "player2" : "player1") + ": ");
        LinkedQueue<AlgorithmType> blueAlgorithms = getAlgorithms(blueBots);

        // Initialize bots
        for (int i = 0; i <= Math.max(redBots, blueBots); i++) {
            if (countRed < redBots) {
                Bot redBot = null;
                try {
                    redBot = new Bot(redAlgorithms.dequeue(), TeamType.RED, flagBlue, flagRed);
                } catch (EmptyCollectionException e) {
                    throw new RuntimeException(e);
                }
                map.getVertices()[map.getMap().getVertex(flagRed)].addBot(redBot);
                bots.enqueue(redBot);
                countRed++;
            }

            if (countBlue < blueBots) {
                Bot blueBot = null;
                try {
                    blueBot = new Bot(blueAlgorithms.dequeue(), TeamType.BLUE, flagRed, flagBlue);
                } catch (EmptyCollectionException e) {
                    throw new RuntimeException(e);
                }
                map.getVertices()[map.getMap().getVertex(flagBlue)].addBot(blueBot);
                bots.enqueue(blueBot);
                countBlue++;
            }
        }
    }

    /**
     * Starts the game loop.
     *
     * @param startingPlayer The player who starts the game.
     */
    public void start(String startingPlayer) {
        initialize(startingPlayer);
        this.mapVisualizer = new MapVisualizer(map);
        mapVisualizer.visualize(0);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Bot currentBot = null;

        // Game loop
        do {
            currentBot = playRound(currentBot);
            mapVisualizer.visualize(round);
            round++;
            mapVisualizer.updateMoves("---------------------------------------");
        } while (!gameOver(currentBot, startingPlayer));
        round = 0;
        Bot.resetId();
    }

    /**
     * Plays a round of the game.
     *
     * @param currentBot The bot whose turn it is to play.
     * @return The next bot to play.
     */
    private Bot playRound(Bot currentBot) {
        try {
            currentBot = bots.dequeue();
        } catch (EmptyCollectionException e) {
            throw new RuntimeException(e);
        }
        executeMove(currentBot);
        bots.enqueue(currentBot);
        return currentBot;
    }

    /**
     * Checks if the game is over.
     *
     * @param bot            The bot whose turn it is to play.
     * @param startingPlayer The player who starts the game.
     * @return True, if the game is over, otherwise false.
     */
    private boolean gameOver(Bot bot, String startingPlayer) {
        if (gameOver) {
            return gameOver;
        }

        if (bot.getCurrent().equals(bot.getBase()) && bot.hasFlag()) {
            switch (bot.getTeamType()) {
                case BLUE:
                    mapVisualizer.updateMoves("\n********************\n[Blue] Bot"
                            + bot.getId() + " captured the enemy flag\nTeam Blue Won which belongs to " +
                            (startingPlayer.equals("player1") ? "player2" : "player1") + "\n" +
                            "The bot is using the algorithm: " + bot.getAlgorithm() + "\n********************");
                    break;
                case RED:
                    mapVisualizer.updateMoves("\n********************\n[Red] Bot"
                            + bot.getId() + " captured the enemy flag\nTeam Red Won which belongs to "
                            + startingPlayer + "\n" +
                            "The bot is using the algorithm: " + bot.getAlgorithm() + "\n********************");
                    break;
            }
            gameOver = true;
            return gameOver;
        }

        gameOver = false;
        return gameOver;
    }

    /**
     * Executes a move for the current bot.
     *
     * @param currentBot The bot whose move is to be executed.
     */
    private void executeMove(Bot currentBot) {
        if (!currentBot.hasFlag()) {
            play(currentBot, currentBot.getCurrent(), currentBot.getEnemyBase());
        } else {
            play(currentBot, currentBot.getCurrent(), currentBot.getBase());
        }
        defend(currentBot);
        if (canRecaptureFlag(currentBot)) {
            mapVisualizer.updateMoves("********************\nRound " + round + ": [" + TeamType.teamTypeToString(currentBot.getTeamType()) + "] Bot" +
                    currentBot.getId() + " has recaptured his team's flag\n********************");
            mapVisualizer.visualize(round);
        }
    }

    /**
     * Defends the base if the bot's algorithm is set to defense.
     * Moves the bot towards the base using the shortest path algorithm if it's not already at the base.
     *
     * @param bot The bot to defend the base.
     */
    private void defend(Bot bot) {
        if (bot.getAlgorithm().equals(AlgorithmType.DEFENSE)) {
            Iterator iterator = null;
            if (bot.getCurrent().equals(bot.getBase())) {
                Location[] list = map.getAdjacentLocations(bot.getBase());
                if (list.length > 0) {
                    Random random = new Random();
                    Location l = list[random.nextInt(list.length)];
                    iterator = map.getMap().iteratorShortestPath(bot.getBase(), l);
                }
            } else {
                iterator = map.getMap().iteratorShortestPath(bot.getCurrent(), bot.getBase());
            }
            bot.move(iterator);
            moveVisualizer(bot);
        }
    }

    /**
     * Executes a move for the current bot based on its algorithm.
     * Moves the bot using the corresponding algorithm (Shortest Path, MST, or DFS).
     *
     * @param currentBot The bot whose move is to be executed.
     * @param start      The starting location of the move.
     * @param end        The destination location of the move.
     */
    private void play(Bot currentBot, Location start, Location end) {
        Iterator iterator;
        switch (currentBot.getAlgorithm()) {
            case SHORTEST_PATH:
                iterator = map.getMap().iteratorShortestPath(start, end);
                currentBot.move(iterator);
                moveVisualizer(currentBot);
                break;
            case MST:
                iterator = map.getMap().iteratorMstNetwork(start, end);
                currentBot.move(iterator);

                if (currentBot.hasNoPath()) {
                    iterator = map.getMap().iteratorShortestPath(start, end);
                    currentBot.move(iterator);
                    mapVisualizer.updateMoves("********************\nBot" + currentBot.getId() + " doesn't have a path. " +
                            "Algorithm Changed from MST to Shortest Path\n********************");
                }
                moveVisualizer(currentBot);
                break;
            case DFS:
                iterator = map.getMap().iteratorDFS(start, end);
                if (iterator.hasNext()) {
                    currentBot.move(iterator);
                }

                if (currentBot.hasNoPath()) {
                    iterator = map.getMap().iteratorShortestPath(start, end);
                    currentBot.move(iterator);
                    mapVisualizer.updateMoves("********************\nBot" + currentBot.getId() + " doesn't have a path. " +
                            "Algorithm Changed from DFS to Shortest Path\n********************");
                }

                moveVisualizer(currentBot);
                break;
        }
    }

    /**
     * Checks if the current bot can recapture its team's flag from a contested location.
     * If an enemy bot holds the flag and is in the same location, the flag is recaptured.
     *
     * @param currentBot The bot attempting to recapture the flag.
     * @return True if the flag was recaptured, otherwise false.
     */
    private boolean canRecaptureFlag(Bot currentBot) {
        if (currentBot.getCurrent().getTeamType() != TeamType.CONTESTED) {
            return false;
        } else {
            for (Bot b : currentBot.getCurrent().getBots()) {
                if (b.hasFlag()) {
                    if (!b.getTeamType().equals(currentBot.getTeamType())) {
                        b.setFlag(false);
                        currentBot.getBase().setFlagTaken(false);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Visualizes the bot's move on the map and updates the game status.
     * Highlights the edge between the previous and current location of the bot.
     *
     * @param currentBot The bot whose move is to be visualized.
     */
    public void moveVisualizer(Bot currentBot) {
        if (currentBot.hasMoved()) {
            mapVisualizer.highlightEdge(currentBot.getPrevious().getCharacter(), currentBot.getCurrent().getCharacter(), currentBot.getTeamType());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mapVisualizer.visualize(round);
            mapVisualizer.updateMoves("Round" + round + ": [" + TeamType.teamTypeToString(currentBot.getTeamType()) + "] Bot" +
                    currentBot.getId() +
                    " moved from " + currentBot.getPrevious().getCharacter() + " to " +
                    currentBot.getCurrent().getCharacter() + " and travelled " + map.getMap().shortestPathWeight(currentBot.getPrevious(), currentBot.getCurrent()) + " km");
            if (currentBot.getCurrent().equals(currentBot.getEnemyBase()) && !currentBot.getCurrent().isFlagTaken() && !currentBot.hasFlag()) {
                currentBot.getCurrent().setFlagTaken(true);
                currentBot.setFlag(true);
                mapVisualizer.updateMoves("********************\nRound" + round + ": [" + TeamType.teamTypeToString(currentBot.getTeamType()) + "] Bot" +
                        currentBot.getId() + " has stolen the enemy flag\n********************");
                mapVisualizer.visualize(round);
            }
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (currentBot.getCurrent().equals(currentBot.getBase())) {
                mapVisualizer.updateMoves("Round" + round + ": [" + TeamType.teamTypeToString(currentBot.getTeamType()) + "] Bot"
                        + currentBot.getId() + " has no path\n********************\nGame Over\n********************");
                gameOver = true;
            } else if (currentBot.getCurrent().equals(currentBot.getEnemyBase()) && !currentBot.hasFlag() && currentBot.getEnemyBase().isFlagTaken()) {
                mapVisualizer.updateMoves("Round" + round + ": [" + TeamType.teamTypeToString(currentBot.getTeamType()) + "] Bot"
                        + currentBot.getId() + " is waiting for the enemy flag to respawn");
            }
        }
    }

    /**
     * Adds a new bot to the game.
     *
     * @param bot The bot to be added to the game.
     */
    public void addBot(Bot bot) {
        bots.enqueue(bot);
    }

    /**
     * Gets the map associated with the game.
     *
     * @return The map object.
     */
    public Map getMap() {
        return map;
    }

    /**
     * Gets the number of red team bots in the game.
     *
     * @return The number of red team bots.
     */
    public int getRedBots() {
        return redBots;
    }

    /**
     * Gets the number of blue team bots in the game.
     *
     * @return The number of blue team bots.
     */
    public int getBlueBots() {
        return blueBots;
    }

    /**
     * Gets the queue of bots currently in the game.
     *
     * @return The queue of bots.
     */
    public LinkedQueue<Bot> getBots() {
        return bots;
    }
}