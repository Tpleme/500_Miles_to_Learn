package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;

public class MenuState extends State {

    private Texture background;
    private Texture playButton;
    private Texture instructionsButton;
    private Texture quitButton;
    private Music entrySound = Gdx.audio.newMusic(Gdx.files.internal("sounds/500milessmallcur.wav"));

     public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("images/menu.png");
        playButton = new Texture("images/PlayButton.png");
        instructionsButton = new Texture("images/InstructionsButton.png");
        quitButton = new Texture("images/QuitButton.png");

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gameStateManager.set(new PlayState(gameStateManager));
            entrySound.stop();
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
        entrySound.play();
        spriteBatch.draw(background, 0, 0, MainClass.WIDTH, MainClass.HEIGHT);
        spriteBatch.draw(playButton, (MainClass.WIDTH / 2) - (playButton.getWidth() / 2) + 100 , MainClass.HEIGHT / 2);
        spriteBatch.draw(instructionsButton,(MainClass.WIDTH / 2) - (playButton.getWidth() / 2) +100 , (MainClass.HEIGHT / 2) -100);
        spriteBatch.draw(quitButton,(MainClass.WIDTH / 2) - (playButton.getWidth() / 2) +100 , (MainClass.HEIGHT / 2) -200);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
