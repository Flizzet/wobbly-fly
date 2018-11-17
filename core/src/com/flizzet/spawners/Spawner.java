package com.flizzet.spawners;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.entity.Entity;
import com.flizzet.interfaces.Renderable;
import com.flizzet.interfaces.Updatable;

/**
 * Abstract EnemySpawner for main EnemySpawners to extend.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public abstract class Spawner<E extends Entity> implements Renderable, Updatable {
	
	/* Lists for enemy addition and updating */
	protected Queue<Entity> toBeAdded = new LinkedList<Entity>();
	protected Queue<Entity> toBeRemoved = new LinkedList<Entity>();
	protected ArrayList<Entity> allEntities = new ArrayList<Entity>();
	
	/* Values for spawning */
	protected float randomness = 0;
	protected float maximumCooldown = 15;
	private float cooldown = maximumCooldown;
	
	/** Default instantiable constructor
	 * @param spawningCooldown - Frequency of spawning. Less is more */
	public Spawner(float spawningCooldown, float randomness) {
		this.maximumCooldown = spawningCooldown;
		this.cooldown = maximumCooldown;
		this.randomness = randomness;
	}
	
	@Override
	public void update(float delta) {
		/* Add entities based on cooldowns */
		cooldown--;
		if (cooldown <= 0) {
			spawnEntity();
			cooldown = maximumCooldown + (float) (Math.random() * randomness);
		}
		
		/* Add and remove all entities from Queues to Main List */
		allEntities.addAll(toBeAdded);
		allEntities.removeAll(toBeRemoved);
		toBeAdded.removeAll(toBeAdded);
		toBeRemoved.removeAll(toBeRemoved);
		
		/* Update all added entities */
		for (Entity e : allEntities) {
			e.update(delta);
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		/* Render all added entities */
		for (Entity e : allEntities) {
			e.render(batch);
		}
	}
	
	/** Spawns a new enemy and adds it to the List of enemies. */
	public abstract void spawnEntity();
	
	/** Adds new {@link Entity} to the List within the spawner. */
	public void addNewEntity(Entity e) {
		toBeAdded.add(e);
	}
	
	/** Removes a {@link Entity} from the List within the spawner */
	public void removeEntity(Entity e) {
		toBeRemoved.add(e);
	}

}
