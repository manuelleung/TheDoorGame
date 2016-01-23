package org.thedoorgame.doorgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import org.thedoorgame.doorgame.DoorGame;
import org.thedoorgame.doorgame.Objects.*;
import org.thedoorgame.doorgame.Objects.Character;

public class MainMenuScreen implements Screen {


    final DoorGame doorGame;

    private Stage stage;
    private Table table; //table layout
    private Skin skin; //appearance
    private TextureAtlas atlas;
    private TextButton buttonExit, buttonPlay, buttonSetting, buttonScore;
    private Label heading;

    private int width, height;

    // constructor to keep a reference to the main DoorGame class
    public MainMenuScreen(DoorGame doorGame){
        this.doorGame = doorGame;

        // screen width and height
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // update stage
        stage.act(delta);
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {
    }


    @Override
    public void show() {
        stage = new Stage();

        // allow input
        Gdx.input.setInputProcessor(stage);

        // create skin
        atlas = new TextureAtlas("ui/button.pack");
        skin = new Skin(atlas);
        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);

        // create table
        table = new Table(skin);
        table.setFillParent(true);
        //table.setBounds(0, 0, width, height);

        // Creating heading
        heading = new Label(DoorGame.TITLE, skin);
        heading.setFontScale(2);


        // TODO change handlers to switches in a method

        //play
        buttonPlay = new TextButton("PLAY", skin);
        buttonPlay.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                doorGame.setScreen(new GameScreen(doorGame));
            }
        });
        buttonPlay.pad(15);

        //scores
        buttonScore = new TextButton("SCORE", skin);
        buttonScore.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                doorGame.setScreen(new ScoreScreen(doorGame));
            }
        });
        buttonScore.pad(15);

        //settings
        buttonSetting = new TextButton("SETTING", skin);
        buttonSetting.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                doorGame.setScreen(new SettingScreen(doorGame));
            }
        });
        buttonSetting.pad(15);

        // TODO exit Remove this later not necessary
        buttonExit = new TextButton("Exit", skin);
        buttonExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        buttonExit.pad(15);


        table.add(heading);
        table.getCell(heading).spaceBottom(100); // margin between buttons / text
        table.row(); //add a new row after heading
        table.add(buttonPlay);
        table.getCell(buttonPlay).spaceBottom(20);
        table.row();
        table.add(buttonScore);
        table.getCell(buttonScore).spaceBottom(20);
        table.row();
        table.add(buttonSetting);
        table.getCell(buttonSetting).spaceBottom(20);
        table.row();
        table.add(buttonExit);
        table.debug();
        stage.addActor(table);

        // Door example
        Door greenDoor = new Door(Door.GREEN,350,200);
        greenDoor.play();
        stage.addActor(greenDoor);

        // Character example
        Character bobby = new Character(Character.BOBBY,150,200);
        bobby.play();
        bobby.resize(100,115);
        stage.addActor(bobby);

        // Floor example
        Floor floor = new Floor(150, 150);
        stage.addActor(floor);



    }


    @Override
    public void hide() {
        // called when current screen changes from this to a different screen
        dispose();
    }


    @Override
    public void pause() {
    }


    @Override
    public void resume() {
    }


    @Override
    public void dispose() {
        // never called automatically
        stage.dispose();
        skin.dispose();
        atlas.dispose();
    }
}