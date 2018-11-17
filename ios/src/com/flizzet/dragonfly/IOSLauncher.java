package com.flizzet.dragonfly;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.flizzet.ads.AdHandler;
import com.flizzet.wobblyfly.DragonflyGame;

public class IOSLauncher extends IOSApplication.Delegate {
    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        return new IOSApplication(new DragonflyGame(new BlankAdHandler()), config);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}

class BlankAdHandler implements AdHandler {

	@Override
	public void showBannerAds(boolean show) {
	}

	@Override
	public void showInterstitialAds(boolean show) {
	}

	@Override
	public void showInterstitialVideoAds(boolean show) {
	}

	@Override
	public void showVideoAds(boolean show) {
	}
	
}