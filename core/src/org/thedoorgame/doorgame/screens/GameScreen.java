package org.thedoorgame.doorgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import org.thedoorgame.doorgame.DoorGame;

/**
 * Created by Manuel on 1/21/2016.
 */
public class GameScreen implements Screen {

    final DoorGame doorGame;


    OrthographicCamera camera;


    private int width, height;

    public GameScreen(DoorGame doorGame) {
        this.doorGame = doorGame;

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();
        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        doorGame.batch.setProjectionMatrix(camera.combined);

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

    }

    @Override
    public void dispose() {

    }
}
