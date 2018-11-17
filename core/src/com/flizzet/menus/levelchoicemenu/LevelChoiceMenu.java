package com.flizzet.menus.levelchoicemenu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.guicomponent.GuiConstants;
import com.flizzet.menus.Menu;
import com.flizzet.menus.startmenu.MenuBackground;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Menu for choosing level.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class LevelChoiceMenu extends Menu {
	
	private LevelOneButton levelOneButton;
	private LevelTwoButton levelTwoButton;
	private LevelThreeButton levelThreeButton;
	private LevelFourButton levelFourButton;
	private MenuBackground background = new MenuBackground();

	/** Default instantiable constructor */
	public LevelChoiceMenu() {}

	@Override
	public void update(float delta) {
	}

	@Override
	public void render(SpriteBatch batch) {
	}

	@Override
	public void buildMenu() {
		levelOneButton = new LevelOneButton();
		levelTwoButton = new LevelTwoButton();
		levelThreeButton = new LevelThreeButton();
		levelFourButton = new LevelFourButton();
		
		/* Position all buttons */
		ButtonComponent[] buttons = new ButtonComponent[] { levelOneButton, levelTwoButton, levelThreeButton, levelFourButton };
		float fullWidth = (levelOneButton.getWidth() * buttons.length) + (GuiConstants.SPACING * (buttons.length - 1));
		int totalButtons = 0;
		for (ButtonComponent b : buttons) {
			b.setX(GameWorld.INSTANCE.camera.getCenterX() - (fullWidth / 2)
					+ (totalButtons * levelOneButton.getWidth()));
			b.setX(b.getX() + (totalButtons * GuiConstants.PADDING));
			b.setY(GameWorld.INSTANCE.camera.getCenterY() - b.getHalfHeight());
			totalButtons++;
		}
		
		/* Position background */
		background.setCenterX(GameWorld.INSTANCE.camera.getCenterX());
		background.setCenterY(GameWorld.INSTANCE.camera.getCenterY());
		
		/* Add all to GuiContainer */
		GameWorld.INSTANCE.guiContainer.add(background);
		GameWorld.INSTANCE.guiContainer.add(levelOneButton);
		GameWorld.INSTANCE.guiContainer.add(levelTwoButton);
		GameWorld.INSTANCE.guiContainer.add(levelThreeButton);
		GameWorld.INSTANCE.guiContainer.add(levelFourButton);
	}
	
	@Override
	public void reset() {
	}

}
