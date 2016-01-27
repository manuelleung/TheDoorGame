package org.thedoorgame.doorgame;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by Leibniz H. Berihuete on 1/27/2016.
 */
public class GameSound {
    // This is where all the sounds will be listed:
    private static final Sound GAME_MUSIC_AUDIO = Gdx.audio.newSound(Gdx.files.internal("sound/game_music.wav"));
    private static final Sound DOOR_OPENING_AUDIO = Gdx.audio.newSound(Gdx.files.internal("sound/door_opening.wav"));
    private static final Sound DOOR_CLOSING_AUDIO = Gdx.audio.newSound(Gdx.files.internal("sound/door_closing.wav"));

    // This is where all the static values-access will be listed:
    public static final int GAME_MUSIC = 0;
    public static final int DOOR_OPENING = 1;
    public static final int DOOR_CLOSING = 2;




    public Sound getSound(int audio) {
        switch (audio) {
            case GAME_MUSIC:
                return GAME_MUSIC_AUDIO;

            case DOOR_OPENING:
                return DOOR_OPENING_AUDIO;

            case DOOR_CLOSING:
                return DOOR_CLOSING_AUDIO;
            default:
                return null;
        }
    }
}
