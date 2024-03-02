/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Game.Game;
import java.io.IOException;
import java.util.Scanner;

public class Menus {

    private Game game;

    public Menus() {
    }

    public void mainMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---------------------------------------------");
            System.out.println("Main Menu");
            System.out.println("1. Start Game");
            System.out.println("2. Load Game");
            System.out.println("3. Exit");
            System.out.println("---------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startNewGame();
                    break;
                case 2:
                    loadGame();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }

    private void startNewGame() throws IOException {
        System.out.println("Starting a new game...");

        gameOptions();

        gameLoop();
    }

    private void loadGame() throws IOException {
        System.out.println("Loading game...");

        gameLoop();
    }

    private void gameLoop() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---------------------------------------------");
            System.out.println("Game Menu");
            System.out.println("1. Play");
            System.out.println("2. Save Game");
            System.out.println("3. Quit");
            System.out.println("---------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playGame();
                    break;
                case 2:
                    saveGame();
                    break;
                case 3:
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }

    private void gameOptions() throws IOException {
        boolean flag = false, bot = false;
        int choice;

        do {
        if (!flag || !bot) {
            System.out.println("You haven't completed the game options!");
        }
        System.out.println("---------------------------------------------");
        System.out.println("Game Options");
        System.out.println("1. Choose the location of flag");
        System.out.println("2. Choose number of bots to play");
        System.out.println("3. Quit");
        System.out.println("---------------------------------------------");
        System.out.print("Enter your choice: ");
        choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                chooseFlag();
                flag = true;
                break;
            case 2:
                numberBots();
                bot = true;
                break;
            case 3:
                if (flag && bot) {
                    System.out.println("Quitting...");
                } else {
                    System.out.println("You need to complete both flag and bot options!");
                    choice = -1; // Continue o loop, já que a escolha é inválida
                }
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
    } while (choice != 3 || !flag || !bot);
}

    private void chooseFlag() throws IOException {
        System.out.println("Choose the locations of flag player");
        int locationFlag = new Scanner(System.in).nextInt();
        // Game logic and user input handling
    }

    private void numberBots() throws IOException {
        System.out.println("Choose the number of bots for both players");
        int numberOfBots = new Scanner(System.in).nextInt();
        // Game logic and user input handling
    }

    private void playGame() throws IOException {
        System.out.println("Playing game...");
        // Game logic and user input handling
    }

    private void saveGame() throws IOException {
        System.out.println("Saving game...");
        // Save game objects to a file or database
    }
}
