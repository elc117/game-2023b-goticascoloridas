package com.terminalroot.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

public class Jardim extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;
    private Image playButton;
    private Image title;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("jardim.jpg");
        stage = new Stage();

        // Configuração da imagem do botão
        Drawable playButtonDrawable = new TextureRegionDrawable(new Texture("play.png"));

        // Configuração do botão
        playButton = new Image(playButtonDrawable);
        playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, 105);

        // Adiciona um ouvinte de clique à imagem
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Ao clicar no botão, inicia a tela Start
                Start startScreen = new Start();

                // Define a tela Start como a tela atual do jogo
                setScreen((Screen) startScreen);
            }
        });

        // Configuração da imagem do título
        Drawable titleDrawable = new TextureRegionDrawable(new Texture("LOGO.png"));

        // Configuração do título
        title = new Image(titleDrawable);
        // Calcula a posição vertical da logo movendo um pouco para cima
        title.setPosition(Gdx.graphics.getWidth() / 2 - title.getWidth() / 2, playButton.getY() + playButton.getHeight() + 280);

        // Adiciona as imagens ao palco
        stage.addActor(playButton);
        stage.addActor(title);

        // Configura o palco como o processador de entrada
        Gdx.input.setInputProcessor(stage);
    }

    private void setScreen(Screen screen) {
        // Obtém a instância do jogo
        Start game = (Start) Gdx.app.getApplicationListener();

        // Define a tela fornecida como a tela atual do jogo
        game.setScreen(screen);
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);

        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

        // Atualiza o palco e desenha os atores (imagens)
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        stage.dispose();
    }
}
