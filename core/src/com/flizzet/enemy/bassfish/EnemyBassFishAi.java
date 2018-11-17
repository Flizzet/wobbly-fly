package com.flizzet.enemy.bassfish;

import com.flizzet.interfaces.Updatable;
import com.flizzet.map.Map;
import com.flizzet.map.ground.Ground;
import com.flizzet.particles.ParticleFunctions;
import com.flizzet.player.Dragonfly;
import com.flizzet.player.DragonflyType;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Controls the {@link EnemyBassFish}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class EnemyBassFishAi implements Updatable {
	
	private final EnemyBassFish target;
	
	private float xVel, yVel;
	private float bounceYVel = 4;
	private float weight = .1f;
	private float jumpZone = 100;
	private float warnZone = 30;
	private boolean jumped = false;
	private boolean warned = false;
	public float rotationSpeed = 10;	// Less is more
	
	/** Default instantiable constructor */
	public EnemyBassFishAi(EnemyBassFish target) {
		this.target = target;
		
		/* Set initial position */
		target.setY(Ground.INSTANCE.getY() + Ground.INSTANCE.getHeight());
		target.setX(GameWorld.INSTANCE.camera.getWidth() / 2);
	}

	@Override
	public void update(float delta) {
		/* Check if within proximity of Dragonfly */
		Dragonfly df = Dragonfly.INSTANCE;
		/* Throw a warning when nearing jump */
		if (target.getX() < df.getX() + jumpZone + warnZone && !warned) {
			warned = true;
			ParticleFunctions.INSTANCE.addWarningParticle(target.getCenterX(), target.getY() + 15, true);
		}
		/* Jumping if near */
		if (target.getX() < df.getX() + jumpZone && !jumped) {
			jump();
		}
		
		/* Constantly move downwards if jumped */
		if (jumped) {
			yVel = yVel - (1 * weight);
		} else {
			yVel = 0;
		}
		
		/* Constantly move to the left at the speed of the map */
		xVel = GameWorld.INSTANCE.currentDragonfly == DragonflyType.SWAMP_DRAGONFLY ? -Map.INSTANCE.getSpeed() / 2 : -Map.INSTANCE.getSpeed();
		
		/* Set rotation based on vertical velocity */
		float rotationDistance = 0;
		if (yVel > 0) {
			rotationDistance = (-75 - target.getRotation()) / rotationSpeed;
		} else if (yVel < 0) {
			rotationDistance = (75 - target.getRotation()) / rotationSpeed;
		}
		target.setRotation(target.getRotation() + rotationDistance);
		
		/* Apply velocities to fish position */
		target.setX(target.getX() + xVel);
		target.setY(target.getY() + yVel);
	}
	
	/** Triggers the bass fish jump */
	private void jump() {
		jumped = true;
		yVel = bounceYVel;
		/* Add water particles */
		ParticleFunctions.INSTANCE.addWaterParticle(target.getCenterX(), 
				Ground.INSTANCE.getY() + Ground.INSTANCE.getHeight(), 5);
	}
	
	public float getYVel()				{ return this.yVel; }
	
	public void setYVel(float newYVel)	{ this.yVel = newYVel; }
	
}
