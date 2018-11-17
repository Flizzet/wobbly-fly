package com.flizzet.passivecreatures.healingcritter;

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
 * Renders and animates the Mosquito.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class HealingCritterAnimator implements Renderable, Updatable {
	
	private final HealingCritter target;
	private Texture flySheet;
	private TextureRegion currentFrame;
	private Animation<TextureRegion> flyAnim;
	private float stateTime = 0;
	private float originX, originY;

	/** Default instantiable constructor */
	public HealingCritterAnimator(HealingCritter target) {
		this.target = target;
		/* Get sheet */
		switch (Map.INSTANCE.getEnvironment()) {
			case DIAMOND:
				flySheet = GameWorld.INSTANCE.assets.get(AssetInfo.DIAMOND_HEALING_CRITTER, Texture.class);
				break;
			case OPAL:
				flySheet = GameWorld.INSTANCE.assets.get(AssetInfo.OPAL_HEALING_CRITTER, Texture.class);
				break;
			case RUBY:
				flySheet = GameWorld.INSTANCE.assets.get(AssetInfo.RUBY_HEALING_CRITTER, Texture.class);
				break;
			case SWAMP:
				flySheet = GameWorld.INSTANCE.assets.get(AssetInfo.SWAMP_HEALING_CRITTER, Texture.class);
				break;
		}
		/* Create animation out of sheet */
		this.flyAnim = AnimationUtils.newAnimation(flySheet, 2, 1, 30);
		this.flyAnim.setPlayMode(PlayMode.LOOP);
		/* Adjust Mosquito dimensions to image frame */
		target.adjustBoundsToImage(flyAnim.getKeyFrame(0));
	}

	@Override
	public void update(float delta) {
		/* Set origin */
		originX = target.getHalfWidth();
		originY = target.getHalfHeight();
		/* Add delta to state time */
		stateTime += delta;
		/* Get current keyframe from Animation and stateTime */
		currentFrame = flyAnim.getKeyFrame(stateTime);
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Draw current frame with rotation */
		batch.draw(currentFrame, target.getX(), target.getY(), originX, originY,
				target.getWidth(), target.getHeight(), 1.0f, 1.0f, target.getRotation());
	}

}
