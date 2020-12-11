package org.academiadecodigo.gnunas.fivehundredmilestolearn;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Map {

    private Texture tileTexture;
    private Vector3 position;

    public Map(int x, int y) {
        tileTexture = new Texture("images/untitled1.png");
        position = new Vector3(x,y,0);
    }

    public void update(float dt) {
        position.add(0,0,0);
    }

    public void moveTile() {
        position.y -= 5;
    }

    public Texture getTileTexture() {
        return tileTexture;
    }

    public Vector3 getPosition() {
        return position;
    }
}
