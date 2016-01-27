package org.thedoorgame.doorgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import org.thedoorgame.doorgame.DoorGame;
import org.thedoorgame.doorgame.Objects.*;
import org.thedoorgame.doorgame.Objects.Character;
import org.thedoorgame.doorgame.Score;
import org.thedoorgame.doorgame.random.DoorChooser;

import java.util.ArrayList;

/**
 * Created by Manuel on 1/21/2016.
 */
public class GameScreen implements Screen {

    final DoorGame doorGame;
    Stage stage;


    ////////////////// question/font skin
    Label textQuestion;
    Skin skin;
    TextureAtlas atlas;
    /////////////

    OrthographicCamera camera;

    DoorChooser doorChooser;


    private int width, height;
    private Score score;

    private ArrayList<Character> characters = new ArrayList<Character>();

    private final Character bobby = new Character(Character.BOBBY);
    private final Character bobby2 = new Character(Character.BOBBY);
    private final Character bobby3 = new Character(Character.BOBBY);
    private final Character bobby4 = new Character(Character.BOBBY);

// -------------- ADDED BY LEIBNIZ ---------------//
    private static final int GRID_CELL = 32;      //    This is for grid-display and
    private ShapeRenderer shapeRenderer;          //    design purposes. This can be
//------------------------------------------------//    removed later when the design is done.

    public GameScreen(DoorGame doorGame) {
        this.doorGame = doorGame;

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();


    }


    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer(); // ADDED BY LEIBNIZ for design purposes
        stage = new Stage(new FitViewport(width,height));

        Gdx.input.setInputProcessor(stage);


        //-------------- EXAMPLE: how to create floors-------------//
                                                                   //
        // Initialize two floors:
        final FloorCreator floor1 = new FloorCreator(stage);       //
        final FloorCreator floor2 = new FloorCreator(stage);       //
                                                                   //
        // Create floors                                           //        WARNING:
        floor1.createFloor(0);                                      //  You must call the createFloor()
        floor2.createFloor(1);                                      //  method first, before you
                                                                   //  relocate them.
                                                                   //
        // relocate them anywhere you want                         //
        floor1.setLocation(0,0);                                   //
        floor2.setLocation(0,350);                                 //
                                                                   //
        //----------------- Done ----------------------------------//



        //---- EXAMPLE: how to access a door from a Floor----------//
                                                                   //
        Door firstDoor = floor1.getDoor(0);                         //   the first door of any floor
        Door secondDoor = floor1.getDoor(1);                       //    is alway zero
                                                                   //
        //--etc----------------------------------------------------//



/* *****************************
        1st FLOOR
 * ****************************/
        floor1.getDoor(0).addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor1.getDoor(0).play();
                score.addScore(10);
            }
        });

        floor1.getDoor(1).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor1.getDoor(1).play();
            }
        });

        floor1.getDoor(2).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor1.getDoor(2).play();
            }
        });

        floor1.getDoor(3).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor1.getDoor(3).play();

            }
        });

        floor1.getDoor(4).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor1.getDoor(4).play();
            }
        });

/* *****************************
        2nd FLOOR
 * ****************************/
        floor2.getDoor(0).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor2.getDoor(0).play();
            }
        });

        floor2.getDoor(1).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor2.getDoor(1).play();
                //bobby.moveLeft();
            }
        });

        floor2.getDoor(2).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor2.getDoor(2).play();
                //bobby.moveRight();
            }
        });

        floor2.getDoor(3).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor2.getDoor(3).play();
            }
        });

        floor2.getDoor(4).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                floor2.getDoor(4).play();

            }
        });

        //bobby.resize(100, 110);
        //bobby.setLocationY(floor1.getFloor().getLocationY() + floor1.getFloor().getHeight());
        //bobby.moveRight();
        //bobby.play();

        //testing multiple characters
        characters.add(bobby);
        characters.add(bobby2);
        characters.add(bobby3);
        characters.add(bobby4);
        ////////////////////////////






        for(int i=0; i<characters.size(); i++) {
            characters.get(i).resize(100, 110);
            characters.get(i).setLocationY(floor1.getFloor().getLocationY() + floor1.getFloor().getHeight());
            characters.get(i).setLocationX(MathUtils.random(Gdx.graphics.getWidth()) - 1);
            characters.get(i).setSpeed(MathUtils.random(10) + 5);
            characters.get(i).moveRight();
            characters.get(i).play();
            characters.get(i).setFloors(floor1, floor2);

            characters.get(i).goToDestinationNow(true);
            stage.addActor(characters.get(i));
        }

        // Test chooser ... Dont mind all the calls.
        // kept them separate for testing
        doorChooser = new DoorChooser();
        doorChooser.addFloor(floor1);
        doorChooser.addFloor(floor2);
        doorChooser.addDoors();
        doorChooser.addCharacters(characters);
        doorChooser.shuffleLists();
        doorChooser.chooseCharacter();
        doorChooser.randomDoorChooser();


        score = new Score();

        // TODO figure out how to ask question after all characters hide

        stage.addActor(askQuestion(bobby));
        stage.addActor(score);



        floor1.getFloor().setWidth(Gdx.graphics.getWidth());
        floor2.getFloor().setWidth(Gdx.graphics.getWidth());






        //--------------------------------------------------------------//
    }

    public Label askQuestion(Character character) {
        atlas = new TextureAtlas("ui/button.pack");
        skin = new Skin(atlas);
        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"),atlas);
        textQuestion = new Label("Where is (SOMEONE)" + "?", skin);
        textQuestion.setFontScale(1);

        return textQuestion;
    }


    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        drawGrid(); // ADDED by LEIBNIZ

        
        score.addScore(1);

        stage.act(delta);
        stage.draw();





//        doorGame.batch.begin();
//        doorGame.font.draw(doorGame.batch, "GAME SCREEN!!", (width / 2) - 50, (height / 2));
//        doorGame.batch.end();
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
        shapeRenderer.dispose();
    }



//----- METHOD ADDED BY LEIBNIZ --------------------------------------------------//
    private void drawGrid() {                                                     //
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);                        //
        //begin                                                                   //  This is to
                                                                                  //  draw the grids
        for(int x = 0; x < Gdx.graphics.getWidth(); x += GRID_CELL) {             //  on the screen
            for(int y = 0; y < Gdx.graphics.getHeight(); y += GRID_CELL) {        //
                shapeRenderer.rect(x,y,GRID_CELL,GRID_CELL);                      //  This can be
            }                                                                     //  removed when
        }                                                                         //  all designs
                                                                                  //  are done.
        //end                                                                     //
        shapeRenderer.end();                                                      //
    }                                                                             //
//--------------------------------------------------------------------------------//
}
