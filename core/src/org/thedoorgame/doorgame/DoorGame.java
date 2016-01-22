package org.thedoorgame.doorgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.thedoorgame.doorgame.screens.GameScreen;
import org.thedoorgame.doorgame.screens.MainMenuScreen;

public class DoorGame extends Game {

    public static final String TITLE = "Door Game", VERSION = "0.0.0.0.1";

	public SpriteBatch batch;
	public BitmapFont font;
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

	}

	public void render () {
        super.render();
	}

    public void dispose() {
        batch.dispose();
        font.dispose();
    }


}
