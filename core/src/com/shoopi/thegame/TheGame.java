package com.shoopi.thegame;

import com.badlogic.gdx.Game;
import com.shoopi.thegame.screens.StartScreen;

public class TheGame extends Game {
    public static final int WORLD_WIDTH = 256;
    public static final int WORLD_HEIGHT = 144;

    StartScreen startScreen;

    @Override
    public void create() {

        startScreen = new StartScreen();
        setScreen(startScreen);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        startScreen.dispose();
    }

    @Override
    public void resize(int width, int height) {
        startScreen.resize(width, height);
    }
}
