/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client.fragments;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.camera.PictureCallback;
import com.googlecode.gwtphonegap.client.camera.PictureOptions;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.ninuku.kinderfun.client.AppResources;

/**
 * @author copyright (c) 2014 Andrew Stevko
 *
 */
public class LocationAddPhoto extends Composite {
	/**
	 * Spielplatz Finder Template
	 * 
	 * @author copyright (C) 2014 Andrew Stevko uses list_entry, location_name, location_desc styles
	 */
	public interface Template extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<div class='{0}'><form><input type=\"file\" accept=\"image/*\" capture=\"camera\"></form></div>")
		SafeHtml content(String entryCss);
	}

	/**
	 * every class has its own logger
	 */
	static private final Logger	logger	= Logger.getLogger(LocationAddPhoto.class.getName());

	static private Template	TEMPLATE	= GWT.create(Template.class);

	private RoundPanel	main;
	private HTML	desktopCamera;

	private Image	display;

	/**
	 * 
	 */
	@Inject
	public LocationAddPhoto(final AppResources appResources, PhoneGap phoneGap) {
		logger.fine("new LocationAddPhoto");

		// layout
		main = new RoundPanel();

		if( MGWT.getOsDetection().isDesktop()) {		
			main.add( desktopCamera = new HTML());
			desktopCamera.setHTML(TEMPLATE.content(appResources.styles().camera()));
		} else {
			main.add( display = new Image());
			PictureOptions options = new PictureOptions(25);
			options.setDestinationType(PictureOptions.DESTINATION_TYPE_DATA_URL);
			options.setSourceType(PictureOptions.PICTURE_SOURCE_TYPE_CAMERA);

			phoneGap.getCamera().getPicture(options, new PictureCallback() {

				@Override
				public void onSuccess(String data) {
					display.setUrl("data:image/jpeg;base64," + data);
				}

				@Override
				public void onFailure(String message) {
					final String msg = "Camera failure: " + message;
					logger.severe(msg);
					Window.alert(msg);

				}
			});			
		}

		initWidget(main);

	}
}
