package com.flizzet.saving;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.flizzet.player.DragonflyType;
import com.flizzet.score.ScoreHolder;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Handles saving and loading.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class Saves {
    
    public static final Saves INSTANCE = new Saves();
    public static Preferences prefs = Gdx.app.getPreferences("flizzetwf004");
    
    /** Private single use constructor */
    private Saves() {}
    
    /** Returns an instance of the Saves class */
	public static Saves getInstance() {
		return INSTANCE;
    }
    
    /** Saves to the save file */
    public void save() {
		saveScore();
		prefs.flush();
    }
    
    /** Loads from the save file */
    public void load() {
    	Constants.PLAYED_BEFORE = prefs.getBoolean("playedBefore");
    	Constants.PRIZE_GIVEN = prefs.getBoolean("prizeGiven");
    	/* Load if played before */
    	if (Constants.PLAYED_BEFORE) {
    		loadScore();
	    	loadDragonflies();
    	} else {
    		/* Set default dragonfly and save it */
    		GameWorld.INSTANCE.currentDragonfly = DragonflyType.SWAMP_DRAGONFLY;
    		saveDragonflies();
    	}
    }
    
    /** Loads score values */
    public void loadScore() {
    	ScoreHolder.INSTANCE.setHighScore(prefs.getInteger("highScore"));
    	ScoreHolder.INSTANCE.setCoins(prefs.getInteger("coins"));
    }
    
    public void loadDragonflies() {
    	/* Load equipped dragonfly */
    	GameWorld.INSTANCE.currentDragonfly = DragonflyType.values()[prefs.getInteger("currentDragonfly")];
    	/* Load which dragonflies are purchased */
    	for (DragonflyType t : DragonflyType.values()) {
    		t.setPurchased(prefs.getBoolean(t.toString() + "Purchased", t.isPurchased()));
    	}
    }
    
    /** Saves the economy elements to the save file */
    public void saveScore() {
    	prefs.putInteger("highScore", ScoreHolder.INSTANCE.getHighScore());
    	prefs.putInteger("coins", ScoreHolder.INSTANCE.getCoins());
    	prefs.flush();
    }
    
    /** Saves Dragonflies and current Dragonfly to the save file */
    public void saveDragonflies() {
    	/* Save the current dragonfly */
    	prefs.putInteger("currentDragonfly", GameWorld.INSTANCE.currentDragonfly.ordinal());
    	/* Save which dragonflies are purchased */
    	for (DragonflyType t : DragonflyType.values()) {
    		prefs.putBoolean(t.toString() + "Purchased", t.isPurchased());
    	}
    }
    
    /** Saves whether or not the user has played before */
    public void savePlayedBefore() {
    	prefs.putBoolean("playedBefore", Constants.PLAYED_BEFORE);
    	Gdx.app.log("Saves", "playedBefore boolean saved.");
    }
    
    /** Saves whether or not a prize has been given */
    public void savePrizeGiven() {
    	prefs.putBoolean("prizeGiven", Constants.PRIZE_GIVEN);
    }
    
    public Preferences get(Preferences prefs)	{ return prefs; }
    
}
