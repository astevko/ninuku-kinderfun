package com.ninuku.kinderfun.client.activities.phone;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.ninuku.kinderfun.client.activities.LocationAddPhotoPlace;
import com.ninuku.kinderfun.client.activities.LocationDetailsPlace;

/**
 * places
 */
public class PhoneActivityMapper implements ActivityMapper {

	private final Provider<HomeActivity>				homeActivityProvider;
	private final LocationDetailsActivity.Factory		locationDetailsActivityFactory;
	private final Provider<LocationAddPhotoActivity>	locationAddPhotoProvider;

	@Inject
	public PhoneActivityMapper(final Provider<HomeActivity> homeActivityProvider,
			final LocationDetailsActivity.Factory locationDetailsActivityFactory,
			final Provider<LocationAddPhotoActivity> locationAddPhotoProvider) {
		this.homeActivityProvider = homeActivityProvider;
		this.locationDetailsActivityFactory = locationDetailsActivityFactory;
		this.locationAddPhotoProvider = locationAddPhotoProvider;
	}

	@Override
	public Activity getActivity(final Place place) {
		if (place instanceof LocationDetailsPlace) {
			return this.locationDetailsActivityFactory.create(((LocationDetailsPlace) place).getLocationId());
		} else if (place instanceof LocationAddPhotoPlace) {
			return this.locationAddPhotoProvider.get();
		}
		return this.homeActivityProvider.get();
	}
}
