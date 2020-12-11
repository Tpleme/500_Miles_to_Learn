package org.academiadecodigo.gnunas.fivehundredmilestolearn.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.LinkedList;
import java.util.List;

public class Map extends Actor {

    private final Sprite sprite;

    private final String actorName;

    public Map(Texture texture, final String actorName) {
        this.actorName = actorName;
        sprite = new Sprite(texture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

}
