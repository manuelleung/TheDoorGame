package org.thedoorgame.doorgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


import org.thedoorgame.doorgame.DoorGame;


/**
 * Created by Manuel on 1/22/2016.
 */
public class SettingScreen implements Screen {

    final DoorGame doorGame;

    private Stage stage;
    private Table table;
    private Skin skin;

    private int width, height;

    public SettingScreen(DoorGame doorGame) {
        this.doorGame = doorGame;

        // screen width and height
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), new TextureAtlas("ui/button.pack"));
        table = new Table(skin);
        table.setFillParent(true);

        // TODO add the changeable settings and make a input listener method

        final TextButton buttonBack = new TextButton("BACK", skin);
        buttonBack.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // TODO save all preferences changes
                doorGame.setScreen(new MainMenuScreen(doorGame));
            }
        });
        buttonBack.pad(15);

        table.add(new Label("SETTINGS", skin)).spaceBottom(100);
        table.add().row();
        table.add(buttonBack);
        table.debug();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
