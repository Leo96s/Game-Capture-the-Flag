/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bot;

import Algorithms.BotAlgorithm;
import Map.Location;
import Map.Map;

/**
 *
 * @author Leona
 */
public class Bot {
    private Location location;
    private BotAlgorithm algorithm;

    public Bot(Location location, BotAlgorithm algorithm) {
        this.location = location;
        this.algorithm = algorithm;
    }

    public void move(Map map) {
        Location nextMove = algorithm.calculateNextMove(this, map);
        // Move the bot to the next location
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BotAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(BotAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
}
