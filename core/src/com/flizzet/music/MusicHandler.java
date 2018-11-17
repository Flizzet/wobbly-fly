package com.flizzet.music;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.flizzet.wobblyfly.Constants;

/**
 * Holds all music needed through the game.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class MusicHandler {

	public static MusicHandler INSTANCE = new MusicHandler();
	
	/* All musics */
	public Music menuMusic;
	public Music diamondMusic;
	public Music opalMusic;
	public Music rubyMusic;
	public Music swampMusic;
	
	private List<Music> musics = new ArrayList<Music>();
	
	/** Single use constructor */
	private MusicHandler() {
	}
	
	/** Loads all music into memory */
	public void loadMusic() {
		musics.add(menuMusic = Gdx.audio.newMusic(Gdx.files.internal("music/menu_music.ogg")));
		musics.add(diamondMusic = Gdx.audio.newMusic(Gdx.files.internal("music/diamond_music.ogg")));
		musics.add(opalMusic = Gdx.audio.newMusic(Gdx.files.internal("music/opal_music.ogg")));
		musics.add(rubyMusic = Gdx.audio.newMusic(Gdx.files.internal("music/ruby_music.ogg")));
		musics.add(swampMusic = Gdx.audio.newMusic(Gdx.files.internal("music/swamp_music.ogg")));
	}

	/** Plays a music multiplied by the game volume */
	public static void play(Music music, float volume) {
		if (Constants.MUSIC) {
			music.setVolume(volume * Constants.MUSIC_VOLUME);
			music.play();
		}
	}
	
	/** Plays a music multiplied by the game volume with looping */
	public static void play(Music music, float volume, boolean looping) {
		if (Constants.MUSIC) {
			music.setLooping(looping);
			music.setVolume(volume * Constants.MUSIC_VOLUME);
			music.play();
		}
	}

	/** Stops a music */
	public static void stop(Music music) {
		music.stop();
	}
	
	/** Removes all musics from memory */
	public void dispose() {
		for (Music m : musics) {
			m.dispose();
		}
	}
	
}
