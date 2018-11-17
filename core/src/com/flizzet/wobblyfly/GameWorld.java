package com.flizzet.wobblyfly;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.flizzet.assets.AssetHandler;
import com.flizzet.camera.Camera;
import com.flizzet.camera.MainCamera;
import com.flizzet.containers.Container;
import com.flizzet.entity.Entity;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.interfaces.Renderable;
import com.flizzet.interfaces.Updatable;
import com.flizzet.map.obstacles.Obstacle;
import com.flizzet.particles.Particle;
import com.flizzet.player.DragonflyType;
import com.flizzet.score.ScoreHolder;
import com.flizzet.states.StateManager;

/**
 * Manages all game-required containers etc.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class GameWorld implements Renderable, Updatable {
    
    public static final GameWorld INSTANCE = new GameWorld();
    public final StateManager states = new StateManager();
    public final Camera camera = new MainCamera();
    public final AssetHandler assets = new AssetHandler();
    public DragonflyType currentDragonfly;
    public final Container<GuiComponent> guiContainer = new Container<GuiComponent>();
    public final Container<Particle> particleContainer = new Container<Particle>();
    public final Container<Obstacle> obstacleContainer = new Container<Obstacle>();
    public final Container<Entity> entityContainer = new Container<Entity>() {
    	@Override public void render(SpriteBatch batch) {
    		for (Entity e : getAll()) {
    			if (!e.isDrawOnTop()) ((Renderable)e).render(batch);
    		}
    		for (Entity e : getAll()) {
    			if (e.isDrawOnTop()) ((Renderable)e).render(batch);
    		}
    	}
    };
    
    /* ShapeRenderer for Particle drawing */
    private ShapeRenderer sr = new ShapeRenderer();

    /** Suppressed constructor */
    private GameWorld() {}

    @Override
    public void update(float delta) {
		entityContainer.update(delta);
		particleContainer.update(delta);
		guiContainer.update(delta);
		states.update(delta);
		camera.update(delta);
		ScoreHolder.INSTANCE.updateHighScore();
    }

    @Override
    public void render(SpriteBatch batch) {
		entityContainer.render(batch);
		particleContainer.render(batch, sr);
		guiContainer.render(batch);
		states.render(batch);
    }
    
}
