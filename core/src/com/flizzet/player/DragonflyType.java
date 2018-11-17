package com.flizzet.player;

import com.badlogic.gdx.graphics.Texture;
import com.flizzet.assets.AssetInfo;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Handles dragonfly types and their values.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public enum DragonflyType {

	SWAMP_DRAGONFLY(GameWorld.INSTANCE.assets.get(AssetInfo.SWAMP_DRAGONFLY, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_MENU_PREVIEW_SWAMP_DRAGONFLY, Texture.class),
			"swamp", "swamp environment"),
	OPAL_DRAGONFLY(GameWorld.INSTANCE.assets.get(AssetInfo.ADULT_OPAL_DRAGONFLY, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_MENU_PREVIEW_OPAL_DRAGONFLY, Texture.class),
			"opal", "opal environment"),
	DIAMOND_DRAGONFLY(GameWorld.INSTANCE.assets.get(AssetInfo.ADULT_DIAMOND_DRAGONFLY, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_MENU_PREVIEW_DIAMOND_DRAGONFLY, Texture.class),
			"diamond", "diamond environment"),
	RUBY_DRAGONFLY(GameWorld.INSTANCE.assets.get(AssetInfo.ADULT_RUBY_DRAGONFLY, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_MENU_PREVIEW_RUBY_DRAGONFLY, Texture.class),
			"rubellite", "rubellite environment");
	
	private final Texture flapSheet;
	private final Texture shopPreview;
	private final String title;
	private final String description;
	private boolean purchased = false;
	
	DragonflyType(Texture flapSheet, Texture shopPreview, String title, String description) {
		this.flapSheet = flapSheet;
		this.shopPreview = shopPreview;
		this.title = title;
		this.description = description;
	}
	
	public boolean isPurchased()					{ return this.purchased; }
	public Texture getFlapSheet()					{ return this.flapSheet; }
	public Texture getShopPreview()					{ return this.shopPreview; }
	public String getTitle()						{ return this.title; }
	public String getDescription()					{ return this.description; }
	public void setPurchased(boolean isPurchased)	{ this.purchased = isPurchased; }
	
}
