package com.flizzet.spawners.enemyspawners;

import com.flizzet.enemy.hornet.EnemyHornet;
import com.flizzet.map.Environment;
import com.flizzet.map.Map;
import com.flizzet.spawners.Spawner;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Spawns {@link EnemyHornet}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class EnemyHornetSpawner extends Spawner<EnemyHornet> {

	/** Default instantiable constructor */
	public EnemyHornetSpawner() {
		super(100, 100);
	}

	@Override
	public void spawnEntity() {
		if (Map.INSTANCE.getEnvironment() == Environment.SWAMP) {
			EnemyHornet newHornet = new EnemyHornet();
			newHornet.setX((float) (GameWorld.INSTANCE.camera.getWidth() + newHornet.getWidth()));
			newHornet.setY((float) (Math.random() * GameWorld.INSTANCE.camera.getHeight()));
			GameWorld.INSTANCE.entityContainer.add(newHornet);
		}
	}
	

}
