/**
 * 
 */
package com.ninuku.kinderfun.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Spielplatz Finder User
 * 
 * @author copyright (C) 2014 Andrew Stevko
 */
public class User {
	// every class has its logger
	static private Logger			logger			= Logger.getLogger(User.class.getName());

	private String					emailAddress;

	private final List<Location>	favoritePlaces	= new ArrayList<Location>();

	private Integer					id;

	private String					name;

	/**
	 * 
	 */
	public User(final Integer id, final String name, final String emailAddress) {
		logger.info("new User #" + id);
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
	}

	/**
	 * @param newFav
	 */
	public void addFavorite(final Location newFav) {
		this.favoritePlaces.add(newFav);
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}

	/**
	 * @return the favoritePlaces
	 */
	public List<Location> getFavoritePlaces() {
		return this.favoritePlaces;
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
	 * @param unFav
	 */
	public void removeFavorite(final Location unFav) {
		this.favoritePlaces.remove(unFav);
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
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
}
