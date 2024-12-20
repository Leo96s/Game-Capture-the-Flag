package Interfaces;

import Map.Location;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Interface to assist the creation of the MoveInfo Class {@link Bot.MoveInfo}
 */
public interface MoveInfoADT {

    /**
     * Gets the previous location of the bot.
     *
     * @return The previous location of the bot.
     */
    Location getPrevious();

    /**
     * Gets the current location of the bot.
     *
     * @return The current location of the bot.
     */
    Location getCurrent();

    /**
     * Sets the previous location of the bot.
     *
     * @param previous The previous location to be set.
     */
    void setPrevious(Location previous);

    /**
     * Sets the current location of the bot.
     *
     * @param current The current location to be set.
     */
    void setCurrent(Location current);

    /**
     * Checks if the bot has moved.
     *
     * @return True if the bot has moved, false otherwise.
     */
    boolean hasMoved();

    /**
     * Sets the moved flag indicating whether the bot has moved.
     *
     * @param moved The moved flag to be set.
     */
    void setMoved(boolean moved);

    /**
     * Checks if the bot has encountered a path with no available route.
     *
     * @return True if the bot has encountered a path with no available route, false otherwise.
     */
    boolean hasNoPath();

    /**
     * Sets the noPath flag indicating whether the bot has encountered a path with no available route.
     *
     * @param noPath The noPath flag to be set.
     */
    void setNoPath(boolean noPath);
}
