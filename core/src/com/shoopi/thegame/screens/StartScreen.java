package com.shoopi.thegame.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.shoopi.thegame.Constants;
import com.shoopi.thegame.TheGame;

public class StartScreen implements Screen {

    private Viewport viewport;
    private Camera camera;

    private Skin skin;
    private Stage stage;

    private float cameraCentreX;
    private float cameraCentreY;

    public StartScreen() {

        // For now creates an empty skin.
        TextureAtlas atlas = new TextureAtlas(Constants.SKIN_ATLAS_PATH);
        skin = new Skin(Gdx.files.internal(Constants.SKIN_JSON_PATH), atlas);

        camera = new OrthographicCamera();
        viewport = new FitViewport(TheGame.WORLD_WIDTH, TheGame.WORLD_HEIGHT, camera);

        camera.update();

        stage = new Stage(viewport);
    }

    @Override
    public void show() {
        // Stage will control the input.
        Gdx.input.setInputProcessor(stage);

        // The titles will be inside a table.
        Table table = new Table();
        // Table will fill the stage.
        table.setFillParent(true);
        // Set the alignment of content inside the table.
        table.top();

        // Create buttons:
        TextButton playButton = new TextButton("Play", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        // Creating listeners to the buttons:
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Opens the GameScreen
                ((Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
            }
        });
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        table.add(playButton).padTop(Constants.TOP_PADDING);
        table.row();
        table.add(exitButton).padTop(Constants.PADDING_BETWEEN_BUTTONS);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        // Clears the screen:
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.update();
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
        skin.dispose();
    }
}
