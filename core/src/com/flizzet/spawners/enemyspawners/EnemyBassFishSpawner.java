package com.flizzet.spawners.enemyspawners;

import com.flizzet.enemy.bassfish.EnemyBassFish;
import com.flizzet.player.DragonflyType;
import com.flizzet.spawners.Spawner;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Spawns {@link EnemyBassFish}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class EnemyBassFishSpawner extends Spawner<EnemyBassFish> {

	/** Default instantiable constructor */
	public EnemyBassFishSpawner() {
		super(200, 400);
	}

	@Override
	public void spawnEntity() {
		EnemyBassFish newFish = new EnemyBassFish(this);
		if (GameWorld.INSTANCE.currentDragonfly == DragonflyType.SWAMP_DRAGONFLY) {
			newFish.setX(GameWorld.INSTANCE.camera.getWidth() - 100);
			newFish.setY(0);
		} else {
			newFish.setX(GameWorld.INSTANCE.camera.getWidth());
		}
		GameWorld.INSTANCE.entityContainer.add(newFish);
	}

}
