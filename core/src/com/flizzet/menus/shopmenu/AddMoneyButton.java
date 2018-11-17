package com.flizzet.menus.shopmenu;

import com.badlogic.gdx.graphics.Texture;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Button for in app purchases.
 *
 * @author Pedro Dutra (2018)
 * @version 1.0
 */
public class AddMoneyButton extends ButtonComponent {

	/** Default instantiable constructor */
	public AddMoneyButton() {
		/* Set images */
		this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.ADD_MONEY_BUTTON, Texture.class));
		this.setImageHovered(this.getImage());
		this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.ADD_MONEY_BUTTON_PUSHED, Texture.class));
	}

	@Override
	public void triggered() {
	}

}
