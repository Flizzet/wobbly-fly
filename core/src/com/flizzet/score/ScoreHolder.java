package com.flizzet.score;

/**
 * Holds scores, high scores, etc.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ScoreHolder {

	public static final ScoreHolder INSTANCE = new ScoreHolder();
	
	private int score;
	private int highScore;
	private int coins;
	
	/** Suppress default constructor for noninstantiability */
	public ScoreHolder() {
	}
	
	/* Keeps the highscore above the score */
	public void updateHighScore() {
		if (highScore < score) {
			highScore = score;
		}
	}
	
	public void setScore(int newScore) 			{ score = newScore; }
	public void setHighScore(int newHighScore)	{ highScore = newHighScore; }
	public void setCoins(int newCoins)			{ coins = newCoins; }
	
	public int getScore()						{ return this.score; }
	public int getHighScore()					{ return this.highScore; }
	public int getCoins()						{ return this.coins; }

}
