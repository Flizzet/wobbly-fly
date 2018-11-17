package com.flizzet.enemy.hornet;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.enemy.Enemy;
import com.flizzet.enemy.FlyingEnemyAi;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Hornet enemy from swamp environment.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class EnemyHornet extends Enemy {

	private EnemyHornetAnimator animator;
	private FlyingEnemyAi ai;
	private EnemyHornetCollision collision;
	
	/** Default instantiable constructor */
	public EnemyHornet() {
		animator = new EnemyHornetAnimator(this);
		ai = new FlyingEnemyAi(this);
		collision = new EnemyHornetCollision(this);
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
	
	/** Kills the Enemy Hornet */
	public void kill() {
		ai.setState(FlyingEnemyAi.FlyingMovementState.DEAD);
		/* Play death sound */
		SoundHandler.play(SoundHandler.INSTANCE.hornetDeath, 1.0f);
	}
	
	/** Removes itself from existence */
	public void remove() {
		GameWorld.INSTANCE.entityContainer.remove(this);
	}

	@Override
	public void reset() {}
	
	public FlyingEnemyAi getAi()				{ return this.ai; }
	public float getRotation()					{ return this.rotation; }
	
	public void setRotation(float newRotation)	{ this.rotation = newRotation; }

}
