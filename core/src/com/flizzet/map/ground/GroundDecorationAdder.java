package com.flizzet.map.ground;

import java.util.Random;

import com.flizzet.interfaces.Updatable;

/**
 * Adds GroundDecorations based on their frequency.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class GroundDecorationAdder implements Updatable {

	private Random random = new Random();
	
	private float[] cooldowns = {
		GroundDecorationLayer.LAYER_1.FREQUENCY,
		GroundDecorationLayer.LAYER_2.FREQUENCY,
		GroundDecorationLayer.LAYER_3.FREQUENCY,
		GroundDecorationLayer.LAYER_4.FREQUENCY
	};
	private float[] maximumCooldowns = cooldowns.clone();
	
	private final GroundDecorationHolder decorationHolder;
	
	/** Default instantiable constructor */
	public GroundDecorationAdder(GroundDecorationHolder decorationHolder) {
		this.decorationHolder = decorationHolder;
	}

	@Override
	public void update(float delta) {
		/* Go through every cooldown */
		for (int i = 0; i < cooldowns.length; i++) {
			/* Decrease cooldown */
			cooldowns[i]--;
			/* Check if it's below 0 */
			if (cooldowns[i] < 0) {
				/* Reset cooldown */
				cooldowns[i] = maximumCooldowns[i] + random.nextInt(20);
				/* Add the decoration to the layer */
				addDecoration(i);
			}
		}
	}
	
	/** Adds a decoration based on the int->{@link GroundDecorationLayer} */
	private void addDecoration(int layer) {
		/* Check which layer it is, add a GroundDecoration accordingly */
		switch (layer) {
			case 0: decorationHolder.addDecoration(GroundDecorationLayer.LAYER_1, new GroundDecoration(decorationHolder.getGround(), GroundDecorationLayer.LAYER_1)); return;
			case 1: decorationHolder.addDecoration(GroundDecorationLayer.LAYER_2, new GroundDecoration(decorationHolder.getGround(), GroundDecorationLayer.LAYER_2)); return;
			case 2: decorationHolder.addDecoration(GroundDecorationLayer.LAYER_3, new GroundDecoration(decorationHolder.getGround(), GroundDecorationLayer.LAYER_3)); return;
			case 3: decorationHolder.addDecoration(GroundDecorationLayer.LAYER_4, new GroundDecoration(decorationHolder.getGround(), GroundDecorationLayer.LAYER_4)); return;
		}
		/* If nothing was returned, throw NPE */
		throw new NullPointerException("Bad layer");
	}

}
