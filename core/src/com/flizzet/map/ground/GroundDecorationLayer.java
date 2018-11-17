package com.flizzet.map.ground;

/**
 * Holds {@link GroundDecoration} lists for the {@link GroundDecorationHolder}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public enum GroundDecorationLayer {

	LAYER_1(100), LAYER_2(30), LAYER_3(5), LAYER_4(20);
	
	public final float FREQUENCY;
	
	GroundDecorationLayer(float frequency) {
		this.FREQUENCY = frequency;
	}
	
	/** @return the number of GroundDecorationLayers */
	public int getTotalLayers() {
		return values().length;
	}
	
}