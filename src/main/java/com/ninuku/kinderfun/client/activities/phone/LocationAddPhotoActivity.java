/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client.activities.phone;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.ninuku.kinderfun.client.ClientFactory;
import com.ninuku.kinderfun.client.model.LocationModel;

/**
 * @author copyright (c) 2014 Andrew Stevko
 *
 */
public class LocationAddPhotoActivity extends MGWTAbstractActivity {

	/**
	 * every class has its own logger
	 */
	static private final Logger	logger	= Logger.getLogger(LocationAddPhotoActivity.class.getName());
	private ClientFactory	clientFactory;
	private LocationAddPhotoView	view;
	private LocationModel	locationModel;

	
	/**
	 * 
	 */
	@Inject
	public LocationAddPhotoActivity(ClientFactory clientFactory, 
			final LocationAddPhotoView view,
			final LocationModel locationModel ) {
		this.clientFactory = clientFactory;
		this.view = view;
		this.locationModel = locationModel;
	}
	
	/**
	 * @see com.googlecode.mgwt.mvp.client.MGWTAbstractActivity#start(com.google.gwt.user.client.ui.AcceptsOneWidget, com.google.web.bindery.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view);
	}
}
