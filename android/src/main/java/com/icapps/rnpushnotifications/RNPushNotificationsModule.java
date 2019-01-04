package com.icapps.rnpushnotifications;

import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * @author Koen Van Looveren
 */
public class RNPushNotificationsModule extends ReactContextBaseJavaModule {

	private static final String NAME = "RNPushNotifications";

	private final ReactApplicationContext reactContext;

	RNPushNotificationsModule(ReactApplicationContext reactContext) {
		super(reactContext);
		this.reactContext = reactContext;
	}

	@ReactMethod
	public void getFirebaseToken(Promise promise) {
		promise.resolve("real-token");
		Log.d(NAME, "token provided");
	}

	@Override
	public String getName() {
		return NAME;
	}
}