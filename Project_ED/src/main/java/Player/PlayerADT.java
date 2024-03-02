/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Player;

import Bot.Bot;
import Map.Map;
import java.util.List;

/**
 *
 * @author Leona
 */
public interface PlayerADT {
    void selectFlagLocation(Map map);

    void controlBots(List<Bot> bots);
}
