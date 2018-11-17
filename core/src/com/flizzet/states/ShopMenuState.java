package com.flizzet.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.menus.shopmenu.ShopMenu;

/**
 * State for shopping for new Dragonflies/Updragadeables.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ShopMenuState extends GameState {

	private ShopMenu shopMenu;
	
	/** Default instantiable constructor */
	public ShopMenuState() {
	}

	@Override
	public void entered() {
		shopMenu = new ShopMenu();
		shopMenu.buildMenu();
		guiContainer.add(shopMenu);
	}

	@Override
	public void update(float delta) {}

	@Override
	public void render(SpriteBatch batch) {}

	@Override
	public void exited() {
		entityContainer.clear();
		guiContainer.clear();
	}

	@Override
	public void dispose() {
	}

}
