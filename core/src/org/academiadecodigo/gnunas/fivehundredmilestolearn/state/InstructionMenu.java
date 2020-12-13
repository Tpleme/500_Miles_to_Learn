package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;

public class InstructionMenu extends AbstractState {

    private Game game;

    private Texture background;
    private Texture instructionsMenu;
    private Texture playButton;
    private Texture goBackButton;

    private SpriteBatch spriteBatch;


    public InstructionMenu(StateManager stateManager, Game game) {
        super(stateManager);
        this.stateManager = stateManager;
        this.game = game;

        spriteBatch = new SpriteBatch();

        background = new Texture("images/menu.png");
        instructionsMenu = new Texture("images/Instructions.png");
        playButton = new Texture("images/PlayButton.png");
        goBackButton = new Texture("images/MenuButton.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.J)) {
            MainClass.buttonClick.play();
            MainClass.MainMenuMusic.stop();
            MainClass.MainMenuMusic.dispose();
            stateManager.setState(new Play(stateManager, game));
            game.setScreen(stateManager.getState());
            dispose();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            MainClass.buttonClick.play();
            stateManager.setState(new MainMenu(stateManager, game));
            game.setScreen(stateManager.getState());
            dispose();
        }

        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, MainClass.WIDTH, MainClass.HEIGHT);
        spriteBatch.draw(instructionsMenu, 251, 135, 498, 331);
        spriteBatch.draw(playButton, 250, 50);
        spriteBatch.draw(goBackButton, 550, 50);
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
        spriteBatch.dispose();
    }
}
