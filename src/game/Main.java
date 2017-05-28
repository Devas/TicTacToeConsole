package game;

import locale.Localization;
import models.HumanPlayer;
import models.Position2D;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        localeSettings();
        Position2D boardSize = boardSizeSettings();

        final HumanPlayer playerO = new HumanPlayer("o");
        final HumanPlayer playerX = new HumanPlayer("x");
        TicTacToeGame game = new TicTacToeGame(playerO, playerX, boardSize.getX(), boardSize.getY());
        game.setInitialTurnPlayerA(); // Player "O" plays first

        while (!game.isFinished()) {
            game.start();
        }

    }

    private static void localeSettings() {
        System.out.println("Locale settings");
        System.out.print("'E' English locale | 'P' Polish locale | Press key: ");
        Scanner s = new Scanner(System.in);
        String lang = s.next();
        switch (lang) {
            case "E":
                Localization.setENG();
                break;
            case "P":
                Localization.setPL();
                break;
            default:
                Localization.setENG();
        }
    }

    private static Position2D boardSizeSettings() {
        System.out.println("Board size settings");
        Scanner s = new Scanner(System.in);
        int x = 0;
        int y = 0;
        do {
            System.out.print("Set X board size: ");
            x = s.nextInt();
            System.out.print("Set Y board size: ");
            y = s.nextInt();
        } while (x < 1 || y < 1);
        return new Position2D(x, y);
    }

}
