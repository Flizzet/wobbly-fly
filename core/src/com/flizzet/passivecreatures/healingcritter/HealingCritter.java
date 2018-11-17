package com.flizzet.passivecreatures.healingcritter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.entity.Entity;
import com.flizzet.player.Dragonfly;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Mosquito that flies around and adds health when tapped.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class HealingCritter extends Entity {
	
	private float rotation = 0;
	private HealingCritterAnimator animator;
	private HealingCritterAi ai;
	private HealingCritterCollision collision;
	private float healthAddingAmount = 15;

	/** Default instantiable constructor */
	public HealingCritter() {
		animator = new HealingCritterAnimator(this);
		ai = new HealingCritterAi(this);
		collision = new HealingCritterCollision(this);
	}

	@Override
	public void update(float delta) {
		animator.update(delta);
		ai.update(delta);
		collision.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		animator.render(batch);
		collision.render(batch);
	}
	
	/** Kills mosquito, adds to player health */
	public void kill() {
		/* Kill the AI */
		ai.setState(HealingCritterAi.MosquitoMovementState.DEAD);
		/* Add to the health of the DragonFly */
		Dragonfly.INSTANCE.addToHealth(healthAddingAmount);
		/* Play death sound */
		SoundHandler.play(SoundHandler.INSTANCE.mosquitoDeath, 1.0f);
	}

	/** Removes itself from existence */
	public void remove() {
		GameWorld.INSTANCE.entityContainer.remove(this);
	}
	
	@Override
	public void reset() {}

	public void setRotation(float newRotation)	{ this.rotation = newRotation; }
	
	public float getRotation()					{ return this.rotation; }
	public HealingCritterAi getAi()					{ return this.ai; }
	
}
