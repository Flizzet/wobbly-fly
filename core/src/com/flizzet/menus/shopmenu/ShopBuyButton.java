package com.flizzet.menus.shopmenu;

import com.badlogic.gdx.graphics.Texture;
import com.flizzet.assets.AssetInfo;
import com.flizzet.guicomponent.ButtonComponent;
import com.flizzet.player.DragonflyType;
import com.flizzet.saving.Saves;
import com.flizzet.score.ScoreHolder;
import com.flizzet.sounds.SoundHandler;
import com.flizzet.wobblyfly.Constants;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Buys dragonflies in the {@link ShopMenu}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
class ShopBuyButton extends ButtonComponent {
	
	private final ShopPreviewScroller scroller;
	private DragonflyType selectedType = GameWorld.INSTANCE.currentDragonfly;
	private boolean purchased = false;

	/** Default instantiable constructor */
	public ShopBuyButton(ShopPreviewScroller scroller) {
		/* Set scroller */
		this.scroller = scroller;
		
		/* Set images */
		this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_BUY_BUTTON, Texture.class));
		this.setImageHovered(this.getImage());
		this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_BUY_BUTTON_PUSHED, Texture.class));
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		
		/* Find currently selected dragonfly based on ShopPreviewScroller selection */
		selectedType = scroller.getSelectedDragonflyType();
		this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_BUY_BUTTON, Texture.class));
		this.setImageHovered(this.getImage());
		this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_BUY_BUTTON_PUSHED, Texture.class));
		
		if (selectedType.isPurchased()) {
			purchased = true;
			this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_EQUIP_BUTTON, Texture.class));
			this.setImageHovered(this.getImage());
			this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_EQUIP_BUTTON_PUSHED, Texture.class));
		}
		if (!selectedType.isPurchased()) {
			purchased = false;
			this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_BUY_BUTTON, Texture.class));
			this.setImageHovered(this.getImage());
			this.setImagePushed(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_BUY_BUTTON_PUSHED, Texture.class));
		}
		if (selectedType == GameWorld.INSTANCE.currentDragonfly) {
			this.setImage(GameWorld.INSTANCE.assets.get(AssetInfo.SHOP_EQUIPPED_BUTTON, Texture.class));
			this.setImageHovered(this.getImage());
			this.setImagePushed(this.getImage());
		}
	}

	@Override
	public void triggered() {
		if (purchased) {
			GameWorld.INSTANCE.currentDragonfly = selectedType;
		} else {
			if (!Constants.EVERYTHING_FREE) {
				if (ScoreHolder.INSTANCE.getCoins() < 1000) {
					return;
				} else {
					ScoreHolder.INSTANCE.setCoins(ScoreHolder.INSTANCE.getCoins() - 1000);
				}
			}
			selectedType.setPurchased(true);
			Saves.INSTANCE.saveScore();
			Saves.INSTANCE.saveDragonflies();
			SoundHandler.play(SoundHandler.INSTANCE.click, 1.0f);
		}
	}

}
