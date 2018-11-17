package com.flizzet.states;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.ads.AdManager;
import com.flizzet.guicomponent.ingamegui.InGameGui;
import com.flizzet.items.Coin;
import com.flizzet.map.Environment;
import com.flizzet.map.Map;
import com.flizzet.map.Vignette;
import com.flizzet.map.ground.Ground;
import com.flizzet.map.ground.GroundDecorationHolder;
import com.flizzet.map.obstacles.ObstacleGenerator;
import com.flizzet.music.MusicHandler;
import com.flizzet.player.Dragonfly;
import com.flizzet.player.DragonflyType;
import com.flizzet.spawners.Spawner;
import com.flizzet.spawners.enemyspawners.EnemySpawner;
import com.flizzet.spawners.miscspawners.CoinSpawner;
import com.flizzet.wobblyfly.GameWorld;

/**
 * State of Gameplay.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class GameplayState extends GameState {

	private Random random = new Random();
	
	private Map map;
	private Ground ground;
	private GroundDecorationHolder groundDecoration;
	private Dragonfly dragonfly;
	private InGameGui inGameGui;
	private EnemySpawner enemySpawner;
	private Spawner<Coin> coinSpawner;
	private ObstacleGenerator obstacles;
	private Vignette vignette;
	
	/** Default instantiable constructor */
	public GameplayState() {}

	@Override
	public void entered() {
		
		/* Randomly display ad */
		if (random.nextInt(5) == 3) {
			AdManager.INSTANCE.showBannerAd();
		}
		
		/* Object creation */
			//Entities
				// Map
		map = Map.INSTANCE;
		entityContainer.add(map);
				// Obstacles
		obstacles = ObstacleGenerator.INSTANCE;
		obstacles.reset();
		entityContainer.add(obstacles);
				// Ground creation
		ground = Ground.INSTANCE;
		ground.setDrawOnTop(true);
		groundDecoration = new GroundDecorationHolder();
		entityContainer.add(ground);
		entityContainer.add(groundDecoration);
				// Dragonfly
		dragonfly = Dragonfly.INSTANCE;
		dragonfly.reset();
		entityContainer.add(dragonfly);
				// Vignette
		vignette = new Vignette();
		vignette.setDrawOnTop(true);
		entityContainer.add(vignette);
		
			// Spawners
				// Enemy Spawner
		enemySpawner = new EnemySpawner();
		enemySpawner.reset();
		entityContainer.add(enemySpawner);
				// Coin spawner
		coinSpawner = new CoinSpawner();
			//GuiComponents
				// HealthBar
		inGameGui = new InGameGui();
		inGameGui.reset();
		inGameGui.build();
		guiContainer.add(inGameGui);
		
		/* Set environments and Dragonflies based on global Dragonfly type */
		switch (GameWorld.INSTANCE.currentDragonfly) {
			case DIAMOND_DRAGONFLY:
				Map.INSTANCE.setEnvironment(Environment.DIAMOND);
				Dragonfly.INSTANCE.setType(DragonflyType.DIAMOND_DRAGONFLY);
				break;
			case OPAL_DRAGONFLY:
				Map.INSTANCE.setEnvironment(Environment.OPAL);
				Dragonfly.INSTANCE.setType(DragonflyType.OPAL_DRAGONFLY);
				break;
			case RUBY_DRAGONFLY:
				Map.INSTANCE.setEnvironment(Environment.RUBY);
				Dragonfly.INSTANCE.setType(DragonflyType.RUBY_DRAGONFLY);
				break;
			case SWAMP_DRAGONFLY:
				Map.INSTANCE.setEnvironment(Environment.SWAMP);
				Dragonfly.INSTANCE.setType(DragonflyType.SWAMP_DRAGONFLY);
				break;
		}
		
		/* Play music depending on environment */
		switch (Map.INSTANCE.getEnvironment()) {
			case DIAMOND:
				MusicHandler.play(MusicHandler.INSTANCE.diamondMusic, 1.0f, true);
				break;
			case OPAL:
				MusicHandler.play(MusicHandler.INSTANCE.opalMusic, 1.0f, true);
				break;
			case RUBY:
				MusicHandler.play(MusicHandler.INSTANCE.rubyMusic, 1.0f, true);
				break;
			case SWAMP:
				MusicHandler.play(MusicHandler.INSTANCE.swampMusic, 1.0f, true);
				break;
		}
	}

	@Override
	public void update(float delta) {
		coinSpawner.update(delta);
		obstacleContainer.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		coinSpawner.render(batch);
		obstacleContainer.render(batch);
	}

	@Override
	public void exited() {
		map.reset();
		obstacles.reset();
		dragonfly.reset();
		enemySpawner.reset();
		inGameGui.reset();
		
		guiContainer.clear();
		entityContainer.clear();
		obstacleContainer.clear();
		
		/* Stop music depending on environment */
		switch (Map.INSTANCE.getEnvironment()) {
			case DIAMOND:
				MusicHandler.stop(MusicHandler.INSTANCE.diamondMusic);
				break;
			case OPAL:
				MusicHandler.stop(MusicHandler.INSTANCE.opalMusic);
				break;
			case RUBY:
				MusicHandler.stop(MusicHandler.INSTANCE.rubyMusic);
				break;
			case SWAMP:
				MusicHandler.stop(MusicHandler.INSTANCE.swampMusic);
				break;
		}
	}

	@Override
	public void dispose() {
	}

}
