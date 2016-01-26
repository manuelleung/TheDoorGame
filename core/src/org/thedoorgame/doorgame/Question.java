package org.thedoorgame.doorgame;

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
public class Question extends Actor {

    Character character;


    Label textQuestion;
    Skin skin;
    TextureAtlas atlas;


    public Question(Character character) {
        this.character = character;
        atlas = new TextureAtlas("ui/button.pack");
        skin = new Skin(atlas);
        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);

        whereIsIt();
    }

    public void whereIsIt() {
        textQuestion = new Label("Where is (SOMEONE)" + "?", skin);
        textQuestion.setFontScale(2);
        textQuestion.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {


        //batch.draw()


    }

}
