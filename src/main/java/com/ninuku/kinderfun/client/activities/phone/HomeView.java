/**
 * 
 */
package com.ninuku.kinderfun.client.activities.phone;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.ninuku.kinderfun.client.model.Location;

/**
 * KinderFun Finder HomeView displays a list of Place
 * 
 * @author copyright (C) 2014 Andrew Stevko
 */
public interface HomeView extends IsWidget {

	/**
	 * useful for registering a handler for when a Location Cell is selected.
	 * 
	 * @return
	 */
	public HasCellSelectedHandler getList();

	public void render(List<Location> locations);
}
