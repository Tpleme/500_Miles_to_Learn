package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.Map;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.Questions;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.player.Car;

import java.util.LinkedList;
import java.util.List;


public class PlayState extends State {

    private BitmapFont questionText;
    private BitmapFont answerA;
    private BitmapFont answerB;
    private BitmapFont answerC;


    private String question;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String option1;
    private String option2;
    private String option3;

    List<String> options = new LinkedList<>();


    private Car car;
    private Map backGround;
    private Texture textBackground;


    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        car = new Car(400 - 35, 60);
        camera.setToOrtho(false, MainClass.WIDTH, MainClass.HEIGHT);
        backGround = new Map(0,0);

        generateText();
        question = getRandomQuestion();
        option1 = getRandomAnswer();
        option2 = getRandomAnswer();
        option3 = getRandomAnswer();

        textBackground = new Texture("images/TextBackground.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && car.getPosition().x < 500) {
            car.moveRight();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && car.getPosition().x > 230) {
            car.moveLeft();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        backGround.moveTile();
        car.update(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        spriteBatch.draw(backGround.getTileTexture(), backGround.getPosition().x, backGround.getPosition().y);
        spriteBatch.draw(car.getCarTexture(), car.getPosition().x, car.getPosition().y);
        spriteBatch.draw(textBackground, 100, -10);
        questionText.draw(spriteBatch, question, 110, 45);
        answerA.draw(spriteBatch, "A) " + option1, 110, 25);
        answerB.draw(spriteBatch, "B) " + option2, 300, 25);
        answerC.draw(spriteBatch, "C) " + option3, 500, 25);


        spriteBatch.end();
    }

    @Override
    public void dispose() {

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
    }

    private String getRandomAnswer() {

        String option = options.get((int)(Math.random() * options.size()));
        options.remove(option);

        return option;
    }

    private String getRandomQuestion() {

        Questions[] questions = Questions.values();

        Questions randomQuestion = questions[((int) (Math.random() * questions.length))];

        correctAnswer = randomQuestion.getCorrectAnswer();
        wrongAnswer1 = randomQuestion.getWrongAnswer1();
        wrongAnswer2 = randomQuestion.getWrongAnswer2();

        options.add(correctAnswer);
        options.add(wrongAnswer1);
        options.add(wrongAnswer2);

        return randomQuestion.getQuestion();
    }
}
