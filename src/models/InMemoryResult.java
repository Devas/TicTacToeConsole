package models;

import api.Result;

/**
 * Represents results stored as objects
 */
public class InMemoryResult implements Result, Comparable<InMemoryResult> {

    private int score;

    public InMemoryResult() {
        this.score = 0;
    }

    public InMemoryResult(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void incScore() {
        score++;
    }

    @Override
    public void decScore() {
        score--;
    }

    @Override
    public void resetScore() {
        score = 0;
    }

    @Override
    public String toString() {
        return "InMemoryResult{" +
                "score=" + score +
                '}';
    }

    @Override
    public int compareTo(InMemoryResult o) {
        if (score > o.score)
            return 1;
        else if (score < o.score)
            return -1;
        else
            return 0;
    }

}
