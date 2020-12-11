package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.Map;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.player.Car;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PlayState extends State {

    private Car car;
    private Array<Map> backgrounds;

    //private Map background;

    private int y;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        car = new Car(400 - 35, 25);
        camera.setToOrtho(false, MainClass.WIDTH, MainClass.HEIGHT);
        backgrounds = new Array<>();
        //background = new Map(0,0);

        y = 0;
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

        while (backgrounds.size <= 5) {
            backgrounds.add(new Map(0, y));

            y = (int)backgrounds.get(0).getPosition().y + 600;
        }

        for (Map map : backgrounds) {
            //map.moveTile();

            if (map.getPosition().y <= -600) {
                backgrounds.removeIndex(0);
                //map.getTileTexture().dispose();
            }

            //map.moveTile();
        }

        //background.moveTile();

        car.update(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();

        for (Map map : backgrounds) {
            spriteBatch.draw(map.getTileTexture(), map.getPosition().x, map.getPosition().y);
        }

        //spriteBatch.draw(background.getTileTexture(), background.getPosition().x, background.getPosition().y);

        spriteBatch.draw(car.getCarTexture(), car.getPosition().x, car.getPosition().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
