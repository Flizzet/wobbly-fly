package com.flizzet.menus.startmenu;

import com.badlogic.gdx.graphics.Texture;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.states.State;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Button to enter {@link ShopState}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
class ShopButton extends ButtonComponent {

	public ShopButton() {
		this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.START_MENU_SHOP_BUTTON, Texture.class));
		this.setImageHovered(this.getImage());
		this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.START_MENU_SHOP_BUTTON_PUSHED, Texture.class));
	}
	
	@Override
	public void update(float delta) {
		if (!Constants.PRIZE_GIVEN) return;
		super.update(delta);
	}
	
	@Override
	public void triggered() {
		GameWorld.INSTANCE.states.enterState(State.SHOP_MENU);
		SoundHandler.play(SoundHandler.INSTANCE.click, 1.0f);
	}

}
