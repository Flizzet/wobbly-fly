package com.flizzet.guicomponent;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.assets.AssetInfo;
import com.flizzet.score.ScoreHolder;
import com.flizzet.utils.FontUtils;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Displays the amount of coins the player has.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class CoinDisplay extends GuiComponent {

	private String text = "100";
	private BitmapFont textFont = FontUtils.MAINFONT_50;
	private GlyphLayout textLayout = new GlyphLayout(textFont, text);
	private float textX, textY;
	
	private Texture icon;
	private float iconX, iconY;
	private float iconWidth, iconHeight;
	
	/** Default instantiable constructor */
	public CoinDisplay() {
		icon = GameWorld.INSTANCE.assets.get(AssetInfo.COIN, Texture.class);
	}

	@Override
	public void update(float delta) {
		/* Set text */
		this.text = String.valueOf(ScoreHolder.INSTANCE.getCoins());
		/* Set text to layout */
		textLayout.setText(textFont, text);
		/* Set component position */
		this.setX(GameWorld.INSTANCE.camera.getWidth() - textLayout.width - GuiConstants.SPACING);
		this.setY(GameWorld.INSTANCE.camera.getHeight() - GuiConstants.SPACING);
		/* Set text position */
		textX = this.getX();
		textY = this.getY();
		
		/* Set icon size based on text */
		float iconScale = textLayout.height / icon.getHeight();
		iconWidth = icon.getWidth() * iconScale;
		iconHeight = icon.getHeight() * iconScale;
		/* Set icon position */
		iconX = textX - iconWidth - 2;
		iconY = textY - (textLayout.height / 2) - (iconHeight / 2);
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Draw text */
		textFont.draw(batch, text, textX, textY);
		
		/* Draw icon */
		batch.draw(icon, iconX, iconY, iconWidth, iconHeight);
	}

	@Override
	public void reset() {
	}

}
