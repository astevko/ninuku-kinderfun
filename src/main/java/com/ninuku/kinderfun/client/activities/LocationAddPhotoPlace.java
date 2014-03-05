/**
 * 
 */
package com.ninuku.kinderfun.client.activities;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.ninuku.kinderfun.client.activities.phone.PhoneActivityMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletMainActivityMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletNavActivityMapper;

/**
 * add location using photo to database 
 * @see AppPlaceHistoryMapper
 * @see PhoneActivityMapper
 * @see TabletMainActivityMapper
 * @see TabletNavActivityMapper
 * @author copyright (c) 2014 Andrew Stevko
 */
public class LocationAddPhotoPlace extends Place {

	@Prefix("addphoto")
	public static class Tokenizer implements PlaceTokenizer<LocationAddPhotoPlace> {

		@Override
		public LocationAddPhotoPlace getPlace(final String token) {
			return new LocationAddPhotoPlace();
		}

		@Override
		public String getToken(final LocationAddPhotoPlace place) {
			return "";
		}

	}
}
