package com.flizzet.menus.startmenu;

import com.badlogic.gdx.graphics.Texture;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.saving.Saves;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.states.GameplayState;
import com.flizzet.states.State;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Button clicked to enter {@link GameplayState}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
class PlayButton extends ButtonComponent {

	/** Default instantiable constructor */
	public PlayButton() {
		this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.START_MENU_PLAY_BUTTON, Texture.class));
		this.setImageHovered(this.getImage());
		this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.START_MENU_PLAY_BUTTON_PUSHED, Texture.class));
	}	
	
	@Override
	public void update(float delta) {
		if (!Constants.PRIZE_GIVEN) return;
		super.update(delta);
	}
	
	@Override
	public void triggered() {
		GameWorld.INSTANCE.states.enterState(State.GAMEPLAY);
		SoundHandler.play(SoundHandler.INSTANCE.click, 1.0f);
		
		/* Tell the saves that it has been played before if not already told */
		if (!Constants.PLAYED_BEFORE) {
			Constants.PLAYED_BEFORE = true;
			Saves.INSTANCE.savePlayedBefore();
		}
	}

}
