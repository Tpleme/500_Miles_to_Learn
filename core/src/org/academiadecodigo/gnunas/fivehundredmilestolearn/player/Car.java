package org.academiadecodigo.gnunas.fivehundredmilestolearn.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Car {

    private static final int SPEED = 20;
    private Vector3 position;
    private Vector3 velocity;

    private Texture carTexture;

    public Car(int x, int y) {
        position = new Vector3(x, y, 0);
        //velocity = new Vector3(0,0,0);
        carTexture = new Texture("Car.png");
    }

    public void update(float dt) {
        //velocity.add(0, 0, 0);
        //velocity.scl(dt);
        position.add(0, 0, 0);

        //velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getCarTexture() {
        return carTexture;
    }

    public void moveRight() {
        position.x += 135;
    }

    public void moveLeft() {
        position.x -= 135;
    }
}
