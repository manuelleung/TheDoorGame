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
    private static final float DISTANCE_BETWEEN_DOORS = 200;
    private  Door [] doors = new Door[NUMBER_OF_DOORS];

    private Floor floor = new Floor();

    private float distance = 30; // starting distance
    private Stage stage;

    public FloorCreator(Stage stage) {
        this.stage = stage;
    }


    public void createFloor() {
        // build floor
        floor = new Floor();
        stage.addActor(floor);

        // build Doors
        for(int i = 0; i < NUMBER_OF_DOORS; i++) {
            doors[i] = new Door(i);
            doors[i].setLocationX(floor.getLocationX() + distance);
            doors[i].setLocationY(floor.getHeight());
            distance += DISTANCE_BETWEEN_DOORS;
            stage.addActor(doors[i]);
        }






    }


    public void setLocation(float locationX, float locationY) {
        floor.setLocation(floor.getLocationX() + locationX,
                floor.getLocationY() + locationY);

        for(int i =0; i < NUMBER_OF_DOORS; i++) {
            doors[i].setLocation(doors[i].getLocationX() + locationX,
                                 doors[i].getLocationY() + locationY);
        }

    }

    public void increaseWidthBy (float width) {
        for(int i =0; i < NUMBER_OF_DOORS; i++) {
            doors[i].setWidth(doors[i].getWidth() + width);
        }

        floor.setWidth(floor.getWidth() + width);
    }

    public void decreaseWidthBy (float width) {
        for(int i =0; i < NUMBER_OF_DOORS; i++) {
            doors[i].setWidth(doors[i].getWidth() - width);
        }

        floor.setWidth(floor.getWidth() - width);
    }

    public void increaseHeightBy (float height) {
        for(int i =0; i < NUMBER_OF_DOORS; i++) {
            doors[i].setHeight(doors[i].getHeight() + height);
        }

        floor.setHeight(floor.getHeight() + height);
    }

    public void decreaseHeightBy (float height) {
        for(int i =0; i < NUMBER_OF_DOORS; i++) {
            doors[i].setHeight(doors[i].getHeight() - height);
        }

        floor.setHeight(floor.getHeight() - height);
    }

}
