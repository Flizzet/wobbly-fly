package com.flizzet.player;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.ads.AdManager;
import com.flizzet.entity.Entity;
import com.flizzet.menus.deathmenu.DeathMenu;
import com.flizzet.saving.Saves;
import com.flizzet.score.ScoreHolder;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Main Player class.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class Dragonfly extends Entity {
	
	public static final Dragonfly INSTANCE = new Dragonfly(DragonflyType.SWAMP_DRAGONFLY);
	
	public enum DragonflyState { ALIVE, DEAD; }
	
	private DragonflyState state = DragonflyState.ALIVE;
	private DragonflyType type;
	private DragonflyAnimator animator;
	private DragonflyController controller;
	private DragonflyCollision collision;
	private Random random = new Random();
	private float rotation = 0;
	private float maximumHealth = 100;
	private float health = maximumHealth;
	
	/** Default instantiable constructor */
	private Dragonfly(DragonflyType type) {
		/* Set initial type */
		this.type = type;
		/* Create inner components */
		this.animator = new DragonflyAnimator(this);
		this.controller = new DragonflyController(this);
		this.collision = new DragonflyCollision(this);
	}

	@Override
	public void update(float delta) {
		/* Update all components */
		animator.update(delta);
		controller.update(delta);
		collision.update(delta);
		
		/* Constantly decrease health */
		if (state == DragonflyState.ALIVE) {
			health -= 0.05f;
		}
		
		/* Die if health is low */
		if (state != DragonflyState.DEAD && health <= 0) {
			die();
		}
		
		/* Update score if not dead */
		if (state != DragonflyState.DEAD) {
			ScoreHolder.INSTANCE.setScore(ScoreHolder.INSTANCE.getScore() + 1);
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Render all components */
		animator.render(batch);
		collision.render(batch);
	}

	@Override
	public void reset() {
		/* Reset health and state */
		this.health = this.maximumHealth;
		this.state = DragonflyState.ALIVE;
		/* Set initial position */
		this.setY(GameWorld.INSTANCE.camera.getCenterY());
		this.setX(20);
		/* Set initial score */
		ScoreHolder.INSTANCE.setScore(0);
	}
	
	/** Kills the Dragonfly. */
	public void die() {
		if (this.state != DragonflyState.DEAD) {
			/* Skip method if Debug Invincible is turned on */
			if (Constants.DEBUG_INVINCIBLE) return;
			
			/* Set state to dead state */
			this.state = DragonflyState.DEAD;
			
			/* Create and add DeathMenu */
			DeathMenu deathMenu = new DeathMenu();
			deathMenu.buildMenu();
			GameWorld.INSTANCE.guiContainer.add(deathMenu);
			
			/* Save high score */
			Saves.INSTANCE.saveScore();
			
			/* Display either an interstitial video or interstitial still ad one out of 3 times */
			if (random.nextInt(3) == 2) {
				if (random.nextBoolean()) {
					AdManager.INSTANCE.showInterstitialAd();
				} else {
					AdManager.INSTANCE.showInterstitialVideoAd();
				}
			}
			AdManager.INSTANCE.hideBannerAd();
			
		}
	}
	
	public void addToHealth(float addedHealth)	{
		/* Add to the health */
		this.health += addedHealth;
		/* Ensure that the health is capped at maximumHealth */
		if (health > maximumHealth) {
			health = maximumHealth;
		}
	}
	public void setRotation(float newRotation)	{ this.rotation = newRotation; }
	public void setType(DragonflyType newType)	{ this.type = newType; animator.rebuildAnimation(newType); }

	public DragonflyType getType()				{ return this.type; }
	public DragonflyAnimator getAnimator()		{ return this.animator; }
	public DragonflyController getController()	{ return this.controller; }
	public DragonflyState getState()			{ return this.state; }
	public float getRotation()					{ return this.rotation; }
	public float getHealth()					{ return this.health; }
	
}
