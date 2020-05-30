package com.shoopi.thegame;

import com.badlogic.gdx.Game;
import com.shoopi.thegame.screens.GameScreen;

public class TheGame extends Game {
    public static final int WORLD_WIDTH = 128;
    public static final int WORLD_HEIGHT = 72;

    GameScreen gameScreen;

    @Override
    public void create() {

        gameScreen = new GameScreen();
        setScreen(gameScreen);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        gameScreen.dispose();
    }

    @Override
    public void resize(int width, int height) {
        gameScreen.resize(width, height);
    }
}
