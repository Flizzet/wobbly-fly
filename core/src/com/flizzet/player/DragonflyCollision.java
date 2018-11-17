package com.flizzet.player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.flizzet.enemy.bassfish.EnemyBassFish;
import com.flizzet.entity.Entity;
import com.flizzet.interfaces.Updatable;
import com.flizzet.map.ground.Ground;
import com.flizzet.map.obstacles.Obstacle;
import com.flizzet.map.obstacles.ObstacleGenerator;
import com.flizzet.map.obstacles.TriangleObstacleCollision;
import com.flizzet.particles.ParticleFunctions;
import com.flizzet.utils.ShapeUtils;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Handles collision for the {@link Dragonfly}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class DragonflyCollision implements Updatable {

	private Rectangle collisionBounds = new Rectangle(0, 0, 16, 16);
	private Polygon polygonCollisionBounds;
	private ShapeRenderer sr;
	private Dragonfly target;

	public DragonflyCollision(Dragonfly dragonfly) {
		this.target = dragonfly;

		/* Create initial collisions */
		collisionBounds.setWidth(target.getAnimator().getDrawnWidth());
		collisionBounds.setHeight(target.getAnimator().getDrawnHeight() / 3);
		polygonCollisionBounds = ShapeUtils.rectToPolygon(collisionBounds);
		
		/* Create ShapeRenderer if necessary */
		if (Constants.SHOW_COLLISIONS) {
			sr = new ShapeRenderer();
		}
	}

	@Override
	public void update(float delta) {
		/* Update collision rectangle */
		collisionBounds.setX(target.getX());
		collisionBounds.setY(target.getY() + (collisionBounds.height / 1.3f));
		polygonCollisionBounds.setPosition(collisionBounds.x, collisionBounds.y);
		
		/* Check if hitting ground */
		if (collisionBounds.y < Ground.INSTANCE.getY() + Ground.INSTANCE.getHeight()) {
			/* Bounce */
			target.getController().setYVel(target.getController().getMaximumYVel());
			ParticleFunctions.INSTANCE.addWaterParticle(target.getCenterX(), target.getCenterY(), 5);
		}
		/* Check if hitting ceiling */
		if (collisionBounds.y + collisionBounds.height > GameWorld.INSTANCE.camera.getHeight()) {
			/* Bounce */
			target.getController().setYVel(-target.getController().getMaximumYVel());
		}
		/* Check if hitting Obstacle */
		for (Obstacle o : ObstacleGenerator.INSTANCE.getAllObstacles()) {
			Polygon cobwebCollisionBounds = ((TriangleObstacleCollision) o.getCollision()).getCobwebCollisionBounds();
			if (Intersector.overlapConvexPolygons(polygonCollisionBounds, cobwebCollisionBounds)) {
				target.die();
			}
		}
		/* Check if hitting EnemyBassFish */
		for (Entity e : GameWorld.INSTANCE.entityContainer.getAll()) {
			if (e instanceof EnemyBassFish) {
				if (Intersector.overlapConvexPolygons(polygonCollisionBounds, ((EnemyBassFish) e).getCollision().getCollisionBounds())) {
					target.die();
				}
			}
		}
	}

	public void render(SpriteBatch batch) {
		/* Draw collision Rectangle if necessary */
		if (Constants.SHOW_COLLISIONS) {
			batch.end();
			sr.setProjectionMatrix(batch.getProjectionMatrix());
			sr.setColor(Color.YELLOW);
			sr.begin(ShapeType.Line);
			//sr.rect(collisionBounds.x, collisionBounds.y, collisionBounds.width, collisionBounds.height);
			sr.polygon(polygonCollisionBounds.getTransformedVertices());
			sr.end();
			batch.begin();
		}
	}

}
