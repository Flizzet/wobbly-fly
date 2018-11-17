package com.flizzet.particles;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.flizzet.map.Map;
import com.flizzet.utils.Direction;

/**
 * Particle for hitting water.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class WaterParticle extends Particle {
	
	private float xVel = 0;
	private float yVel = 0;
	private Direction direction = Direction.LEFT;
	private Random random = new Random();
	private Color randomColor;
	
	/** Default instantiable constructor */
	public WaterParticle() {
		/* Set initial dimensions */
		this.setWidth(2);
		this.setHeight(2);
		/* Randomly determine direction of movement */
		direction = random.nextBoolean() ? Direction.LEFT : Direction.RIGHT;
		/* Randomly determine what Vels will begin at */
		xVel = random.nextInt(2) + 2;
		yVel = random.nextInt(2) + 2;
		/* Depending on random direction, set xVel */
		if (direction == Direction.LEFT) {
			xVel = -xVel;
		}
		/* Determine color */
		float shade = random.nextFloat() / 5;
		randomColor = random.nextBoolean() ?
			new Color(0.47f + shade, 0.65f + shade, 0.89f + shade, 1.0f) : new Color(1.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public void update(float delta) {
		/* Fall */
		yVel -= 0.4f;
		
		/* Constantly move xVel towards 0 */
		xVel += (0 - xVel) / 4;
		
		/* Add Vels to position */
		this.setX(this.getX() + xVel);
		this.setY(this.getY() + yVel);
		
		/* Constantly decrease by speed of Map */
		this.setX(this.getX() - Map.INSTANCE.getSpeed());
		
		/* Removal */
		if (this.getY() - this.getHeight() < 0) {
			this.remove();
		} else if (this.getX() - this.getWidth() < 0) {
			this.remove();
		}
	}

	@Override
	public void render(SpriteBatch batch, ShapeRenderer sr) {
		batch.end();
		sr.setProjectionMatrix(batch.getProjectionMatrix());
		sr.begin(ShapeType.Filled);
		sr.setColor(randomColor);
		sr.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		sr.end();
		batch.begin();
	}

	@Override
	public void reset() {}

}
