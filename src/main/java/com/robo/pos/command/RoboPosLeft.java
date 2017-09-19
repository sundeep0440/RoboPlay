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
public class RoboPosLeft implements RoboPosCommand {
	
	/* (non-Javadoc)
	 * @see com.robo.pos.command.RoboPosCommand#executeCommand(com.robo.pos.service.RoboPosService)
	 */
	@Override
	public void executeCommand(RoboPosSetup roboPosService) throws CustomException {
		switch (roboPosService.getRoboFacing()) {
		case NORTH:
			roboPosService.setRoboFacing(RoboPosEnum.WEST);
			break;
		case WEST:
			roboPosService.setRoboFacing(RoboPosEnum.SOUTH);
			break;
		case SOUTH:
			roboPosService.setRoboFacing(RoboPosEnum.EAST);
			break;
		case EAST:
			roboPosService.setRoboFacing(RoboPosEnum.NORTH);
			break;
		default:
			new CustomException(RoboConstants.INVLD_TURN);
		}
	}

}
