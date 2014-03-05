package com.ninuku.kinderfun.client.activities.phone;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.ninuku.kinderfun.client.activities.HomePlace;
import com.ninuku.kinderfun.client.activities.LocationDetailsPlace;

/**
 * 
 */
public class PhoneAnimationMapper implements AnimationMapper {

	@Override
	public Animation getAnimation(final Place oldPlace, final Place newPlace) {
		if (newPlace instanceof HomePlace) {
			return Animation.SLIDE_REVERSE;
		}
		return Animation.SLIDE;
	}

}
