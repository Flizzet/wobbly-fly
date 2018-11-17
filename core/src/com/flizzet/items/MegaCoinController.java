package com.flizzet.items;

import java.util.Random;

import com.flizzet.interfaces.Updatable;
import com.flizzet.map.Map;
import com.flizzet.map.ground.Ground;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Controls the {@MegaCoin}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class MegaCoinController implements Updatable {

	private final MegaCoin target;
	private Random random = new Random();
	public enum MegaCoinMovementState { BUZZING, DEAD; }
	private MegaCoinMovementState currentState = MegaCoinMovementState.BUZZING;
	private int maximumCooldown = 50;
	private int minimumCooldown = 20;
	private int cooldown = maximumCooldown;
    private float targetX = 300;
    private float targetY = 300;
    private float speed = 5;
    private float yVel = 5;
    private float targetRotation = 0;
	
	/** Default instantiable constructor */
	public MegaCoinController(MegaCoin target) {
		this.target = target;
		/* Set initial random target position */
		targetX = (float) (Math.random() * GameWorld.INSTANCE.camera.getWidth());
	    targetY = (float) (Math.random() * GameWorld.INSTANCE.camera.getHeight());
	}

	@Override
	public void update(float delta) {
		switch (currentState) {
		case BUZZING:
			updateBuzzing();
			break;
		case DEAD:
			updateDead();
			break;
		}
	}
	
	/** Updates MegaCoin movement when in buzzing state */
	private void updateBuzzing() {
		/* Update cooldowns */
		cooldown--;
		if (cooldown <= 0) {
		    findNewPosition();
		}
		
		/* Determine the distance needed to move closer to target position */
		float distanceX = (targetX - target.getCenterX()) / speed;
		float distanceY = (targetY - target.getCenterY()) / speed;
		/* Add distance to position */
		target.setX(target.getX() + distanceX);
		target.setY(target.getY() + distanceY);
		
		/* Determine the distance needed to move closer to target rotation */
		float distanceRotation = (targetRotation - target.getRotation()) / 20;
		/* Add distance to rotation */
		target.setRotation(target.getRotation() + distanceRotation);
	}
	
	/** Updates MegaCoin when in dead state */
	private void updateDead() {
		/* Decrease yVel */
		yVel -= .5f;
		/* Apply yVel to position */
		target.setY(target.getY() + yVel);
		/* Move horizontally at the move of the speed of the map */
		target.setX(target.getX() - Map.INSTANCE.getSpeed());
		/* Apply yVel to rotation */
		target.setRotation(target.getRotation() + yVel * 4);
	}

	/** Finds a new position for the MegaCoin to fly towards */
	private void findNewPosition() {
		/* Determine new target position */
		targetX = (float) (Math.random() * GameWorld.INSTANCE.camera.getWidth());
	    targetY = Ground.INSTANCE.getHeight() + (float) (Math.random() * 
	    		GameWorld.INSTANCE.camera.getHeight() - Ground.INSTANCE.getHeight());
	    /* Determine a new random rotation */
	    targetRotation = (float) (Math.random() * 10);
	    /* Randomly set rotation to negative */
	    targetRotation = random.nextBoolean() ? -targetRotation : targetRotation;
	    /* Set a new cooldown */
		cooldown = random.nextInt(maximumCooldown - minimumCooldown) + minimumCooldown;
	}
	
	public MegaCoinMovementState getState()					{ return this.currentState; }
	
}
