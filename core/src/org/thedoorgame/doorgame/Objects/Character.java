package org.thedoorgame.doorgame.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

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
    private static final Texture [] MIKE_TEXTURE = {      //
            new Texture(Gdx.files.internal("mike0.png")), //
            new Texture(Gdx.files.internal("mike1.png")), //
            new Texture(Gdx.files.internal("mike2.png")), //
            new Texture(Gdx.files.internal("mike3.png")), //
            new Texture(Gdx.files.internal("mike4.png")), //
            new Texture(Gdx.files.internal("mike5.png")), //
            new Texture(Gdx.files.internal("mike6.png")), //
            new Texture(Gdx.files.internal("mike7.png")), //
    };                                                    //
    private static final Texture [] LALA_TEXTURE = {      //
            new Texture(Gdx.files.internal("lala0.png")), //
            new Texture(Gdx.files.internal("lala1.png")), //
            new Texture(Gdx.files.internal("lala2.png")), //
            new Texture(Gdx.files.internal("lala3.png")), //
            new Texture(Gdx.files.internal("lala4.png")), //
            new Texture(Gdx.files.internal("lala5.png")), //
            new Texture(Gdx.files.internal("lala6.png")), //
            new Texture(Gdx.files.internal("lala7.png")), //
    };
//--------------------------------------------------------//



//---------- Static Player Values ---------//
    public static final int BOBBY = 0;     //
    public static final int MIKE = 1;      //
    public static final int LALA = 2;      //
                                           //
                                           //-> More players coming soon
//-----------------------------------------//

//--------------- Other Data fields -------------------------//
    //boolean                                                //
    boolean animationEnabled = false;                        //
    boolean floorsGiven = false;                             //
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
    private static final float ANIMATION_TIME = 0F;          //
    private float timer = ANIMATION_TIME;                    //
    private int textureCount = 0;                            //
    private String moving = "";                              //
    private float speed = 10;                                //
                                                             //
    //for texture size:                                      //
    private float width = 100;                               //
    private float height = 110;                              //
                                                             //
    private ArrayList<Float> locationsOfFloors               //
            = new ArrayList<Float>();                        //
    private float floorHeight = new Floor().getHeight();     //
                                                             //
                                                             //
    private Texture currentTexture;                          //
    private Texture [] textureArray = BOBBY_TEXTURE;         //
    private Door door;                                       //
    private Floor floor;                                     //
    private boolean goToDestination = false;                 //
    private boolean facingLeft = false;                      //
    private boolean randomFloorsEnabled = true;             //
//-----------------------------------------------------------//


    private boolean isInside = false;

    private String characterName = "";

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
        setLocation(locationX, locationY);
        resize(currentTexture.getWidth(), currentTexture.getHeight());

    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        timer -= parentAlpha;
        if (timer <= 0) {
            timer = ANIMATION_TIME;
            if (animationEnabled) {
                playAnimation();
                checkForOutOfBounce();
            }
        }


        if(goToDestination && !isInside) {
            goToDestination();
        }


        batch.draw(currentTexture, locationX, locationY, width, height, 0, 0, currentTexture.getWidth(), currentTexture.getHeight(), facingLeft, false);
        setBounds(locationX, locationY, width, height);

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

    public void setSpeed (float speed) {
        this.speed = speed;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void setFloorDestination(Floor floor) {
        this.floor = floor;
    }

    public void setDoorDestination(Door door) {
        this.door = door;
    }

    public void goToDestinationNow(boolean goToDestination) {
        this.goToDestination = goToDestination;
    }

    public void setRandomFloorsEnabled(boolean randomFloorsEnabled) {
        this.randomFloorsEnabled = randomFloorsEnabled;
    }


    public void setIsInside(boolean isInside) {
        this.isInside = isInside;
    }
    public boolean getIsInside() {
        return isInside;
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

    public float getSpeed() {
        return speed;
    }

    public int getDoorNumber() {
        return this.doorNumber;
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public boolean getGoToDestination() {
        return this.goToDestination;
    }

    public Door getDoor() {
        return this.door;
    }

    public Floor getFloor() {
        return this.getFloor();
    }

    public boolean getRandomFloorEnabled() {
        return this.randomFloorsEnabled;
    }



    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public String getCharacterName() {
        return characterName;
    }



/* **************************
        setUpCharacter()
 * *************************/
    private void setUpCharacter(int player) {
        switch (player) {
            case BOBBY:
                textureArray = BOBBY_TEXTURE;
                characterName = "Bobby";
                setCurrentTexture(BOBBY_TEXTURE[0]);
                break;
            case MIKE:
                textureArray = MIKE_TEXTURE;
                characterName = "Mike";
                setCurrentTexture(MIKE_TEXTURE[0]);
                break;
            case LALA:
                textureArray = LALA_TEXTURE;
                characterName = "Lala";
                setCurrentTexture(LALA_TEXTURE[0]);
                break;

            //...
            //...
            //...more players coming soon...
        }
    }



    public void setFloors(FloorCreator ...floors) {
        for(int i = 0; i < floors.length; i++) {
            locationsOfFloors.add(floors[i].getFloor().getLocationY());
        }
        if(floors.length == 2) {
            floorsGiven = true;
        }
    }

    private void checkForOutOfBounce() {
        // If the character go out of bounce on the RIGHT side
        if(locationX >= Gdx.graphics.getWidth()) {
            locationX = Gdx.graphics.getWidth();




            // In order to appear in a random floor
            if(floorsGiven && randomFloorsEnabled) {
                goToRandomFloor();
                moveLeft();
            }

            // in order to appear in the next floor available
            else if(floorsGiven && !randomFloorsEnabled) {
               goToNextFloor();
                moveLeft();
            }
        }
        else if(locationX < (0-this.width)) {
            locationX = 0 - this.width;


            // In order to appear in a random floor
            if(floorsGiven && randomFloorsEnabled) {
                goToRandomFloor();
                moveRight();
            }

            // in order to appear in the next floor available
            else if(floorsGiven && !randomFloorsEnabled) {
                goToNextFloor();
                moveRight();
            }
        }
    }

    public void moveRight() {
        moving = "RIGHT";
    }

    public void moveLeft() {
        moving = "LEFT";
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

        if(moving.equals("RIGHT")) {
            locationX += speed;
            facingLeft = false;
        }
        else if(moving.equals("LEFT")) {
            locationX -= speed;
            facingLeft = true;

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

    private void goToDestination() {

        // Check if the character is on the correct floor;
        if (this.getLocationY() == (floor.getLocationY() + floor.getHeight())) {

            // comparare distance between door and character
            if (this.getLocationX() > door.getLocationX() + 10) {
                this.moveLeft();
            } else if (this.getLocationX() < door.getLocationX() - 10) {
                this.moveRight();
            } else {
                this.stop(); // stop the character from moving.
                door.play();      // Open the door
                this.setVisible(false); // make the character disappear inside the door
                isInside = true; // character is inside flag
            }

        }
    }

    private void goToRandomFloor() {
        locationY = locationsOfFloors.get(MathUtils.random(locationsOfFloors.size()-1)) + floorHeight;
    }

    private void goToNextFloor() {
        System.out.println("Location boolean: " + (locationY == locationsOfFloors.get(0) + floorHeight));

        if((locationY == (locationsOfFloors.get(0) + floorHeight))) {
            locationY = locationsOfFloors.get(1) + floorHeight;
            System.out.println("LocationY: " + locationY);
        }

        else  if((locationY == (locationsOfFloors.get(1) + floorHeight))) {
                locationY = locationsOfFloors.get(0) + floorHeight;
                System.out.println("LocationY: " + locationY);
        }
    }




}
