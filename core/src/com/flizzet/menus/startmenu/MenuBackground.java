package com.flizzet.menus.startmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Interactive background image for {@link Menu}.
 * TODO Add movement with Gyroscope/accelerometer
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class MenuBackground extends GuiComponent {
	
	private Texture image;
	private float offsetX = 0;
	private float offsetY = 0;
	private float distanceDivisible = 50;

	/** Default instantiable constructor */
	public MenuBackground() {
		/* Set initial image */
		image = GameWorld.INSTANCE.assets.get(AssetInfo.START_MENU_BACKGROUND, Texture.class);
		this.adjustBoundsToImage(image);
		
		/* Adjust size according to either the width or height depending on which is larger */
		float multiple = 1;
		if (GameWorld.INSTANCE.camera.getWidth() > GameWorld.INSTANCE.camera.getHeight()) {
			multiple = GameWorld.INSTANCE.camera.getWidth() / image.getWidth();
		} else {
			multiple = GameWorld.INSTANCE.camera.getHeight() / image.getHeight();
		}
		
		/* Apply newly acquired multiple to dimensions */
		this.setWidth(this.getWidth() *  (multiple * 1.2f));
		this.setHeight(this.getHeight() * (multiple * 1.2f));
	}

	@Override
	public void update(float delta) {
		/* Move a certain way depending on platform */
		switch(Gdx.app.getType()) {
		case Android:
			break;
		case Applet:	// Fall through intended
		case Desktop:
			moveWithMouse();
			break;
		case iOS:
			break;
		default:
			break;
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, this.getX() + offsetX, this.getY() + offsetY, this.getWidth(), this.getHeight());
	}
	
	/** Moves the background with the mouse. To be used on a Desktop platform */
	private void moveWithMouse() {
		float differenceX = GameWorld.INSTANCE.camera.getCenterX()
				- GameWorld.INSTANCE.camera.getMousePos().x;
		float differenceY = GameWorld.INSTANCE.camera.getCenterY()
				- GameWorld.INSTANCE.camera.getMousePos().y;
		offsetX += ((differenceX / distanceDivisible) - offsetX) / 15;
		offsetY += ((differenceY / distanceDivisible) - offsetY) / 15;
	}

	@Override
	public void reset() {}	

}
