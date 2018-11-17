package com.flizzet.menus.startmenu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.guicomponent.GuiConstants;
import com.flizzet.menus.Menu;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Start menu. Initial menu.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class StartMenu extends Menu {

	private MenuBackground background;
	private ButtonComponent playButton;
	private ButtonComponent shopButton;
	private StartMenuLogo logo;
	private StartMenuScoreDisplay scoreDisplay;
	
	/** Default instantiable constructor */
	public StartMenu() {
	}
	
	@Override
	public void update(float delta) {
		/* Update elements */
		background.update(delta);
		playButton.update(delta);
		shopButton.update(delta);
		logo.update(delta);
		scoreDisplay.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Render elements */
		background.render(batch);
		playButton.render(batch);
		shopButton.render(batch);
		logo.render(batch);
		scoreDisplay.render(batch);
	}

	@Override
	public void buildMenu() {
		background = new MenuBackground();
		playButton = new PlayButton();
		shopButton = new ShopButton();
		logo = new StartMenuLogo();
		scoreDisplay = new StartMenuScoreDisplay();
		
		/* Position background */
		background.setX(GameWorld.INSTANCE.camera.getX()
				+ GameWorld.INSTANCE.camera.getWidth() / 2 - background.getHalfWidth());
		background.setY(GameWorld.INSTANCE.camera.getY()
				+ GameWorld.INSTANCE.camera.getHeight() / 2 - background.getHalfHeight());
		/* Position PlayButton */
		playButton.setX(GameWorld.INSTANCE.camera.getWidth() - playButton.getWidth() - GuiConstants.SPACING);
		playButton.setY(GuiConstants.SPACING);
		/* Position ShopButton relative to PlayButton */
		shopButton.setX(playButton.getX() - shopButton.getWidth() - GuiConstants.PADDING);
		shopButton.setY(GuiConstants.SPACING);
		/* Position Logo */
		logo.setX(GuiConstants.SPACING);
		logo.setY(GameWorld.INSTANCE.camera.getHeight() - GuiConstants.SPACING - logo.getHeight());
		/* Position score display */
		scoreDisplay.setX(GuiConstants.SPACING);
		scoreDisplay.setY(GuiConstants.SPACING);
	}

	@Override
	public void reset() {}

}
