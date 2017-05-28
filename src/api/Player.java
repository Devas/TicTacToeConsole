package api;

import java.util.List;

public interface Player {

    String getName();

    void setName(String name);

    Result getResult();

    default void addMove(Move move) {}

    default List<Move> getMoves() {
        return null;
    }

    default void resetMoves() {}

    default boolean hasMoved(Move move) {
        return false;
    }

}
