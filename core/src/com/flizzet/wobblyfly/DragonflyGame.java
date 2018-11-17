package com.flizzet.wobblyfly;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.ads.AdHandler;
import com.flizzet.ads.AdManager;
import com.flizzet.saving.Saves;
import com.flizzet.states.State;

public class DragonflyGame extends ApplicationAdapter {
	
	private SpriteBatch batch;
	private GameWorld world;
	private AdManager adManager = AdManager.INSTANCE;
	
	public DragonflyGame(AdHandler handler) {
		adManager.setHandler(handler);
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		world = GameWorld.INSTANCE;

		world.states.enterState(State.LOADING);
		world.camera.createCamera();
		world.assets.loadAll();
		
		/* Instantly hide the banner ad */
		adManager.hideBannerAd();
	}
	
	@Override
	public void render () {
		/* Updates */
		/* Get delta */
		float delta = Gdx.graphics.getDeltaTime();
		
		/* Set up batch */
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setProjectionMatrix(world.camera.getCombinedMatrix());
		
		switch (world.states.getCurrentState().getEnum()) {
		case LOADING:
			break;
		default:
			break;
		}
		
		/* Update world */
		world.update(delta);
		
		/* Rendering */
		world.render(batch);
		
		/* End batch */
		batch.end();
	}
	
	@Override
	public void resize(int width, int height) {
		world.camera.resize(width, height);
	}
	
	@Override
	public void dispose () {
		Saves.INSTANCE.save();
		batch.dispose();
	}
	
	public AdManager getAdManager()	{ return this.adManager; }
}
