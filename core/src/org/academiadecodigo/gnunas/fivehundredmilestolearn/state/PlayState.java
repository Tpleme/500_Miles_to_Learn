package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.Map;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.player.Car;


import java.util.List;

public class PlayState extends State {

    private Car car;
    //private List<Map> backGround;
    private Map backGround;


    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        car = new Car(400 - 35, 25);
        camera.setToOrtho(false, MainClass.WIDTH, MainClass.HEIGHT);
        backGround = new Map(0,0);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && car.getPosition().x < 500) {
            car.moveRight();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && car.getPosition().x > 230) {
            car.moveLeft();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        backGround.moveTile();
        car.update(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        spriteBatch.draw(backGround.getTileTexture(), backGround.getPosition().x, backGround.getPosition().y);
        spriteBatch.draw(car.getCarTexture(), car.getPosition().x, car.getPosition().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
