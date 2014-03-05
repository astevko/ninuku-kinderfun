/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client.fragments;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
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
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.FormListEntry;
import com.googlecode.mgwt.ui.client.widget.MTextArea;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;
import com.ninuku.kinderfun.client.AppResources;

/**
 * @author copyright (c) 2014 Andrew Stevko
 *
 */
public class LocationAddPhoto extends Composite {
	/**
	 * TODO:localize
	 */
	private static final String	NEW_DESCRIPTION	= "Description";

	/**
	 * TODO:localize
	 */
	private static final String	NEW_NAME	= "Name";

	/**
	 * TODO:localize
	 */
	private static final String	SUBMIT_A_NEW_PLAYGROUND_BUTTON	= "Submit a new playground";

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

	private WidgetList	main;
	
	private HTML	desktopCamera;

	private Image	display;

	private Button	submitButton;

	private MTextBox	name;

	private MTextArea	desc;

	/**
	 * 
	 */
	@Inject
	public LocationAddPhoto(final AppResources appResources, PhoneGap phoneGap) {
		logger.fine("new LocationAddPhoto");

		// layout
		main = new WidgetList();
		main.setRound(true);

	
		// image capture
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
					logger.info("showing image");
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
		// name capture
		main.add(new FormListEntry(NEW_NAME, name = new MTextBox()));
		main.add(new FormListEntry(NEW_DESCRIPTION, desc = new MTextArea()));
		main.add( submitButton = new Button(SUBMIT_A_NEW_PLAYGROUND_BUTTON));
		submitButton.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				// TODO: validate input non-empty
				// TODO: communicate intent to upload with Activity
				Window.alert("TODO: adding playground " + name.getValue());
			}
		});

		initWidget(main);

	}
}
