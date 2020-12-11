package org.academiadecodigo.gnunas.fivehundredmilestolearn.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.player.Player;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Map extends Actor {

    private Array<Sprite> sprites;

    private Texture[] textures;

    private final String actorName;

    private Player player;

    private int posY = 0;

    private Sprite optionA;
    private Sprite optionB;
    private Sprite optionC;

    Rectangle optionARect;
    Rectangle optionBRect;
    Rectangle optionCRect;

    public Map(final String actorName, Player player) {
        this.player = player;
        this.actorName = actorName;
        sprites = new Array<>();

        optionA = new Sprite(new Texture("images/AnswerA.png"));
        optionB = new Sprite(new Texture("images/AnswerB.png"));
        optionC = new Sprite(new Texture("images/AnswerC.png"));

        optionARect = optionA.getBoundingRectangle();
        optionBRect = optionB.getBoundingRectangle();
        optionCRect = optionC.getBoundingRectangle();

        textures = new Texture[]{new Texture("images/untitled1.png"),
                new Texture("images/untitled2.png"),
                new Texture("images/untitled3.png"),
                new Texture("images/untitled4.png"),
                new Texture("images/untitled5.png"),
                new Texture("images/untitled6.png")
        };


        optionA.setPosition(250, Gdx.graphics.getHeight() - 50);
        optionB.setPosition(380, Gdx.graphics.getHeight() - 50);
        optionC.setPosition(535, Gdx.graphics.getHeight() - 50);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Sprite sprite : sprites) {
            sprite.draw(batch);
        }

        optionA.draw(batch);
        optionB.draw(batch);
        optionC.draw(batch);
    }

    @Override
    public void act(float delta) {
        if (sprites.size <= 5) {
            Sprite sprite = new Sprite(textures[(int)(Math.random() * textures.length - 1)]);
            sprite.setPosition(0, posY);

            sprites.add(sprite);

            posY += 600;
        }

        optionARect = optionA.getBoundingRectangle();
        optionBRect = optionB.getBoundingRectangle();
        optionCRect = optionC.getBoundingRectangle();

        if (player.getSprite().getY() >= sprites.first().getY() + 1000) {
            sprites.removeIndex(0);
        }
    }

    public Rectangle getOptionARect() {
        return optionARect;
    }

    public Rectangle getOptionBRect() {
        return optionBRect;
    }

    public Rectangle getOptionCRect() {
        return optionCRect;
    }

    public Sprite getOptionA() {
        return optionA;
    }

    public Sprite getOptionB() {
        return optionB;
    }

    public Sprite getOptionC() {
        return optionC;
    }
}
