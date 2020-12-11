package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;

public class InstructionsState extends State{

    private Texture background;
    private Texture instructionsMenu;
    private Texture playButton;
    private Texture goBackButton;

    public InstructionsState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("images/menu.png");
        instructionsMenu = new Texture("images/Instructions.png");
        playButton = new Texture("images/PlayButton.png");
        goBackButton = new Texture("images/QuitButton.png");
    }

    @Override
    public void handleInput() {

        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            gameStateManager.set(new PlayState(gameStateManager));
            dispose();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            gameStateManager.set(new MenuState(gameStateManager));
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
        spriteBatch.draw(instructionsMenu, 251, 135, 498, 331);
        spriteBatch.draw(playButton, 250 , 50);
        //spriteBatch.draw(instructionsButton,(MainClass.WIDTH / 2) - (playButton.getWidth() / 2) +100 , (MainClass.HEIGHT / 2) -100);
        spriteBatch.draw(goBackButton,550, 50);
        spriteBatch.end();

    }

    @Override
    public void dispose() {

    }
}
