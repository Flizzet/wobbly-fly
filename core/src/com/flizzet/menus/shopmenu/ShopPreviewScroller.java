package com.flizzet.menus.shopmenu;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.guicomponent.GuiComponent;
import com.flizzet.player.DragonflyType;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Opponent that allows scrolling through Dragonfly previews.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ShopPreviewScroller extends GuiComponent {

	private ArrayList<ShopPreviewScrollerCell> cells = new ArrayList<ShopPreviewScrollerCell>();
	private float[] positions = new float[] { 0, 0, 0, 0 };
	private int selectedPosition = 0;
	private float scrollAmount = 0;
	private float scrollSpeed = 10;
	private float mouseYChange = 0;
	private float currentMouseY;
	private float initialMouseY;
	private boolean clicked = false;
	public static final int CELL_PADDING = 20;
	
	/** Default instantiable constructor */
	public ShopPreviewScroller() {
		buildCells();
		this.setHeight(cells.get(0).getHeight());
		this.setWidth(cells.get(0).getWidth());
	}

	@Override
	public void update(float delta) {
		/* Check for a click */
		if (Gdx.input.isTouched()) {
			/* If not clicked, set the initial mouse Y */
			if (!clicked) {
				clicked = true;
				initialMouseY = GameWorld.INSTANCE.camera.getMousePos().x;
			}
			/* Find current mouse Y */
			currentMouseY = GameWorld.INSTANCE.camera.getMousePos().x;
		} else {
			clicked = false;
		}
		
		/* Ease initial mouse Y towards real mouse Y for slow end */
		initialMouseY += (currentMouseY - initialMouseY) / 10;
		
		/* Find mouse change with initial mouseY and new mouseY */
		mouseYChange = currentMouseY - initialMouseY;
		
		/* Add mouseYChange to scrollAmount */
		scrollAmount += mouseYChange / scrollSpeed;
		
		/* Finding which position is selected based on scrollAmount */
		for (int i = 0; i < positions.length; i++) {
			if (scrollAmount > positions[i] + (positions[1] / 2)
			&& scrollAmount < positions[i] - (positions[1] / 2)) {
				selectedPosition = i;
				cells.get(i).setSelected(true);
				for (ShopPreviewScrollerCell c : cells) {
					if (c != cells.get(i)) {
						c.setSelected(false);
					}
				}
			}
		}
		/* Snapping to selected position */
		if (!clicked) {
			scrollAmount += (positions[selectedPosition] - scrollAmount) / 3;
		}
		
		/* Update and position all ShopPreviewScrollerCells */
		int totalCells = 0;
		for (ShopPreviewScrollerCell c : cells) {
			/* Update cells */
			c.update(delta);
			/* Position cells, add scroll amount */
			c.setX(this.getX() - c.getWidth() + ((c.getWidth() + CELL_PADDING) * totalCells)
					+ scrollAmount + c.getHalfWidth());
			c.setY(this.getCenterY() - (c.getHalfHeight()));
			totalCells++;
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Render all ShopPreviewScrollerCells */
		for (ShopPreviewScrollerCell c : cells) {
			c.render(batch);
		}
	}
	
	private void buildCells() {
		/* Build cells based on total dragonfly types */
		for (int i = 0; i < DragonflyType.values().length; i++) {
			ShopPreviewScrollerCell cell = new ShopPreviewScrollerCell(DragonflyType.values()[i]);
			cell.setX(this.getX() + ((i - 1) * (cell.getWidth() + CELL_PADDING)));
			cell.setY(this.getY() - (cell.getHalfHeight()));
			cells.add(cell);
		}
		/* Build positions based on newly built cells */
		for (int i = 0; i < positions.length; i++) {
			positions[i] = -((cells.get(0).getWidth() + CELL_PADDING) * i);
		}
	}

	@Override public void reset() {}
	
	public DragonflyType getSelectedDragonflyType() {
		for (ShopPreviewScrollerCell c : cells) {
			if (c.isSelected()) {
				return c.getType();
			}
		}
		return DragonflyType.SWAMP_DRAGONFLY;
	}

}
