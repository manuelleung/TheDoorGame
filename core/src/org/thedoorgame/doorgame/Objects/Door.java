package org.thedoorgame.doorgame.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;


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
            new Texture(Gdx.files.internal("blue_door3.png")),       //
            new Texture(Gdx.files.internal("blue_door2.png")),       //
            new Texture(Gdx.files.internal("blue_door1.png")),       //
    };                                                               //
                                                                     //
    private static final Texture [] GREEN_DOOR_TEXTURE = {           //
            new Texture(Gdx.files.internal("green_door0.png")),      //
            new Texture(Gdx.files.internal("green_door1.png")),      //
            new Texture(Gdx.files.internal("green_door2.png")),      //
            new Texture(Gdx.files.internal("green_door3.png")),      //
            new Texture(Gdx.files.internal("green_door4.png")),      //
            new Texture(Gdx.files.internal("green_door3.png")),      //
            new Texture(Gdx.files.internal("green_door2.png")),      //
            new Texture(Gdx.files.internal("green_door1.png")),      //
    };                                                               //
                                                                     //
    private static final Texture [] GRAY_DOOR_TEXTURE = {            //
            new Texture(Gdx.files.internal("gray_door0.png")),       //
            new Texture(Gdx.files.internal("gray_door1.png")),       //
            new Texture(Gdx.files.internal("gray_door2.png")),       //
            new Texture(Gdx.files.internal("gray_door3.png")),       //
            new Texture(Gdx.files.internal("gray_door4.png")),       //
            new Texture(Gdx.files.internal("gray_door3.png")),       //
            new Texture(Gdx.files.internal("gray_door2.png")),       //
            new Texture(Gdx.files.internal("gray_door1.png")),       //
    };                                                               //
                                                                     //
    private static final Texture [] ORANGE_DOOR_TEXTURE = {          //
            new Texture(Gdx.files.internal("orange_door0.png")),     //
            new Texture(Gdx.files.internal("orange_door1.png")),     //
            new Texture(Gdx.files.internal("orange_door2.png")),     //
            new Texture(Gdx.files.internal("orange_door3.png")),     //
            new Texture(Gdx.files.internal("orange_door4.png")),     //
            new Texture(Gdx.files.internal("orange_door3.png")),     //
            new Texture(Gdx.files.internal("orange_door2.png")),     //
            new Texture(Gdx.files.internal("orange_door1.png")),     //
    };                                                               //
                                                                     //
    private static final Texture [] YELLOW_DOOR_TEXTURE = {          //
            new Texture(Gdx.files.internal("yellow_door0.png")),     //
            new Texture(Gdx.files.internal("yellow_door1.png")),     //
            new Texture(Gdx.files.internal("yellow_door2.png")),     //
            new Texture(Gdx.files.internal("yellow_door3.png")),     //
            new Texture(Gdx.files.internal("yellow_door4.png")),     //
            new Texture(Gdx.files.internal("yellow_door3.png")),     //
            new Texture(Gdx.files.internal("yellow_door2.png")),     //
            new Texture(Gdx.files.internal("yellow_door1.png")),     //
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
    //booleans:                                              //
    private boolean isOccupied = false;                      //
    private boolean animationEnabled = false;                //
                                                             //
    //for x and y location of the door                       //
    private float locationX;                                 //
    private float locationY;                                 //
                                                             //
    // for animation purposes                                //
    private static final float ANIMATION_TIME = 3F;          //
    private float timer = 0;                                 //
    private int textureCount = 0;                            //
                                                             //
    // texture: current texture of the door                  //
    private Texture currentTexture;                          //
    private Texture [] textureArray = BLUE_DOOR_TEXTURE;     //-> Texture: BLUE DOOR by default
                                                             //
    //for resizing door                                      //
    private float width;                                     //
    private float height;                                    //
//-----------------------------------------------------------//

    private int floorNumber;
    private int doorNumber;


/* *************************************
         DEFAULT  CONSTRUCTOR
 * *************************************/
    public Door() {
        setCurrentTexture(BLUE_DOOR_TEXTURE[0]); //-> Default Color: BLUE
        setLocation(0, 0);                        //-> Default Location: (0,0)
        resize(currentTexture.getWidth(),
               currentTexture.getHeight());

    }


/* *************************************
          CONSTRUCTOR (Color)
* *************************************/
    public Door (int doorColor) {
        setUpDoorColor(doorColor);
        setLocation(0, 0);                       //-> Default Location (0,0)
        resize(currentTexture.getWidth(),
               currentTexture.getHeight());
    }


/* *************************************
          CONSTRUCTOR (x,y)
* *************************************/
public Door (float xLocation, float yLocation) {
        setCurrentTexture(BLUE_DOOR_TEXTURE[0]); //-> Default Color: BLUE
        setLocation(xLocation, yLocation);
        resize(currentTexture.getWidth(),
               currentTexture.getHeight());
    }



/* *************************************
              CONSTRUCTOR (Color, x, y)
 * *************************************/
public Door (int doorColor, float xLocation, float yLocation) {
        setUpDoorColor(doorColor);
        setLocation(xLocation, yLocation);
        resize(currentTexture.getWidth(),
                currentTexture.getHeight());
    }







/* ************************************
        OVERRIDE  DRAW METHOD
 * ***********************************/
    @Override
    public void draw(Batch batch, float parentAlpha) {
        timer -= parentAlpha;
        if(timer <= 0) {
            timer = ANIMATION_TIME;
            if(animationEnabled) {
                playAnimation();
            }


        }
        batch.draw(currentTexture, locationX, locationY, width, height);
        this.setBounds(locationX, locationY, width, height);
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

    public void setLocationX(float x) {
        locationX = x;
    }

    public void setLocationY(float y) {
        locationY = y;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public void resize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }




    //////////////////////////////
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public int getFloorNumber() {
        return floorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }
    public int getDoorNumber() {
        return doorNumber;
    }
    //////////////////////////////


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

    public boolean IsOccupied() {
        return isOccupied;
    }

    public boolean IsPlaying() {
        return animationEnabled;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }







/* **************************
      setUpDoorColor Method
 * **************************/
    private void setUpDoorColor(int doorColor) {
        switch(doorColor) {
            case BLUE:
                setCurrentTexture(BLUE_DOOR_TEXTURE[0]);
                this.textureArray = BLUE_DOOR_TEXTURE;
                break;

            case GREEN:
                setCurrentTexture(GREEN_DOOR_TEXTURE[0]);
                this.textureArray = GREEN_DOOR_TEXTURE;
                break;

            case GRAY:
                setCurrentTexture(GRAY_DOOR_TEXTURE[0]);
                this.textureArray = GRAY_DOOR_TEXTURE;
                break;

            case ORANGE:
                setCurrentTexture(ORANGE_DOOR_TEXTURE[0]);
                this.textureArray = ORANGE_DOOR_TEXTURE;
                break;

            case YELLOW:
                setCurrentTexture(YELLOW_DOOR_TEXTURE[0]);
                this.textureArray = YELLOW_DOOR_TEXTURE;
                break;
        }
    }




/* **************************
      checkForEvent() Method
 * **************************/
    private void playAnimation() {
        if(textureCount < textureArray.length-1) {
            textureCount++;
            setCurrentTexture(textureArray[textureCount]);
        }
        else {
            textureCount = 0;
            this.animationEnabled =false;
        }

    }


    public void addEventListener(EventListener event) {
        this.addListener(event);
    }






/* **************************
          play() Method
 * **************************/
    public void play() {
        this.animationEnabled = true;
    }

/* **************************
         pause() Method
 * **************************/
    public void pause() {
        this.animationEnabled = false;
    }

/* **************************
           stop() Method
 * **************************/
    public void stop() {
        this.animationEnabled = false;
        setCurrentTexture(textureArray[0]);
    }
}
