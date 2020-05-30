package com.shoopi.thegame.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
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
import com.shoopi.thegame.TheGame;

public class StartScreen implements Screen {

    private Viewport viewport;
    private Camera camera;

    protected Skin skin;
    protected Stage stage;

    public StartScreen() {

        // For now creates an empty skin.
        TextureAtlas atlas = new TextureAtlas("skin/flat-earth-ui.atlas");
        FileHandle  json = Gdx.files.internal("skin/flat-earth-ui.json");
        skin = new Skin(json, atlas);

        camera = new OrthographicCamera();
        viewport = new FitViewport(TheGame.WORLD_WIDTH, TheGame.WORLD_HEIGHT, camera);

        camera.position.set(camera.viewportWidth /2, camera.viewportHeight /2,0);
        camera.update();

        stage = new Stage();
    }

    @Override
    public void show() {
        // Stage will control the input.
        Gdx.input.setInputProcessor(stage);

        // The titles will be inside a table.
        Table table = new Table();
        // Table will fill the stage
        table.setFillParent(true);
        // Set the alignment of content inside the table;
        table.top();

        // Create buttons:
        TextButton playButton = new TextButton("Play", skin );
        TextButton exitButton = new TextButton( "Exit", skin);

        // Creating listeners to the button:
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Opens the GameScreen
                ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen());
            }
        });
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        table.add(playButton).padTop(50);
        table.row();
        table.add(exitButton).padTop(10);

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
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
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
