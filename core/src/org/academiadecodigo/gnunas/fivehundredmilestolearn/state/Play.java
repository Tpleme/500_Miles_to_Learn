package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.Questions;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.map.Map;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.player.Player;

import java.util.LinkedList;
import java.util.List;

public class Play extends AbstractState {

    private BitmapFont questionText;
    private BitmapFont answerA;
    private BitmapFont answerB;
    private BitmapFont answerC;

    private BitmapFont gasText;
    private BitmapFont milesText;


    private String question;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String option1;
    private String option2;
    private String option3;

    private Texture textBackground;
    private Music playMusic;
    private Sound correctSound;

    List<String> options = new LinkedList<>();

    private Game game;
    private Stage stage;
    private Viewport viewport;
    private AssetManager manager;

    private SpriteBatch spriteBatch;

    private Player player;
    private Map map;

    private OrthographicCamera camera;

    public Play(StateManager stateManager, Game game) {
        super(stateManager);
        this.game = game;
        manager = new AssetManager();
        spriteBatch = new SpriteBatch();

        generateText();

        textBackground = new Texture("images/TextBackground.png");
        playMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/500milesbigcut.wav"));
        correctSound = Gdx.audio.newSound(Gdx.files.internal("sounds/correctAnswer.wav"));
    }

    @Override
    public void show() {
        playMusic.play();
        camera = new OrthographicCamera();

        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(stage);

        loadAssets();

        player = new Player(manager.<Texture>get("Car.png"), "Player");
        map = new Map("Map", player);

        getNewQuestionAndAnswer();

        stage.addActor(map);
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        detectCollisions();

        camera.position.set((Gdx.graphics.getWidth() / 2), player.getSprite().getY() + 250, 0);
        camera.update();

        stage.act(delta);
        stage.draw();

        spriteBatch.begin();

        spriteBatch.draw(textBackground, 100, -10);

        questionText.draw(spriteBatch, question, 110, 45);

        answerA.setColor(Color.MAGENTA);
        answerB.setColor(Color.BLUE);
        answerC.setColor(Color.RED);

        answerA.draw(spriteBatch, "A) " + option1, 110, 25);
        answerB.draw(spriteBatch, "B) " + option2, 300, 25);
        answerC.draw(spriteBatch, "C) " + option3, 500, 25);

        gasText.draw(spriteBatch, "Gasolina: " + player.getGas(), 50, 550);
        milesText.draw(spriteBatch, "Milhas: " + player.getMiles(), 50, 526);

        spriteBatch.end();
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
        playMusic.stop();
        stage.dispose();
    }


    private void loadAssets() {
        manager.load("Car.png", Texture.class);
        manager.load("images/untitled1.png", Texture.class);

        manager.finishLoading();
    }

    private void generateText() {
        questionText = new BitmapFont();
        questionText.setColor(Color.BLACK);

        answerA = new BitmapFont();
        answerB = new BitmapFont();
        answerC = new BitmapFont();

        answerA.setColor(Color.BLACK);
        answerB.setColor(Color.BLACK);
        answerC.setColor(Color.BLACK);

        gasText = new BitmapFont();
        milesText = new BitmapFont();

    }

    private String getRandomAnswer() {

        String option = options.get((int) (Math.random() * options.size()));
        options.remove(option);

        return option;
    }

    private String getRandomQuestion() {

        Questions[] questions = Questions.values();

        Questions randomQuestion = questions[((int) (Math.random() * questions.length))];

        correctAnswer = randomQuestion.getCorrectAnswer().toLowerCase();
        wrongAnswer1 = randomQuestion.getWrongAnswer1();
        wrongAnswer2 = randomQuestion.getWrongAnswer2();

        options.add(correctAnswer);
        options.add(wrongAnswer1);
        options.add(wrongAnswer2);

        return randomQuestion.getQuestion();
    }

    private void detectCollisions() {

        if (player.getCarRect().overlaps(map.getOptionARect())) {
            if (correctAnswer.equals(option1)) {
                correctSound.play();
                player.setGas(player.getGas() + 10);
                getNewQuestionAndAnswer();
                return;
            }

            player.setGas(player.getGas() - 10);
            getNewQuestionAndAnswer();
            return;
        }

        if (player.getCarRect().overlaps(map.getOptionBRect())) {
            if (correctAnswer.equals(option2)) {
                correctSound.play();
                player.setGas(player.getGas() + 10);
                getNewQuestionAndAnswer();
                return;
            }
            player.setGas(player.getGas() - 10);
            getNewQuestionAndAnswer();
            return;
        }

        if (player.getCarRect().overlaps(map.getOptionCRect())) {
            if (correctAnswer.equals(option3)) {
                correctSound.play();
                player.setGas(player.getGas() + 10);
                getNewQuestionAndAnswer();
                return;
            }
            player.setGas(player.getGas() - 10);
            getNewQuestionAndAnswer();
        }

        if (player.getGas() <= 0) {
            stateManager.setState(new End(stateManager, game, false));
            game.setScreen(stateManager.getState());
            dispose();
        }

        if (player.getGas() >= 500) {
            stateManager.setState(new End(stateManager, game, true));
            game.setScreen(stateManager.getState());
            dispose();
        }
    }

    private void getNewQuestionAndAnswer() {

        map.getOptionA().setY(map.getOptionA().getY() + 520);
        map.getOptionB().setY(map.getOptionB().getY() + 520);
        map.getOptionC().setY(map.getOptionC().getY() + 520);

        question = getRandomQuestion();

        option1 = getRandomAnswer().toLowerCase();
        option2 = getRandomAnswer().toLowerCase();
        option3 = getRandomAnswer().toLowerCase();
    }
}
