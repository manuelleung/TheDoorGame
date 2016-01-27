package org.thedoorgame.doorgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by leibnix on 1/27/2016.
 */
public class Score extends Label {
    // Skin and Atlas
    private static final TextureAtlas atlas = new TextureAtlas("ui/button.pack");
    private static final Skin skin = new Skin(Gdx.files.internal("ui/menuSkin.json"),atlas);

    // int: score = 0 by default
    private int score = 0;

    public Score() {
        super("SCORE: 0" , skin); // Gives something to the superclass for now
        this.setText("SCORE: " + score); // The text that will be displayed on the screen

        // Font size
        this.setFontScale(1);

        // Location: Top - right corner
        this.setX(Gdx.graphics.getWidth()- this.getWidth()-200);
        this.setY(Gdx.graphics.getHeight()-this.getHeight());
    }



// setters:
    public void setScore(int score) {
        this.score = score;
        this.setText("SCORE: " + this.score);
    }

    public void addScore(int score) {
        this.score += score;
        this.setText("SCORE: " + this.score);
    }

// getters:
    public int getScore() {
        return this.score;
    }
}
