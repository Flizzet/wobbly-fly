package com.flizzet.menus.startmenu;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Logo image for {@link StartMenu}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class StartMenuLogo extends GuiComponent {

	private Random random = new Random();
	private Texture image;
	private float shakeTargetX, shakeTargetY;
	private float shakeAmountX, shakeAmountY;
	private float shakeAmount = 1;
	private int maximumChangeTargetCooldown = 3;
	private int changeTargetCooldown = maximumChangeTargetCooldown;
	
	/** Default instantiable constructor */
	public StartMenuLogo() {
		this.image = GameWorld.INSTANCE.assets.get(AssetInfo.START_MENU_LOGO, Texture.class);
		this.adjustBoundsToImage(image);
		/* Double size */
		this.setWidth(this.getWidth() * 2);
		this.setHeight(this.getHeight() * 2);
	}

	@Override
	public void update(float delta) {
		/* Shake randomly */
		changeTargetCooldown--;
		if (changeTargetCooldown <= 0) {
			changeTargetCooldown = maximumChangeTargetCooldown;
			changeShakeAmount();
		}
		
		/* Ease into shakes */
		shakeAmountX += (shakeTargetX - shakeAmountX) / 2f;
		shakeAmountY += (shakeTargetY - shakeAmountY) / 2f;
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Draw image */
		batch.draw(image, this.getX() + shakeAmountX, this.getY() + shakeAmountY, this.getWidth(), this.getHeight());
	}

	/** Changes shake amounts */
	private void changeShakeAmount() {
		/* Find new values */
		shakeTargetX = (float) Math.random() * shakeAmount;
		shakeTargetY = (float) Math.random() * shakeAmount;
		/* Randomly make values negative */
		shakeTargetX = random.nextBoolean() ? -shakeTargetX : shakeTargetX;
		shakeTargetY = random.nextBoolean() ? -shakeTargetY : shakeTargetY;
	}
	
	@Override
	public void reset() {
	}

}
