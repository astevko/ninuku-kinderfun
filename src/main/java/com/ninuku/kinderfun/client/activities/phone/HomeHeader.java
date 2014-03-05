/**
 * 
 */
package com.ninuku.kinderfun.client.activities.phone;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.inject.Inject;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.ninuku.kinderfun.client.ClientFactory;
import com.ninuku.kinderfun.client.Styles;
import com.ninuku.kinderfun.client.activities.LocationAddPhotoPlace;

/**
 * Phone application header widget
 * 
 * @author copyright (c) 2014 Andrew Stevko
 */
public class HomeHeader extends HeaderPanel {
	// every class has its logger
	static private final Logger		logger	= Logger.getLogger(HomeHeader.class.getName());

	/**
	 * TODO: convert to ICON
	 *	TODO: move to localization 
	 */
	private static final String	SET_LOCATION_BUTTON	= "Location";
	/**
	 *	TODO: move to localization 
	 */
	private static final String	HEADER_CENTER_TEXT	= "KinderFunFinder";
	/**
	 * TODO: convert to ICON
	 *	TODO: move to localization 
	 */
	private static final String	MENU_BUTTON_TEXT	= "Menu";
	/**
	 * TODO: convert to ICON
	 *	TODO: move to localization 
	 */
	private static final String	ADD_BUTTON_TEXT	= "Add";

	/**
	 * TODO: opens up a menu
	 * 
	 */
	private final HeaderButton	menuButton;
	
	/**
	 * TODO: goto location add page
	 */
	private final HeaderButton	addLocationButton;
	
	/**
	 * TODO: open up location search
	 */
	private final HeaderButton	setLocationButton;

	/**
	 * Because this class has a default constructor, it can be used as a binder template. In other words, it can be used
	 * in other *.ui.xml files as follows: <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 * xmlns:g="urn:import:**user's package**"> <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that
	 * depending on the widget that is used, it may be necessary to implement HasHTML instead of HasText.
	 */
	@Inject
	public HomeHeader(final ClientFactory clientFactory) {
		final Styles styles = clientFactory.getAppResources().styles();
		// left
		this.menuButton = new HeaderButton();
		this.menuButton.setText(MENU_BUTTON_TEXT);
		this.menuButton.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				logger.info("User tappend MENU button");				
			}
		});
		// right 1
		this.addLocationButton = new HeaderButton();
		this.addLocationButton.setText(ADD_BUTTON_TEXT);
		this.addLocationButton.addStyleName(styles.headerButton());
		this.addLocationButton.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				logger.info( "user tapped ADD LOCATION button");
				clientFactory.getPlaceController().goTo(new LocationAddPhotoPlace());
			}
		});
		// right 2
		this.setLocationButton = new HeaderButton();
		this.setLocationButton.setText(SET_LOCATION_BUTTON);
		this.addLocationButton.addStyleName(styles.headerButton());
		this.setLocationButton.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				logger.info( "user tapped SET LOCATION button");
			}
		});
		
		setLeftWidget(this.menuButton);
		Panel buttons = new HorizontalPanel(); // TODO: better than HorizontalPanel? It sucks
		buttons.add(setLocationButton);
		buttons.add(addLocationButton);		
		setRightWidget(buttons);
		setCenter(HEADER_CENTER_TEXT);
 	}

}
