package com.flizzet.dragonfly.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.flizzet.ads.AdHandler;
import com.flizzet.wobblyfly.DragonflyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width = 800;
		config.height = 480;
		config.title = "Wobbly Fly";
		
		new LwjglApplication(new DragonflyGame(new BlankAdHandler()), config);
	}
}

class BlankAdHandler implements AdHandler {
    @Override
    public void showBannerAds(boolean show) {}
    @Override
    public void showVideoAds(boolean show) {}
    @Override
    public void showInterstitialAds(boolean show) {}
    @Override
    public void showInterstitialVideoAds(boolean show) {}
}