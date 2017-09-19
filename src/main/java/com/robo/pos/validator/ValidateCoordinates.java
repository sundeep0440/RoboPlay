/**
 * 
 */
package com.robo.pos.validator;

import com.robo.pos.util.RoboPosLongLat;

/**
 * @author Sundeep Bellumkenda
 *
 */
public interface ValidateCoordinates {
	
	/**
	 * 
	 * @param roboCordinates
	 * @return
	 */
	public boolean isOutOfRange(RoboPosLongLat roboCordinates);
	
	/**
	 * 
	 * @param roboCordinates
	 * @return
	 */
	public RoboPosLongLat resetCoordinates(RoboPosLongLat roboCordinates);

}
