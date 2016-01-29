package org.thedoorgame.doorgame.labels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import org.thedoorgame.doorgame.Objects.*;
import org.thedoorgame.doorgame.Objects.Character;

/**
 * Created by Manuel on 1/26/2016.
 */
public class Question extends Label {

    Character character;

    public Question(Skin skin) {
        super("Where is ", skin);

        this.setFontScale(1);

        // Location: Top - right corner
        this.setX(Gdx.graphics.getWidth() - this.getWidth()-800);
        this.setY(Gdx.graphics.getHeight() - this.getHeight());
    }

    public void setCharacter(Character character) {
        this.character = character;
        this.setText("Where is "+character.getCharacterName()+"?");
    }

    public Character getCharacter() {
        return character;
    }


}
