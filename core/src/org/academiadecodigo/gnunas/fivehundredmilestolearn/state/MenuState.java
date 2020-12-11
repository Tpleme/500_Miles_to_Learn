package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;

public class MenuState extends State {

    private Texture background;
    private Texture playButton;

     public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("menu.png");
        playButton = new Texture("PlayButton.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gameStateManager.set(new PlayState(gameStateManager));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, MainClass.WIDTH, MainClass.HEIGHT);
        spriteBatch.draw(playButton, (MainClass.WIDTH / 2) - (playButton.getWidth() / 2) , MainClass.HEIGHT / 2);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
