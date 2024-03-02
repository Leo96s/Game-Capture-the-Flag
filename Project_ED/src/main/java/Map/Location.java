/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Map;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leona
 */
public class Location {
    private int x;
    private int y;
    private List<Location> connections;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.connections = new ArrayList<>();
    }

    public void addConnection(Location location) {
        connections.add(location);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Location> getConnections() {
        return connections;
    }
}
