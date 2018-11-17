package com.flizzet.menus.startmenu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.score.ScoreHolder;
import com.flizzet.utils.FontUtils;

/**
 * Displays the score on the start menu.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class StartMenuScoreDisplay extends GuiComponent {
	
	private BitmapFont font = FontUtils.MAINFONT_75;
	private String highScoreText = "";
	private GlyphLayout highScoreLayout = new GlyphLayout(font, highScoreText);
	private float coinsYOffset = 0;
	private String coinsText = "";
	private GlyphLayout coinsLayout = new GlyphLayout(font, coinsText);

	/** Default instantiable constructor */
	public StartMenuScoreDisplay() {
	}

	@Override
	public void update(float delta) {
		/* Set text */
		highScoreText = "high score: " + ScoreHolder.INSTANCE.getHighScore();
		highScoreLayout.setText(font, highScoreText);
		coinsYOffset = highScoreLayout.height + 5;
		coinsText = "coins: " + ScoreHolder.INSTANCE.getCoins();
		coinsLayout.setText(font, coinsText);
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Draw text */
		font.draw(batch, highScoreText, bounds.x, bounds.y + highScoreLayout.height);
		font.draw(batch, coinsText, bounds.x, bounds.y + highScoreLayout.height + coinsLayout.height + coinsYOffset);
	}

	@Override
	public void reset() {}

}
