/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bot;

import Enums.AlgorithmType;
import Enums.TeamType;
import Interfaces.BotADT;
import Map.Location;

import java.util.Iterator;


/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Represents a bot in a game scenario, implementing the BotADT interface.
 */
public class Bot extends MoveInfo implements BotADT {
    private static int nextId = 1; // Static variable to manage the unique identifier for each bot
    private int id; // Unique identifier for the bot
    private AlgorithmType algorithm; // Algorithm used by the bot for navigation
    private TeamType teamType; // Team type of the bot (e.g., RED, BLUE)
    private boolean flag; // Indicates whether the bot is carrying a flag
    private Location enemyBase; // Location of the enemy base
    private Location base; // Location of the bot's base

    /**
     * Constructs a new bot with the specified algorithm, team type, enemy base, and base.
     *
     * @param algorithm The algorithm used by the bot for navigation.
     * @param team      The team type of the bot (e.g., RED, BLUE).
     * @param enemyBase The location of the enemy base.
     * @param base      The location of the bot's base.
     */
    public Bot(AlgorithmType algorithm, TeamType team, Location enemyBase, Location base) {
        super(base); // Calls the constructor of the superclass (MoveInfo) to initialize the current location
        this.base = base; // Initializes the bot's base location
        this.enemyBase = enemyBase; // Initializes the enemy base location
        this.algorithm = algorithm; // Initializes the algorithm used by the bot
        this.teamType = team; // Initializes the team type of the bot
        this.flag = false; // Initializes the flag status of the bot as false
        this.id = nextId++; // Assigns a unique identifier to the bot
    }

    /**
     * Moves the bot according to the specified iterator.
     *
     * @param iterator The iterator containing the sequence of locations for the bot to move.
     */
    @Override
    public void move(Iterator iterator) {
        iterator.next(); // Skips the current location

        if (iterator.hasNext()) {
            this.setPrevious(this.getCurrent()); // Sets the previous location as the current location
            this.getPrevious().removeBot(this); // Removes the bot from the previous location
            this.setCurrent((Location) iterator.next()); // Sets the new current location
            this.getCurrent().addBot(this); // Adds the bot to the current location
            this.setMoved(true); // Sets the moved flag as true
        } else {
            // Checks if the bot has not leaved the enemy base or its own base
            if ((this.getCurrent().equals(enemyBase) && hasFlag()) || this.getCurrent().equals(base)) {
                this.setNoPath(true); // Sets the no path flag as true
                // Changes the algorithm to the shortest path if not already using defense algorithm
                if (!this.getAlgorithm().equals(AlgorithmType.DEFENSE)) {
                    this.assignAlgorithm(AlgorithmType.SHORTEST_PATH);
                }
            }
            this.setMoved(false); // Sets the moved flag as false
        }
    }

    /**
     * Gets the algorithm used by the bot for navigation.
     *
     * @return The algorithm used by the bot.
     */
    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    /**
     * Gets the team type of the bot.
     *
     * @return The team type of the bot.
     */
    public TeamType getTeamType() {
        return teamType;
    }

    /**
     * Sets the team type of the bot.
     *
     * @param teamType The team type to be set.
     */
    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;
    }

    /**
     * Checks if the bot is carrying a flag.
     *
     * @return True if the bot is carrying a flag, false otherwise.
     */
    public boolean hasFlag() {
        return flag;
    }

    /**
     * Sets the flag status of the bot.
     *
     * @param flag The flag status to be set.
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * Assigns a new algorithm to the bot.
     *
     * @param algorithm The new algorithm to be assigned.
     */
    @Override
    public void assignAlgorithm(AlgorithmType algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Gets the unique identifier of the bot.
     *
     * @return The unique identifier of the bot.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the location of the enemy base.
     *
     * @return The location of the enemy base.
     */
    public Location getEnemyBase() {
        return enemyBase;
    }

    /**
     * Sets the location of the enemy base.
     *
     * @param enemyBase The location of the enemy base to be set.
     */
    public void setEnemyBase(Location enemyBase) {
        this.enemyBase = enemyBase;
    }

    /**
     * Gets the location of the bot's base.
     *
     * @return The location of the bot's base.
     */
    public Location getBase() {
        return base;
    }

    /**
     * Sets the location of the bot's base.
     *
     * @param base The location of the bot's base to be set.
     */
    public void setBase(Location base) {
        this.base = base;
    }

    /**
     * Generates a string representation of the bot.
     *
     * @return A string representation of the bot.
     */
    public String toString() {
        String s = "";

        if (hasFlag()) {
            s += "[Flag]-";
        }

        s += "[" + TeamType.teamTypeToString(teamType) + "] Bot" + id;

        return s;
    }

    /**
     * Resets the nextId when the game is Over
     */
    public static void resetId() {
        nextId = 1;
    }
}
