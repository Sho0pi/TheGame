package com.shoopi.thegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.shoopi.thegame.TheGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = TheGame.WORLD_HEIGHT * 4;
        config.width = TheGame.WORLD_WIDTH * 4;
        new LwjglApplication(new TheGame(), config);
    }
}
