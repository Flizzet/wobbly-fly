package com.flizzet.map.ground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flizzet.entity.Entity;
import com.flizzet.map.MapBackgroundDarkener;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Holds {@link GroundDecoration}s.
 * I'm not going to lie, this system could be done better but to implement
 * a strong system would take forever and would make no difference in 
 * performance it would only look cuter in the code so whatever.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class GroundDecorationHolder extends Entity {
	
	/* Layer 1 */
	private Queue<GroundDecoration> toBeAdded1 = new LinkedList<GroundDecoration>();
	private Queue<GroundDecoration> toBeRemoved1 = new LinkedList<GroundDecoration>();
	private ArrayList<GroundDecoration> layerList1 = new ArrayList<GroundDecoration>();
	
	/* Layer 2 */
	private Queue<GroundDecoration> toBeAdded2 = new LinkedList<GroundDecoration>();
	private Queue<GroundDecoration> toBeRemoved2 = new LinkedList<GroundDecoration>();
	private ArrayList<GroundDecoration> layerList2 = new ArrayList<GroundDecoration>();
	
	/* Layer 3 */
	private Queue<GroundDecoration> toBeAdded3 = new LinkedList<GroundDecoration>();
	private Queue<GroundDecoration> toBeRemoved3 = new LinkedList<GroundDecoration>();
	private ArrayList<GroundDecoration> layerList3 = new ArrayList<GroundDecoration>();
	
	/* Layer 4 */
	private Queue<GroundDecoration> toBeAdded4 = new LinkedList<GroundDecoration>();
	private Queue<GroundDecoration> toBeRemoved4 = new LinkedList<GroundDecoration>();
	private ArrayList<GroundDecoration> layerList4 = new ArrayList<GroundDecoration>();

	private final Ground ground;
	private MapBackgroundDarkener[] darkeners = {
			new MapBackgroundDarkener(0.3f),
			new MapBackgroundDarkener(0.3f)
	};
	
	private final GroundDecorationAdder adder;
	
	/** Default instantiable constructor */
	public GroundDecorationHolder() {
		this.ground = Ground.INSTANCE;
		this.adder = new GroundDecorationAdder(this);
	}

	@Override
	public void update(float delta) {
		/* Update GroundDecorationAdder */
		adder.update(delta);
		
		/* Add and remove new decorations for each layer */
		/* Layer 1 */
		layerList1.addAll(toBeAdded1);
		layerList1.removeAll(toBeRemoved1);
		toBeAdded1.removeAll(toBeAdded1);
		toBeRemoved1.removeAll(toBeRemoved1);
		/* Layer 2 */
		layerList2.addAll(toBeAdded2);
		layerList2.removeAll(toBeRemoved2);
		toBeAdded2.removeAll(toBeAdded2);
		toBeRemoved2.removeAll(toBeRemoved2);
		/* Layer 3 */
		layerList3.addAll(toBeAdded3);
		layerList3.removeAll(toBeRemoved3);
		toBeAdded3.removeAll(toBeAdded3);
		toBeRemoved3.removeAll(toBeRemoved3);
		/* Layer 4 */
		layerList4.addAll(toBeAdded4);
		layerList4.removeAll(toBeRemoved4);
		toBeAdded4.removeAll(toBeAdded4);
		toBeRemoved4.removeAll(toBeRemoved4);
		
		/* Update all darkeners */
		for (MapBackgroundDarkener d : darkeners) {
			d.update(delta);
		}
		
		/* Update all layers */
		for (GroundDecoration g : layerList4) { g.update(delta); }
		for (GroundDecoration g : layerList3) { g.update(delta); }
		for (GroundDecoration g : layerList2) { g.update(delta); }
		for (GroundDecoration g : layerList1) { g.update(delta); }
	}

	@Override
	public void render(SpriteBatch batch) {
		/* Render all layers */
		for (GroundDecoration g : layerList4) { g.render(batch); }
		darkeners[0].render(batch);
		for (GroundDecoration g : layerList3) { g.render(batch); }
		darkeners[1].render(batch);
		for (GroundDecoration g : layerList2) { g.render(batch); }
		for (GroundDecoration g : layerList1) { g.render(batch); }
	}

	/** Adds a new decoration to the defined {@link GroundDecorationLayer}. */
	public void addDecoration(GroundDecorationLayer layer, GroundDecoration decoration) {
		decoration.setX(GameWorld.INSTANCE.camera.getWidth());
		decoration.setY(ground.getY() + ground.getHeight());
		/* Add to list that corresponds to defined layer */
		switch (layer) {
		case LAYER_1: toBeAdded1.add(decoration); break;
		case LAYER_2: toBeAdded2.add(decoration); break;
		case LAYER_3: toBeAdded3.add(decoration); break;
		case LAYER_4: toBeAdded4.add(decoration); break;
		}
	}
	/** @return a decoration layer based on the defined {@link GroundDecorationLayer}.  */
	public ArrayList<GroundDecoration> getDecorationLayer(GroundDecorationLayer layer) {
		/* Return list that corresponds to defined layer */
		switch (layer) {
		case LAYER_1: return layerList1;
		case LAYER_2: return layerList2;
		case LAYER_3: return layerList3;
		case LAYER_4: return layerList4;
		}
		/* Throw NPE if bad layer defined */
		throw new NullPointerException("Bad layer");
	}

	@Override
	public void reset() {}
	
	public Ground getGround()	{ return this.ground; }
	
}
