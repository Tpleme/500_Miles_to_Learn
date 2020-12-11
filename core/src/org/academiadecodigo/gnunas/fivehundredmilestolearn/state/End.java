package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class End extends AbstractState {

    private Game game;
    private boolean win;

    private Texture winBackground;
    private Texture loseBackground;
    private Texture winTexture;
    private Texture lostTexture;
    private Texture car;

    private Texture losePlayButton;
    private Texture loseQuitButton;

    private Texture winPlayButton;
    private Texture winQuitButton;

    private SpriteBatch spriteBatch;

    public End(StateManager stateManager, Game game, boolean win) {
        super(stateManager);
        this.game = game;
        this.win = win;
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void show() {
        losePlayButton = new Texture("images/PlayButton.png");
        loseQuitButton = new Texture("images/MenuButton.png");

        winPlayButton = new Texture("images/PlayButton.png");
        winQuitButton = new Texture("images/MenuButton.png");

        car = new Texture("Car.png");

    }

    @Override
    public void render(float delta) {

        handleInput();
        spriteBatch.begin();

        if (win) {
            winBackground = new Texture("images/untitledEND.png");
            winTexture = new Texture("images/Ganhaste.png");
            spriteBatch.draw(winBackground, 0, 0);
            spriteBatch.draw(winTexture, 130, 20);

            spriteBatch.draw(winPlayButton, 65, 400);
            spriteBatch.draw(winQuitButton, 550, 400);

        } else {
            loseBackground = new Texture("images/untitled5.png");
            lostTexture = new Texture("images/Perdeste.png");
            spriteBatch.draw(loseBackground, 0, 0);
            spriteBatch.draw(lostTexture, 150, 20);

            spriteBatch.draw(losePlayButton, 160, 400);
            spriteBatch.draw(loseQuitButton, 450, 400);
        }

        spriteBatch.draw(car, 360, 140);

        spriteBatch.end();
    }

    private void handleInput() {

        if(Gdx.input.isKeyJustPressed(Input.Keys.J)){
            stateManager.setState(new Play(stateManager, game));
            game.setScreen(stateManager.getState());
            dispose();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
            stateManager.setState(new MainMenu(stateManager, game));
            game.setScreen(stateManager.getState());
            dispose();
        }
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

    }
}
