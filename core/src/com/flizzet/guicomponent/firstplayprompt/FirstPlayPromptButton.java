package com.flizzet.guicomponent.firstplayprompt;

import com.badlogic.gdx.graphics.Texture;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Button for closing and accepting the {@link FirstPlayPrompt}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class FirstPlayPromptButton extends ButtonComponent {
	
	private final FirstPlayPrompt prompt;
	
	public FirstPlayPromptButton(FirstPlayPrompt prompt) {
		this.prompt = prompt;
		
		/* Set images */
		this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.ACCEPT_BUTTON, Texture.class));
		this.setImageHovered(this.getImage());
		this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.ACCEPT_BUTTON_PUSHED, Texture.class));
	}

	@Override
	public void triggered() {
		prompt.remove();
	}

}
