/**
 * 
 */
package com.ninuku.kinderfun.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.inject.Inject;

/**
 * Spielplatz Finder LocationModel dummy singleton used to create a model until we hook up the backend
 * 
 * @author copyright (C) 2014 Andrew Stevko
 */
public class LocationModelMemoryImpl implements LocationModel {
	// every class has its logger
	private static final Logger				logger		= Logger.getLogger(LocationModelMemoryImpl.class.getName());

	private final List<Location>			locations	= new ArrayList<Location>();
	private final Map<Integer, Location>	map			= new HashMap<Integer, Location>();

	private Location						unknown;

	/**
	 * 
	 */
	@Inject
	public LocationModelMemoryImpl() {
		init();
	}

	/**
	 * look up location by id
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Location getLocationById(final Integer id) {
		return this.map.get(id);
	}

	/**
	 * @see com.ninuku.kinderfun.client.model.LocationModel#getLocationByIndex(int)
	 */
	@Override
	public Location getLocationByIndex(final int selectedIndex) {
		try {
			return this.locations.get(selectedIndex);
		} catch (final IndexOutOfBoundsException e) {
			if (this.unknown != null) {
				logger.severe("creating unknown location for selectedIndex=" + selectedIndex);
				this.unknown = new Location(0, "Unknown location", "Unknown location");
			}
			return this.unknown;
		}
	}

	/**
	 * @return
	 */
	@Override
	public List<Location> getLocations() {
		return this.locations;
	}

	/**
	 * initialize in memory list of locations
	 */
	private void init() {
		if (this.locations.isEmpty()) {
			logger.info("seeding locations");
			Location location = new Location(1, "Dreamland Playground",
					"Dreamland playgroud is really nice for preschool up to middleschool.");
			this.locations.add(location);
			this.map.put(location.getId(), location);

			location = new Location(
					2,
					"Adventure Playground",
					"It is a wonderfully unique outdoor facility where staff encourage children to play and build creatively.  Come climb on the many unusual kid designed and built forts, boats, and towers. Ride the zip line or hammer, saw, and paint. By providing these low risk activities ");
			this.locations.add(location);
			this.map.put(location.getId(), location);

			location = new Location(
					3,
					"Virginia-McGee Totland",
					"Tot and school-age play area featuring accessible ramp, spiral chute slide, play panel, theatre panel, sand play, vertical climber, coil climber, bridge, overhead ladder, school bus panels, abacus panel, play platform with roof");
			this.locations.add(location);
			this.map.put(location.getId(), location);
		}
	}
}
