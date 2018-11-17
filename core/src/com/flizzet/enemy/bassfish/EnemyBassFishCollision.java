package com.flizzet.enemy.bassfish;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Polygon;
import com.flizzet.interfaces.Renderable;
import com.flizzet.interfaces.Updatable;
import com.flizzet.utils.ShapeUtils;
import com.flizzet.wobblyfly.Constants;

/**
 * Collision for the {@link EnemyBassFish}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class EnemyBassFishCollision implements Updatable, Renderable {

	private final EnemyBassFish target;
	private Polygon collisionBounds;
	private ShapeRenderer sr;
	
	/** Default instantiable constructor */
	public EnemyBassFishCollision(EnemyBassFish target) {
		this.target = target;
		
		/* Set up collision bounds */
		collisionBounds = ShapeUtils.rectToPolygon(target.getBounds());
		collisionBounds.setOrigin(target.getHalfWidth(), target.getHalfHeight());
		
		/* Create ShapeRenderer if required */
		if (Constants.SHOW_COLLISIONS) {
			sr = new ShapeRenderer();
		}
	}

	@Override
	public void update(float delta) {
		/* Update collisionBOunds */
		collisionBounds.setPosition(target.getX(), target.getY());
		collisionBounds.setRotation(target.getRotation());
		/* Check if off screen. If so, remove */
		if (target.getX() + target.getWidth() < 0) {
			target.remove();
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		if (Constants.SHOW_COLLISIONS) {
			batch.end();
			sr.setProjectionMatrix(batch.getProjectionMatrix());
			sr.begin(ShapeType.Line);
			sr.setColor(Color.MAGENTA);
			sr.polygon(collisionBounds.getTransformedVertices());
			sr.end();
			batch.begin();
		}
	}
	
	public Polygon getCollisionBounds()	{ return this.collisionBounds; }

}
