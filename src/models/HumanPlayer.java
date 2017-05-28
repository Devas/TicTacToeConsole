package models;

import api.Move;
import api.Player;
import api.Result;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer implements Player, Comparable<HumanPlayer> {

    private String name;

    private Result result = new InMemoryResult();
    private List<Move> moves = new ArrayList<>();

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Result getResult() {
        return result;
    }

    @Override
    public void addMove(Move move) {
        moves.add(move);
    }

    @Override
    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public void resetMoves() {
        moves.clear();
    }

    @Override
    public boolean hasMoved(Move move) {
        for (Move m : moves) {
            if (m.equals(move)) return true;
        }
        return false;
    }

    @Override
    public int compareTo(HumanPlayer o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Player: " + name + " Score: " + result.getScore();
    }

}
