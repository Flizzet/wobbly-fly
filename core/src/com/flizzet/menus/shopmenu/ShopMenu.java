package com.flizzet.menus.shopmenu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.CoinDisplay;
import com.flizzet.guicomponent.GuiConstants;
import com.flizzet.menus.Menu;
import com.flizzet.menus.startmenu.MenuBackground;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Shop menu for {@link ShopState}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ShopMenu extends Menu {

	private AddMoneyButton addMoneyButton;
	private ShopBackButton backButton;
	private ShopBuyButton buyButton;
	private ShopPreviewScroller previewScroller;
	private MenuBackground background;
	private ShopTitle title;
	private CoinDisplay coinDisplay;
	private ShopDescription description;
	
	/** Default instantiable constructor */
	public ShopMenu() {}

	@Override public void update(float delta) {}
	@Override public void render(SpriteBatch batch) {}
	@Override public void reset() {}

	@Override
	public void buildMenu() {
		/* Create and position menu background */
		background = new MenuBackground();
		background.setX(GameWorld.INSTANCE.camera.getCenterX() - background.getHalfWidth());
		background.setY(GameWorld.INSTANCE.camera.getCenterY() - background.getHalfHeight());
		/* Create and position back button */
		backButton = new ShopBackButton();
		backButton.setX(GuiConstants.SPACING);
		backButton.setY(GameWorld.INSTANCE.camera.getHeight() - backButton.getHeight() - GuiConstants.SPACING);
		/* Create title and position */
		title = new ShopTitle();
		title.setX(backButton.getX() + backButton.getWidth() + GuiConstants.PADDING);
		title.setY(backButton.getY() + backButton.getHeight() - title.getHeight());
		/* Create coin display */
		coinDisplay = new CoinDisplay();
		/* Create and position preview scroller */
		previewScroller = new ShopPreviewScroller();
		previewScroller.setX(GameWorld.INSTANCE.camera.getCenterX());
		previewScroller.setY(GameWorld.INSTANCE.camera.getHeight() - 100);
		/* Create and position description */
		description = new ShopDescription(previewScroller);
		description.setX(GameWorld.INSTANCE.camera.getCenterX() - description.getHalfWidth());
		description.setY(previewScroller.getY() - description.getHeight());
		/* Create and position buy button */
		buyButton = new ShopBuyButton(previewScroller);
		buyButton.setX(GameWorld.INSTANCE.camera.getCenterX() - (buyButton.getHalfWidth()));
		buyButton.setY(GuiConstants.SPACING);
		/* Create and position in app purchase button */
		addMoneyButton = new AddMoneyButton();
		addMoneyButton.setX(GameWorld.INSTANCE.camera.getCenterX() - (addMoneyButton.getHalfWidth()));
		addMoneyButton.setY(GameWorld.INSTANCE.camera.getY() + GameWorld.INSTANCE.camera.getHeight()
							- addMoneyButton.getHeight() - GuiConstants.SPACING);
		
		GameWorld.INSTANCE.guiContainer.add(background);
		GameWorld.INSTANCE.guiContainer.add(backButton);
		GameWorld.INSTANCE.guiContainer.add(title);
		GameWorld.INSTANCE.guiContainer.add(coinDisplay);
		GameWorld.INSTANCE.guiContainer.add(previewScroller);
		GameWorld.INSTANCE.guiContainer.add(description);
		GameWorld.INSTANCE.guiContainer.add(buyButton);
		GameWorld.INSTANCE.guiContainer.add(addMoneyButton);
	}

}
