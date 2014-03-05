/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client;

import com.google.gwt.resources.client.CssResource;

/**
 * application styles
 * @author copyright (c) 2014 Andrew Stevko
 *
 */
public interface Styles extends CssResource {
	/**
	 * for base
	 * background white;
	 * @return 
	 */
	String mainBase();
	/**
	 * for tiles
	 * background grey;
	 * @return
	 */
	String tileBase();
	/**
	 * name of location
	 * @return
	 */
	String locationName();
	/**
	 * description of location
	 * @return
	 */
	String locationDesc();
	/**
	 * @return
	 */
	String locationListEntry();
	
	/**
	 * @return header button css
	 */
	String headerButton();
	/**
	 * @return add photo body
	 */
	String camera();
}
