package com.flizzet.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.flizzet.entity.Entity;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Darkens layers of the background.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class MapBackgroundDarkener extends Entity {
	
	private ShapeRenderer sr = new ShapeRenderer();
	private float alpha = 1;
	
	/** Default instantiable constructor */
	public MapBackgroundDarkener(float alpha) {
		this.alpha = alpha;
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
	    
		batch.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		sr.setProjectionMatrix(batch.getProjectionMatrix());
		sr.begin(ShapeType.Filled);
		sr.setColor(new Color(0, 0, 0, alpha));
		sr.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		sr.end();
		batch.begin();
	    Gdx.gl.glDisable(GL20.GL_BLEND);
	}

	@Override
	public void reset() {
	}

	public void setAlpha(float newAlpha)	{ this.alpha = newAlpha; }
	public float getAlpha()					{ return this.alpha; }
	
}
