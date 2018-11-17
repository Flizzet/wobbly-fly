package com.flizzet.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.flizzet.assets.AssetInfo;
import com.flizzet.interfaces.Renderable;
import com.flizzet.interfaces.Updatable;
import com.flizzet.utils.AnimationUtils;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Animates and renders the {@link Dragonfly}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class DragonflyAnimator implements Renderable, Updatable {
	
	private final Dragonfly dragonfly;
	
	private Texture flapSheet;
	private Animation<TextureRegion> flapAnim;
	private TextureRegion currentFrame;
	private float stateTime = 0;
	private float originX, originY;

	/** Default instantiable constructor */
	public DragonflyAnimator(Dragonfly dragonfly) {
		this.dragonfly = dragonfly;
		/* Set main flap sheet */
		this.flapSheet = dragonfly.getType().getFlapSheet();
		/* Create flap animation */
		this.flapAnim = AnimationUtils.newAnimation(flapSheet, 3, 1, 120);
		this.flapAnim.setPlayMode(PlayMode.LOOP);
		if (dragonfly.getType() != DragonflyType.SWAMP_DRAGONFLY) {
			this.dragonfly.setWidth(flapAnim.getKeyFrame(0).getRegionWidth() / 2);
			this.dragonfly.setHeight(flapAnim.getKeyFrame(0).getRegionHeight() / 2);
		} else {
			this.dragonfly.adjustBoundsToImage(flapAnim.getKeyFrame(0));
		}
		this.currentFrame = flapAnim.getKeyFrame(0);
	}

	@Override
	public void update(float delta) {
		/* Add delta to state time */
		stateTime += delta;
		
		/* Find keyframe based on stateTime */
		currentFrame = flapAnim.getKeyFrame(stateTime);
		
		/* Set rotation origin */
		originX = dragonfly.getHalfWidth();
		originY = dragonfly.getHalfWidth();
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Draw current frame */
		//batch.draw(currentFlapFrame, dragonfly.getX(), dragonfly.getY());
		batch.draw(currentFrame, dragonfly.getX(), dragonfly.getY(), originX, originY,
				dragonfly.getWidth(), dragonfly.getHeight(), 1, 1, dragonfly.getRotation());
	}
	
	/** Builds a new animation based on the {@link DragonflyType} */
	public void rebuildAnimation(DragonflyType type) {
		switch (type) {
			case DIAMOND_DRAGONFLY:
				flapSheet = GameWorld.INSTANCE.assets.get(AssetInfo.ADULT_DIAMOND_DRAGONFLY, Texture.class);
				break;
			case OPAL_DRAGONFLY:
				flapSheet = GameWorld.INSTANCE.assets.get(AssetInfo.ADULT_OPAL_DRAGONFLY, Texture.class);
				break;
			case RUBY_DRAGONFLY:
				flapSheet = GameWorld.INSTANCE.assets.get(AssetInfo.ADULT_RUBY_DRAGONFLY, Texture.class);
				break;
			case SWAMP_DRAGONFLY:
				flapSheet = GameWorld.INSTANCE.assets.get(AssetInfo.SWAMP_DRAGONFLY, Texture.class);
				break;
		}
		
		this.flapAnim = AnimationUtils.newAnimation(flapSheet, 3, 1, 120);
		this.flapAnim.setPlayMode(PlayMode.LOOP);
	}

	public float getDrawnWidth()	{ return currentFrame.getRegionWidth(); }
	public float getDrawnHeight()	{ return currentFrame.getRegionHeight(); }
	
}
