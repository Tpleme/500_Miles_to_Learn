package org.academiadecodigo.gnunas.fivehundredmilestolearn;

import com.badlogic.gdx.Game;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.Play;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.StateManager;

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
