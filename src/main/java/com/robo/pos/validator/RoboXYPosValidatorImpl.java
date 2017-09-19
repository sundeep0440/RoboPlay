/**
 * 
 */
package com.robo.pos.validator;

import com.robo.pos.util.RoboConstants;
import com.robo.pos.util.RoboPosLongLat;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class RoboXYPosValidatorImpl implements ValidateCoordinates {

	/* (non-Javadoc)
	 * @see com.robo.pos.service.ValidateCoordinates#isOutOfRange(RoboPosLongLat roboCordinates)
	 */
	@Override
	public boolean isOutOfRange(RoboPosLongLat roboCordinates) {
		if (roboCordinates.getLattitude() > RoboConstants.LAT_MAX || roboCordinates.getLattitude() < 0
				|| roboCordinates.getLongitude() > RoboConstants.LON_MAX
				|| roboCordinates.getLongitude() < 0) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.robo.pos.service.ValidateCoordinates#resetCoordinates(RoboPosLongLat roboCordinates)
	 */
	@Override
	public RoboPosLongLat resetCoordinates(RoboPosLongLat roboCordinates) {
		if (roboCordinates.getLattitude() < 0 || roboCordinates.getLattitude() >= 4) {
			roboCordinates = new RoboPosLongLat(0, roboCordinates.getLongitude());
		}
		if (roboCordinates.getLongitude() < 0 || roboCordinates.getLongitude() >= 4) {
			//Builder DP
			roboCordinates = new RoboPosLongLat(roboCordinates.getLattitude(), 0);
		}
		return roboCordinates;
	}

}
