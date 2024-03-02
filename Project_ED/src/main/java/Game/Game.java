/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

/**
 *
 * @author Leona
 */
import Bot.Bot;
import Map.Flag;
import Map.Map;
import Player.Player;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private Map map;
    private List<Flag> flags;
    private List<Bot> bots;

    public Game(Player player1, Player player2, Map map) {
        this.player1 = player1;
        this.player2 = player2;
        this.map = map;
        this.flags = new ArrayList<>();
        this.bots = new ArrayList<>();
    }

    public void initialize() {
        // Initialize flags and bots
    }

    public void start() {
        initialize();

        // Game loop
        while (!gameOver()) {
            // Alternate player turns
        }
    }

    private boolean gameOver() {
        // Check if a bot has reached the opponent's field
        return false;
    }

    public void addFlag(Flag flag) {
        flags.add(flag);
    }

    public void addBot(Bot bot) {
        bots.add(bot);
    }

    public Map getMap() {
        return map;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public List<Bot> getBots() {
        return bots;
    }
}
