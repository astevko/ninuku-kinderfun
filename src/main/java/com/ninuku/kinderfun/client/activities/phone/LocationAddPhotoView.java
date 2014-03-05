/**
 * @author copyright (c) 2014 Andrew Stevko
 */
package com.ninuku.kinderfun.client.activities.phone;

import com.google.gwt.user.client.ui.IsWidget;
import com.ninuku.kinderfun.client.model.Location;

/**
 * @author copyright (c) 2014 Andrew Stevko
 *
 */
public interface LocationAddPhotoView extends IsWidget {

	/**
	 * @param location
	 */
	void render(Location location);

}