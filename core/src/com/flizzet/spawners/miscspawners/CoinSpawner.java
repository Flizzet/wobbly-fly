package com.flizzet.spawners.miscspawners;

import com.flizzet.items.Coin;
import com.flizzet.items.MegaCoin;
import com.flizzet.map.ground.Ground;
import com.flizzet.player.Dragonfly;
import com.flizzet.player.Dragonfly.DragonflyState;
import com.flizzet.score.ScoreHolder;
import com.flizzet.spawners.Spawner;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Spawns coins.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class CoinSpawner extends Spawner<Coin> {

	private int megaCoinFrequency = 1000;
	
	/** Default instantiable constructor */
	public CoinSpawner() {
		super(100, 100);
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		/* Spawning MegaCoin */
		if (ScoreHolder.INSTANCE.getScore() != 0
		&& ScoreHolder.INSTANCE.getScore() % megaCoinFrequency == 0
		&& Dragonfly.INSTANCE.getState() != DragonflyState.DEAD) {
			MegaCoin coin = new MegaCoin();
			coin.setX(GameWorld.INSTANCE.camera.getWidth());
			coin.setY(GameWorld.INSTANCE.camera.getCenterY() - (coin.getHeight() / 2));
			GameWorld.INSTANCE.entityContainer.add(coin);
		}
	}

	@Override
	public void spawnEntity() {
		/* Don't spawn if dead */
		if (Dragonfly.INSTANCE.getState() == DragonflyState.DEAD) {
			return;
		}
		
		Coin coin = new Coin();
		coin.setX(GameWorld.INSTANCE.camera.getWidth());
		coin.setY((float) (Math.random() * 
				GameWorld.INSTANCE.camera.getHeight() - Ground.INSTANCE.getHeight())
				+ Ground.INSTANCE.getHeight() - 20);
		GameWorld.INSTANCE.entityContainer.add(coin);
	}

}