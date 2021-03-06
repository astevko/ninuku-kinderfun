package com.ninuku.kinderfun.client.activities;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.ninuku.kinderfun.client.activities.phone.PhoneActivityMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletMainActivityMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletNavActivityMapper;

/**
 * URL used to get to the home of the application.
 * 
 * @author copyright (c) 2014 Andrew Stevko Registered with ActivityMappers to trigger Activities to start
 * @see AppPlaceHistoryMapper
 * @see PhoneActivityMapper
 * @see TabletMainActivityMapper
 * @see TabletNavActivityMapper
 */
public class HomePlace extends Place {

	@Prefix("home")
	public static class Tokenizer implements PlaceTokenizer<HomePlace> {

		@Override
		public HomePlace getPlace(final String token) {
			return new HomePlace();
		}

		@Override
		public String getToken(final HomePlace place) {
			return "";
		}

	}

}
