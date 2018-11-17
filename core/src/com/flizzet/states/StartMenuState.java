package com.flizzet.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.firstplayprompt.FirstPlayPrompt;
import com.flizzet.menus.startmenu.StartMenu;
import com.flizzet.music.MusicHandler;
import com.flizzet.wobblyfly.Constants;

/**
 * GameState for Start Menu.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class StartMenuState extends GameState {

	private StartMenu startMenu;
	
	/** Default instantiable constructor */
	public StartMenuState() {}

	@Override
	public void entered() {
		startMenu = new StartMenu();
		startMenu.buildMenu();
		guiContainer.add(startMenu);
		
		if (!Constants.PRIZE_GIVEN && !Constants.PLAYED_BEFORE) {
			FirstPlayPrompt prizePrompt = new FirstPlayPrompt();
			guiContainer.add(prizePrompt);
		}
		
		MusicHandler.play(MusicHandler.INSTANCE.menuMusic, 1.0f);
	}

	@Override
	public void update(float delta) {}

	@Override
	public void render(SpriteBatch batch) {}

	@Override
	public void exited() {
		guiContainer.clear();
		entityContainer.clear();
		
		MusicHandler.stop(MusicHandler.INSTANCE.menuMusic);
	}

	@Override
	public void dispose() {}

}
