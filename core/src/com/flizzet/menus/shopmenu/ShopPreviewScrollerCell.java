package com.flizzet.menus.shopmenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.player.DragonflyType;

/**
 * Cell for displaying a Dragonfly preview.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ShopPreviewScrollerCell extends GuiComponent {

	private final DragonflyType type;
	private final Texture image;
	private float scale = 2;
	private float destinedWidth = 64;
	private boolean selected = false;
	private float selectedScaleOffset = 0;
	private float maximumSelectedScaleOffset = 20;
	
	/** Default instantiable constructor */
	public ShopPreviewScrollerCell(DragonflyType type) {
		this.type = type;
		this.image = type.getShopPreview();
		this.adjustBoundsToImage(image);
		
		/* Set dimensions with special scale */
		scale = destinedWidth / this.getWidth();
		this.setWidth(this.getWidth() * scale);
		this.setHeight(this.getHeight() * scale);
	}

	@Override
	public void update(float delta) {
		/* Set selected scale */
		if (selected) {
			selectedScaleOffset += (maximumSelectedScaleOffset - selectedScaleOffset) / 2;
		} else {
			selectedScaleOffset += (0 - selectedScaleOffset) / 2;
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, this.getX() - (selectedScaleOffset / 2), this.getY() - (selectedScaleOffset / 2),
				this.getWidth() + selectedScaleOffset, this.getHeight() + selectedScaleOffset);
	}

	@Override public void reset() {}

	public void setSelected(boolean isSelected)	{ this.selected = isSelected; }

	public boolean isSelected()					{ return this.selected; }
	public DragonflyType getType()				{ return this.type; }
	
}
