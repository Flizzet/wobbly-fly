package com.flizzet.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/**
 * Handles and manages loading and getting assets using an {@link AssetManager}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class AssetHandler {

	private AssetManager manager = new AssetManager();
	
	/** Default instantiable constructor */
	public AssetHandler() {}
	
	/** Loads all assets using their AssetDescriptors */
	public void loadAll() {
		/* Load every file in lists */
		for (String s : AssetInfo.SWAMP_GRAPHICS) {
			manager.load(s, Texture.class);
		}
		for (String s : AssetInfo.OPAL_GRAPHICS) {
			manager.load(s, Texture.class);
		}
		for (String s : AssetInfo.DIAMOND_GRAPHICS) {
			manager.load(s, Texture.class);
		}
		for (String s : AssetInfo.RUBY_GRAPHICS) {
			manager.load(s, Texture.class);
		}
		for (String s : AssetInfo.OBSTACLES) {
			manager.load(s, Texture.class);
		}
		/* Load every constant file */
			// Player
		manager.load(AssetInfo.SWAMP_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.ADULT_DIAMOND_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.BABY_DIAMOND_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.ADULT_OPAL_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.BABY_OPAL_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.ADULT_RUBY_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.BABY_RUBY_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.ALEXANDRITE_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.CRYSTAL_DRAGONFLY, Texture.class);
			// Enemies
		manager.load(AssetInfo.SWAMP_BASS_FISH, Texture.class);
		manager.load(AssetInfo.DIAMOND_FROG, Texture.class);
		manager.load(AssetInfo.OPAL_RAT, Texture.class);
		manager.load(AssetInfo.RUBY_SPIDER, Texture.class);
		manager.load(AssetInfo.SWAMP_HORNET, Texture.class);
		manager.load(AssetInfo.OPAL_CAVE_CRITTER, Texture.class);
		manager.load(AssetInfo.DIAMOND_CAVE_CRITTER, Texture.class);
		manager.load(AssetInfo.RUBY_CAVE_CRITTER, Texture.class);
			// Passive creatures
		manager.load(AssetInfo.SWAMP_HEALING_CRITTER, Texture.class);
		manager.load(AssetInfo.OPAL_HEALING_CRITTER, Texture.class);
		manager.load(AssetInfo.DIAMOND_HEALING_CRITTER, Texture.class);
		manager.load(AssetInfo.RUBY_HEALING_CRITTER, Texture.class);
			// Effects/Particles
		manager.load(AssetInfo.VIGNETTE, Texture.class);
		manager.load(AssetInfo.WARNING_EXCLAMATION_PARTICLE, Texture.class);
		manager.load(AssetInfo.HEALING_PARTICLE, Texture.class);
		manager.load(AssetInfo.CURRENCY_GLOW, Texture.class);
			// Items
		manager.load(AssetInfo.COIN, Texture.class);
		manager.load(AssetInfo.DIAMOND_CURRENCY, Texture.class);
		manager.load(AssetInfo.OPAL_CURRENCY, Texture.class);
		manager.load(AssetInfo.RUBY_CURRENCY, Texture.class);
		manager.load(AssetInfo.SWAMP_CURRENCY, Texture.class);
			// GUI
		manager.load(AssetInfo.HEALTH_CONTAINER, Texture.class);
		manager.load(AssetInfo.HEALTH_FILL, Texture.class);
		manager.load(AssetInfo.START_MENU_PLAY_BUTTON, Texture.class);
		manager.load(AssetInfo.START_MENU_PLAY_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.START_MENU_SHOP_BUTTON, Texture.class);
		manager.load(AssetInfo.START_MENU_SHOP_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.START_MENU_BACKGROUND, Texture.class);
		manager.load(AssetInfo.BACK_BUTTON, Texture.class);
		manager.load(AssetInfo.BACK_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.ACCEPT_BUTTON, Texture.class);
		manager.load(AssetInfo.ACCEPT_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.DEATH_MENU_RETRY_BUTTON, Texture.class);
		manager.load(AssetInfo.DEATH_MENU_RETRY_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.DEATH_MENU_STARTMENU_BUTTON, Texture.class);
		manager.load(AssetInfo.DEATH_MENU_STARTMENU_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.START_MENU_LOGO, Texture.class);
		manager.load(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_1_BUTTON, Texture.class);
		manager.load(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_1_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_2_BUTTON, Texture.class);
		manager.load(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_2_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_3_BUTTON, Texture.class);
		manager.load(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_3_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_4_BUTTON, Texture.class);
		manager.load(AssetInfo.LEVEL_CHOICE_MENU_LEVEL_4_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.SHOP_MENU_PREVIEW_SWAMP_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.SHOP_MENU_PREVIEW_OPAL_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.SHOP_MENU_PREVIEW_DIAMOND_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.SHOP_MENU_PREVIEW_RUBY_DRAGONFLY, Texture.class);
		manager.load(AssetInfo.SHOP_BACK_BUTTON, Texture.class);
		manager.load(AssetInfo.SHOP_BUY_BUTTON, Texture.class);
		manager.load(AssetInfo.SHOP_BUY_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.SHOP_EQUIP_BUTTON, Texture.class);
		manager.load(AssetInfo.SHOP_EQUIP_BUTTON_PUSHED, Texture.class);
		manager.load(AssetInfo.SHOP_EQUIPPED_BUTTON, Texture.class);
		manager.load(AssetInfo.ADD_MONEY_BUTTON, Texture.class);
		manager.load(AssetInfo.ADD_MONEY_BUTTON_PUSHED, Texture.class);
	}
	
	/** Disposes all assets for closing of application, prevents memory leaks */
	public void dispose() {
		manager.dispose();
	}

	public AssetManager getManager()	{ return this.manager; }
	public boolean isFinishedLoading()	{ return manager.update(); }
	
	public <T> T get (String fileName, Class<T> type) {
		return manager.get(fileName, type);
	}
	
}
