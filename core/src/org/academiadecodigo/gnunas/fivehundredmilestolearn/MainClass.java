package org.academiadecodigo.gnunas.fivehundredmilestolearn;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.MainMenu;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.state.StateManager;

public class MainClass extends Game {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static final String title = "500 Miles to Learn";

	public static Music MainMenuMusic;
	public static Sound buttonClick;

	@Override
	public void create() {
		MainMenuMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/500milessmallcur.wav"));
		buttonClick = Gdx.audio.newSound(Gdx.files.internal("sounds/buttonClick.wav"));
		MainMenuMusic.play();
		StateManager stateManager = new StateManager();
		stateManager.setState(new MainMenu(stateManager, this));
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
