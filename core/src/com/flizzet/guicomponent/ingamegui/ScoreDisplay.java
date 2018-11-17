package com.flizzet.guicomponent.ingamegui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.guicomponent.GuiConstants;
import com.flizzet.score.ScoreHolder;
import com.flizzet.utils.FontUtils;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Displays the score for the {@link InGameGui}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ScoreDisplay extends GuiComponent {

	private int score;
	private int highScore;
	private int coins;
	
	private BitmapFont font = FontUtils.MAINFONT_30;
	private String scoreText = "score";
	private GlyphLayout scoreLayout = new GlyphLayout(font, scoreText);
	private float scoreYOffset = -scoreLayout.height;
	private String highScoreText = "high score";
	private float highScoreYOffset = -scoreLayout.height - GuiConstants.SPACING;
	private GlyphLayout highScoreLayout = new GlyphLayout(font, highScoreText);
	
	private String coinsText = "coins";
	private GlyphLayout coinsLayout = new GlyphLayout(font, coinsText);
	private float coinsYOffset = -coinsLayout.height;
	private float coinsX = 0;
	
	/** Default instantiable constructor */
	public ScoreDisplay() {}

	@Override
	public void update(float delta) {
		/* Update score and highScore */
		score = ScoreHolder.INSTANCE.getScore();
		highScore = ScoreHolder.INSTANCE.getHighScore();
		coins = ScoreHolder.INSTANCE.getCoins();
		/* Set scoreText according to score */
		scoreText = "score: " + score;
		highScoreText = "high score: " + highScore;
		coinsText = "coins: " + coins;
		scoreLayout.setText(font, scoreText);
		highScoreLayout.setText(font, highScoreText);
		coinsLayout.setText(font, coinsText);
		coinsX = GameWorld.INSTANCE.camera.getWidth() - GuiConstants.PADDING - coinsLayout.width;
	}

	@Override
	public void render(SpriteBatch batch) {
		font.draw(batch, scoreText, this.getX(), this.getY() + scoreYOffset);
		font.draw(batch, highScoreText, this.getX(), this.getY() + scoreYOffset + highScoreYOffset);
		font.draw(batch, coinsText, coinsX, this.getY() + coinsYOffset);
	}

	@Override
	public void reset() {}

}
