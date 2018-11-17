package com.flizzet.particles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.flizzet.entity.Entity;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Abstract particle for concrete Particles.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public abstract class Particle extends Entity {

	/** Default instantiable constructor */
	public Particle() {}
	
	public abstract void render(SpriteBatch batch, ShapeRenderer sr);

	/** Block render from being used */
	@Override
	public void render(SpriteBatch batch) { throw new AssertionError(); }
	
	public void remove() {
		GameWorld.INSTANCE.particleContainer.remove(this);
	}
	
}
