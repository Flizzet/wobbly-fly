package com.flizzet.guicomponent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.wobblyfly.GameWorld;

/**
 * A basic button with standard, hovered, and pushed images.
 * Implement triggered ActionListener to add events on button push.
 * 
 * @author Pedro Dutra (2017)
 * @version 1.0
 * @see also GuiComponent
 */
public abstract class ButtonComponent extends GuiComponent {

	protected Texture image;
	protected Texture imageHovered;
	protected Texture imagePushed;
	public enum BtnState { DEFAULT, HOVERED, PUSHED };
	protected BtnState state = BtnState.DEFAULT;
	private float initialX, initialY;
	protected boolean justPushed = false;
	protected boolean pushed = false;

	public ButtonComponent() {}

	@Override
	public void update(float delta) {

		state = BtnState.DEFAULT;

		if (Gdx.input.isTouched() && !pushed) {
			pushed = true;
			initialX = GameWorld.INSTANCE.camera.getMousePos().x;
			initialY = GameWorld.INSTANCE.camera.getMousePos().y;
		}

		if (!Gdx.input.isTouched()) {
			pushed = false;
		}

		if (bounds.contains(GameWorld.INSTANCE.camera.getMousePos().x, GameWorld.INSTANCE.camera.getMousePos().y)
				&& bounds.contains(initialX, initialY)) {
			state = BtnState.HOVERED;
			/* If mouse is pushed, go into pushed state */
			if (pushed) {
				state = BtnState.PUSHED;
				justPushed = true;
			} else {
				if (justPushed) {
					triggered();
					justPushed = false;
				}
			}
		} else {
			state = BtnState.DEFAULT;
			justPushed = false;
		}
	}

	@Override
	public void render(SpriteBatch batch) {

		switch (state) {
		case DEFAULT:
			batch.draw(image, bounds.x, bounds.y, bounds.width, bounds.height);
			break;
		case HOVERED:
			batch.draw(imageHovered, bounds.x, bounds.y, bounds.width, bounds.height);
			break;
		case PUSHED:
			batch.draw(imagePushed, bounds.x, bounds.y, bounds.width, bounds.height);
			break;
		}
	}

	/** Called when the button is pressed */
	public abstract void triggered();

	public void setImage(Texture newImage) 				{ this.image = newImage; adjustBoundsToImage(image); }
	public void setImageHovered(Texture newImageHovered){ this.imageHovered = newImageHovered; }
	public void setImagePushed(Texture newImagePushed)	{ this.imagePushed = newImagePushed; }
	public boolean isPushed()							{ return this.justPushed; }
	
	public Texture getImage()							{ return this.image; }

	@Override
	public void reset() {
	}

}
