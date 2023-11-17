package com.Jardim.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;

public class FadeScreen extends ScreenAdapter {

    private Interpolation fadeInterpolation;
    private float fadeDuration;

    public FadeScreen(Game game, FadeInfo fade, Screen screen, Screen next) {
        this.game = game;
        this.fade = fade;
        this.screen = screen;
        this.next = next;
        this.shapeRenderer = new ShapeRenderer();
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0f);
        this.camera.update();
    }

    public FadeScreen(Game game, FadeInfo fade, Jardim jardim, Start startScreenInstance, Interpolation fadeInterpolation, float fadeDuration) {
        this.game = game;
        this.fade = fade;
        this.screen = (Screen) jardim; // ou talvez screen = jardim, dependendo da lógica do seu código
        this.next = startScreenInstance;
        this.shapeRenderer = new ShapeRenderer();
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0f);
        this.camera.update();
    }

    public enum FadeType { IN, OUT }

    public static class FadeInfo {
        public final FadeType type;
        public final Color color;
        public final Interpolation interpolation;
        public final float duration;

        public FadeInfo(FadeType type, Color color, Interpolation interpolation, float duration) {
            this.type = type;
            this.color = color;
            this.interpolation = interpolation;
            this.duration = duration;
        }
    }

    private final FadeInfo fade;
    private Screen screen;
    private Screen next;
    private final Game game;
    private final ShapeRenderer shapeRenderer;
    private final OrthographicCamera camera;
    private float elapsed;

    private void renderFade() {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        float f = Math.min(1f, elapsed / fade.duration);
        float opacity = fade.type == FadeType.OUT ? fade.interpolation.apply(f) : 1f - fade.interpolation.apply(f);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(fade.color.r, fade.color.g, fade.color.b, opacity);
        shapeRenderer.rect(0, 0, camera.viewportWidth, camera.viewportHeight);
        shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
    }

    @Override
    public void render(float delta) {
        if (screen != null) {
            elapsed += delta;
            if (elapsed >= fade.duration) {
                if (next != null) {
                    game.setScreen(next);
                    screen.dispose();
                    screen = null;
                } else {
                    game.setScreen(screen);
                }
            }
        }
        Gdx.gl.glClearColor(0, 0, 0, 0);
        if (screen != null) screen.render(delta);
        renderFade();
    }
}
