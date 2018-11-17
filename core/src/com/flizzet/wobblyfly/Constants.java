package com.flizzet.wobblyfly;

/**
 * Holds public values for use around the codebase.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class Constants {
	
	public static final boolean EVERYTHING_FREE = true;
	public static final boolean SHOW_COLLISIONS = false;
	public static final boolean DEBUG_INVINCIBLE = false;
	public static boolean PLAYED_BEFORE = false;
	public static boolean PRIZE_GIVEN = false;
	public static boolean ADS_PLAYABLE = false;
	
	public static boolean LEVEL_1_UNLOCKED = true;
	public static boolean LEVEL_2_UNLOCKED = true;
	public static boolean LEVEL_3_UNLOCKED = true;
	public static boolean LEVEL_4_UNLOCKED = true;
	
	public static boolean SOUND = true;
	public static float SOUND_VOLUME = 1f;
	public static boolean MUSIC = true;
	public static float MUSIC_VOLUME = 1f;

	/** Suppress default constructor for noninstantiability */
	private Constants() {
		throw new AssertionError();
	}

}
