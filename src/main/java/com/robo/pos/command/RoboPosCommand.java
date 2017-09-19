/**
 * 
 */
package com.robo.pos.command;

import com.robo.pos.exception.CustomException;

/**
 * @author Sundeep Bellumkenda
 *
 */
public interface RoboPosCommand {
	
	/**
	 * 
	 * @param roboPosService
	 * @throws CustomException
	 */
	public void executeCommand(RoboPosSetup roboPosService) throws CustomException;

}
