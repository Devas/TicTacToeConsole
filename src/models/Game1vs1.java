package models;

import api.Player;

public abstract class Game1vs1 extends AbstractGame {

    protected Player playerA;
    protected Player playerB;
    protected Player currentTurn;

    public Game1vs1(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    @Override
    public abstract void start();

    public Player getPlayerA() {
        return playerA;
    }

    public void setPlayerA(Player playerA) {
        this.playerA = playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setPlayerB(Player playerB) {
        this.playerB = playerB;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setInitialTurnPlayerA() {
        currentTurn = playerA;
    }

    public void setInitialTurnPlayerB() {
        currentTurn = playerB;
    }

    public Player nextTurn() {
        if (currentTurn.equals(playerA)) {
            currentTurn = playerB;
        } else {
            currentTurn = playerA;
        }
        return currentTurn;
    }

}
