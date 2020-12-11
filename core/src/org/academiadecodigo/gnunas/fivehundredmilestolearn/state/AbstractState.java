package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Screen;

public abstract class AbstractState implements Screen {

    protected StateManager stateManager;

    public AbstractState(StateManager stateManager) {
        this.stateManager = stateManager;
    }
}
