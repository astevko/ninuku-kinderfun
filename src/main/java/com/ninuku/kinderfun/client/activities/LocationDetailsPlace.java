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
import com.ninuku.kinderfun.client.model.Location;

/**
 * show main details for this place show back button to return
 * @see AppPlaceHistoryMapper
 * @see PhoneActivityMapper
 * @see TabletMainActivityMapper
 * @see TabletNavActivityMapper
 * @author copyright (c) 2014 Andrew Stevko
 */
public class LocationDetailsPlace extends Place {

	@Prefix("location")
	public static class Tokenizer implements PlaceTokenizer<LocationDetailsPlace> {

		@Override
		public LocationDetailsPlace getPlace(final String token) {
			return new LocationDetailsPlace(new Integer(token));
		}

		@Override
		public String getToken(final LocationDetailsPlace place) {
			return place.getLocationId().toString();
		}

	}

	/**
	 * id of the location to show details for.
	 */
	private final Integer	locationId;

	/**
	 * @param location
	 *            id of the location to show details for.
	 */
	public LocationDetailsPlace(final Integer locationId) {
		super();
		this.locationId = locationId;
	}

	/**
	 * @param location
	 *            - location to show details for.
	 */
	public LocationDetailsPlace(final Location location) {
		super();
		this.locationId = location.getId();
	}

	/**
	 * @return the locationId
	 */
	public Integer getLocationId() {
		return this.locationId;
	}
}
