/**
 * 
 */
package com.robo.pos.command;

import com.robo.pos.exception.CustomException;
import com.robo.pos.exception.ExitException;
import com.robo.pos.util.RoboPosEnum;
import com.robo.pos.util.RoboPosLongLat;

/**
 * @author 388339
 *
 */
public interface RoboPosSetup {
	
	/**
	 * 
	 * @param inputCmdAry
	 * @param roboPos
	 * @throws ExitException
	 * @throws CustomException
	 */
	public void setPosition(String inputCmdAry, RoboPosLongLat roboPos) throws CustomException;
	
	
	/**
	 * 
	 * @return RoboPosLongLat
	 */
	public RoboPosLongLat getRoboCordinates();
	
	/**
	 * 
	 * @param roboCordinates
	 */
	public void setRoboCordinates(RoboPosLongLat roboCordinates);
	
	/**
	 * 
	 * @return RoboPosEnum
	 */
	public RoboPosEnum getRoboFacing();
	
	/**
	 * 
	 * @param roboFacing
	 */
	public void setRoboFacing(RoboPosEnum roboFacing);


}
