package Interfaces;

import Enums.AlgorithmType;
import Enums.TeamType;

import java.util.Iterator;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Interface that assists the creation of the class {@link Bot}
 */
public interface BotADT<T> {

    /**
     * Execute the movement of the bot
     */
    public void move(Iterator iterator);

    /**
     * Assign the algorithm used for the bot
     */
    void assignAlgorithm(AlgorithmType algorithm);

    /**
     * Checks if the bot has captured the enemy team Flag
     *
     * @return true if he has, false otherwise
     */
    boolean hasFlag();

    /**
     * Changes the flag depending on whether the bot has the enemy team flag
     *
     * @param flag boolean that defines whether the bot has the enemy team flag
     */
    void setFlag(boolean flag);

    /**
     * Returns the algorithm that the bot was assigned
     *
     * @return algorithm chosen for the bot
     */
    AlgorithmType getAlgorithm();

    /**
     * Returns the Team of the Bot
     *
     * @return team of the bot
     */
    TeamType getTeamType();

    /**
     * Assigns the Team of the Bot
     *
     * @param teamType team
     */
    void setTeamType(TeamType teamType);
}
