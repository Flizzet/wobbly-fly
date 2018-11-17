package com.flizzet.particles;

import com.flizzet.containers.Container;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Allows for easy repeated particle creation without retyping all the code.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class ParticleFunctions {

	public static final ParticleFunctions INSTANCE = new ParticleFunctions();
	private Container<Particle> container = GameWorld.INSTANCE.particleContainer;
	
	/** Suppress default constructor for noninstantiability */
	private ParticleFunctions() {}
	
	/** Creates a new {@link WaterParticle} */
	public void addWaterParticle(float x, float y, int amount) {
		for (int i = 0; i < amount; i++) {
			WaterParticle newParticle = new WaterParticle();
			newParticle.setX(x);
			newParticle.setY(y);
			container.add(newParticle);
		}
	}
	
	/** Creates a new {@link WarningExclamationParticle} */
	public void addWarningParticle(float x, float y, boolean center) {
		WarningExclamationParticle newParticle = new WarningExclamationParticle();
		newParticle.setX(center ? x - newParticle.getHalfWidth() : x);
		newParticle.setY(y);
		container.add(newParticle);
	}

	/** Creates a new {@link HealingParticle} */
	public void addHealingParticle(float x, float y, boolean center) {
		HealingParticle newParticle = new HealingParticle();
		newParticle.setX(center ? x - newParticle.getHalfWidth() : x);
		newParticle.setY(y);
		container.add(newParticle);
	}
	
}
