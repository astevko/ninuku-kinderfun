package com.ninuku.kinderfun.client.activities.tablet;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.ninuku.kinderfun.client.ClientFactory;

public class TabletNavActivityMapper implements ActivityMapper {

	private final ClientFactory	clientFactory;

	@Inject
	public TabletNavActivityMapper(final ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(final Place place) {
		return null;
	}
}
