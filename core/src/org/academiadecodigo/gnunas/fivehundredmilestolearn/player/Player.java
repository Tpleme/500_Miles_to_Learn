package org.academiadecodigo.gnunas.fivehundredmilestolearn.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {

    private final float speed = 1000;
    private int gas = 30;
    private int miles = 0;

    private final Sprite sprite;

    private final String actorName;

    public Player(Texture texture, final String actorName) {
        this.actorName = actorName;
        sprite = new Sprite(texture);
    }

    private void move(float delta) {
        //sprite.translateY(delta * speed);

        /*if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            sprite.translateX(- delta * speed);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
            sprite.translateX(delta * speed);
        }*/

        setPosition(sprite.getX(), sprite.getY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        move(delta);
    }
}
