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

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.ninuku.kinderfun.client.activities.phone.PhoneActivityMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletMainActivityMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletNavActivityMapper;

/**
 * KinderFinder Gin Injector
 * 
 * @author copyright (c) 2014 Andrew Stevko
 */
@GinModules(GinModule.class)
public interface ClientFactory extends Ginjector {
	/**
	 * access to styles.css
	 * @return client bundle cssresources
	 */
	public AppResources getAppResources();

	public EventBus getEventBus();

	/**
	 * @return phone activity mapper
	 */
	public PhoneActivityMapper getPhoneActivityMapper();

	/**
	 * @return clientFactory.getPlaceController().goto( new  HomePlace() );
	 */
	public PlaceController getPlaceController();

	/**
	 * @return tablet main activity mapper
	 */
	public TabletMainActivityMapper getTableMainActivityMapper();

	/**
	 * @return tablet navigation activity mapper
	 */
	public TabletNavActivityMapper getTabletNavActivityMapper();
}
