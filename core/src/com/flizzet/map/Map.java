package com.flizzet.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.entity.Entity;
import com.flizzet.map.ground.Ground;

/**
 * Holds all map components and manages speeds.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class Map extends Entity {
	
	public static final Map INSTANCE = new Map();
	
	private float minimumSpeed = 3f;
	private float speed = minimumSpeed;
	private float speedIncreaseAmount = 0.00005f;
	private float backgroundParallaxAmount = .6f;
	private float groundDecorationParallaxAmount = .8f;
	private Environment environment = Environment.RUBY;
	
	/* Inner map pieces */
	private MapBackground background = new MapBackground(this);

	/** Single use constructor */
	private Map() {}

	@Override
	public void update(float delta) {
		speed += speedIncreaseAmount;
		/* Update inner components */
		background.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Render inner components */
		background.render(batch);
	}

	@Override
	public void reset() {
		speed = minimumSpeed;
	}
	
	public void setEnvironment(Environment newEnvironment)	{
		this.environment = newEnvironment;
		background.setEnvironment(newEnvironment);
		Ground.INSTANCE.setEnvironment(newEnvironment);
	}
	
	public Environment getEnvironment()						{ return this.environment; }
	public float getSpeed()									{ return this.speed; }
	public float getBackgroundParallaxAmount()				{ return this.backgroundParallaxAmount; }
	public float getDecorationParallaxAmount()				{ return this.groundDecorationParallaxAmount; }
	
}
