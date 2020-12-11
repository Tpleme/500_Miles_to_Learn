package org.academiadecodigo.gnunas.fivehundredmilestolearn.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Car {

    private Vector3 position;

    private Texture carTexture;
    private Sprite carSprite;
    private Rectangle rectangleCar;

    public Car(int x, int y) {
        position = new Vector3(x, y, 0);
        carTexture = new Texture("Car.png");
        carSprite = new Sprite(carTexture);
    }

    public void update(float dt) {
        position.add(0, 0, 0);

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getCarTexture() {
        return carTexture;
    }

    public void moveRight() {
        position.x += 135;
        rectangleCar.x += 135;
        rectangleCar = carSprite.getBoundingRectangle();
    }

    public void moveLeft() {
        position.x -= 135;
        rectangleCar.x -= 135;
        rectangleCar = carSprite.getBoundingRectangle();
    }

    public Rectangle getRectangleCar() {
        return rectangleCar;
    }
}
