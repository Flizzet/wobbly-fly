package com.flizzet.map.obstacles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.entity.Entity;
import com.flizzet.map.Environment;
import com.flizzet.map.Map;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Generates {@link Obstacle}s.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ObstacleGenerator extends Entity {
	
	public static final ObstacleGenerator INSTANCE = new ObstacleGenerator();
	
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private Queue<Obstacle> toBeAdded = new LinkedList<Obstacle>();
	private Queue<Obstacle> toBeRemoved = new LinkedList<Obstacle>();
	private int obstacleStartCooldown = 100;
	private boolean firstObstacleAdded = false;
	
	/** Default instantiable constructor */
	private ObstacleGenerator() {}

	@Override
	public void update(float delta) {
		/* Add and remove Obstacles in Queue */
		obstacles.addAll(toBeAdded);
		obstacles.removeAll(toBeRemoved);
		toBeAdded.clear();
		toBeRemoved.clear();
		
		/* Add first Obstacle when cooldown is finished */
		if (obstacleStartCooldown > 0) {
			obstacleStartCooldown--;
		} else if (!firstObstacleAdded) {
			firstObstacleAdded = true;
			addNewObstacle();
		}
		
		/* Create new obstacles */
		if (Map.INSTANCE.getEnvironment() == Environment.SWAMP) {
			if (obstacles.size() != 0 && obstacles.get(obstacles.size() - 1).getX() < 
					GameWorld.INSTANCE.camera.getWidth() - obstacles.get(obstacles.size() - 1).getWidth()) {
				addNewObstacle();
			}
		} else {
			if (obstacles.size() != 0 && obstacles.get(obstacles.size() - 1).getX() <
					GameWorld.INSTANCE.camera.getWidth() - (obstacles.get(obstacles.size() - 1).getWidth() * 2)
					- (Math.random() * 50)) {
				addNewObstacle();
			}
		}
		
		
	}

	@Override
	public void render(SpriteBatch batch) {}
	
	/** Adds a new Obstacle to the Queue of Obstacles to be added */
	private void addNewObstacle() {
		Obstacle newObstacle = null;
		/* Decide placement based on previous placement */
		Obstacle.ObstaclePlacement placement;
		if (!obstacles.isEmpty() && obstacles.get(obstacles.size() - 1)
				.getPlacement() == Obstacle.ObstaclePlacement.TOP) {
			placement = Obstacle.ObstaclePlacement.BOTTOM;
		} else {
			placement = Obstacle.ObstaclePlacement.TOP;
		}
		switch (Map.INSTANCE.getEnvironment()) {
			case SWAMP:
				newObstacle = new Obstacle(ObstacleType.COBWEB, this, placement);
				break;
			case OPAL:
				newObstacle = new Obstacle(ObstacleType.OPAL_STALAGMITE, this, placement);
				break;
			case DIAMOND:
				newObstacle = new Obstacle(ObstacleType.DIAMOND_STALAGMITE, this, placement);
				break;
			case RUBY:
				newObstacle = new Obstacle(ObstacleType.RUBY, this, placement);
				break;
		}
		toBeAdded.add(newObstacle);
		newObstacle.setX(GameWorld.INSTANCE.camera.getWidth());
		newObstacle.setDrawOnTop(true);
		GameWorld.INSTANCE.obstacleContainer.add(newObstacle);
	}
	
	/** Adds Obstacle to Queue of Obstacles to be removed */
	public void removeObstacle(Obstacle removedObstacle) {
		toBeRemoved.add(removedObstacle);
	}
	
	/** Removes all obstacles */
	public void removeAll() {
		toBeRemoved.addAll(obstacles);
	}
	
	public ArrayList<Obstacle> getAllObstacles()	{ return this.obstacles; }

	@Override
	public void reset() {
		removeAll();
		firstObstacleAdded = false;
		obstacleStartCooldown = 100;
	}

}
