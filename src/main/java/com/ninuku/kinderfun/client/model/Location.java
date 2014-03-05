/** 	
 * 
 */
package com.ninuku.kinderfun.client.model;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Spielplatz Finder Simple Location
 * 
 * @author copyright (C) 2014 Andrew Stevko
 */
public class Location {
	// every class has its logger
	static final private Logger	logger	= Logger.getLogger(Location.class.getName());

	private Date				dateAdded;

	private Date				dateUpdated;

	private String				description;

	private Integer				id;

	private String				name;

	/**
	 * @param name
	 *            the name of the location
	 * @param description
	 *            a description of the location
	 */
	public Location(final Integer id, final String name, final String description) {
		logger.info("new Location #" + id);
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the dateAdded
	 */
	public Date getDateAdded() {
		return this.dateAdded;
	}

	/**
	 * @return the dateUpdated
	 */
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param dateAdded
	 *            the dateAdded to set
	 */
	public void setDateAdded(final Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * @param dateUpdated
	 *            the dateUpdated to set
	 */
	public void setDateUpdated(final Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	// TODO add location
	// TODO add photo(s)
	// TODO add address
	// TODO add comments
	// TODO add map
	// TODO add amenities
}
