package com.Jardim.game;

import com.badlogic.gdx.graphics.Texture;

public class AssetUtils {
    public static Texture playButton;
    public static Texture playButtonHighlight;
    public static Texture title;
    public static Texture backgroundMenu;

    private AssetUtils() {
    }

    public static void initAssets() {
        loadAssets();
    }

    private static void loadAssets() {
        playButton = new Texture("play.png");
        playButtonHighlight = new Texture("play2.png");
        title = new Texture("logo.png");
        backgroundMenu = new Texture("jardim.jpg");
    }
}