/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;

/**
 * @author copyright (c) 2014 Andrew Stevko
 *
 */
public interface AppResources extends ClientBundle {
	/**
	 * NOTE: make sure the app entry point calls ensureInjected on any CssResource styles.
	 * @return
	 */
	@NotStrict
	@Source("styles.css")
	Styles styles();
}