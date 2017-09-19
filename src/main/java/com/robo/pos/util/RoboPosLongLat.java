package com.robo.pos.util;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class RoboPosLongLat {
	private int lattitude;
	private int longitude;

	/**
	 * Default Constructor
	 */
	public RoboPosLongLat() {
	}

	/**
	 * 
	 * @param lattitude
	 * @param longitude
	 */
	public RoboPosLongLat(int lattitude, int longitude) {
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	/**
	 * 
	 * @param lattitude
	 * @param longitude
	 * @return
	 */
	public RoboPosLongLat changePoint(int lattitude, int longitude) {
		int newLatitude = this.lattitude + lattitude;
		int newLongitude = this.longitude + longitude;
		return new RoboPosLongLat(newLatitude, newLongitude);
	}

	/**
	 * @return the lattitude
	 */
	public int getLattitude() {
		return lattitude;
	}

	/**
	 * @param lattitude
	 *            the lattitude to set
	 */
	public void setLattitude(int lattitude) {
		this.lattitude = lattitude;
	}

	/**
	 * @return the longitude
	 */
	public int getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

}
