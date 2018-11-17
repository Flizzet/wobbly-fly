package com.flizzet.enemy.cavecritter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.enemy.Enemy;
import com.flizzet.enemy.FlyingEnemyAi;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Critter to pop out of caves.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class CaveCritter extends Enemy {

	private FlyingEnemyAi ai = new FlyingEnemyAi(this);
	private CaveCritterCollision collision = new CaveCritterCollision(this);
	private CaveCritterAnimator animator = new CaveCritterAnimator(this);
	
	/** Default instantiable constructor */
	public CaveCritter() {
		ai.setYHomingSpeed(20);
	}

	@Override
	public void update(float delta) {
		ai.update(delta);
		animator.update(delta);
		collision.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		animator.render(batch);
		collision.render(batch);
	}

	@Override
	public void reset() {
	}
	
	/** Kills this */
	public void kill() {
		ai.setState(FlyingEnemyAi.FlyingMovementState.DEAD);
		/* Play death sound */
		SoundHandler.play(SoundHandler.INSTANCE.hornetDeath, 1.0f);
	}
	
	/** Removes this */
	public void remove() {
		GameWorld.INSTANCE.entityContainer.remove(this);
	}
	
	public FlyingEnemyAi getAi()	{ return this.ai; }

}
