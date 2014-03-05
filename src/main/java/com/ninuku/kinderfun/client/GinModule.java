/**
 * 
 */
package com.ninuku.kinderfun.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.ninuku.kinderfun.client.activities.phone.HomeActivity;
import com.ninuku.kinderfun.client.activities.phone.HomeView;
import com.ninuku.kinderfun.client.activities.phone.HomeViewImpl;
import com.ninuku.kinderfun.client.activities.phone.LocationAddPhotoActivity;
import com.ninuku.kinderfun.client.activities.phone.LocationAddPhotoView;
import com.ninuku.kinderfun.client.activities.phone.LocationAddPhotoViewImpl;
import com.ninuku.kinderfun.client.activities.phone.LocationDetailsActivity;
import com.ninuku.kinderfun.client.activities.phone.LocationDetailsView;
import com.ninuku.kinderfun.client.activities.phone.LocationDetailsViewImpl;
import com.ninuku.kinderfun.client.activities.phone.PhoneActivityMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletMainActivityMapper;
import com.ninuku.kinderfun.client.activities.tablet.TabletNavActivityMapper;
import com.ninuku.kinderfun.client.fragments.LocationCell;
import com.ninuku.kinderfun.client.model.LocationModel;
import com.ninuku.kinderfun.client.model.LocationModelMemoryImpl;

/**
 * KinderFinder ClientFactoryModule
 * 
 * @author copyright (C) 2014 Andrew Stevko
 */
public class GinModule extends AbstractGinModule {
	/*
	 * (non-Javadoc)
	 * @see com.google.gwt.inject.client.AbstractGinModule#configure()
	 */
	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceController.class).toProvider(PlaceControllerProvider.class).in(Singleton.class);

		// activity mappers
		bind(PhoneActivityMapper.class).in(Singleton.class);
		bind(TabletMainActivityMapper.class).in(Singleton.class);
		bind(TabletNavActivityMapper.class).in(Singleton.class);

		// Model singleton
		bind(LocationModel.class).to(LocationModelMemoryImpl.class).in(Singleton.class);

		// location list view
		bind(LocationCell.class);
		
		// location details view
		bind(LocationDetailsView.class).to(LocationDetailsViewImpl.class);

		// location ADD view
		bind(LocationAddPhotoView.class).to(LocationAddPhotoViewImpl.class);
		bind(LocationAddPhotoActivity.class);
		
		// factory
		install(new GinFactoryModuleBuilder().build(LocationDetailsActivity.Factory.class));

		bind(HomeView.class).to(HomeViewImpl.class);
		bind(HomeActivity.class);
		
	}
}
