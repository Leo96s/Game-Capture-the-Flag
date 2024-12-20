package Map;

import DataStructures.List.ArrayUnorderedList;

import Bot.Bot;
import Enums.TeamType;
import Interfaces.LocationADT;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Class that represents the locations of the {@link Map}
 */
public class Location implements LocationADT {
    // identifier of the location
    private char character;
    // boolean that defines whether the location is a flag
    private boolean flag;
    // boolean that defines whether the flag was taken or not
    private boolean flagTaken;
    // bots in the location
    private ArrayUnorderedList<Bot> bots;
    private TeamType teamType;
    // counter of red bots on the location
    private int countRed;
    // counter of blue bots on the location
    private int countBlue;

    /**
     * Constructor of Location, takes a character as an input to identify the location.
     *
     * @param c character to identify the location
     */
    public Location(char c) {
        character = c;
        flag = false;
        bots = new ArrayUnorderedList<>();
        this.teamType = TeamType.DEFAULT;
        countBlue = 0;
        countRed = 0;
        flagTaken = false;
    }

    /**
     * Constructor of a Location that is a flag, takes a character as an input to identify the location and the team of
     * the flag {@link TeamType}
     *
     * @param c        character to identify the location
     * @param teamType team of the flag
     */
    public Location(char c, TeamType teamType) {
        character = c;
        flag = true;
        bots = new ArrayUnorderedList<>();
        this.teamType = teamType;
        countBlue = 0;
        countRed = 0;
        flagTaken = false;
    }

    /**
     * Returns the team of the Location
     *
     * @return team of the location
     */
    public TeamType getTeamType() {
        return teamType;
    }

    /**
     * Sets the team of the location
     *
     * @param teamType team of the location
     */
    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;
    }

    /**
     * Checks whether the location is occupied by bots
     *
     * @return true if it is occupied, false otherwise
     */
    public boolean isOccupied() {
        return countBlue != 0 || countRed != 0;
    }

    /**
     * Checks if the location is a flag
     *
     * @return true if it is, false otherwise
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Checks if the flag was taken
     *
     * @return true if it is, false otherwise
     */
    public boolean isFlagTaken() {
        return flagTaken;
    }

    /**
     * Defines whether the flag was taken or not
     *
     * @param flagTaken boolean that defines whether the flag was taken or not
     */
    public void setFlagTaken(boolean flagTaken) {
        this.flagTaken = flagTaken;
    }

    /**
     * Returns the character that identifies the location
     *
     * @return character that identifies the location
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Sets the character that identifies the location
     *
     * @param character character that identifies the location
     */
    public void setCharacter(char character) {
        this.character = character;
    }

    /**
     * Defines whether the location is a flag
     *
     * @param flag boolean that defines whether the location is a flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * Returns a list {@link ArrayUnorderedList} of bots in the location
     *
     * @return list {@link ArrayUnorderedList} of bots in the location
     */
    public ArrayUnorderedList<Bot> getBots() {
        return bots;
    }

    /**
     * Sets the bots of the location
     *
     * @param bots list {@link ArrayUnorderedList} of bots of the location
     */
    public void setBots(ArrayUnorderedList<Bot> bots) {
        this.bots = bots;
    }

    /**
     * Adds the given bot to the location
     *
     * @param b bot {@link Bot} to be added
     */
    public void addBot(Bot b) {
        bots.addToFront(b);

        switch (b.getTeamType()) {
            case BLUE -> countBlue++;
            case RED -> countRed++;
        }

        updateTeam();
    }

    /**
     * Removes the given bot from the location
     *
     * @param b bot {@link Bot} to be removed
     */
    public void removeBot(Bot b) {
        bots.remove(b);

        switch (b.getTeamType()) {
            case BLUE -> countBlue--;
            case RED -> countRed--;
        }
        updateTeam();
    }

    /**
     * Updates the team of the location based on the number of bots in each team.
     * If the number of bots is 0, the location is of a DEFAULT team
     * if there are only bots of one team it is a RED or BLUE team
     * If there is bots of each team it is CONTESTED
     */
    private void updateTeam() {
        if (!isFlag()) {
            if (countBlue != 0 && countRed != 0) {
                teamType = TeamType.CONTESTED;
            } else if (countBlue != 0 && countRed == 0) {
                teamType = TeamType.BLUE;
            } else if (countBlue == 0 && countRed != 0) {
                teamType = TeamType.RED;
            } else {
                teamType = TeamType.DEFAULT;
            }
        }
    }

    /**
     * Returns a string that contains the information of the location
     *
     * @return returns a string that contains the information of the location
     */
    public String toString() {
        String string = "[" + character + "]";

        // checks if the location is a flag
        if (isFlag()) {
            if (!isFlagTaken()) {
                // appends to the string the information of the flag
                string += " [Flag " + TeamType.teamTypeToString(getTeamType()) + "]";
            } else {
                string += " [Flag Taken]";
            }
        }

        // appends the bots to the string
        if (bots != null) {
            for (Bot b : bots) {
                string += "\n" + b;
            }
        }

        return string;
    }

    /**
     * Checks if the given Location is equal to this
     *
     * @param o object to compare
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;

        return character == location.character;
    }
}
