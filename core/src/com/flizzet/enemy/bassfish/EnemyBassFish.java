package com.flizzet.enemy.bassfish;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.enemy.Enemy;
import com.flizzet.spawners.enemyspawners.EnemyBassFishSpawner;

/**
 * Bass fish enemy. Jumps out of water at player. Appears in Swamp Environment.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class EnemyBassFish extends Enemy {

	private EnemyBassFishCollision collision = new EnemyBassFishCollision(this);
	private EnemyBassFishAi ai = new EnemyBassFishAi(this);
	private EnemyBassFishAnimator animator = new EnemyBassFishAnimator(this);
	private float rotation = 0;
	private EnemyBassFishSpawner spawner;
	
	/** Default instantiable constructor */
	public EnemyBassFish(EnemyBassFishSpawner spawner) {
		this.spawner = spawner;
	}

	@Override
	public void update(float delta) {
		/* Update components */
		collision.update(delta);
		ai.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Render components */
		animator.render(batch);
		collision.render(batch);
	}

	@Override
	public void reset() {}
	
	public void remove() {
		spawner.removeEntity(this);
	}
	
	public void setRotation(float newRotation)		{ this.rotation = newRotation; }
	
	public EnemyBassFishCollision getCollision()	{ return this.collision; }
	public EnemyBassFishAi getAi()					{ return this.ai; }
	public float getRotation()						{ return this.rotation; }

}
