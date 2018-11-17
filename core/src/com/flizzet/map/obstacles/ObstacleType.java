package com.flizzet.map.obstacles;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.flizzet.assets.AssetInfo;
import com.flizzet.wobblyfly.GameWorld;

/**
 * Holds information about the defined {@link Obstacle}.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public enum ObstacleType {
	
	COBWEB(
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_COBWEB_1, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_COBWEB_2, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_COBWEB_3, Texture.class) ),
	OPAL_STALAGMITE(
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_OPAL_STALAGMITE_1, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_OPAL_STALAGMITE_2, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_OPAL_STALAGMITE_3, Texture.class) ),
	DIAMOND_STALAGMITE(
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_DIAMOND_STALAGMITE_1, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_DIAMOND_STALAGMITE_2, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_DIAMOND_STALAGMITE_3, Texture.class) ),
	RUBY(
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_RUBY_STALAGMITE_1, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_RUBY_STALAGMITE_2, Texture.class),
			GameWorld.INSTANCE.assets.get(AssetInfo.OBSTACLE_RUBY_STALAGMITE_3, Texture.class) );
	
	private final ArrayList<Texture> allImages = new ArrayList<Texture>();
	
	ObstacleType(Texture... params) {
		for (Texture t : params) {
			allImages.add(t);
		}
	}
	
	public ArrayList<Texture> getAllImages()	{ return this.allImages; }

}
