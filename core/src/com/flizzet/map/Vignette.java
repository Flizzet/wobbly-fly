package com.flizzet.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.entity.Entity;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Surrounding vignette effect for depth.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class Vignette extends Entity {
	
	private Texture image;

	/** Default instantiable constructor */
	public Vignette() {
		/* Set image */
		image = GameWorld.INSTANCE.assets.get(AssetInfo.VIGNETTE, Texture.class);
	}

	@Override
	public void update(float delta) {
		/* Set dimensions and position */
		this.setX(0);
		this.setY(0);
		this.setWidth(GameWorld.INSTANCE.camera.getWidth());
		this.setHeight(GameWorld.INSTANCE.camera.getHeight());
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

	@Override
	public void reset() {
	}

}
