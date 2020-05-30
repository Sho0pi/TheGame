package com.shoopi.thegame.backgrounds;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.shoopi.thegame.Constants;
import com.shoopi.thegame.TheGame;

import java.util.Arrays;

public class Background extends Actor {

    private TextureRegion[] backgrounds;
    private float[] backgroundOffsets;
    private float backgroundMaxScrollingSpeed;

    public Background() {
        super();

        TextureAtlas atlas = new TextureAtlas(Constants.BACKGROUND_ATLAS_PATH);
        backgrounds = new TextureRegion[Constants.BACKGROUND_ELEMENTS.length];
        for (int i = 0; i < backgrounds.length; i++) {
            backgrounds[i] = atlas.findRegion(Constants.BACKGROUND_ELEMENTS[i]);
        }
        backgroundOffsets = new float[backgrounds.length];
        Arrays.fill(backgroundOffsets, 0);

        backgroundMaxScrollingSpeed = (float) (TheGame.WORLD_WIDTH) / 16;

    }

    @Override
    public void act(float deltaTime) {

        // Creating different movement speed for every cloud.
        backgroundOffsets[1] += deltaTime * backgroundMaxScrollingSpeed / 8;
        backgroundOffsets[2] += deltaTime * backgroundMaxScrollingSpeed / 4;
        backgroundOffsets[3] += deltaTime * backgroundMaxScrollingSpeed / 2;
        backgroundOffsets[4] += deltaTime * backgroundMaxScrollingSpeed;


        for (int layer = 0; layer < backgroundOffsets.length; layer++) {
            if (backgroundOffsets[layer] > TheGame.WORLD_WIDTH) {
                backgroundOffsets[layer] = 0;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        // Will draw each layer twice to give loop effect.
        for (int layer = 0; layer < backgroundOffsets.length; layer++) {
            batch.draw(backgrounds[layer], -backgroundOffsets[layer], 0, TheGame.WORLD_WIDTH, TheGame.WORLD_HEIGHT);
            batch.draw(backgrounds[layer], -backgroundOffsets[layer] + TheGame.WORLD_WIDTH, 0, TheGame.WORLD_WIDTH, TheGame.WORLD_HEIGHT);
        }

    }
}
