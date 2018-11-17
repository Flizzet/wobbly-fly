package com.flizzet.guicomponent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Darkens components behind it.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ScreenDarkener extends GuiComponent {

	private ShapeRenderer sr = new ShapeRenderer();
	private float alpha = 0;
	
	public ScreenDarkener(float alpha) {
		this.alpha = alpha;
	}
	
	@Override
	public void update(float delta) {
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.end();
		/* Enable GLBlend for alpha drawing */
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		/* Draw darkener */
		sr.setProjectionMatrix(batch.getProjectionMatrix());
		sr.begin(ShapeType.Filled);
		sr.setColor(new Color(0, 0, 0, alpha));
		sr.rect(0, 0, GameWorld.INSTANCE.camera.getWidth(), GameWorld.INSTANCE.camera.getHeight());
		sr.end();
		batch.begin();
		/* Disable GLBlend to end alpha drawing */
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}

	@Override
	public void reset() {}

	public void setAlpha(float newAlpha)	{ this.alpha = newAlpha; }
	
}
