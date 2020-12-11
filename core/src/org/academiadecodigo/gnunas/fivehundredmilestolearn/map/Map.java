package org.academiadecodigo.gnunas.fivehundredmilestolearn.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.player.Player;

import java.util.LinkedList;
import java.util.List;

public class Map extends Actor {

    private Array<Sprite> sprites;

    private Texture[] textures;

    private final String actorName;

    private Player player;

    private int posY = 0;

    public Map(final String actorName, Player player) {
        this.player = player;
        this.actorName = actorName;
        sprites = new Array<>();

        textures = new Texture[]{new Texture("images/untitled1.png"),
                new Texture("images/untitled2.png"),
                new Texture("images/untitled3.png"),
                new Texture("images/untitled4.png"),
                new Texture("images/untitled5.png"),
                new Texture("images/untitled6.png")
        };
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Sprite sprite : sprites) {
            sprite.draw(batch);
        }
    }

    @Override
    public void act(float delta) {
        if (sprites.size <= 5) {
            Sprite sprite = new Sprite(textures[(int)(Math.random() * textures.length - 1)]);
            sprite.setPosition(0, posY);

            sprites.add(sprite);

            posY += 600;
        }

        if (player.getSprite().getY() >= sprites.first().getY() + 1000) {
            sprites.removeIndex(0);
        }
    }

}
