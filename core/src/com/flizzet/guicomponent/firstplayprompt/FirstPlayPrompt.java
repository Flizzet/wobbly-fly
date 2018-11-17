package com.flizzet.guicomponent.firstplayprompt;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.guicomponent.GuiConstants;
import com.flizzet.guicomponent.ScreenDarkener;
import com.flizzet.saving.Saves;
import com.flizzet.score.ScoreHolder;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Appears on a first play to grant the user a prize.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class FirstPlayPrompt extends GuiComponent {

	private ScreenDarkener darkener = new ScreenDarkener(0.5f);
	private FirstPlayPromptText text = new FirstPlayPromptText();
	private FirstPlayPromptButton button = new FirstPlayPromptButton(this);
	
	/** Default instantiable constructor */
	public FirstPlayPrompt() {
		button.setCenterX(GameWorld.INSTANCE.camera.getCenterX());
		button.setY(GameWorld.INSTANCE.camera.getCenterY() - button.getHeight() - GuiConstants.PADDING);
	}

	@Override
	public void update(float delta) {
		darkener.update(delta);
		text.update(delta);
		button.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		darkener.render(batch);
		text.render(batch);
		button.render(batch);
	}

	@Override
	public void reset() {}
	
	/** Removes the prompt from the screen and applies the prize */
	public void remove() {
		GameWorld.INSTANCE.guiContainer.remove(this);
		Constants.PRIZE_GIVEN = true;
		ScoreHolder.INSTANCE.setCoins(ScoreHolder.INSTANCE.getCoins() + 500);
		Saves.INSTANCE.savePrizeGiven();
		Saves.INSTANCE.saveScore();
	}

}
