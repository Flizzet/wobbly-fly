package com.flizzet.utils;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

/**
 * Utilities for Shapes i.e. Shape conversion.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ShapeUtils {

	/** Suppress default constructor for noninstantiability */
	private ShapeUtils() {
		throw new AssertionError();
	}

	/** Convert a rectangle to a polygon */
    public static Polygon rectToPolygon(Rectangle bounds) {
		Polygon newBounds;
		newBounds = new Polygon(new float[] { 0, 0, bounds.width, 0, bounds.width, bounds.height, 0, bounds.height });
		return newBounds;
    }
	
}
