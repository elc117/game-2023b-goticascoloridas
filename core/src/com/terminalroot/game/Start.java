package com.terminalroot.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Start extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture background;
    private Stage stage;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("jardim.jpg");
        stage = new Stage();
    }

    @Override
    public void render() {
        // Limpa a tela
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

        // Desenha o background
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }

    public void setScreen(Screen screen) {
    }
}
