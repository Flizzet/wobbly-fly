package com.flizzet.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Midstate for resetting everything and returning into GameplayState.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class RestartingState extends GameState {

	private float queueCooldown = 3;
	
	/** Default instantiable constructor */
	public RestartingState() {
	}

	@Override
	public void entered() {
	}

	@Override
	public void update(float delta) {
		queueCooldown--;
		if (queueCooldown <= 0) {
			GameWorld.INSTANCE.states.enterState(State.GAMEPLAY);
		}
	}

	@Override
	public void render(SpriteBatch batch) {
	}

	@Override
	public void exited() {
		entityContainer.clear();
		guiContainer.clear();
		queueCooldown = 3;
	}

	@Override
	public void dispose() {
	}

}
