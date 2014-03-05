/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client.activities.phone;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.ninuku.kinderfun.client.GinModule;
import com.ninuku.kinderfun.client.fragments.LocationDetailsTile;
import com.ninuku.kinderfun.client.model.Location;

/**
 * @author copyright (c) 2014 Andrew Stevko
 * @see GinModule for wiring details
 */
public class LocationDetailsViewImpl implements LocationDetailsView {

	/**
	 * every class has its own logger
	 */
	static private final Logger			logger	= Logger.getLogger(LocationDetailsViewImpl.class.getName());

	private final LayoutPanel			main;

	private final LocationDetailsTile	detailsTile;

	private final LocationDetailsHeader			header;

	/**
	 * @param locationDetailsTile
	 * @param header
	 */
	@Inject
	public LocationDetailsViewImpl(final LocationDetailsTile locationDetailsTile, final LocationDetailsHeader header) {
		super();
		this.detailsTile = locationDetailsTile;
		this.header = header;
		this.main = new LayoutPanel();

		main.add(header);
		main.add(locationDetailsTile);
	}

	/**
	 * @see com.ninuku.kinderfun.client.activities.phone.LocationDetailsView#render(com.ninuku.kinderfun.client.model.Location)
	 */
	@Override
	public void render(final Location location) {
		detailsTile.render(location);
	}

	/*
	 * (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	@Override
	public Widget asWidget() {
		return this.main;
	}
}
