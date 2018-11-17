package com.flizzet.guicomponent.firstplayprompt;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.utils.FontUtils;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Displays the text for the {@link FirstPlayPrompt}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class FirstPlayPromptText extends GuiComponent {
	
	private String text = "tap below for 500 free coins";
	private BitmapFont font = FontUtils.MAINFONT_75;
	private GlyphLayout layout = new GlyphLayout(font, text);
	private float textX, textY;
	
	public FirstPlayPromptText() {}
	
	@Override
	public void update(float delta) {
		/* Set text position */
		textX = GameWorld.INSTANCE.camera.getCenterX() - (layout.width / 2);
		textY = GameWorld.INSTANCE.camera.getCenterY() - (layout.height / 2) + layout.height;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		/* Draw text */
		font.draw(batch, text, textX, textY);
	}

	@Override
	public void reset() {}

}
