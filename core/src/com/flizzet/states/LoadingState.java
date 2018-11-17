package com.flizzet.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.menus.loadingmenu.LoadingMenu;
import com.flizzet.music.MusicHandler;
import com.flizzet.player.DragonflyType;
import com.flizzet.saving.Saves;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Loading state.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class LoadingState extends GameState {
	
	private LoadingMenu menu;

    /** Default instantiable constructor */
    public LoadingState() {
    }

    @Override
    public void entered() {
    	/* Set up asset ArrayLists */
    	AssetInfo.setUpArrayLists();
    	/* Load all graphical assets */
    	world.assets.loadAll();
    	/* Load all sound assets */
    	SoundHandler.INSTANCE.loadSounds();
    	/* Load all music assets */
    	MusicHandler.INSTANCE.loadMusic();
    	/* Create menu */
    	menu = new LoadingMenu();
    	guiContainer.add(menu);
    }
    
    @Override
    public void update(float delta) {
    	System.out.println("Loading");
    	/* Check if assets are loaded, if they are move to Start Menu */
    	if (world.assets.isFinishedLoading()) {
        	/* Load saved values */
        	Saves.INSTANCE.load();
        	GameWorld.INSTANCE.currentDragonfly = DragonflyType.DIAMOND_DRAGONFLY;
        	/* Enter game state */
    		world.states.enterState(State.START_MENU);
    	}
    }

    @Override
    public void render(SpriteBatch batch) {
    }

    @Override
    public void exited() {}

    @Override
    public void dispose() {}

}
