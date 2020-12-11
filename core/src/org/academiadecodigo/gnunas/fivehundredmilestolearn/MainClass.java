package org.academiadecodigo.gnunas.fivehundredmilestolearn;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.GameStateManager;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.MenuState;

public class MainClass extends ApplicationAdapter {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static final String title = "500 Miles to Learn";

	private GameStateManager gameStateManager;
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gameStateManager = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gameStateManager.push(new MenuState(gameStateManager));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
