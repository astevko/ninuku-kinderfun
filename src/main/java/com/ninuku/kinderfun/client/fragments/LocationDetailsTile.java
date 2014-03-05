/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client.fragments;

import java.util.logging.Logger;

import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.ninuku.kinderfun.client.AppResources;
import com.ninuku.kinderfun.client.model.Location;

/**
 * nice round panel with location details header info
 * @author copyright (c) 2014 Andrew Stevko
 */
public class LocationDetailsTile extends Composite {

	
	/**
	 * every class has its own logger
	 */
	static private final Logger	logger	= Logger.getLogger(LocationDetailsTile.class.getName());
	/**
	 * 
	 */
	private final RoundPanel	main;
	/**
	 * 
	 */
	private final HTML	name;
	/**
	 * 
	 */
	private final HTML	desc;
	/**
	 * 
	 */
//	private final HTML	id;
	/**
	 * 
	 */
//	private final MDateBox	lastUpdate;

	/**
	 * 
	 */
	@Inject
	public LocationDetailsTile(AppResources appResources) {
		logger.fine( "new LocationDetailsTile()");
		
		// layout
		main = new RoundPanel();
		// name
		main.add( name = new HTML() );
		name.addStyleName(appResources.styles().locationName());
		// description
		main.add( desc = new HTML() );
		desc.addStyleName(appResources.styles().locationDesc());
		
		initWidget(main);
	}
	
	public void render(Location location) {
		logger.fine( "LocationDetailsHeader  render " + location.getName());
		name.setHTML(SafeHtmlUtils.htmlEscape(location.getName()));
		desc.setHTML(SafeHtmlUtils.htmlEscape(location.getDescription()));
	}
}
