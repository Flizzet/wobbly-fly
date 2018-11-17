package com.flizzet.menus.shopmenu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.utils.FontUtils;

/**
 * Title for {@link ShopMenu}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ShopTitle extends GuiComponent {
	
	private String titleText = "shop";
	private BitmapFont titleFont = FontUtils.MAINFONT_50;
	private GlyphLayout layout = new GlyphLayout(titleFont, titleText);

	/** Default instantiable constructor */
	public ShopTitle() {}

	@Override
	public void update(float delta) {}

	@Override
	public void render(SpriteBatch batch) {
		titleFont.draw(batch, titleText, this.getX(), this.getY());
	}

	@Override public void reset() {}
	
	@Override
	public float getHeight()	{ return layout.height; }
	public float getWidth()		{ return layout.width; }

}
