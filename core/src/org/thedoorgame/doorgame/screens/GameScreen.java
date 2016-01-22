package org.thedoorgame.doorgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import org.thedoorgame.doorgame.DoorGame;

/**
 * Created by Manuel on 1/21/2016.
 */
public class GameScreen implements Screen {

    final DoorGame doorGame;


    OrthographicCamera camera;


    private int width, height;

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

        doorGame.batch.begin();
        doorGame.font.draw(doorGame.batch, "GAME SCREEN!!", (width/2)-50, (height/2) );
        doorGame.batch.end();
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
