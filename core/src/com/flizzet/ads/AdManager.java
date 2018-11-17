package com.flizzet.ads;

import com.flizzet.interfaces.Updatable;
import com.flizzet.wobblyfly.Constants;

/**
 * Handles displaying and not displaying ads.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class AdManager implements Updatable {

	public static final AdManager INSTANCE = new AdManager();
	private AdHandler handler;
	
	/** Default instantiable constructor */
	public AdManager() {
	}

	@Override
	public void update(float delta) {
	}

	/** Displays a banner ad */
	public void showBannerAd() {
		handler.showBannerAds(true);
	}

	/** Hides a banner ad if it's displayed */
	public void hideBannerAd() {
		handler.showBannerAds(false);
	}

	/** Displays an interstitial ad */
	public void showInterstitialAd() {
		handler.showInterstitialAds(true);
	}

	/** Displays an interstitial video ad */
	public void showInterstitialVideoAd() {
		handler.showInterstitialVideoAds(true);
	}

	/** Plays a video ad if it's loaded */
	public void showVideoAd() {
		handler.showVideoAds(true);
	}

	/** Called when a video is loaded */
	public void videoLoaded() {
		Constants.ADS_PLAYABLE = true;
	}

	/** Called when a video failed to load */
	public void videoFailed() {
		Constants.ADS_PLAYABLE = false;
	}

	/** Called when a video is completed and rewarded */
	public void videoRewarded() {
	}

	public void setHandler(AdHandler newHandler) {
		this.handler = newHandler;
	}

}
