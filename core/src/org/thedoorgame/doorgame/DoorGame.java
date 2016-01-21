package org.thedoorgame.doorgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DoorGame extends Game {
	SpriteBatch batch;
	BitmapFont font;
    //Texture img;

	MainMenuScreen mainMenuScreen;
    GameScreen gameScreen;

    @Override
	public void create () {
        batch = new SpriteBatch();
        font = new BitmapFont();




		mainMenuScreen = new MainMenuScreen(this);
        gameScreen = new GameScreen(this);

        this.setScreen(new MainMenuScreen(this));

        //img = new Texture("badlogic.jpg");
	}

	public void render () {
        super.render();
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}

    public void dispose() {
        batch.dispose();
        font.dispose();
    }


}
