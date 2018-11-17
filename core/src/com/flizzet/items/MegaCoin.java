package com.flizzet.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.flizzet.assets.AssetInfo;
import com.flizzet.entity.Entity;
import com.flizzet.map.Map;
import com.flizzet.score.ScoreHolder;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Giant coin for extra coins.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class MegaCoin extends Entity {

	private MegaCoinController controller = new MegaCoinController(this);
	private Texture image;
	private Texture glowImage;
	private float glowImageX = 0;
	private float glowImageY = 0;
	private int scoreValue = 10;
	private Rectangle collisionBounds = new Rectangle(0, 0, 16, 16);
	
	/** Default instantiable constructor */
	public MegaCoin() {
		image = findNewImage();
		glowImage = GameWorld.INSTANCE.assets.get(AssetInfo.CURRENCY_GLOW, Texture.class);
		
		this.adjustBoundsToImage(image);
	}
	
	@Override
	public void update(float delta) {
		/* Update controller */
		controller.update(delta);
		
		/* Set collision bounds */
		collisionBounds.setWidth(this.getWidth() * 2);
		collisionBounds.setHeight(this.getHeight() * 2);
		collisionBounds.setX(this.getCenterX() - (collisionBounds.getWidth() / 2));
		collisionBounds.setY(this.getCenterY() - (collisionBounds.getHeight() / 2));
		
		/* Check for a clickity clack */
		if (collisionBounds.contains(GameWorld.INSTANCE.camera.getMousePos().x, GameWorld.INSTANCE.camera.getMousePos().y)) {
			collected();
		}
		
		/* Position glow */
		glowImageX = this.getCenterX() - (glowImage.getWidth() / 2);
		glowImageY = this.getCenterY() - (glowImage.getHeight() / 2);
	}

	private void collected() {
		/* Increase coins by value */
		ScoreHolder.INSTANCE.setCoins(ScoreHolder.INSTANCE.getCoins() + scoreValue);
		/* Remove from Container */
		GameWorld.INSTANCE.entityContainer.remove(this);
		/* Play collection sound */
		SoundHandler.play(SoundHandler.INSTANCE.megaCoinCollect, 1.0f);
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(glowImage, glowImageX, glowImageY);
		batch.draw(image, this.getX(), this.getY());
	}
	
	private Texture findNewImage() {
		Texture image = null;
		switch (Map.INSTANCE.getEnvironment()) {
			case DIAMOND:
				image = GameWorld.INSTANCE.assets.get(AssetInfo.DIAMOND_CURRENCY, Texture.class);
				break;
			case OPAL:
				image = GameWorld.INSTANCE.assets.get(AssetInfo.OPAL_CURRENCY, Texture.class);
				break;
			case RUBY:
				image = GameWorld.INSTANCE.assets.get(AssetInfo.RUBY_CURRENCY, Texture.class);
				break;
			case SWAMP:
				image = GameWorld.INSTANCE.assets.get(AssetInfo.SWAMP_CURRENCY, Texture.class);
				break;
		}
		return image;
	}

	@Override public void reset() {}
	
}
