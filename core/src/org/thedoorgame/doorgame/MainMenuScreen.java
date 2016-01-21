package org.thedoorgame.doorgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {


    final DoorGame doorGame;

    OrthographicCamera camera;

    private int width, height;

    // constructor to keep a reference to the main DoorGame class
    public MainMenuScreen(DoorGame doorGame){
        this.doorGame = doorGame;

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        doorGame.batch.setProjectionMatrix(camera.combined);


        doorGame.batch.begin();
        doorGame.font.draw(doorGame.batch, "Welcome to Door Game!!", (width/2)-50, (height/2) );
        doorGame.font.draw(doorGame.batch, "Tap anywhere to begin!", (width/2)-50, (height/2)-50 );
        doorGame.batch.end();

        // update and draw stuff
        if (Gdx.input.isTouched()) { // use your own criterion here
            doorGame.setScreen(new GameScreen(doorGame));
            dispose();
        }
    }


    @Override
    public void resize(int width, int height) {
    }


    @Override
    public void show() {
        // called when this screen is set as the screen with doorGame.setScreen();
    }


    @Override
    public void hide() {
        // called when current screen changes from this to a different screen
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
    }
}