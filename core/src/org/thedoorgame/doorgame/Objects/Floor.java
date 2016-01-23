package org.thedoorgame.doorgame.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Leibniz H. Berihuete on 1/23/2016.
 */
public class Floor extends Actor {
    private static final Texture FLOOR_TEXTURE =
            new Texture(Gdx.files.internal("floor0.png"));

    private Texture currentTexture = FLOOR_TEXTURE;

    private float locationX;
    private float locationY;
    private float width;
    private float height;

/* ***************************
     DEFAULT CONSTRUCTOR
 * **************************/
    public Floor() {
        setLocation(0, 0);
        resize(currentTexture.getWidth(),currentTexture.getHeight());

    }




/* **************************
        Constructor(x,y)
 * *************************/
    public Floor(float locationX, float locationY) {
        setLocation(locationX,locationY);
        resize(currentTexture.getWidth(),currentTexture.getHeight());
    }




/* **********************************
              D R A W
 * *********************************/
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(FLOOR_TEXTURE, locationX, locationY, width, height);
    }


/* **********************
       Setters
 * *********************/
    public void setLocation(float locationX, float locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public void setLocationX(float locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(float locationY) {
        this.locationY = locationY;
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






/* ***********************
        Getters
 * **********************/
    public Texture getCurrentTexture() {
        return FLOOR_TEXTURE;
    }

    public float getLocationX() {
        return locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }



}
