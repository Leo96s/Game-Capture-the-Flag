/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms;

import Bot.Bot;
import Map.Location;
import Map.Map;

/**
 *
 * @author Leona
 */
public interface BotAlgorithm {
    Location calculateNextMove(Bot bot, Map map);
}
