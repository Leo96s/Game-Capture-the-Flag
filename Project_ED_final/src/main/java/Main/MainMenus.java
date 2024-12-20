package Main;

import Menus.Menus;

import java.io.IOException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 *
 * Main Class of the program
 */
public class MainMenus {

    public static void main(String[] args) {
        Menus menu = new Menus();
        try {
            menu.mainProgram();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
