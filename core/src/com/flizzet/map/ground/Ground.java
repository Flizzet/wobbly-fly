package com.flizzet.map.ground;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.entity.Entity;
import com.flizzet.map.Environment;
import com.flizzet.map.Map;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Infinite looping ground on bottom of screen.
 *
 * @author Pedro Dutra (2017)
 * @version 1.1
 */
public class Ground extends Entity {
	
	public static Ground INSTANCE = new Ground(Map.INSTANCE);
	private final Map map;
	private Environment environment;
	private Texture groundImage;
	private float fullWidth = GameWorld.INSTANCE.camera.getWidth();
	private int requiredGrounds;
	private float currentOffset = 0;
	
	/** Default instantiable constructor */
	private Ground(Map map) {
		/* Set initial variables */
		this.map = map;
		this.environment = map.getEnvironment();
		this.groundImage = findGroundImage(environment);
		
		/* Figure out the number of ground tiles required to fill the screen */
		requiredGrounds = (int) (fullWidth / groundImage.getWidth());
		
		/* Set height to ground image height */
		this.setHeight(groundImage.getHeight());
	}

	@Override
	public void update(float delta) {
		/* Increase or reset the offset */
		if (currentOffset < groundImage.getWidth()) {
			currentOffset += map.getSpeed();
		} else {
			currentOffset = map.getSpeed();
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Draw ground images across the bottom of the screen */
		for (int i = 0; i < requiredGrounds + 2; i++) {
			batch.draw(groundImage, this.getX() + (groundImage.getWidth() * i) - currentOffset, this.getY());
		}
	}

	@Override
	public void reset() {}

	/** Finds the ground image of the environment based on the Dragonfly */
	private Texture findGroundImage(Environment environment) {
		/* Find the file depending on the DragonflyType */
		switch (environment) {
		case SWAMP:
			return GameWorld.INSTANCE.assets.get(AssetInfo.SWAMP_GROUND, Texture.class);
		case OPAL:
			return GameWorld.INSTANCE.assets.get(AssetInfo.OPAL_GROUND, Texture.class);
		case DIAMOND:
			return GameWorld.INSTANCE.assets.get(AssetInfo.DIAMOND_GROUND, Texture.class);
		case RUBY:
			return GameWorld.INSTANCE.assets.get(AssetInfo.RUBY_GROUND, Texture.class);
		}
		
		/* If no file is found, there's an error. NPE */
		throw new NullPointerException();
	}
	
	public void setEnvironment(Environment newEnvironment) {
		this.environment = newEnvironment;
		this.groundImage = findGroundImage(newEnvironment);
		requiredGrounds = (int) (fullWidth / groundImage.getWidth());
		this.setHeight(groundImage.getHeight());
	}
	
	
	public Map getMap()							{ return this.map; }
	
}
