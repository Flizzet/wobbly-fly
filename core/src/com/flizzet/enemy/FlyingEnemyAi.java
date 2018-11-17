package com.flizzet.enemy;

import com.flizzet.interfaces.Updatable;
import com.flizzet.map.Map;
import com.flizzet.player.Dragonfly;

/**
 * Controls flying enemies.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class FlyingEnemyAi implements Updatable {
	
	private final Enemy target;
	public enum FlyingMovementState { HOMING, ATTACKING, DONE, DEAD; }
	private FlyingMovementState currentState = FlyingMovementState.HOMING;
	private float attackCooldown = 20;
	private float yVel = 10;
	private boolean doneAttacking = false;
	private float yHomingSpeed = 1;
	
	/** Default instantiable constructor */
	public FlyingEnemyAi(Enemy target) {
		this.target = target;
	}

	@Override
	public void update(float delta) {
		/* Do specific movement for each state */
		switch (currentState) {
		case HOMING:
			homeIn();
			break;
		case ATTACKING:
			attack();
			break;
		case DONE:
			done();
		case DEAD:
			dead();
			break;
		}
	}
	
	/** Homes the target into the player */
	private void homeIn() {
		/* Determine the position the flying enemy has to home into */
		float targetX = Dragonfly.INSTANCE.getCenterX() + 40;
		float targetY = Dragonfly.INSTANCE.getCenterY();
		float travelTime = 5;
		float desiredSpeed = 2;
		/* Move into next phase of movement if already there */
		if (doneAttacking) {
			attackCooldown--;
			target.setX(target.getX() + attackCooldown / 10);
			target.setY(target.getY() + attackCooldown / 15);
			if (attackCooldown <= 0) {
				currentState = FlyingMovementState.ATTACKING;
			}
		} else {
			/* Determine distances */
			float xSpeed = (targetX - target.getCenterX()) / travelTime;
			float ySpeed = (targetY - target.getCenterY()) / travelTime;
			/* Make speed static */
			float factor = (float) (desiredSpeed / Math.sqrt(xSpeed * xSpeed + ySpeed * ySpeed));
			/* Decide x velocity based on factor */
			xSpeed *= factor;
			/* Apply speeds to position */
			target.setX(target.getX() + xSpeed);
			target.setY(target.getY() + (ySpeed / yHomingSpeed));
			/* Determine if it's at the position */
			if (target.getX() < targetX + 0.1f) {
				doneAttacking = true;
			}
		}
	}
	
	/** Attacks player */
	private void attack() {
		/* Determine the position the flying enemy has to home into */
		float targetX = Dragonfly.INSTANCE.getCenterX();
		float targetY = Dragonfly.INSTANCE.getCenterY();
		float travelTime = 5;
		/* Determine distances */
		float xSpeed = (targetX - target.getCenterX()) / travelTime;
		float ySpeed = (targetY - target.getCenterY()) / travelTime;
		/* Apply speeds to position */
		target.setX(target.getX() + xSpeed);
		target.setY(target.getY() + ySpeed);
		/* Check if the attack was successful. If so, move into next phase */
		if (target.getX() < targetX + .5f) {
			currentState = FlyingMovementState.DONE;
		}
	}
	
	/** Completes movement */
	private void done() {
		/* Kill the Dragonfly if not already dead */
		if (Dragonfly.INSTANCE.getState() != Dragonfly.DragonflyState.DEAD) {
			Dragonfly.INSTANCE.die();
		}
		/* Move diagonally right */
		target.setX(target.getX() + 3);
		target.setY(target.getY() + 3);
	}
	
	/** Dies */
	private void dead() {
		/* Decrease yVel */
		yVel -= .5;
		/* Apply yVel to position */
		target.setY(target.getY() + yVel);
		/* Move horizontally at the move of the speed of the map */
		target.setX(target.getX() - Map.INSTANCE.getSpeed());
		/* Apply yVel to rotation */
		target.setRotation(target.getRotation() + 10);
	}
	
	public FlyingMovementState getState()					{ return this.currentState; }
	public void setState(FlyingMovementState newState)		{ this.currentState = newState; }
	public void setYHomingSpeed(float newSpeed)				{ this.yHomingSpeed = newSpeed; }
	
}
