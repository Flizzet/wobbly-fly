package com.flizzet.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.flizzet.assets.AssetInfo;
import com.flizzet.entity.Entity;
import com.flizzet.score.ScoreHolder;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Coin for currency collection.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class Coin extends Entity {

	private Texture image;
	protected float xVel = -2;
	private Rectangle collisionBounds = new Rectangle(0, 0, 10, 10);
	private ShapeRenderer sr = new ShapeRenderer();
	
	/** Default instantiable constructor */
	public Coin() {
		image = GameWorld.INSTANCE.assets.get(AssetInfo.COIN, Texture.class);
		this.adjustBoundsToImage(image);
	}

	@Override
	public void update(float delta) {
		/* Move left constantly */
		this.setX(this.getX() + xVel);
		
		/* Update collisionBounds */
		collisionBounds.setWidth(this.getWidth() * 1.5f);
		collisionBounds.setHeight(this.getHeight() * 1.5f);
		collisionBounds.setX(this.getCenterX() - (collisionBounds.getWidth() / 2));
		collisionBounds.setY(this.getCenterY() - (collisionBounds.getHeight() / 2));
		
		/* Check if clicked */
		if (Gdx.input.isTouched()) {
			if (collisionBounds.contains(
					GameWorld.INSTANCE.camera.getMousePos().x, GameWorld.INSTANCE.camera.getMousePos().y)) {
				this.collected();
			}
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, this.getX(), this.getY(), this.getWidth(), this.getHeight());
		/* Draw collision bounds if enabled */
		if (Constants.SHOW_COLLISIONS) {
			batch.end();
			sr.setProjectionMatrix(batch.getProjectionMatrix());
			sr.setColor(Color.GREEN);
			sr.begin(ShapeType.Line);
			sr.rect(collisionBounds.x, collisionBounds.y, collisionBounds.width, collisionBounds.height);
			sr.end();
			batch.begin();
		}
	}

	/** Collects the coin in the score */
	private void collected() {
		ScoreHolder.INSTANCE.setCoins(ScoreHolder.INSTANCE.getCoins() + 1);
		GameWorld.INSTANCE.entityContainer.remove(this);
	}
	
	@Override
	public void reset() {
	}

}
