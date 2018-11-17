package com.flizzet.menus.deathmenu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiConstants;
import com.flizzet.menus.Menu;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Menu that appears on death.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class DeathMenu extends Menu {
	
	private RetryButton retryButton;
	private StartMenuButton startMenuButton;

	/** Default instantiable constructor */
	public DeathMenu() {}

	@Override
	public void update(float delta) {
		/* Update all elements */
		retryButton.update(delta);
		startMenuButton.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Render all elements */
		retryButton.render(batch);
		startMenuButton.render(batch);
	}

	@Override
	public void buildMenu() {
		/* Create elements */
		retryButton = new RetryButton();
		startMenuButton = new StartMenuButton();
		/* Position retry button */
		retryButton.setX(GameWorld.INSTANCE.camera.getCenterX() - retryButton.getWidth() - (GuiConstants.SPACING / 2));
		retryButton.setY(GameWorld.INSTANCE.camera.getCenterY() - retryButton.getHalfHeight());
		/* Position back to start menu button */
		startMenuButton.setX(GameWorld.INSTANCE.camera.getCenterX() + (GuiConstants.SPACING / 2));
		startMenuButton.setY(GameWorld.INSTANCE.camera.getCenterY() - startMenuButton.getHalfHeight());
	}
	
	@Override
	public void reset() {}

}
