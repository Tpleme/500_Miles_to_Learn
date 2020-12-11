package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.map.Map;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.player.Player;

public class Play extends AbstractState {

    private Game game;
    private Stage stage;
    private Viewport viewport;
    private AssetManager manager;

    private Player player;
    private Map map;

    private OrthographicCamera camera;

    public Play(Game game) {
        this.game = game;
        manager = new AssetManager();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();

        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(stage);

        loadAssets();

        player = new Player(manager.<Texture>get("Car.png"), "Player");
        map = new Map("Map", player);

        stage.addActor(map);
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.set((Gdx.graphics.getWidth() / 2), player.getSprite().getY() + 250, 0);
        camera.update();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }


    private void loadAssets() {
        manager.load("Car.png", Texture.class);
        manager.load("images/untitled1.png", Texture.class);

        manager.finishLoading();
    }
}
