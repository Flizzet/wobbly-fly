package com.flizzet.passivecreatures.healingcritter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.flizzet.interfaces.Renderable;
import com.flizzet.interfaces.Updatable;
import com.flizzet.particles.ParticleFunctions;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Handles collision for the {@link HealingCritter}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class HealingCritterCollision implements Renderable, Updatable {

	private final HealingCritter target;
	private Rectangle collisionBounds = new Rectangle(0, 0, 16, 16);
	private ShapeRenderer sr = new ShapeRenderer();
	
	/** Default instantiable constructor */
	public HealingCritterCollision(HealingCritter target) {
		this.target = target;
	}

	@Override
	public void update(float delta) {
		/* Upate collision bounds */
		collisionBounds.setWidth(target.getBounds().getWidth() * 2f);
		collisionBounds.setHeight(target.getBounds().getHeight() * 2f);
		collisionBounds.setX(target.getCenterX() - (collisionBounds.getWidth() / 2));
		collisionBounds.setY(target.getCenterY() - (collisionBounds.getHeight() / 2));
		
		/* Check if mouse is down */
		if (Gdx.input.isTouched()) {
			/* Check if mouse point is inside of Mosquito */
			if (target.getAi().getState() != HealingCritterAi.MosquitoMovementState.DEAD && 
					collisionBounds.contains(new Vector2(GameWorld.INSTANCE.camera.getMousePos().x, 
							GameWorld.INSTANCE.camera.getMousePos().y))) {
				ParticleFunctions.INSTANCE.addHealingParticle(target.getCenterX(), target.getY() + target.getY() + 2, true);
				target.kill();
			}
		}
		/* Checking for removal */
		if (target.getY() - target.getHeight() < 0) {
			target.remove();
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		if (Constants.SHOW_COLLISIONS) {
			batch.end();
			sr.setProjectionMatrix(batch.getProjectionMatrix());
			sr.begin(ShapeType.Line);
			sr.setColor(Color.ORANGE);
			sr.rect(collisionBounds.x, collisionBounds.y, collisionBounds.width, collisionBounds.height);
			sr.end();
			batch.begin();
		}
	}

}
