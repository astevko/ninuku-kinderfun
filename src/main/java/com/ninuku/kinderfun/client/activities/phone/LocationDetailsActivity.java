/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client.activities.phone;

import java.util.logging.Logger;

import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.ninuku.kinderfun.client.ClientFactory;
import com.ninuku.kinderfun.client.model.Location;
import com.ninuku.kinderfun.client.model.LocationModel;

/**
 * @author copyright (c) 2014 Andrew Stevko
 */
public class LocationDetailsActivity extends MGWTAbstractActivity {

	/**
	 * Guice/Gin Factory Module Builder {@link}
	 * http://google-guice.googlecode.com/svn/trunk/javadoc/com/google/inject/assistedinject/FactoryModuleBuilder.html
	 * 
	 * @see FactoryModuleBuilder
	 * @see GinFactoryModuleBuilder
	 */
	public interface Factory {
		LocationDetailsActivity create(final Integer locationId);
	}

	/**
	 * every class has its own logger
	 */
	static private final Logger			logger	= Logger.getLogger(LocationDetailsActivity.class.getName());

	@SuppressWarnings("unused")
	private final ClientFactory			clientFactory;

	/**
	 * view associated with this activity
	 */
	private final LocationDetailsView	view;

	/**
	 * location model
	 */
	private final LocationModel			locationModel;

	/**
	 * id of location
	 */
	private final Integer				locationId;

	private Location					location;

	/**
	 * @param clientFactory
	 * @param view
	 * @param locationModel
	 * @param locationId
	 */
	@Inject
	public LocationDetailsActivity(final ClientFactory clientFactory, final LocationDetailsView view,
			final LocationModel locationModel, @Assisted final Integer locationId) {
		super();
		this.clientFactory = clientFactory;
		this.view = view;
		this.locationModel = locationModel;
		this.locationId = locationId;
		logger.info("new LocationDetailsActivity()");
	}

	/**
	 * @see com.googlecode.mgwt.mvp.client.MGWTAbstractActivity#start(com.google.gwt.user.client.ui.AcceptsOneWidget,
	 *      com.google.web.bindery.event.shared.EventBus)
	 */
	@Override
	public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
		// TODO Auto-generated method stub
		this.location = this.locationModel.getLocationById(this.locationId);
		panel.setWidget(view);
		this.view.render(this.location);
	}

}
