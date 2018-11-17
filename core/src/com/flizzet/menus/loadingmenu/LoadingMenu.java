package com.flizzet.menus.loadingmenu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.menus.Menu;
import com.flizzet.utils.FontUtils;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Displays on the Loading Screen.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class LoadingMenu extends Menu {
	
	private BitmapFont font = FontUtils.MAINFONT_120;
	private String loadingText = "loading...";
	private GlyphLayout loadingLayout = new GlyphLayout(font, loadingText);
	private float loadingX, loadingY;
	
	/** Default instantiable constructor */
	public LoadingMenu() {
	}

	@Override
	public void update(float delta) {
		/* Set loading text position */
		loadingX = GameWorld.INSTANCE.camera.getCenterX() - (loadingLayout.width / 2);
		loadingY = GameWorld.INSTANCE.camera.getCenterY() - (loadingLayout.height / 2);
	}

	@Override
	public void render(SpriteBatch batch) {
		font.draw(batch, loadingText, loadingX, loadingY);
	}

	@Override
	public void buildMenu() {
	}
	
	@Override
	public void reset() {
	}

}
