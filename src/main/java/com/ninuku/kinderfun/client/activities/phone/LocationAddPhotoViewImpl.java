/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client.activities.phone;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.ninuku.kinderfun.client.GinModule;
import com.ninuku.kinderfun.client.fragments.LocationAddPhoto;
import com.ninuku.kinderfun.client.model.Location;

/**
 * Add a photo 
 * @see GinModule for Impl registration 
 * @author copyright (c) 2014 Andrew Stevko
 */
public class LocationAddPhotoViewImpl implements LocationAddPhotoView {

	/**
	 * every class has its own logger
	 */
	static private final Logger	logger	= Logger.getLogger(LocationAddPhotoViewImpl.class.getName());
	/**
	 * main body
	 */
	private final LayoutPanel	main;

	/**
	 * 
	 */
	@Inject
	public LocationAddPhotoViewImpl(final LocationAddPhotoHeader header, final LocationAddPhoto body) {
		logger.info("new LocationAddPhotoViewImpl()");
		this.main = new LayoutPanel();
		this.main.add(header);
		this.main.add(body);
	}

	/**
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	@Override
	public Widget asWidget() {
		return this.main;
	}

	/**
	 * @see com.ninuku.kinderfun.client.activities.phone.LocationAddPhotoView#render(com.ninuku.kinderfun.client.model.Location)
	 */
	@Override
	public void render(final Location location) {
		// TODO: header.render(location);
	}
}
