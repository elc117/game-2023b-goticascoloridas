package com.terminalroot.game;

import com.Jardim.game.screens.Jardim;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Jardim");
		config.setWindowedMode(800, 800);

		Game myGame = new Game() {
			@Override
			public void create() {
				setScreen(new Jardim(this));
			}
		};

		new Lwjgl3Application(myGame, config);
	}
}
