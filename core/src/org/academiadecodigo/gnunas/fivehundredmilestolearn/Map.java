package org.academiadecodigo.gnunas.fivehundredmilestolearn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.LinkedList;
import java.util.List;

public class Map {

    private final Texture[] textures;
    private final Texture texture;
    private Vector3 position;

    public Map(int x, int y) {
        textures = new Texture[]{
                new Texture("images/untitled1.png"),
                new Texture("images/untitled2.png"),
                new Texture("images/untitled3.png"),
                new Texture("images/untitled4.png"),
                new Texture("images/untitled5.png"),
                new Texture("images/untitled6.png"),
        };

        texture = textures[(int)(Math.random() * textures.length)];

        position = new Vector3(x, y,0);
    }

    public void moveTile() {
        position.y -= 5;
    }

    public Texture getTileTexture() {
        return texture;
    }

    public Vector3 getPosition() {
        return position;
    }

}
