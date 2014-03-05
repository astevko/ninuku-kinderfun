/**
 * 
 */
package com.ninuku.kinderfun.client.fragments;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;
import com.ninuku.kinderfun.client.ClientFactory;
import com.ninuku.kinderfun.client.Styles;
import com.ninuku.kinderfun.client.model.Location;

/**
 * Spielplatz Finder LocationCell
 * 
 * @author copyright (C) 2014 Andrew Stevko
 */
public class LocationCell implements Cell<Location> {
	/**
	 * Spielplatz Finder Template
	 * 
	 * @author copyright (C) 2014 Andrew Stevko uses list_entry, location_name, location_desc styles
	 */
	public interface Template extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<div class='{0}'><span class='{1}'>{2}</span>&nbsp;<span class='{3}'>{4}</span></div>")
		SafeHtml content(String listEntryCss, String nameCss, String name, String descCss, String description);
	}

	// every class has its logger
	static private Logger	logger		= Logger.getLogger(LocationCell.class.getName());

	static private Template	TEMPLATE	= GWT.create(Template.class);

	private ClientFactory	clientFactory;
	
	/**
	 * 
	 */
	@Inject
	public LocationCell(final ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.googlecode.mgwt.ui.client.widget.celllist.Cell#canBeSelected(java .lang.Object)
	 */
	@Override
	public boolean canBeSelected(final Location model) {
		return true;
	}

	/**
	 * @see com.googlecode.mgwt.ui.client.widget.celllist.Cell#render(com.google.* gwt.safehtml.shared.SafeHtmlBuilder,
	 *      java.lang.Object)
	 * @see Styles
	 */
	@Override
	public void render(final SafeHtmlBuilder safeHtmlBuilder, final Location model) {
		logger.info("rendering cell");
		final Styles styles = clientFactory.getAppResources().styles();
		safeHtmlBuilder.append(TEMPLATE.content(styles.locationListEntry(), styles.locationName(), model.getName(), styles.locationDesc(), model.getDescription()));
	}
}
