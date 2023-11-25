package com.Jardim.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class MyLabel {
    private Label label;

    public MyLabel(String text, float x, float y) {
        // Cria uma nova fonte BitmapFont
        BitmapFont font = new BitmapFont(Gdx.files.internal("font.fnt"));

        // Cria um novo estilo de rótulo
        LabelStyle style = new LabelStyle();
        style.font = font;
        style.fontColor = Color.WHITE;

        // Cria um novo rótulo com o texto e estilo especificados
        label = new Label(text, style);

        // Define a posição do rótulo
        label.setPosition(x, y);
    }

    public Label getLabel() {
        return label;
    }
}

