package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.SoundLoader;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu extends AbstractState {

    private Texture texture;
    private Image backgroundImage;
    private Sound sound;

    private final Stage stage;

    public MainMenu() {
        stage = new Stage(new ScreenViewport());

        Label.LabelStyle titleStyle = new Label.LabelStyle();
        BitmapFont bitmapFont = new BitmapFont(Gdx.files.internal("fonts/Arial.fnt"));
        titleStyle.font = bitmapFont;
        titleStyle.fontColor = Color.BLACK;

        Label title = new Label("Main Menu", titleStyle);
        title.setPosition((Gdx.graphics.getWidth() / 2) - title.getFontScaleX(), (Gdx.graphics.getHeight() / 2) - title.getFontScaleY());
        title.setAlignment(Align.center);
        stage.addActor(title);

        texture = new Texture("badlogic.jpg");
        backgroundImage = new Image(texture);
        stage.addActor(backgroundImage);

        //sound = Gdx.audio.newSound(Gdx.files.internal(""));
        //sound.loop();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // TODO: Verify User Input to choose menu option

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
        texture.dispose();
        stage.dispose();
    }
}
