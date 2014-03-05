/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ninuku.kinderfun.client;

import java.util.logging.Logger;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.dialog.TabletPortraitOverlay;
import com.googlecode.mgwt.ui.client.layout.MasterRegionHandler;
import com.googlecode.mgwt.ui.client.layout.OrientationRegionHandler;
import com.ninuku.kinderfun.client.activities.phone.PhoneActivityMapper;
import com.ninuku.kinderfun.client.activities.phone.PhoneAnimationMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletMainActivityMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletMainAnimationMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletNavAnimationMapper;
import com.ninuku.kinderfun.client.css.AppBundle;
import com.ninuku.kinderfun.client.theme.CustomTheme;

/**
 * @author Daniel Kurka
 */
public class MgwtAppEntryPoint implements EntryPoint {

	static private final Logger	logger			= Logger.getLogger(MgwtAppEntryPoint.class.getName());
	private final ClientFactory	clientFactory	= GWT.create(ClientFactory.class);

	/**
	 * create a phone display with a single AnimatingActivityMapper
	 */
	private void createPhoneDisplay() {
		logger.info("createPhoneDisplay()");
	
		final AnimatableDisplay display = GWT.create(AnimatableDisplay.class);

		final PhoneActivityMapper appActivityMapper = this.clientFactory.getPhoneActivityMapper();

		final PhoneAnimationMapper appAnimationMapper = new PhoneAnimationMapper();

		final AnimatingActivityManager activityManager = new AnimatingActivityManager(appActivityMapper,
				appAnimationMapper, this.clientFactory.getEventBus());

		activityManager.setDisplay(display);

		RootPanel.get().add(display);

	}

	/**
	 * 
	 */
	private void createTabletDisplay() {
		logger.info("createTabletDisplay()");

		// ---- Nav container - shown landscape only -----------
		final SimplePanel navContainer = new SimplePanel();
		navContainer.getElement().setId("nav");
		navContainer.getElement().addClassName("landscapeonly");
		final AnimatableDisplay navDisplay = GWT.create(AnimatableDisplay.class);

		final TabletPortraitOverlay tabletPortraitOverlay = new TabletPortraitOverlay();

		new OrientationRegionHandler(navContainer, tabletPortraitOverlay, navDisplay);
		new MasterRegionHandler(this.clientFactory.getEventBus(), "nav", tabletPortraitOverlay);

		final ActivityMapper navActivityMapper = this.clientFactory.getTabletNavActivityMapper();

		final AnimationMapper navAnimationMapper = new TabletNavAnimationMapper();

		final AnimatingActivityManager navActivityManager = new AnimatingActivityManager(navActivityMapper,
				navAnimationMapper, this.clientFactory.getEventBus());

		navActivityManager.setDisplay(navDisplay);

		RootPanel.get().add(navContainer);

		// ---- main container ---------
		final SimplePanel mainContainer = new SimplePanel();
		mainContainer.getElement().setId("main");
		final AnimatableDisplay mainDisplay = GWT.create(AnimatableDisplay.class);

		final TabletMainActivityMapper tabletMainActivityMapper = this.clientFactory.getTableMainActivityMapper();

		final AnimationMapper tabletMainAnimationMapper = new TabletMainAnimationMapper();

		final AnimatingActivityManager mainActivityManager = new AnimatingActivityManager(tabletMainActivityMapper,
				tabletMainAnimationMapper, this.clientFactory.getEventBus());

		mainActivityManager.setDisplay(mainDisplay);
		mainContainer.setWidget(mainDisplay);

		RootPanel.get().add(mainContainer);

	}

	@Override
	public void onModuleLoad() {

		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(final Throwable e) {
				// TODO put in your own meaninful handler
				Window.alert("uncaught: " + e.getMessage());
				e.printStackTrace();

			}
		});

		new Timer() {
			@Override
			public void run() {
				start();

			}
		}.schedule(1);

	}

	private void start() {
		
		// override custom theme
		MGWTStyle.setTheme (new CustomTheme()); 
		// local styles come next
		clientFactory.getAppResources().styles().ensureInjected();

		// set viewport and other settings for mobile
		MGWT.applySettings(MGWTSettings.getAppSetting());

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		final AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);

		historyHandler.register(this.clientFactory.getPlaceController(), this.clientFactory.getEventBus(),
				new com.ninuku.kinderfun.client.activities.HomePlace());

		if ((MGWT.getOsDetection().isTablet())) {
			// very nasty workaround because GWT does not corretly support
			// @media
			StyleInjector.inject(AppBundle.INSTANCE.css().getText());

			createTabletDisplay();
		} else {
			createPhoneDisplay();

		}
		historyHandler.handleCurrentHistory();

	}

}
