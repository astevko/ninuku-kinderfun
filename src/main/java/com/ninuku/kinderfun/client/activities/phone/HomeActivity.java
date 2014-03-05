/**
 * 
 */
package com.ninuku.kinderfun.client.activities.phone;

import java.util.logging.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.ninuku.kinderfun.client.ClientFactory;
import com.ninuku.kinderfun.client.activities.LocationDetailsPlace;
import com.ninuku.kinderfun.client.model.Location;
import com.ninuku.kinderfun.client.model.LocationModel;

/**
 * KinderFun Finder HomeActitvity Phone
 * 
 * @author copyright (C) 2014 Andrew Stevko
 */
public class HomeActivity extends MGWTAbstractActivity {
	// every class has its logger
	static private Logger		logger	= Logger.getLogger(HomeActivity.class.getName());

	private final ClientFactory	clientFactory;

	/**
	 * view associated with this activity
	 */
	private final HomeView		view;

	/**
	 * location model
	 */
	private final LocationModel	locationModel;

	/**
	 * @param clientFactory
	 * @param view
	 * @param locationModel
	 */
	@Inject
	public HomeActivity(final ClientFactory clientFactory, final HomeView view, final LocationModel locationModel) {
		this.clientFactory = clientFactory;
		this.view = view;
		this.locationModel = locationModel;
		logger.info("new HomeActivity()");
	}

	/**
	 * register event handlers, get a list of places. render it into a celllist
	 * 
	 * @see com.googlecode.mgwt.mvp.client.MGWTAbstractActivity#start(com.google. gwt.user.client.ui.AcceptsOneWidget,
	 *      com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
		// create and register event handlers
		// TODO - abstract to LocationSelectedHandler class
		addHandlerRegistration(this.view.getList().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(final CellSelectedEvent event) {
				final int selectedIndex = event.getIndex();

				logger.fine("user selected index " + selectedIndex);
				final Location selectedLocation = HomeActivity.this.locationModel.getLocationByIndex(selectedIndex);

				logger.info("user selected location named " + selectedLocation.getName());
				HomeActivity.this.clientFactory.getPlaceController().goTo(new LocationDetailsPlace(selectedLocation));
			}

		}));
		panel.setWidget(this.view);
		this.view.render(this.locationModel.getLocations());
	}
}
