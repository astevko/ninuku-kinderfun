/**
 * 
 */
package com.ninuku.kinderfun.client.activities.phone;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.ninuku.kinderfun.client.ClientFactory;
import com.ninuku.kinderfun.client.activities.HomePlace;
import com.ninuku.kinderfun.client.model.Location;

/**
 * Location Header widget
 * 
 * @author copyright (c) 2014 Andrew Stevko
 */
public class LocationDetailsHeader extends HeaderPanel {

	/**
	 * TODO: move to constants
	 */
	private static final String	BACK_BUTTON_TEXT	= "Back";

	/**
	 * TODO: move to constants
	 */
	private static final String	PLAYGROUND_TITLE	= "Playground";

	/**
	 * every class has its own logger
	 */
	static private final Logger			logger	= Logger.getLogger(LocationDetailsHeader.class.getName());

	private final HeaderButton	backButton;

	/**
	 * Because this class has a default constructor, it can be used as a binder template. In other words, it can be used
	 * in other *.ui.xml files as follows: <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 * xmlns:g="urn:import:**user's package**"> <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that
	 * depending on the widget that is used, it may be necessary to implement HasHTML instead of HasText.
	 */
	@Inject
	public LocationDetailsHeader(final ClientFactory clientFactory) {
		// back button
		this.backButton = new HeaderButton();		
		backButton.setBackButton(true);
		backButton.setText(BACK_BUTTON_TEXT);
		// Place Name
		final HTML placeName = new HTML(PLAYGROUND_TITLE);
		
		setLeftWidget(backButton);
		setCenterWidget(placeName);
		
		backButton.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				logger.info("User clicked back from LocationHeader");
				clientFactory.getPlaceController().goTo(new HomePlace());
			}
		});
	}

	void render(Location location) {
		
	}
}
