/**
 * 
 */
package com.ninuku.kinderfun.client.model;

import java.util.List;

/**
 * KinderFun Finder LocationModel
 * 
 * @author copyright (C) 2014 Andrew Stevko
 */
public interface LocationModel {
	// every class has its logger

	/**
	 * look up location by id
	 * 
	 * @param id
	 * @return
	 */
	public Location getLocationById(Integer id);

	/**
	 * @param selectedIndex
	 * @return
	 */
	public Location getLocationByIndex(int selectedIndex);

	/**
	 * @return all locations (in memory?)
	 */
	public List<Location> getLocations();

}