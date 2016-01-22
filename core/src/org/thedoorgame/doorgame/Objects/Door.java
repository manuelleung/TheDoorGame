package org.thedoorgame.doorgame.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Leibniz H. Berihuete on 1/22/2016.
 */
public class Door extends Actor {

 //---------------------- TEXTURES ----------------------------------//
    private static final Texture [] BLUE_DOOR_TEXTURE = {            //
            new Texture(Gdx.files.internal("blue_door0.png")),       //
            new Texture(Gdx.files.internal("blue_door1.png")),       //
            new Texture(Gdx.files.internal("blue_door2.png")),       //
            new Texture(Gdx.files.internal("blue_door3.png")),       //
            new Texture(Gdx.files.internal("blue_door4.png")),       //
    };                                                               //
                                                                     //
    private static final Texture [] GREEN_DOOR_TEXTURE = {           //
            new Texture(Gdx.files.internal("green_door0.png")),      //
            new Texture(Gdx.files.internal("green_door1.png")),      //
            new Texture(Gdx.files.internal("green_door2.png")),      //
            new Texture(Gdx.files.internal("green_door3.png")),      //
            new Texture(Gdx.files.internal("green_door4.png")),      //
    };                                                               //
                                                                     //
    private static final Texture [] GRAY_DOOR_TEXTURE = {            //
            new Texture(Gdx.files.internal("gray_door0.png")),       //
            new Texture(Gdx.files.internal("gray_door1.png")),       //
            new Texture(Gdx.files.internal("gray_door2.png")),       //
            new Texture(Gdx.files.internal("gray_door3.png")),       //
            new Texture(Gdx.files.internal("gray_door4.png")),       //
    };                                                               //
                                                                     //
    private static final Texture [] ORANGE_DOOR_TEXTURE = {          //
            new Texture(Gdx.files.internal("orange_door0.png")),     //
            new Texture(Gdx.files.internal("orange_door1.png")),     //
            new Texture(Gdx.files.internal("orange_door2.png")),     //
            new Texture(Gdx.files.internal("orange_door3.png")),     //
            new Texture(Gdx.files.internal("orange_door4.png")),     //
    };                                                               //
                                                                     //
    private static final Texture [] YELLOW_DOOR_TEXTURE = {          //
            new Texture(Gdx.files.internal("yellow_door0.png")),     //
            new Texture(Gdx.files.internal("yellow_door1.png")),     //
            new Texture(Gdx.files.internal("yellow_door2.png")),     //
            new Texture(Gdx.files.internal("yellow_door3.png")),     //
            new Texture(Gdx.files.internal("yellow_door4.png")),     //
    };                                                               //
//-------------------------------------------------------------------//

// ---------- Static Color Values ------------//
    public static final int BLUE = 0;         //
    public static final int GREEN = 1;        //
    public static final int GRAY = 2;         //
    public static final int ORANGE = 3;       //
    public static final int YELLOW = 4;       //
//--------------------------------------------//

//------------------ Other Data Fields: ---------------------//
    private boolean isOccupied = false;                      //
    private Texture currentTexture;                          //
    private float locationX;                                 //
    private float locationY;                                 //
//-----------------------------------------------------------//




/* *************************************
         DEFAULT  CONSTRUCTOR
 * *************************************/
    public Door() {
        setCurrentTexture(BLUE_DOOR_TEXTURE[0]); //-> Default Color: BLUE
        setLocation(0,0);                        //-> Default Location: (0,0)
    }


/* *************************************
          CONSTRUCTOR (Color)
* *************************************/
    public Door (int doorColor) {
        setUpDoorColor(doorColor);
        setLocation(0, 0);                       //-> Default Location (0,0)
    }


/* *************************************
          CONSTRUCTOR (x,y)
* *************************************/
    public Door (float xLocation, float yLocation) {
        setCurrentTexture(BLUE_DOOR_TEXTURE[0]); //-> Default Color: BLUE
        setLocation(xLocation, yLocation);
    }



/* *************************************
              CONSTRUCTOR (Color, x, y)
 * *************************************/
    public Door (int doorColor, float xLocation, float yLocation) {
        setUpDoorColor(doorColor);
        setLocation(xLocation,yLocation);
    }







/* ************************************
        OVERRIDE  DRAW METHOD
 * ***********************************/
    @Override
    public void draw(Batch batch, float parentAlpha) {
       batch.draw(currentTexture, locationX, locationY);
    }







/* **********************
        Setters
 * **********************/
    public void setCurrentTexture(Texture currentTexture) {
        this.currentTexture = currentTexture;
    }

    public void setLocation (float x, float y) {
        locationX = x;
        locationY = y;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }







/* **********************
        Getters
 * **********************/
    public Texture getCurrentTexture() {
        return this.currentTexture;
    }

    public float getLocationX() {
        return locationX;
    }

    public float getLocationY() {
        return locationY;
    }








/* **************************
      setUpDoorColor Method
 * **************************/
    private void setUpDoorColor(int doorColor) {
        switch(doorColor) {
            case BLUE:
                setCurrentTexture(BLUE_DOOR_TEXTURE[0]);
                break;

            case GREEN:
                setCurrentTexture(GREEN_DOOR_TEXTURE[0]);
                break;

            case GRAY:
                setCurrentTexture(GRAY_DOOR_TEXTURE[0]);
                break;

            case ORANGE:
                setCurrentTexture(ORANGE_DOOR_TEXTURE[0]);
                break;

            case YELLOW:
                setCurrentTexture(YELLOW_DOOR_TEXTURE[0]);
                break;
        }
    }
}
