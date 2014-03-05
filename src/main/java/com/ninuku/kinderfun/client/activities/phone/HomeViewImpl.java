/**
 * 
 */
package com.ninuku.kinderfun.client.activities.phone;

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.ninuku.kinderfun.client.fragments.LocationCellList;
import com.ninuku.kinderfun.client.model.Location;

/**
 * Spielplatz Finder HomeViewImpl
 * 
 * @author copyright (C) 2014 Andrew Stevko
 */
public class HomeViewImpl implements HomeView {
	// every class has its logger
	static private Logger			logger	= Logger.getLogger(HomeViewImpl.class.getName());

	private final LayoutPanel		main;

	private final LocationCellList	locationList;

	private final HomeHeader			header;

	/**
	 * this view consists of a LayoutPanel with an application header and list of locations
	 */
	@Inject
	public HomeViewImpl(final HomeHeader header, final LocationCellList locationList) {
		this.header = header;
		this.locationList = locationList;
		logger.info("new HomeViewImpl");

		// initialize and configure view main panel
		this.main = new LayoutPanel();
		this.main.add(header);
		this.main.add(locationList);

	}

	/*
	 * (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	@Override
	public Widget asWidget() {
		return this.main;
	}

	/**
	 * activity uses this to handle a cell selection
	 * 
	 * @see com.ninuku.spielplatz.client.activities.HomeView#getList()
	 */
	@Override
	public HasCellSelectedHandler getList() {
		return this.locationList;
	}

	/**
	 * render the list of places by calling cellList.Render()
	 * 
	 * @see com.ninuku.spielplatz.client.activities.list.ListView#render(java.util.List)
	 */
	@Override
	public void render(final List<Location> locations) {
		// pass down render to list
		this.locationList.render(locations);

	}
}
