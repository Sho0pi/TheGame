package com.shoopi.thegame.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.shoopi.thegame.TheGame;

public class GameScreen implements Screen {

    // screen
    private Camera camera;
    private Viewport viewport;

    private SpriteBatch batch;

    public GameScreen() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(TheGame.WORLD_WIDTH, TheGame.WORLD_HEIGHT, camera);

        batch = new SpriteBatch();

    }


    @Override
    public void render(float delta) {
        batch.begin();


        batch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
