package com.flizzet.particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.flizzet.assets.AssetInfo;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Particle for warning the player.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class WarningExclamationParticle extends Particle {

	private float yVel = 3;
	private float alpha = 1;
	private Texture image;
	
	/** Default instantiable constructor */
	public WarningExclamationParticle() {
		/* Assign image */
		this.image = GameWorld.INSTANCE.assets.get(AssetInfo.WARNING_EXCLAMATION_PARTICLE, Texture.class);
		this.adjustBoundsToImage(image);
	}

	@Override
	public void update(float delta) {
		/* Fade out */
		alpha -= 0.05f;
		/* Move up at all times */
		yVel += (0 - yVel) / 15;
		this.setY(this.getY() + yVel);
		/* Removal */
		if (alpha <= 0) {
			GameWorld.INSTANCE.particleContainer.remove(this);
		}
	}

	@Override
	public void render(SpriteBatch batch, ShapeRenderer sr) {
		Color originalColor = batch.getColor();
		batch.setColor(new Color(originalColor.r, originalColor.g, originalColor.b, alpha));
		batch.draw(image, this.getX(), this.getY());
		batch.setColor(originalColor);
	}
	
	@Override
	public void reset() {}

}
