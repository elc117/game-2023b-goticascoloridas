package com.Jardim.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class QuestionScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;
    private Game game;
    private Drawable answerButtonDrawable;
    private Drawable answerButtonOverDrawable;
    private Image[] answerButtons;
    private Image question;

    public QuestionScreen(Game game, String questionText) {
        this.game = game;
    }

    public QuestionScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.app.log("QuestionScreen", "show() called");
        batch = new SpriteBatch();
        background = new Texture("question2.jpeg");
        stage = new Stage();

        // Configuração da imagem de pergunta
        Drawable questionDrawable = new TextureRegionDrawable(new Texture("pergunta.png"));

        // Configuração da pergunta
        question = new Image(questionDrawable);
        question.setPosition(Gdx.graphics.getWidth() / 2 - question.getWidth() / 2, Gdx.graphics.getHeight() / 2);

        // Adiciona a pergunta ao palco
        stage.addActor(question);

        // Configuração da imagem do botão
        answerButtonDrawable = new TextureRegionDrawable(new Texture("resposta.png"));
        answerButtonOverDrawable = new TextureRegionDrawable(new Texture("resposta2.png"));

        // Configuração do botão
        answerButtons = new Image[4];
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new Image(answerButtonDrawable);
            int row = i / 2; // 0 para os dois primeiros botões, 1 para os dois últimos
            int col = i % 2; // 0 para os botões da esquerda, 1 para os da direita
            answerButtons[i].setPosition(Gdx.graphics.getWidth() / 2 - answerButtons[i].getWidth() / 2 - 140 + col * (answerButtons[i].getWidth() + 10), question.getY() - (row + 1) * (answerButtons[i].getHeight() + 10));

            // Adiciona um ouvinte de clique à imagem
            answerButtons[i].addListener(new ClickListener() {
                @Override
                public void enter(InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor fromActor) {
                    ((Image) event.getTarget()).setDrawable(answerButtonOverDrawable);
                }

                @Override
                public void exit(InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor toActor) {
                    ((Image) event.getTarget()).setDrawable(answerButtonDrawable);
                }
            });

            // Adiciona as imagens ao palco
            stage.addActor(answerButtons[i]);
        }

        // Configura o palco como o processador de entrada
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        stage.dispose();
    }
}
