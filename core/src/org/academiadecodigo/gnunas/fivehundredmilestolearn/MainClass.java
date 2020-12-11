package org.academiadecodigo.gnunas.fivehundredmilestolearn;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.AbstractState;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.Play;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.StateList;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.StateManager;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.GameStateManager;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.MenuState;

public class MainClass extends Game {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static final String title = "500 Miles to Learn";

	@Override
	public void create() {
		StateManager stateManager = new StateManager();
		stateManager.setState(new Play(this));
		this.setScreen(stateManager.getState());
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		super.render();
	}
}
