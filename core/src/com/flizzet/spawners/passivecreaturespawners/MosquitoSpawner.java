package com.flizzet.spawners.passivecreaturespawners;

import com.flizzet.passivecreatures.healingcritter.HealingCritter;
import com.flizzet.spawners.Spawner;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Spawns {@link HealingCritter}s.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class MosquitoSpawner extends Spawner<HealingCritter> {

	/** Default instantiable constructor */
	public MosquitoSpawner() {
		super(200, 200);
	}

	@Override
	public void spawnEntity() {
		HealingCritter newMosquito = new HealingCritter();
		newMosquito.setX(GameWorld.INSTANCE.camera.getWidth());
		newMosquito.setY((float) (Math.random() * GameWorld.INSTANCE.camera.getHeight()));
		GameWorld.INSTANCE.entityContainer.add(newMosquito);
	}

}
