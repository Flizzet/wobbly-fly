package com.flizzet.enemy.cavecritter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.flizzet.assets.AssetInfo;
import com.flizzet.interfaces.Renderable;
import com.flizzet.interfaces.Updatable;
import com.flizzet.map.Map;
import com.flizzet.utils.AnimationUtils;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Draws {@link CaveCritter}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class CaveCritterAnimator implements Renderable, Updatable {
	
	private final CaveCritter target;
	private Texture flySheet;
	private TextureRegion currentFrame;
	private Animation<TextureRegion> flyAnim;
	private float stateTime = 0;
	private float originX, originY;
	
	/** Default instantiable constructor */
	public CaveCritterAnimator(CaveCritter target) {
		this.target = target;
		
		/* Create animation */
		this.flySheet = findImage();
		flyAnim = AnimationUtils.newAnimation(flySheet, 2, 1, 40);
		flyAnim.setPlayMode(PlayMode.LOOP);
		/* Set size of target based on image */
		target.adjustBoundsToImage(flyAnim.getKeyFrame(0));
	}

	@Override
	public void update(float delta) {
		/* Add delta to stateTime for keyframe getting */
		stateTime += delta;
		
		/* Get current keyframe from animation */
		currentFrame = flyAnim.getKeyFrame(stateTime);
		
		/* Set rotations */
		originX = target.getHalfWidth();
		originY = target.getHalfHeight();
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Draw current frame */
		batch.draw(currentFrame, target.getX(), target.getY(), originX, originY,
				target.getWidth(), target.getHeight(), 1.0f, 1.0f, target.getRotation());
	}
	
	private Texture findImage() {
		switch (Map.INSTANCE.getEnvironment()) {
			case DIAMOND:
				return GameWorld.INSTANCE.assets.get(AssetInfo.DIAMOND_CAVE_CRITTER, Texture.class);
			case OPAL:
				return GameWorld.INSTANCE.assets.get(AssetInfo.OPAL_CAVE_CRITTER, Texture.class);
			case RUBY:
				return GameWorld.INSTANCE.assets.get(AssetInfo.RUBY_CAVE_CRITTER, Texture.class);
			default:
				throw new NullPointerException("Wrong environment for a CaveCritter");
		}
	}

}
