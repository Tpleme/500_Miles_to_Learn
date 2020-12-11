package org.academiadecodigo.gnunas.fivehundredmilestolearn;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import javax.xml.soap.Text;

public class Map {

    private float speed = 1f;

    private Texture tileTexture;
    private Vector3 position;

    private Sprite spriteA;
    private Sprite spriteB;
    private Sprite spriteC;

    private Rectangle rectA;
    private Rectangle rectB;
    private Rectangle rectC;

    public Map(int x, int y) {

        tileTexture = new Texture("images/untitled1.png");
        position = new Vector3(x,y,0);

        spriteA = new Sprite(new Texture("images/AnswerA.png"));
        spriteA.setPosition(230, 400);

        spriteB = new Sprite(new Texture("images/AnswerB.png"));
        spriteB.setPosition(365, 400);

        spriteC = new Sprite(new Texture("images/AnswerC.png"));
        spriteC.setPosition(500, 400);

    }

    public void update(float dt) {
        position.add(0,0,0);
    }

    public void moveTile() {
        position.y -= speed;
        spriteC.setY(spriteC.getY() - speed);
        spriteB.setY(spriteB.getY() - speed);
        spriteA.setY(spriteA.getY() - speed);

        rectA = spriteA.getBoundingRectangle();
        rectB = spriteB.getBoundingRectangle();
        rectC = spriteC.getBoundingRectangle();
    }

    public Texture getTileTexture() {
        return tileTexture;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void renderTextures(SpriteBatch spriteBatch) {

        spriteA.draw(spriteBatch);
        spriteB.draw(spriteBatch);
        spriteC.draw(spriteBatch);
    }

    public Rectangle getRectA() {
        return rectA;
    }

    public Rectangle getRectB() {
        return rectB;
    }

    public Rectangle getRectC() {
        return rectC;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Sprite getSpriteA() {
        return spriteA;
    }

    public Sprite getSpriteB() {
        return spriteB;
    }

    public Sprite getSpriteC() {
        return spriteC;
    }
}
