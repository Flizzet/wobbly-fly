package com.flizzet.map.ground;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.enemy.cavecritter.CaveCritter;
import com.flizzet.entity.Entity;
import com.flizzet.map.Environment;
import com.flizzet.map.Map;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Decoration piece for the ground.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class GroundDecoration extends Entity {
	
	private Environment environment;
	private final Texture image;
	private final Ground ground;
	private final boolean flipX;
	private boolean onTopY = false;
	private Random random = new Random();
	private boolean crittersSpawned = false;

	/** Default instantiable constructor */
	public GroundDecoration(Ground ground, GroundDecorationLayer layer) {
		/* Set initial variables */
		this.environment = Map.INSTANCE.getEnvironment();
		this.ground = ground;
		
		/* Set image to a new random image */
		this.image = this.findRandomDecoration(layer);
		this.adjustBoundsToImage(image);
		/* Decide if the decoration will be flipped horizontally */
		flipX = random.nextBoolean();
	}
	
	@Override
	public void update(float delta) {
		/* Move at the speed of the ground */
		this.setX(this.getX() - (ground.getMap().getSpeed() * ground.getMap().getDecorationParallaxAmount()));
		/* Set to top of screen if onTopY */
		if (onTopY) {
			this.setY(GameWorld.INSTANCE.camera.getHeight() - this.getHeight());
		}
		/* Create new CaveCritter pack when in position */
		if (GameWorld.INSTANCE.assets.getManager().getAssetFileName(image).contains("cave")) {
			if (this.getCenterX() < GameWorld.INSTANCE.camera.getCenterX()
					+ (GameWorld.INSTANCE.camera.getWidth() / 4)
					&& !crittersSpawned) {
				int totalCritters = random.nextInt(2) + 1;
				for (int i = 0; i < totalCritters; i++) {
					CaveCritter critter = new CaveCritter();
					critter.setX(this.getCenterX() + (random.nextFloat() * 30));
					critter.setY(this.getY() + (random.nextFloat() * 30));
					GameWorld.INSTANCE.entityContainer.add(critter);
				}
				crittersSpawned = true;
			}
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Render image */
		batch.draw(image, getX(), getY(), getWidth(), getHeight(), 0, 0,
				(int) getWidth(), (int) getHeight(), flipX, false);
	}

	@Override
	public void reset() {}
	
	/** Finds a random decoration to be used */
	private Texture findRandomDecoration(GroundDecorationLayer layer) {
		Texture randomImage = null;
		/* Get the list of all decorations by removing the first two elements of the Full Graphics ArrayList */
		switch (environment) {
			/* Find a random green dragonfly decoration image */
			case SWAMP:
				randomImage = this.findSwampDecoration(layer);
				break;
			case OPAL:
				randomImage = this.findOpalDecoration(layer);
				break;
			case DIAMOND:
				randomImage = this.findDiamondDecoration(layer);
				break;
			case RUBY:
				randomImage = this.findRubyDecoration(layer);
				break;
		}
		
		/* Place the decoration on top if it's a stalactite */
		if (GameWorld.INSTANCE.assets.getManager().getAssetFileName(randomImage)
				.contains("stalactite")) {
			onTopY = true;
		} else {
			onTopY = false;
		}
		
		return randomImage;
	}
	
	private Texture findSwampDecoration(GroundDecorationLayer layer) {
		String randomImageDir = "Image not found";
		/* Find random Swamp decoration based on layer */
		switch (layer) {
			case LAYER_1:
				randomImageDir = AssetInfo.SWAMP_DECORATIONS_1.get(random.nextInt(AssetInfo.SWAMP_DECORATIONS_1.size())); break;
			case LAYER_2:
				randomImageDir = AssetInfo.SWAMP_DECORATIONS_2.get(random.nextInt(AssetInfo.SWAMP_DECORATIONS_2.size())); break;
			case LAYER_3:
				randomImageDir = AssetInfo.SWAMP_DECORATIONS_3.get(random.nextInt(AssetInfo.SWAMP_DECORATIONS_3.size())); break;
			case LAYER_4:
				randomImageDir = AssetInfo.SWAMP_DECORATIONS_4.get(random.nextInt(AssetInfo.SWAMP_DECORATIONS_4.size())); break;
		}
		
		return GameWorld.INSTANCE.assets.get(randomImageDir, Texture.class);
	}
	
	private Texture findOpalDecoration(GroundDecorationLayer layer) {
		String randomImageDir = "Image not found";
		/* Find random Opal decoration based on layer */
		switch (layer) {
			case LAYER_1:
				randomImageDir = AssetInfo.OPAL_DECORATIONS_1.get(random.nextInt(AssetInfo.OPAL_DECORATIONS_1.size())); break;
			case LAYER_3:	// Fall through intended
			case LAYER_4:	// Fall through intended
			case LAYER_2:
				randomImageDir = AssetInfo.OPAL_DECORATIONS_2.get(random.nextInt(AssetInfo.OPAL_DECORATIONS_2.size())); break;
		}
		
		return GameWorld.INSTANCE.assets.get(randomImageDir, Texture.class);
	}
	
	private Texture findDiamondDecoration(GroundDecorationLayer layer) {
		String randomImageDir = "Image not found";
		/* Find random Diamond decoration based on layer */
		switch (layer) {
			case LAYER_1:
				randomImageDir = AssetInfo.DIAMOND_DECORATIONS_1.get(random.nextInt(AssetInfo.DIAMOND_DECORATIONS_1.size())); break;
			case LAYER_3:	// Fall through intended
			case LAYER_4:	// Fall through intended
			case LAYER_2:
				randomImageDir = AssetInfo.DIAMOND_DECORATIONS_2.get(random.nextInt(AssetInfo.DIAMOND_DECORATIONS_2.size())); break;
		}
		
		return GameWorld.INSTANCE.assets.get(randomImageDir, Texture.class);
	}
	
	private Texture findRubyDecoration(GroundDecorationLayer layer) {
		String randomImageDir = "Image not found";
		/* Find random Ruby decoration based on layer */
		switch (layer) {
			case LAYER_1:
				randomImageDir = AssetInfo.RUBY_DECORATIONS_1.get(random.nextInt(AssetInfo.RUBY_DECORATIONS_1.size())); break;
			case LAYER_3:	// Fall through intended
			case LAYER_4:	// Fall through intended
			case LAYER_2:
				randomImageDir = AssetInfo.RUBY_DECORATIONS_2.get(random.nextInt(AssetInfo.RUBY_DECORATIONS_2.size())); break;
		}
		
		return GameWorld.INSTANCE.assets.get(randomImageDir, Texture.class);
	}

}
