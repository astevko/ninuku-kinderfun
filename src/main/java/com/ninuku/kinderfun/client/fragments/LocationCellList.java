/**
 * 
 */
package com.ninuku.kinderfun.client.fragments;

import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.theme.base.ListCss;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.ninuku.kinderfun.client.model.Location;

/**
 * @author copyright (c) 2014 Andrew Stevko
 */
public class LocationCellList extends CellList<Location> implements HasCellSelectedHandler {

	/**
	 */
	@Inject
	public LocationCellList(LocationCell cell) {
		super( cell );
		setRound(true);
	}

	/**
	 * @param css
	 */
	public LocationCellList(LocationCell cell, final ListCss css) {
		super( cell, css);
		setRound(true);
	}

}
