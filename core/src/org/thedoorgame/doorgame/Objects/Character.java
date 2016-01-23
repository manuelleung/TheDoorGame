package org.thedoorgame.doorgame.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Leibniz H. Berihuete on 1/22/2016.
 */
public class Character extends Actor {
//--------------- TEXTURE --------------------------------//
    private static final Texture [] BOBBY_TEXTURE = {     //
        new Texture(Gdx.files.internal("player0.png")),   //
        new Texture(Gdx.files.internal("player1.png")),   //
        new Texture(Gdx.files.internal("player2.png")),   //
        new Texture(Gdx.files.internal("player3.png")),   //
        new Texture(Gdx.files.internal("player2.png")),   //
        new Texture(Gdx.files.internal("player1.png")),   //
    };                                                    // -> More Textures coming soon
//--------------------------------------------------------//



//---------- Static Player Values ---------//
    public static final int BOBBY = 0;     //
                                           //
                                           //
                                           //-> More players coming soon
//-----------------------------------------//

//--------------- Other Data fields -------------------------//
    //boolean                                                //
    boolean animationEnabled = false;                        //
                                                             //
    //for player floor and door location                     //
    private int floorNumber;                                 //
    private int doorNumber;                                  //
                                                             //
    //for x and y location of the door                       //
    private float locationX;                                 //
    private float locationY;                                 //
                                                             //
    //for animation purposes                                 //
    private static final float ANIMATION_TIME = 3F;          //
    private float timer = ANIMATION_TIME;                    //
    private int textureCount = 0;                            //
                                                             //
    //for texture size:                                      //
    private float width;                                     //
    private float height;                                    //
                                                             //
                                                             //
    private Texture currentTexture;                          //
    private Texture [] textureArray = BOBBY_TEXTURE;         //
//-----------------------------------------------------------//



/* **********************************
        DEFAULT  CONSTRUCTOR
 * *********************************/
    public Character() {
        setCurrentTexture(BOBBY_TEXTURE[0]); //-> Default Texture: BOBBY
        setLocation(0, 0);                   //-> Default Location: (0,0)
        resize(currentTexture.getWidth(), currentTexture.getHeight());
    }



/* *********************************
      Constructor (player)
 * *********************************/
    public Character(int player) {
        setUpCharacter(player);
        setLocation(0, 0);                    //-> Default Location: (0,0)
        resize(currentTexture.getWidth(), currentTexture.getHeight());

    }




/* ************************
      Constructor (x,y)
 * ***********************/
    public Character(float locationX, float locationY) {
        setCurrentTexture(BOBBY_TEXTURE[0]); //-> Default Texture: BOBBY
        setLocation(locationX, locationY);
        resize(currentTexture.getWidth(), currentTexture.getHeight());
    }



/* ************************
      Constructor (player,x,y)
 * ***********************/
    public Character(int player, float locationX, float locationY) {
        setUpCharacter(player);
        setLocation(locationX,locationY);
        resize(currentTexture.getWidth(), currentTexture.getHeight());
    }






    @Override
    public void draw(Batch batch, float parentAlpha) {
        timer -= parentAlpha;
        if(timer <= 0) {
            timer = ANIMATION_TIME;
            if(animationEnabled) {
                playAnimation();
            }
        }

        batch.draw(currentTexture,locationX,locationY,width,height);
    }








    /* **********************
            Setters
     * *********************/
    public void setCurrentTexture(Texture currentTexture) {
        this.currentTexture = currentTexture;
    }

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




/* *************************
        Getters
 * ************************/
    public Texture getCurrentTexture() {
        return this.currentTexture;
    }

    public float getLocationX() {
        return this.locationX;
    }

    public float getLocationY() {
        return this.locationY;
    }

    public boolean isPlaying() {
        return this.animationEnabled;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }







/* **************************
        setUpCharacter()
 * *************************/
    private void setUpCharacter(int player) {
        switch (player) {
            case BOBBY:
                textureArray = BOBBY_TEXTURE;
                setCurrentTexture(BOBBY_TEXTURE[0]);
                break;

            //...
            //...
            //...more players coming soon...
        }
    }

/* ***********************
        playAnimation()
 * **********************/
    private void playAnimation() {
        if(textureCount < textureArray.length-1) {
            textureCount++;
            setCurrentTexture(textureArray[textureCount]);
        }
        else {
            textureCount = 0;
        }
    }




// -------------- Animation Controls -------------------//
    public void play() {
        animationEnabled = true;
    }

    public void pause() {
        animationEnabled = false;
    }

    public void stop() {
        animationEnabled = false;
        setCurrentTexture(textureArray[0]);

    }
}
