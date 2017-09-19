/**
 * 
 */
package com.robo.pos.command;

import com.robo.pos.exception.CustomException;
import com.robo.pos.util.RoboConstants;
import com.robo.pos.util.RoboPosLongLat;
import com.robo.pos.validator.RoboXYPosValidatorImpl;
import com.robo.pos.validator.ValidateCoordinates;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class RoboPosMove implements RoboPosCommand{
	
	@Override
	public void executeCommand(RoboPosSetup roboPosService) throws CustomException {
		ValidateCoordinates posValidator = new RoboXYPosValidatorImpl();
		roboPosService.setRoboCordinates(getNextPosition(roboPosService));
		if (posValidator.isOutOfRange(roboPosService.getRoboCordinates())) {
			if (roboPosService.getRoboCordinates().getLattitude() < 0) {
				roboPosService.setRoboCordinates(new RoboPosLongLat(0, roboPosService.getRoboCordinates().getLongitude()));
				throw new CustomException(RoboConstants.MIN_LAT);
			}
			if (roboPosService.getRoboCordinates().getLongitude() < 0) {
				roboPosService.setRoboCordinates(new RoboPosLongLat(roboPosService.getRoboCordinates().getLattitude(), 0));
				throw new CustomException(RoboConstants.MIN_LONG);
			}
			if (roboPosService.getRoboCordinates().getLattitude() >= 4) {
				roboPosService.setRoboCordinates(new RoboPosLongLat(4, roboPosService.getRoboCordinates().getLongitude()));
				throw new CustomException(RoboConstants.MAX_LAT);
			}
			if (roboPosService.getRoboCordinates().getLongitude() >= 4) {
				roboPosService.setRoboCordinates(new RoboPosLongLat(roboPosService.getRoboCordinates().getLattitude(), 4));
				throw new CustomException(RoboConstants.MAX_LONG);
			}
		}
		
	}
	
	/**
	 * 
	 * @param roboFacing
	 * @return RoboPosLongLat
	 */
	private RoboPosLongLat getNextPosition(RoboPosSetup roboPosService) {
		switch (roboPosService.getRoboFacing()) {
		case NORTH:
			roboPosService.setRoboCordinates(roboPosService.getRoboCordinates().changePoint(0, 1));
			break;
		case EAST:
			roboPosService.setRoboCordinates(roboPosService.getRoboCordinates().changePoint(1, 0));
			break;
		case SOUTH:
			roboPosService.setRoboCordinates(roboPosService.getRoboCordinates().changePoint(0, -1));
			break;
		case WEST:
			roboPosService.setRoboCordinates(roboPosService.getRoboCordinates().changePoint(-1, 0));
			break;
		}
		return roboPosService.getRoboCordinates();
	}

}
