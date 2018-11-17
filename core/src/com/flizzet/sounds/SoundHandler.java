package com.flizzet.sounds;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.flizzet.wobblyfly.Constants;

/**
 * Holds all sounds needed through the game.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class SoundHandler {

	public static SoundHandler INSTANCE = new SoundHandler();

	/* Play */
	public Sound click;
	public Sound dragonflyDeath;
	public Sound dragonflyFlap;
	public Sound hornetDeath;
	public Sound mosquitoDeath;
	public Sound megaCoinCollect;
	
	private List<Sound> sounds = new ArrayList<Sound>();

	/** Single-use constructor */
	private SoundHandler() {}

	/** Loads all sounds into memory */
	public void loadSounds() {
		sounds.add(click = Gdx.audio.newSound(Gdx.files.internal("sounds/click.ogg")));
		sounds.add(dragonflyDeath = Gdx.audio.newSound(Gdx.files.internal("sounds/dragonfly-death.ogg")));
		sounds.add(dragonflyFlap = Gdx.audio.newSound(Gdx.files.internal("sounds/dragonfly-flap.ogg")));
		sounds.add(hornetDeath = Gdx.audio.newSound(Gdx.files.internal("sounds/hornet-death.ogg")));
		sounds.add(mosquitoDeath = Gdx.audio.newSound(Gdx.files.internal("sounds/mosquito-death.ogg")));
		sounds.add(megaCoinCollect = Gdx.audio.newSound(Gdx.files.internal("sounds/megacoin-collect.ogg")));
	}

	/** Removes all sounds from memory */
	public void dispose() {
		for (Sound s : sounds) {
			s.dispose();
		}
	}

	/** Plays a sound multiplied by the game volume */
	public static void play(Sound sound, float volume) {
		if (Constants.SOUND) {
			sound.play(volume * Constants.SOUND_VOLUME);
		}
	}

	/** Plays a sound multiplied by the game volume with pitch */
	public static void play(Sound sound, float volume, float pitch) {
		if (Constants.SOUND) {
			long id = sound.play(volume * Constants.SOUND_VOLUME);
			sound.setPitch(id, pitch);
		}
	}

	/** Plays a sound multiplied by the game volume with looping */
	public static void play(Sound sound, float volume, boolean looping) {
		if (Constants.SOUND) {
			long id = sound.play(volume * Constants.SOUND_VOLUME);
			sound.setLooping(id, looping);
		}
	}

	/** Stops a sound */
	public static void stop(Sound sound) {
		sound.stop();
	}
}
