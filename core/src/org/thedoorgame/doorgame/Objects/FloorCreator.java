package org.thedoorgame.doorgame.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

import javax.xml.transform.dom.DOMResult;

/**
 * Created by Leibniz H. Berihuete on 1/22/2016.
 */
public class FloorCreator {
    public static final int NUMBER_OF_DOORS = 6;
    private static final float DISTANCE_BETWEEN_DOORS = Gdx.graphics.getWidth()/6.5f;
    private  Door [] doors = new Door[NUMBER_OF_DOORS];

    private Floor floor = new Floor();

    private float distance = DISTANCE_BETWEEN_DOORS * .5f; // starting distance
    private Stage stage;



/* ****************************
        Constructor (stage)
 * ***************************/
    public FloorCreator(Stage stage) {
        this.stage = stage;
    }



/* *****************************
        createFloor() Method
 * ****************************/
    public void createFloor() {
        // build floor
        floor = new Floor();
        stage.addActor(floor);

        // build Doors
        for(int i = 0; i < NUMBER_OF_DOORS; i++) {
            doors[i] = new Door(getRandomDoorColor());
            doors[i].setLocationX(floor.getLocationX() + distance);
            doors[i].setLocationY(floor.getHeight());
            distance += DISTANCE_BETWEEN_DOORS;
            stage.addActor(doors[i]);
        }
    }




/* ***********************************************
                    S E T T E R S
 * **********************************************/
    public void setLocation(float locationX, float locationY) {
        // modify and set floor location
        floor.setLocation(floor.getLocationX() + locationX,           //
                floor.getLocationY() + locationY);                    //    This method sets the
                                                                      //    location of the floor
        // modify and set doors location                              //    and doors at the same
        for(int i =0; i < NUMBER_OF_DOORS; i++) {                     //    time
            doors[i].setLocation(doors[i].getLocationX() + locationX,
                    doors[i].getLocationY() + locationY);
        }

    }



    public void increaseWidthBy (float width) {
        // Modify and set width of doors
        for(int i =0; i < NUMBER_OF_DOORS; i++) {                    //
            doors[i].setWidth(doors[i].getWidth() + width);          //  This method increases the
        }                                                            //  the floor and doors's width
        // Modify and set Floor width                                //  at the same time
        floor.setWidth(floor.getWidth() + width);
    }



    public void decreaseWidthBy (float width) {
        // Modify and set width of doors                            //
        for(int i =0; i < NUMBER_OF_DOORS; i++) {                   //  This method decreases the
            doors[i].setWidth(doors[i].getWidth() - width);         //  the floor and door's width
        }                                                           //  at the same time.
        // Modify and set Floor width
        floor.setWidth(floor.getWidth() - width);
    }



    public void increaseHeightBy (float height) {
        // Modify and set doors height
        for(int i =0; i < NUMBER_OF_DOORS; i++) {                  //  This method increases the
            doors[i].setHeight(doors[i].getHeight() + height);     //  the floor and door's height
        }                                                          //  at the same time.
        // Modify and set floor height
        floor.setHeight(floor.getHeight() + height);
    }



    public void decreaseHeightBy (float height) {
        // Modify and set doors height
        for(int i =0; i < NUMBER_OF_DOORS; i++) {                   // This method decreases the
            doors[i].setHeight(doors[i].getHeight() - height);      // the floor and door's height
        }                                                           // at the same time.
        // Modify and sett floor height
        floor.setHeight(floor.getHeight() - height);
    }

    private int getRandomDoorColor () {
        return MathUtils.random(4);
    }


/* ***********************************************
                    G E T T E R S
 * **********************************************/
    public Door getDoor(int index) {
        return doors[index];
    }

    public Floor getFloor() {
        return floor;
    }

    public int getNumberOfDoors() {
        return NUMBER_OF_DOORS;
    }

}
