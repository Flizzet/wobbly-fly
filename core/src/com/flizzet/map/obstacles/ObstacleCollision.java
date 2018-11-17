package com.flizzet.map.obstacles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.flizzet.interfaces.Renderable;
import com.flizzet.interfaces.Updatable;
import com.flizzet.wobblyfly.Constants;

/**
 * Manages collision for the Obstacles.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ObstacleCollision implements Renderable, Updatable {

	protected final Obstacle target;
	protected Rectangle collisionBounds = new Rectangle(0, 0, 16, 16);
	
	protected ShapeRenderer sr;
	
	/** Default instantiable constructor */
	public ObstacleCollision(Obstacle target) {
		this.target = target;
		/* Set up collisionBounds */
		collisionBounds.setX(target.getX());
		collisionBounds.setY(target.getY());
		collisionBounds.setWidth(target.getWidth());
		collisionBounds.setHeight(target.getHeight());
		/* Set up ShapeRenderer if necessary */
		if (Constants.SHOW_COLLISIONS) {
			sr = new ShapeRenderer();
		}
	}

	@Override
	public void update(float delta) {
		/* Update collision bounds */
		collisionBounds.setX(target.getX());
		collisionBounds.setY(target.getY());
	}

	@Override
	public void render(SpriteBatch batch) {
		if (Constants.SHOW_COLLISIONS) {
			batch.end();
			sr.setProjectionMatrix(batch.getProjectionMatrix());
			sr.begin(ShapeType.Line);
			sr.rect(collisionBounds.getX(), collisionBounds.getY(), collisionBounds.getWidth(), collisionBounds.getHeight());
			sr.end();
			batch.begin();
		}
	}
	
	public Rectangle getCollisionBounds() {
		return this.collisionBounds;
	}

}
