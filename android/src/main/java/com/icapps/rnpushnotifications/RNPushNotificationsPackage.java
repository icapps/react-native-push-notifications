package com.icapps.rnpushnotifications;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Koen Van Looveren
 */
public class RNPushNotificationsPackage implements ReactPackage {
	@Override
	public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
		final List<NativeModule> list = new ArrayList<>();
		list.add(new RNPushNotificationsModule(reactContext));
		return list;
	}

	@Override
	public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
		return Collections.emptyList();
	}

	@Override
	@Deprecated()
	public List<Class<? extends JavaScriptModule>> createJSModules() {
		return Collections.emptyList();
	}
}