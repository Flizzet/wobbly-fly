package com.flizzet.guicomponent.ingamegui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.player.Dragonfly;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Displays player health.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class HealthBar extends GuiComponent {

	private Texture containerImage;
	private Texture fillImage;
	private final Dragonfly dragonfly;
	private float health;
	
	/** Default instantiable constructor */
	public HealthBar(Dragonfly dragonfly) {
		this.dragonfly = dragonfly;
		/* Set images */
		containerImage = GameWorld.INSTANCE.assets.get(AssetInfo.HEALTH_CONTAINER, Texture.class);
		fillImage = GameWorld.INSTANCE.assets.get(AssetInfo.HEALTH_FILL, Texture.class);
		this.adjustBoundsToImage(containerImage);
	}

	@Override
	public void update(float delta) {
		/* Set health to dragonfly health */
		health = dragonfly.getHealth();
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Draw container */
		batch.draw(containerImage, this.getX(), this.getY());
		/* Draw fill with scale based on health */
		batch.draw(fillImage, this.getX() + 3, this.getY() + 2, 
				fillImage.getWidth() * (health / 100), fillImage.getHeight());
	}

	@Override
	public void reset() {}
	
}
