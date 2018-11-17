package com.flizzet.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.entity.Entity;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Background for the map.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class MapBackground extends Entity {

	private final Map map;
	private Environment environment;
	private Texture image;
	private float currentOffset = 0;
	
	/** Default instantiable constructor */
	public MapBackground(Map map) {
		/* Set initial variables */
		this.map = map;
		this.environment = map.getEnvironment();
		this.image = findBackgroundImage(environment);
		this.currentOffset = -GameWorld.INSTANCE.camera.getWidth();
		
		/* Set width and height to fit window */
		this.setWidth(GameWorld.INSTANCE.camera.getWidth());
		this.setHeight(GameWorld.INSTANCE.camera.getHeight());
	}

	@Override
	public void update(float delta) {
		/* Change/Reset offset */
		currentOffset += (map.getSpeed() * map.getBackgroundParallaxAmount());
		if (currentOffset >= 0) {
			currentOffset = -GameWorld.INSTANCE.camera.getWidth();
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		for (int i = -1; i < 1; i++) {
			batch.draw(image, this.getX() + (this.getWidth() * i) - currentOffset, this.getY(),
					this.getWidth(), this.getHeight());
		}
	}

	@Override
	public void reset() {}
	
	/** Finds the background image of the environment based on the Dragonfly */
	private Texture findBackgroundImage(Environment environment) {
		/* Find the file depending on the DragonflyType */
		switch (environment) {
		case SWAMP:
			return GameWorld.INSTANCE.assets.get(AssetInfo.SWAMP_BACKGROUND, Texture.class);
		case OPAL:
			return GameWorld.INSTANCE.assets.get(AssetInfo.OPAL_BACKGROUND, Texture.class);
		case DIAMOND:
			return GameWorld.INSTANCE.assets.get(AssetInfo.DIAMOND_BACKGROUND, Texture.class);
		case RUBY:
			return GameWorld.INSTANCE.assets.get(AssetInfo.RUBY_BACKGROUND, Texture.class);
		}
		
		/* If no file is found, there's an error. NPE */
		throw new NullPointerException();
	}
	
	public void setEnvironment(Environment newEnvironment)	{
		this.environment = newEnvironment;
		this.image = findBackgroundImage(newEnvironment);
	}

}
