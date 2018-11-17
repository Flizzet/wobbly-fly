package com.flizzet.passivecreatures.healingcritter;

import java.util.Random;

import com.flizzet.interfaces.Updatable;
import com.flizzet.map.Map;
import com.flizzet.map.ground.Ground;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Controls the {@Mosquito}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class HealingCritterAi implements Updatable {

	private final HealingCritter target;
	private Random random = new Random();
	public enum MosquitoMovementState { BUZZING, DEAD; }
	private MosquitoMovementState currentState = MosquitoMovementState.BUZZING;
	private int maximumCooldown = 150;//50;
	private int minimumCooldown = 100;//20;
	private int cooldown = maximumCooldown;
    private float targetX = 300;
    private float targetY = 300;
    private float speed = 5;
    private float yVel = 5;
    private float targetRotation = 0;
    /* Local jittering */
    private float localTargetX = 20;
    private float localTargetY = 20;
    private int maximumLocalCooldown = 15;
    private int minimumLocalCooldown = 10;
    private int localCooldown = maximumLocalCooldown;
	
	/** Default instantiable constructor */
	public HealingCritterAi(HealingCritter target) {
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
	
	/** Updates mosquito movement when in buzzing state */
	private void updateBuzzing() {
		/* Update cooldowns */
		cooldown--;
		if (cooldown <= 0) {
		    findNewPosition();
		}
		localCooldown--;
		if (localCooldown <= 0) {
			findNewLocalPosition();
		}
		
		/* Determine the distance needed to move closer to target position */
		float distanceX = (targetX - localTargetX - target.getCenterX()) / speed;
		float distanceY = (targetY + localTargetY - target.getCenterY()) / speed;
		/* Add distance to position */
		target.setX(target.getX() + distanceX);
		target.setY(target.getY() + distanceY);
		
		/* Determine the distance needed to move closer to target rotation */
		float distanceRotation = (targetRotation - target.getRotation()) / 20;
		/* Add distance to rotation */
		target.setRotation(target.getRotation() + distanceRotation);
	}
	
	/** Updates mosquito when in dead state */
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

	/** Finds a new position for the Mosquito to fly towards */
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
	
	/** Finds a new close position for the Mosquito to fly towards */
	private void findNewLocalPosition() {
		/* Determine new target local position */
		localTargetX = (float) (Math.random() * 50);
		localTargetY = (float) (Math.random() * 50);
		/* Set a new cooldown */
		localCooldown = random.nextInt(maximumLocalCooldown - minimumLocalCooldown) + minimumLocalCooldown;
	}
	
	public void setState(MosquitoMovementState newState)	{ this.currentState = newState; }
	public MosquitoMovementState getState()					{ return this.currentState; }
	
}
