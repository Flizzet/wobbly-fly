package com.flizzet.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.menus.levelchoicemenu.LevelChoiceMenu;

/**
 * State for level choice.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class LevelChoiceState extends GameState {

	private LevelChoiceMenu menu;
	
	/** Default instantiable constructor */
	public LevelChoiceState() {
	}

	@Override
	public void entered() {
		menu = new LevelChoiceMenu();
		menu.buildMenu();
		guiContainer.add(menu);
	}

	@Override
	public void update(float delta) {}

	@Override
	public void render(SpriteBatch batch) {}

	@Override
	public void exited() {
		entityContainer.clear();
		guiContainer.clear();
	}

	@Override
	public void dispose() {}

}
