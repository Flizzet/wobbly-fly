package com.flizzet.enemy.cavecritter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.flizzet.enemy.FlyingEnemyAi;
import com.flizzet.interfaces.Renderable;
import com.flizzet.interfaces.Updatable;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Handles collision for the {@link CaveCritter}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class CaveCritterCollision implements Renderable, Updatable {

	private final CaveCritter target;
	private Rectangle collisionBounds = new Rectangle(0, 0, 16, 16);
	private ShapeRenderer sr = new ShapeRenderer();
	
	/** Default instantiable constructor */
	public CaveCritterCollision(CaveCritter target) {
		this.target = target;
	}

	@Override
	public void update(float delta) {
		/* Update collision bounds */
		collisionBounds.setWidth(target.getWidth() * 2);
		collisionBounds.setHeight(target.getHeight() * 2);
		collisionBounds.setX(target.getCenterX() - (collisionBounds.getWidth() / 2));
		collisionBounds.setY(target.getCenterY() - (collisionBounds.getHeight() / 2));
		
		/* Check if mouse is down */
		if (Gdx.input.isTouched()) {
			/* Check if mouse point is inside of Mosquito */
			if (target.getAi().getState() != FlyingEnemyAi.FlyingMovementState.DEAD && 
			collisionBounds.contains(new Vector2(GameWorld.INSTANCE.camera.getMousePos().x, 
			GameWorld.INSTANCE.camera.getMousePos().y))) {
				target.kill();
			}
		}
		
		/* Checks for removal */
		if (target.getY() > GameWorld.INSTANCE.camera.getHeight()
		|| target.getY() - target.getHeight() < 0) {
			target.remove();
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		if (Constants.SHOW_COLLISIONS) {
			batch.end();
			sr.setProjectionMatrix(batch.getProjectionMatrix());
			sr.begin(ShapeType.Line);
			sr.setColor(Color.RED);
			sr.rect(collisionBounds.getX(), collisionBounds.getY(), collisionBounds.getWidth(), collisionBounds.getHeight());
			sr.end();
			batch.begin();
		}
	}

}
