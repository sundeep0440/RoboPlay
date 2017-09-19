/**
 * 
 */
package com.robo.pos.command;

import com.robo.pos.exception.CustomException;
import com.robo.pos.util.RoboConstants;
import com.robo.pos.util.RoboPosEnum;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class RoboPosRight implements RoboPosCommand {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.robo.pos.command.RoboPosDirection#moveTowards(RoboPosEnum
	 * roboFacing)
	 */
	@Override
	public void executeCommand(RoboPosSetup roboPosService) throws CustomException {
		
		switch (roboPosService.getRoboFacing()) {
		case NORTH:
			roboPosService.setRoboFacing(RoboPosEnum.EAST);
			break;
		case WEST:
			roboPosService.setRoboFacing(RoboPosEnum.NORTH);
			break;
		case SOUTH:
			roboPosService.setRoboFacing(RoboPosEnum.WEST);
			break;
		case EAST:
			roboPosService.setRoboFacing(RoboPosEnum.SOUTH);
			break;
		default:
			new CustomException(RoboConstants.INVLD_TURN);
		}
	}

}
