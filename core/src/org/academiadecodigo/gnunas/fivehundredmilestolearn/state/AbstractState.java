package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractState implements Screen {

    protected StateManager stateManager;

    public AbstractState(StateManager stateManager) {
        this.stateManager = stateManager;
    }
}
