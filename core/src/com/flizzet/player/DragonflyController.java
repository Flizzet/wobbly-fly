package com.flizzet.player;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.flizzet.interfaces.Updatable;
import com.flizzet.map.Map;

/**
 * Controls {@link Dragonfly}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class DragonflyController implements Updatable {

	private final Dragonfly target;
	private float yVel = 0;
	private float maximumYVel = 6;
	private float weight = 10;
	
	/** Default instantiable constructor */
	public DragonflyController(Dragonfly target) {
		this.target = target;
	}

	@Override
	public void update(float delta) {
		switch (target.getState()) {
		case ALIVE:
			updateAlive();
			break;
		case DEAD:
			updateDead();
			break;
		}
	}
	
	/** Update method called when the {@link Dragonfly} is alive */
	private void updateAlive() {
		
		/* Get accelerometer amount */
		float accelY = Gdx.input.getAccelerometerY();
		/* Apply accelY to yVel */
		if (accelY <= maximumYVel || accelY >= maximumYVel) {
			yVel += (accelY - yVel) / weight;
		}
		if (Gdx.app.getType() == ApplicationType.Desktop) {
			if (Gdx.input.isTouched()) {
				yVel += (maximumYVel - yVel) / weight;
			} else {
				yVel += (-maximumYVel - yVel) / weight;
			}
		}
		
		/* Apply yVel to Dragonfly */
		target.setY(target.getY() + yVel);
		
		/* Apply rotation to Dragonfly */
		target.setRotation(yVel * 4);
	}
	
	/** Update method called when the {@link Dragonfly} is dead */
	private void updateDead() {
		/* Fall constantly */
		yVel -= 0.5;

		/* Apply yVel to Dragonfly */
		target.setY(target.getY() + yVel);
		
		target.setX(target.getX() - Map.INSTANCE.getSpeed());
	}
	

	public void setYVel(float newYVel)	{ this.yVel = newYVel; }
	
	public float getYVel()				{ return this.yVel; }
	public float getMaximumYVel()		{ return this.maximumYVel; }
	
}
