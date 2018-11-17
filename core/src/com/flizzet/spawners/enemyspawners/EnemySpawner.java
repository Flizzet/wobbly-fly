package com.flizzet.spawners.enemyspawners;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.enemy.bassfish.EnemyBassFish;
import com.flizzet.enemy.hornet.EnemyHornet;
import com.flizzet.entity.Entity;
import com.flizzet.passivecreatures.healingcritter.HealingCritter;
import com.flizzet.spawners.Spawner;
import com.flizzet.spawners.passivecreaturespawners.MosquitoSpawner;

/**
 * Main {@link Spawner} for all enemies that spawn.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class EnemySpawner extends Entity {
	
	private Spawner<EnemyBassFish> bassFishSpawner = new EnemyBassFishSpawner();
	private Spawner<EnemyHornet> hornetSpawner = new EnemyHornetSpawner();
	private Spawner<HealingCritter> mosquitoSpawner = new MosquitoSpawner();
	
	/** Default instantiable constructor */
	public EnemySpawner() {
	}

	@Override
	public void update(float delta) {
		bassFishSpawner.update(delta);
		hornetSpawner.update(delta);
		mosquitoSpawner.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		bassFishSpawner.render(batch);
		hornetSpawner.render(batch);
		mosquitoSpawner.render(batch);
	}

	@Override
	public void reset() {}

}
