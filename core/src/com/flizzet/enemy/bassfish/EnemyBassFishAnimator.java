package com.flizzet.enemy.bassfish;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.interfaces.Renderable;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Draws the {@link EnemyBassFish}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class EnemyBassFishAnimator implements Renderable {
	
	private Texture image;
	private final EnemyBassFish target;
	private float originX, originY;

	/** Default instantiable constructor */
	public EnemyBassFishAnimator(EnemyBassFish target) {
		this.target = target;
		/* Set image */
		image = findImage();//GameWorld.INSTANCE.assets.get(AssetInfo.SWAMP_BASS_FISH, Texture.class);
		
		target.adjustBoundsToImage(image);
		/* Set origins */
		originX = target.getHalfWidth();
		originY = target.getHalfHeight();
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Draw fish with rotation */
		batch.draw(image, target.getX(), target.getY(), originX, originY, target.getWidth(), target.getHeight(),
				1, 1, target.getRotation(), 0, 0, (int) target.getWidth(), (int) target.getHeight(), false, false);
	}

	private Texture findImage() {
		Texture tmp = null;
		switch (GameWorld.INSTANCE.currentDragonfly) {
			case DIAMOND_DRAGONFLY:
				tmp = GameWorld.INSTANCE.assets.get(AssetInfo.DIAMOND_FROG, Texture.class);
				break;
			case OPAL_DRAGONFLY:
				tmp = GameWorld.INSTANCE.assets.get(AssetInfo.OPAL_RAT, Texture.class);
				break;
			case RUBY_DRAGONFLY:
				tmp = GameWorld.INSTANCE.assets.get(AssetInfo.RUBY_SPIDER, Texture.class);
				break;
			case SWAMP_DRAGONFLY:
				tmp = GameWorld.INSTANCE.assets.get(AssetInfo.SWAMP_BASS_FISH, Texture.class);
				break;
		}
		return tmp;
	}
	
}
