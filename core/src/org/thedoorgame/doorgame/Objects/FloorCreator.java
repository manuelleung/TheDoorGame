package org.thedoorgame.doorgame.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Leibniz H. Berihuete on 1/22/2016.
 */
public class FloorCreator {
    private static final int NUMBER_OF_DOORS = 5;
    private static final float DISTANCE_BETWEEN_DOORS = 150;
    private static final Door [] DOORS = new Door[NUMBER_OF_DOORS];
    private static final Texture floor = new Texture(Gdx.files.internal("floor0.png"));
    private float distance = 0;
    private Stage stage;
    public FloorCreator(Stage stage) {
        this.stage = stage;
        buildFloor();

    }

    private void buildFloor() {
        for(int i = 0; i < NUMBER_OF_DOORS; i++) {
            DOORS[i] = new Door(i);
            DOORS[i].setLocationX(distance);
            distance += DISTANCE_BETWEEN_DOORS;
            stage.addActor(DOORS[i]);
        }
    }

}
