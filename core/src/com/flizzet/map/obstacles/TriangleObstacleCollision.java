package com.flizzet.map.obstacles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Polygon;
import com.flizzet.wobblyfly.Constants;

/**
 * Triangular shaped Obstacle Collision for the Cobweb obstacle.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class TriangleObstacleCollision extends ObstacleCollision {

	private Polygon collisionTriangle;
	
	/** Default instantiable constructor */
	public TriangleObstacleCollision(Obstacle target) {
		super(target);
		switch (target.getPlacement()) {
		case BOTTOM:
			collisionTriangle = new Polygon(new float[] { 0, 0, collisionBounds.width, 0, collisionBounds.width / 2, collisionBounds.height });
			break;
		case TOP:
			collisionTriangle = new Polygon(new float[] { 0, collisionBounds.height, collisionBounds.width, collisionBounds.height, collisionBounds.width / 2, 0 });
			break;
		}
	}

	@Override
	public void update(float delta) {
		/* Update collisionTriangle */
		collisionTriangle.setPosition(target.getX(), target.getY());
	}
	
	@Override
	public void render(SpriteBatch batch) {
		if (Constants.SHOW_COLLISIONS) {
			batch.end();
			sr.setProjectionMatrix(batch.getProjectionMatrix());
			sr.setColor(Color.RED);
			sr.begin(ShapeType.Line);
			sr.polygon(collisionTriangle.getTransformedVertices());
			sr.end();
			batch.begin();
		}
	}
	
	public Polygon getCobwebCollisionBounds()	{ return this.collisionTriangle; }
	
}
