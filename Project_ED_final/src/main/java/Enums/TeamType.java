package Enums;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * Enumeration representing different types of teams in the game.
 */
public enum TeamType {
    RED,        // Represents the red team
    BLUE,       // Represents the blue team
    DEFAULT,    // Represents the default team
    CONTESTED;  // Represents a contested team

    /**
     * Converts a TeamType enum value to a corresponding string representation.
     *
     * @param team The TeamType enum value to convert.
     * @return A string representation of the given TeamType.
     */
    public static String teamTypeToString(TeamType team) {
        String s = "";
        switch (team) {
            case RED -> {
                s = "Red";
            }
            case BLUE -> {
                s = "Blue";
            }
            case DEFAULT -> {
                s = "Default";
            }
            case CONTESTED -> {
                s = "Contested";
            }
        }
        return s;
    }
}
