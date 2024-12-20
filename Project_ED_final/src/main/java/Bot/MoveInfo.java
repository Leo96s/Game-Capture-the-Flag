package Bot;

import Interfaces.MoveInfoADT;
import Map.Location;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Represents the movement information of a bot, including its previous and current locations,
 * and flags indicating whether it has moved or encountered a path with no available route.
 */
public class MoveInfo implements MoveInfoADT {
    private Location previous; // Previous location of the bot
    private Location current; // Current location of the bot
    private boolean noPath; // Flag indicating if the bot encountered a path with no available route
    private boolean moved; // Flag indicating if the bot has moved

    /**
     * Constructs a new MoveInfo object with the specified current location.
     * @param current The current location of the bot.
     */
    public MoveInfo(Location current) {
        this.current = current; // Initializes the current location with the specified location
        this.previous = current; // Initializes the previous location with the specified location
        this.moved = false; // Sets the moved flag to false by default
        this.noPath = false; // Sets the noPath flag to false by default
    }

    /**
     * Gets the previous location of the bot.
     * @return The previous location of the bot.
     */
    public Location getPrevious() {
        return previous;
    }

    /**
     * Gets the current location of the bot.
     * @return The current location of the bot.
     */
    public Location getCurrent() {
        return current;
    }

    /**
     * Sets the previous location of the bot.
     * @param previous The previous location to be set.
     */
    public void setPrevious(Location previous) {
        this.previous = previous;
    }

    /**
     * Sets the current location of the bot.
     * @param current The current location to be set.
     */
    public void setCurrent(Location current) {
        this.current = current;
    }

    /**
     * Checks if the bot has moved.
     * @return True if the bot has moved, false otherwise.
     */
    public boolean hasMoved() {
        return moved;
    }

    /**
     * Sets the moved flag indicating whether the bot has moved.
     * @param moved The moved flag to be set.
     */
    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    /**
     * Checks if the bot has encountered a path with no available route.
     * @return True if the bot has encountered a path with no available route, false otherwise.
     */
    public boolean hasNoPath() {
        return noPath;
    }

    /**
     * Sets the noPath flag indicating whether the bot has encountered a path with no available route.
     * @param noPath The noPath flag to be set.
     */
    public void setNoPath(boolean noPath) {
        this.noPath = noPath;
    }
}
