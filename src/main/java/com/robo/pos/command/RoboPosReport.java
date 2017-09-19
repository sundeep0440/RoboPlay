/**
 * 
 */
package com.robo.pos.command;

import com.robo.pos.exception.CustomException;
import com.robo.pos.util.RoboConstants;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class RoboPosReport implements RoboPosCommand {
	
	/* (non-Javadoc)
	 * @see com.robo.pos.command.RoboPosCommand#executeCommand(com.robo.pos.service.RoboPosService)
	 */
	@Override
	public void executeCommand(RoboPosSetup roboPosService) throws CustomException {
		System.out.println(roboPosService.getRoboCordinates().getLattitude() + RoboConstants.COMA
				+ roboPosService.getRoboCordinates().getLongitude() + RoboConstants.COMA + roboPosService.getRoboFacing());
	}

}
