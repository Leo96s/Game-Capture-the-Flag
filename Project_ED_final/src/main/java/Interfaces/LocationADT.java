package Interfaces;

import Bot.Bot;
import DataStructures.List.ArrayUnorderedList;
import Enums.TeamType;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Interface to assist the creation of the Location {@link Map.Location}
 */
public interface LocationADT {
    /**
     * Returns the team of the Location
     *
     * @return team of the location
     */
    TeamType getTeamType();

    /**
     * Sets the team of the location
     *
     * @param teamType team of the location
     */
    void setTeamType(TeamType teamType);

    /**
     * Checks whether the location is occupied by bots
     *
     * @return true if it is occupied, false otherwise
     */
    boolean isOccupied();

    /**
     * Checks if the location is a flag
     *
     * @return true if it is, false otherwise
     */
    boolean isFlag();

    /**
     * Checks if the flag was taken
     *
     * @return true if it is, false otherwise
     */
    boolean isFlagTaken();

    /**
     * Defines whether the flag was taken or not
     *
     * @param flagTaken boolean that defines whether the flag was taken or not
     */
    void setFlagTaken(boolean flagTaken);

    /**
     * Returns the character that identifies the location
     *
     * @return character that identifies the location
     */
    char getCharacter();

    /**
     * Sets the character that identifies the location
     *
     * @param character character that identifies the location
     */
    void setCharacter(char character);

    /**
     * Defines whether the location is a flag
     *
     * @param flag boolean that defines whether the location is a flag
     */
    void setFlag(boolean flag);

    /**
     * Returns a list {@link ArrayUnorderedList} of bots in the location
     *
     * @return list {@link ArrayUnorderedList} of bots in the location
     */
    ArrayUnorderedList<Bot> getBots();

    /**
     * Sets the bots of the location
     *
     * @param bots list {@link ArrayUnorderedList} of bots of the location
     */
    void setBots(ArrayUnorderedList<Bot> bots);

    /**
     * Adds the given bot to the location
     *
     * @param b bot {@link Bot} to be added
     */
    void addBot(Bot b);

    /**
     * Removes the given bot from the location
     *
     * @param b bot {@link Bot} to be removed
     */
    void removeBot(Bot b);

    /**
     * Returns a string that contains the information of the location
     *
     * @return returns a string that contains the information of the location
     */
    String toString();

    /**
     * Checks if the given Location is equal to this
     *
     * @param o object to compare
     * @return true if they are equal, false otherwise
     */
    @Override
    boolean equals(Object o);
}
