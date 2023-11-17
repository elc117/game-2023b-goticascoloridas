package com.Jardim.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Arrays;
import java.util.List;

public class QuestionScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;
    private Game game;
    private String questionText;
    private Label questionLabel;
    private TextButton[] answerButtons;

    public QuestionScreen(Game game, String questionText) {
        this.game = game;
        this.questionText = questionText;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        background = new Texture("background_question.jpg"); // Substitua pelo seu background de pergunta
        stage = new Stage();

        // Configuração da label da pergunta
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/Gikany-Regular.fnt")); // Substitua pelo caminho correto do seu arquivo de fonte
        labelStyle.font = font;
        labelStyle.fontColor = Color.BLACK; // Cor do texto
        questionLabel = new Label(questionText, labelStyle);
        questionLabel.setAlignment(com.badlogic.gdx.utils.Align.center);

        // Configuração dos botões de alternativa
        TextButtonStyle buttonStyle = new TextButtonStyle();
        buttonStyle.font = font;
        buttonStyle.fontColor = Color.BLACK; // Cor do texto
        answerButtons = new TextButton[4];
        List<String> alternativas = Arrays.asList("Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa 4");

        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new TextButton(alternativas.get(i), buttonStyle);
            final int answerIndex = i;
            answerButtons[i].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    handleAnswerClicked(answerIndex);
                }
            });
        }

        // Adiciona os elementos ao palco
        Table table = new Table();
        table.setFillParent(true);
        table.center().top().padTop(100);
        table.add(questionLabel).expandX().center().padBottom(30).row();
        for (int i = 0; i < 4; i++) {
            table.add(answerButtons[i]).expandX().center().padBottom(20).row();
        }
        stage.addActor(table);

        // Configura o palco como o processador de entrada
        Gdx.input.setInputProcessor(stage);
    }

    private void handleAnswerClicked(int answerIndex) {
        // Aqui você pode implementar a lógica de verificar se a resposta está correta
        Gdx.app.log("Resposta", "Alternativa " + (answerIndex + 1) + " clicada");
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
