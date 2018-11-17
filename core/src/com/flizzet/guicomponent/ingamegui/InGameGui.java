package com.flizzet.guicomponent.ingamegui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.guicomponent.GuiConstants;
import com.flizzet.player.Dragonfly;
import com.flizzet.wobblyfly.GameWorld;

/**
 * In Game heads up display.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class InGameGui extends GuiComponent {
	
	private HealthBar healthBar;
	private ScoreDisplay scoreDisplay;

	/** Default instantiable constructor */
	public InGameGui() {}

	@Override
	public void update(float delta) {
		healthBar.update(delta);
		scoreDisplay.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		healthBar.render(batch);
		scoreDisplay.render(batch);
	}
	
	public void build() {
		healthBar = new HealthBar(Dragonfly.INSTANCE);
		scoreDisplay = new ScoreDisplay();
		
		/* Position HealthBar */
		healthBar.setX(GameWorld.INSTANCE.camera.getCenterX() - healthBar.getHalfWidth());
		healthBar.setY(GameWorld.INSTANCE.camera.getHeight() - this.getHeight() - GuiConstants.PADDING);
		/* Position ScoreDisplay */
		scoreDisplay.setX(GuiConstants.PADDING);
		scoreDisplay.setY(GameWorld.INSTANCE.camera.getHeight() - GuiConstants.PADDING);
	}

	@Override
	public void reset() {}

}
