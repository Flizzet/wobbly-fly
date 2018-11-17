package com.flizzet.menus.deathmenu;

import com.badlogic.gdx.graphics.Texture;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.states.State;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Button for returning to the {@link StartMenuState} from Death state.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class StartMenuButton extends ButtonComponent {

	public StartMenuButton() {
		this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.DEATH_MENU_STARTMENU_BUTTON, Texture.class));
		this.setImageHovered(this.getImage());
		this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.DEATH_MENU_STARTMENU_BUTTON_PUSHED, Texture.class));
	}
	
	@Override
	public void triggered() {
		GameWorld.INSTANCE.states.enterState(State.RESTARTING);
		GameWorld.INSTANCE.states.enterState(State.START_MENU);
		SoundHandler.play(SoundHandler.INSTANCE.click, 1.0f);
	}

}
