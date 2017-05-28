package models;

import api.Game;

public abstract class AbstractGame implements Game {

    private boolean finished = false;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public abstract void start();

}
