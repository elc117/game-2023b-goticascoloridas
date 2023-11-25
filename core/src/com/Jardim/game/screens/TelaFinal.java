package com.Jardim.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class TelaFinal extends ScreenAdapter {
    private SpriteBatch batch;
    private Texture background;
    private Texture fimTexture; // Adicione esta linha
    private Texture resultadoTexture; // Adicione esta linha
    private Stage stage;
    private Game game;
    private BitmapFont font;
    private int correctAnswers;

    public TelaFinal(Game game, int correctAnswers){
        this.game = game;
        this.correctAnswers = correctAnswers;
    }

    public TelaFinal(Game game) {
    }

    public void show(){
        Gdx.app.log("TelaFinal", "show() called");
        batch = new SpriteBatch();
        background = new Texture("final.jpeg");
        fimTexture = new Texture("fim.png");
        resultadoTexture = new Texture("resultado.png");
        font = new BitmapFont(); // Inicialize a fonte aqui
        stage = new Stage();
    }


    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(resultadoTexture, Gdx.graphics.getWidth() / 2 - resultadoTexture.getWidth() / 2, Gdx.graphics.getHeight() / 2 - resultadoTexture.getHeight() / 2);
        batch.draw(fimTexture, Gdx.graphics.getWidth() / 2 - fimTexture.getWidth() / 2, Gdx.graphics.getHeight() / 2 + resultadoTexture.getHeight() / 2);
        if (correctAnswers > 2) {
            font.draw(batch, "Parabéns, você foi bem", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        } else {
            font.draw(batch, "Sinto muito, você foi mal", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        fimTexture.dispose();
        resultadoTexture.dispose();
        font.dispose(); // Adicione esta linha
    }


}
