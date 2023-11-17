package com.Jardim.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Start implements Screen {
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;
    private Game game;
    private
    Image playButton;
    private Image title;
    private Drawable playButtonDrawable;
    private Drawable playButtonOverDrawable;

    //método construtor
    public Start(Game game) {
        this.game = game;
    }

    public Start() {

    }

    //método que inicializa os elementos da tela
    @Override
    public void show() {
        batch = new SpriteBatch();
        background = new Texture("jardim.jpg");
        stage = new Stage();
    }

    private void showQuestion(String questionText) {
        // Aqui você pode implementar a lógica de exibir a tela de pergunta
        // Por exemplo:
        // QuestionScreen questionScreen = new QuestionScreen(game, questionText);
        // game.setScreen(questionScreen);
        Gdx.app.log("Pergunta", questionText);
    }

    @Override
    public void render(float delta) {
        // Este método é chamado continuamente para renderizar a tela
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        // Adicione aqui a lógica de renderização específica da tela Start
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        // Este método é chamado quando a tela é redimensionada
    }

    @Override
    public void pause() {
        // Este método é chamado quando o jogo é pausado
    }

    @Override
    public void resume() {
        // Este método é chamado quando o jogo é retomado após estar pausado
    }

    @Override
    public void hide() {
        // Este método é chamado quando a tela não está mais visível
    }

    @Override
    public void dispose() {
        // Este método é chamado quando a tela é destruída
        batch.dispose();
        background.dispose();
    }
}
