package com.flizzet.menus.shopmenu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.guicomponent.GuiConstants;
import com.flizzet.player.DragonflyType;
import com.flizzet.utils.FontUtils;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Describes the selected dragonfly in a ShopPreviewScrollerCell.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ShopDescription extends GuiComponent {

	private DragonflyType type = DragonflyType.SWAMP_DRAGONFLY;
	private final ShopPreviewScroller scroller;
	private BitmapFont priceFont = FontUtils.MAINFONT_40;
	private String priceText = "1000 coins";
	private GlyphLayout priceLayout = new GlyphLayout(priceFont, priceText);
	private BitmapFont descFont = FontUtils.MAINFONT_40;
	private String descText = "desc";
	private GlyphLayout descLayout = new GlyphLayout(descFont, descText);
	private BitmapFont titleFont = FontUtils.MAINFONT_50;
	private String titleText = "title";
	private GlyphLayout titleLayout = new GlyphLayout(titleFont, titleText);
	private float titleX, titleY;
	private float descX, descY;
	private float priceX, priceY;
			
	/** Default instantiable constructor */
	public ShopDescription(ShopPreviewScroller scroller) {
		this.scroller = scroller;
		this.setHeight(titleLayout.height + GuiConstants.PADDING + descLayout.height);
	}

	@Override
	public void update(float delta) {
		/* Set type based on selected in ShopPreviewScroller */
		type = scroller.getSelectedDragonflyType();
		
		/* Set texts and create layouts */
		titleText = type.getTitle() + " dragonfly";
		titleLayout.setText(titleFont, titleText);
		descText = type.getDescription();
		descLayout.setText(descFont, descText);
		
		/* Position text */
		this.titleX = GameWorld.INSTANCE.camera.getCenterX() - (titleLayout.width / 2);
		this.titleY = scroller.getY() - 20;
		this.descX = GameWorld.INSTANCE.camera.getCenterX() - (descLayout.width / 2);
		this.descY = titleY - descLayout.height - GuiConstants.SPACING;
		this.priceX = GameWorld.INSTANCE.camera.getCenterX() - (priceLayout.width / 2);
		this.priceY = descY - 2 - GuiConstants.SPACING;
		
		/* Set dimensions */
		this.setHeight(titleLayout.height + GuiConstants.PADDING + descLayout.height);
		this.setWidth(descLayout.width > titleLayout.width ? descLayout.width : titleLayout.width);
	}

	@Override
	public void render(SpriteBatch batch) {
		titleFont.draw(batch, titleText, titleX, titleY);
		descFont.draw(batch, descText, descX, descY);
		priceFont.draw(batch, priceText, priceX, priceY);
	}

	@Override
	public void reset() {
	}

}
