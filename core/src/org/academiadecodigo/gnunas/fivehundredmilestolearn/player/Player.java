package org.academiadecodigo.gnunas.fivehundredmilestolearn.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {


    private double gas = 50;
    private double miles = 0;

    public float speed = 120;
    private float turningSpeed = 150;

    private float timeSeconds = 0f;
    private float period = 1f;

    private final Sprite sprite;
    private Rectangle carRect;

    private final String actorName;

    public Player(Texture texture, final String actorName) {
        this.actorName = actorName;
        sprite = new Sprite(texture);

        sprite.setPosition((Gdx.graphics.getWidth() / 2) - (sprite.getWidth() / 2), 0);

        carRect = sprite.getBoundingRectangle();
    }

    private void move(float delta) {
        sprite.translateY(delta * speed);

        if(Gdx.input.isKeyJustPressed(Input.Keys.DPAD_LEFT) && sprite.getX() >= 300) {
            sprite.translateX(-turningSpeed);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DPAD_RIGHT) && sprite.getX() <= Gdx.graphics.getWidth() - 350) {
            sprite.translateX(turningSpeed);
        }

        carRect = sprite.getBoundingRectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        timeSeconds += Gdx.graphics.getDeltaTime();
        if(timeSeconds > period){
            timeSeconds -= period;
            gas --;
            miles += 2.5;
        }

        move(delta);
    }

    public Rectangle getCarRect() {
        return carRect;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public double getMiles() {
        return miles;
    }
}
