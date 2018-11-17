package com.flizzet.dragonfly;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Handles in app purchases.
 *
 * @author Pedro Dutra (2017)
 * @version 1.0
 */
public class InAppBilling {
	
	IInAppBillingService mService;

	ServiceConnection mServiceConn = new ServiceConnection() {
	   @Override
	   public void onServiceDisconnected(ComponentName name) {
	       mService = null;
	   }

	   @Override
	   public void onServiceConnected(ComponentName name, IBinder service) {
	       mService = IInAppBillingService.Stub.asInterface(service);
	   }
	};

	/** Default instantiable constructor */
	public InAppBilling() {
	}

}
