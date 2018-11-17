package com.flizzet.menus.levelchoicemenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.map.Environment;
import com.flizzet.map.Map;
import com.flizzet.player.Dragonfly;
import com.flizzet.player.DragonflyType;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.states.State;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Button for entering level 1.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class LevelFourButton extends ButtonComponent {
	
	private boolean unlocked = false;
	private float lockAlpha = .5f;
	
	/** Default instantiable constructor */
	public LevelFourButton() {
		this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_4_BUTTON, Texture.class));
		this.setImageHovered(GameWorld.INSTANCE.assets.get(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_4_BUTTON, Texture.class));
		this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_4_BUTTON_PUSHED, Texture.class));
		
		/* Check if level is locked or unlocked */
		unlocked = Constants.LEVEL_4_UNLOCKED;
	}
	
	@Override
	public void update(float delta) {
		if (!unlocked) {
			return;
		} else {
			super.update(delta);
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		if (!unlocked) {
			Color originalColor = batch.getColor();
			batch.setColor(new Color(originalColor.r, originalColor.g, originalColor.b, lockAlpha));
			batch.draw(image, bounds.x, bounds.y, bounds.width, bounds.height);
			batch.setColor(originalColor);
		} else {
			super.render(batch);
		}
	}
	
	@Override
	public void triggered() {
		Map.INSTANCE.setEnvironment(Environment.RUBY);
		Dragonfly.INSTANCE.setType(DragonflyType.RUBY_DRAGONFLY);
		GameWorld.INSTANCE.states.enterState(State.GAMEPLAY);
		SoundHandler.play(SoundHandler.INSTANCE.click, 1.0f);
	}

}
