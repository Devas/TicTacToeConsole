package game;

import api.Move;
import api.Player;
import models.*;

import java.util.Scanner;

/**
 * If player wins the x or o is upper-cased to X or O
 */
public class TicTacToeGame extends Game1vs1 {

    private ConsoleBoard board;
    private static int turn = 1;

    public TicTacToeGame(Player playerA, Player playerB, int sizeX, int sizeY) {
        super(playerA, playerB);
        board = new ConsoleBoard(sizeX, sizeY);
    }

    @Override
    public void start() {
        while (!isFinished()) {
            runSingleTurn();
        }
    }

    @SuppressWarnings("Duplicates")
    private void runSingleTurn() {
        System.out.println("\n*** Turn " + turn + " ***");
        System.out.println(playerA + " | " + playerB);
        Position2D position = handleInputCoords();
        BoardMove playersMove = new BoardMove(position);
        getCurrentTurn().addMove(playersMove);
        board.setValueAt(playersMove.getPosition(), getCurrentTurn().getName());
        TurnStatus turnStatus = board.checkAll(getCurrentTurn().getName());
        board.draw();
        if (turnStatus.equals(TurnStatus.WON)) {
            getCurrentTurn().getResult().incScore();
            System.out.println("Wins player: " + getCurrentTurn().getName() + " | " + playerA + " | " + playerB);
            askNewGame();
        }
        if (turn == board.getArea()) {
            System.out.println("It's a draw! | " + getCurrentTurn().getName() + " | " + playerA + " | " + playerB);
            askNewGame();
        }
        nextTurn();
        turn++;
    }

    /**
     * Uncomment nextTurn() to always use the same initial player or comment to swap initial player in every game
     */
    private void askNewGame() {
        playerA.resetMoves();
        playerB.resetMoves();
        System.out.print("\nWanna play again? 'N' for no, other key for yes: ");
        Scanner s = new Scanner(System.in);
        if (s.next().equalsIgnoreCase("n")) {
            setFinished(true);
        } else {
            setFinished(false);
            board.reset();
            turn = 0;
//                nextTurn();
        }
    }

    /**
     * Handles moves and asks to press inpu again if move is out of board or a move has been done already
     */
    private Position2D handleInputCoords() {
        Scanner s = new Scanner(System.in);
        System.out.println("Now plays: " + currentTurn.getName());
        int x = 0;
        int y = 0;
        Move move;
        do {
            System.out.print("Press X coordinate (starting from 1): ");
            x = s.nextInt() - 1;
            System.out.print("Press Y coordinate (starting from 1): ");
            y = s.nextInt() - 1;
            move = new BoardMove(new Position2D(x, y));
        }
        while (x < 0 || y < 0 || x >= board.getSixeX() || y >= board.getSixeY() || playerA.hasMoved(move) || playerB.hasMoved(move));
        return new Position2D(x, y);
    }

}
