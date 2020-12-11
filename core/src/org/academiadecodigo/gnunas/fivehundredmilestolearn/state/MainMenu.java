package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.loaders.SoundLoader;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;

public class MainMenu extends AbstractState {

    private Texture background;
    private Texture playButton;
    private Texture instructionsButton;
    private Texture quitButton;
    private Game game;
    private SpriteBatch spriteBatch;
    private StateManager stateManager;

    public MainMenu(StateManager stateManager, Game game) {
        super(stateManager);
        this.stateManager = stateManager;
        this.game = game;

        spriteBatch = new SpriteBatch();
        background = new Texture("images/menu.png");
        playButton = new Texture("images/PlayButton.png");
        instructionsButton = new Texture("images/InstructionsButton.png");
        quitButton = new Texture("images/QuitButton.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if(Gdx.input.isKeyJustPressed(Input.Keys.J)){
            stateManager.setState(new Play(stateManager, game));
            game.setScreen(stateManager.getState());
            dispose();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.I)){
            stateManager.setState(new InstructionMenu(stateManager, game));
            game.setScreen(stateManager.getState());
            dispose();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            System.exit(0);
        }

        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, MainClass.WIDTH, MainClass.HEIGHT);
        spriteBatch.draw(playButton, (MainClass.WIDTH / 2) - (playButton.getWidth() / 2) + 100 , MainClass.HEIGHT / 2);
        spriteBatch.draw(instructionsButton,(MainClass.WIDTH / 2) - (playButton.getWidth() / 2) +100 , (MainClass.HEIGHT / 2) -100);
        spriteBatch.draw(quitButton,(MainClass.WIDTH / 2) - (playButton.getWidth() / 2) +100 , (MainClass.HEIGHT / 2) -200);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        instructionsButton.dispose();
        quitButton.dispose();
    }
}
