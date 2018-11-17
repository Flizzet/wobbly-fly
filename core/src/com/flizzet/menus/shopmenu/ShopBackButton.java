package com.flizzet.menus.shopmenu;

import com.badlogic.gdx.graphics.Texture;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.saving.Saves;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.states.State;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Back button for returning to {@link StartMenuState} from {@link ShopMenuState}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
class ShopBackButton extends ButtonComponent {

	/** Default instantiable constructor */
	public ShopBackButton() {
		this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_BACK_BUTTON, Texture.class));
		this.setImageHovered(this.getImage());
		this.setImagePushed(this.getImage());
	}

	@Override
	public void triggered() {
		/* Leave shop */
		GameWorld.INSTANCE.states.enterState(State.START_MENU);
		/* Play click */
		SoundHandler.play(SoundHandler.INSTANCE.click, 1.0f);
		/* Save dragonflies */
		Saves.INSTANCE.saveDragonflies();
	}

}
