package com.flizzet.map.obstacles;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.entity.Entity;
import com.flizzet.map.Map;
import com.flizzet.map.ground.Ground;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Collidable obstacle for player to avoid.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class Obstacle extends Entity {

	private final Texture image;
	private final ObstacleType type;
	private final ObstacleGenerator generator;
	private ObstacleCollision collision;
	private final Random random = new Random();
	public enum ObstaclePlacement { TOP, BOTTOM; }
	private ObstaclePlacement placement;
	
	/** Default instantiable constructor */
	public Obstacle(ObstacleType type, ObstacleGenerator generator, ObstaclePlacement placement) {
		this.type = type;
		this.generator = generator;
		this.placement = placement;
		
		/* Find a random image and adjust dimensions accordingly */
		this.image = findRandomImage();
		this.adjustBoundsToImage(image);
		
		/* Position based on placement */
		switch (placement) {
		case BOTTOM:
			this.setY(Ground.INSTANCE.getY() + Ground.INSTANCE.getHeight());
			break;
		case TOP:
			this.setY(GameWorld.INSTANCE.camera.getHeight() - this.getHeight());
			break;
		}
		
		this.collision = new TriangleObstacleCollision(this);
		
	}

	@Override
	public void update(float delta) {
		/* Decrease x by speed */
		this.setX(this.getX() - Map.INSTANCE.getSpeed());
		/* Remove when past the edge */
		if (this.getX() + this.getWidth() < 0) {
			GameWorld.INSTANCE.entityContainer.remove(this);
			generator.removeObstacle(this);
		}
		/* Update collision */
		collision.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, this.getX(), this.getY(), this.getWidth(), this.getHeight(),
				0, 0, (int) this.getWidth(), (int) this.getHeight(), false,
				this.placement == ObstaclePlacement.TOP ? true : false);
		
		/* Render collision */
		collision.render(batch);
	}
	
	/** Finds a random image to use based on the Array */
	private Texture findRandomImage() {
		int chosenImage = random.nextInt(type.getAllImages().size());
		return type.getAllImages().get(chosenImage);
	}

	@Override
	public void reset() {}
	
	public ObstaclePlacement getPlacement()	{ return this.placement; }
	public ObstacleCollision getCollision()	{ return this.collision; }
	public ObstacleType getType()			{ return this.type; }

}
