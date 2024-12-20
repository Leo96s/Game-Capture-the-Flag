package Menus;

import Game.Game;
import Map.Location;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * <p>
 * This class represents the menus and user interface for the game.
 */
public class Menus extends MenuMapConfig {

    private Game game;
    private char flagRed, flagBlue;
    private int botsRed, botsBlue;
    private String startingPlayer;

    /**
     * Constructor for Menus class.
     */
    public Menus() {
        super();
        this.flagRed = this.flagBlue = 0;
        this.botsRed = this.botsBlue = 0;
    }

    /**
     * Initiates the main program.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void mainProgram() throws IOException {
        System.out.println("Initiating the program....");
        gameLoop();
    }

    /**
     * Main game loop for displaying menu options and handling user input.
     *
     * @throws IOException if an I/O error occurs.
     */
    private void gameLoop() throws IOException {
        int choice = -1;
        do {
            System.out.println("---------------------------------------------");
            System.out.println("Main Menu");
            System.out.println("1. Map Config");
            System.out.println("2. Play");
            System.out.println("3. Exit Game");
            System.out.println("---------------------------------------------");
            System.out.print("Enter your choice: ");

            try {
                choice = new Scanner(System.in).nextInt();
            } catch (InputMismatchException ie) {
                System.out.println("Invalid Input");
                gameLoop();
            }

            switch (choice) {
                case 1:
                    mapConfig();
                    break;
                case 2:
                    if (getMap() != null) {
                        playGame();
                        restoreMap();
                    } else {
                        System.out.println("Please config the map first");
                    }
                    break;
                case 3:
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 3);
    }

    /**
     * Displays game options and starts the game.
     *
     * @throws IOException if an I/O error occurs.
     */
    private void gameOptions() throws IOException {
        System.out.println("Game Options");
        Random random = new Random();

        boolean player1first = random.nextBoolean();

        if (player1first) {
            startingPlayer = "player1";
        } else {
            startingPlayer = "player2";
        }

        System.out.println("The starting player will be: " + startingPlayer);

        System.out.println(startingPlayer + "\t" + "belongs to team Read");
        System.out.println((startingPlayer.equals("player1") ? "player2" : "player1") + "\t" + "belongs to team Blue");

        chooseFlag(startingPlayer);
        numberBots(startingPlayer);
    }

    /**
     * Allows players to choose the location of their flags.
     *
     * @param startingPlayer the starting player.
     * @throws IOException if an I/O error occurs.
     */
    private void chooseFlag(String startingPlayer) throws IOException {
        System.out.println("Choose the location of flag");
        System.out.println("Possible locations: " + Arrays.toString(getMap().getVertices()));

        // Player1
        System.out.println(startingPlayer + ": ");
        char player1Flag;
        do {
            player1Flag = new Scanner(System.in).next().toUpperCase().charAt(0);
            if (!isValidFlagLocation(player1Flag)) {
                System.out.println("Invalid location. Please choose from the available locations.");
            }
        } while (!isValidFlagLocation(player1Flag));
        flagRed = player1Flag;

        // Player2
        System.out.println((startingPlayer.equals("player1") ? "player2" : "player1") + ": ");
        char player2Flag;
        do {
            player2Flag = new Scanner(System.in).next().toUpperCase().charAt(0);
            if (!isValidFlagLocation(player2Flag) || player2Flag == flagRed) {
                System.out.println("Invalid location. Please choose from the available locations and ensure it is different from Player1's flag.");
            }
        } while (!isValidFlagLocation(player2Flag) || player2Flag == flagRed);
        flagBlue = player2Flag;
    }

    /**
     * Checks if the flag location is valid.
     *
     * @param location the flag location to check.
     * @return true if the location is valid, otherwise false.
     */
    private boolean isValidFlagLocation(char location) {
        char upperCaseLocation = Character.toUpperCase(location);

        for (Location temp : getMap().getVertices()) {
            if (upperCaseLocation == temp.getCharacter()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Allows players to choose the number of bots to play with.
     *
     * @param startingPlayer the starting player.
     * @throws IOException if an I/O error occurs.
     */
    private void numberBots(String startingPlayer) throws IOException {
        do {
            try {
                System.out.println("Choose number of bots to play");
                System.out.println(startingPlayer + ": ");
                botsRed = new Scanner(System.in).nextInt();

                if (botsRed < 0 || botsRed >= 15) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException ie) {
                System.out.println("Invalid input. Please enter a number equal to or greater than 0 and less than 15.");
            }
        } while (botsRed < 0 || botsRed >= 15);

        do {
            try {
                System.out.println((startingPlayer.equals("player1") ? "player2" : "player1") + ": ");
                botsBlue = new Scanner(System.in).nextInt();

                if (botsBlue < 0 || botsBlue >= 15) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException ie) {
                System.out.println("Invalid input. Please enter a number equal to or greater than 0 and less than 15.");
            }
        } while (botsBlue < 0 || botsBlue >= 15);
    }

    /**
     * Initiates the game.
     *
     * @throws IOException if an I/O error occurs.
     */
    private void playGame() throws IOException {
        System.out.println("Playing game...");
        gameOptions();
        game = new Game(getMap(), flagRed, flagBlue, botsRed, botsBlue);
        game.start(startingPlayer);
    }
}