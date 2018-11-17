package com.flizzet.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

/**
 * Holds fonts and font utilities.
 *
 * @author Pedro Dutra (2017)
 * @version 1.1
 */
public class FontUtils {
    
    private static final String mainFontDir = "fonts/bitwonder.ttf";
    private static final String ALL_CHARS = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-_=+[]{};:,'`./<>?";
    
    public static final BitmapFont MAINFONT_175 = newFont(175, false, Color.WHITE);
    public static final BitmapFont MAINFONT_150 = newFont(150, false, Color.WHITE);
    public static final BitmapFont MAINFONT_120 = newFont(120, false, Color.WHITE);
    public static final BitmapFont MAINFONT_90 = newFont(90, false, Color.WHITE);
    public static final BitmapFont MAINFONT_85 = newFont(85, false, Color.WHITE);
    public static final BitmapFont MAINFONT_75 = newFont(75, false, Color.WHITE);
    public static final BitmapFont MAINFONT_70 = newFont(70, false, Color.WHITE);
    public static final BitmapFont MAINFONT_50 = newFont(50, false, Color.WHITE);
    public static final BitmapFont MAINFONT_40 = newFont(40, false, Color.WHITE);
    public static final BitmapFont MAINFONT_30 = newFont(30, false, Color.WHITE);
    public static final BitmapFont MAINFONT_20 = newFont(20, false, Color.WHITE);
    
    /** Suppress default constructor for noninstantiability */
    private FontUtils() {
    	throw new AssertionError();
    }
    
    /** Create a new BitmapFont of the defined size */
    public static BitmapFont newFont(int size, boolean bordered, Color color) {
		BitmapFont newFont;
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(mainFontDir));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		
		parameter.size = size;
		parameter.color = color;
		parameter.characters = ALL_CHARS;
		/* Build a border if defined */
		if (bordered) {
		    parameter.borderColor = Color.BLACK;
		    parameter.borderStraight = true;
		    parameter.borderWidth = 10;
		}
		newFont = generator.generateFont(parameter);
		newFont.getData().setScale(0.15f);
		newFont.getData().setScale(0.15f);
		newFont.setUseIntegerPositions(false);
		generator.dispose();
		return newFont;
    }

}
