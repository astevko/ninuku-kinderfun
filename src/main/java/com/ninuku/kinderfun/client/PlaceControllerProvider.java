/**
 * 
 */
package com.ninuku.kinderfun.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;

/**
 * KinderFun Finder PlaceControllerProvider
 * 
 * @author copyright (C) 2014 Andrew Stevko 
 * http ://stackoverflow.com/questions/7528952/google-gin-a-provider-needs-a-dependency-nullpointerexception-bindingsprocessor
 */
public class PlaceControllerProvider implements Provider<PlaceController> {

	private final EventBus	eventBus;

	/**
     * 
     */
	@Inject
	public PlaceControllerProvider(final EventBus eventBus) {
		this.eventBus = eventBus;
	}

	/**
	 * 
	 * @see com.google.inject.Provider#get()
	 */
	@Override
	public PlaceController get() {
		return new PlaceController(this.eventBus);
	}
}
