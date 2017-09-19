package com.robo.pos.service;

import org.apache.commons.lang3.EnumUtils;

import com.robo.pos.command.RoboPosCommand;
import com.robo.pos.command.RoboPosLeft;
import com.robo.pos.command.RoboPosMove;
import com.robo.pos.command.RoboPosReport;
import com.robo.pos.command.RoboPosRight;
import com.robo.pos.command.RoboPosSetup;
import com.robo.pos.exception.CustomException;
import com.robo.pos.exception.ExitException;
import com.robo.pos.util.RoboConstants;
import com.robo.pos.util.RoboPosCmdEnum;
import com.robo.pos.util.RoboPosEnum;
import com.robo.pos.util.RoboPosLongLat;

/**
 * 
 * @author Sundeep Bellumkenda
 *
 */
public class RoboPosServiceLookup {
	
	/**
	 * 
	 * @param inputCmdAry
	 * @param roboCmdEnum
	 * @param roboServFactory
	 * @return
	 * @throws CustomException
	 * @throws ExitException
	 */
	public boolean exeRoboPosCmd(RoboPosCmdEnum roboCmdEnum, RoboPosSetup roboService) throws CustomException {
		boolean toContinue = true;
		
		switch (roboCmdEnum) {
		case REPORT:
			RoboPosCommand report = new RoboPosReport();
			if (checkInput(null, roboService.getRoboFacing())) {
				report.executeCommand(roboService);
			}
			break;
		case MOVE:
			RoboPosCommand move = new RoboPosMove();
			if (checkInput(roboService.getRoboCordinates(), roboService.getRoboFacing())) {
				move.executeCommand(roboService);
			}
			break;
		case RIGHT:
			RoboPosCommand right = new RoboPosRight();
			if (checkInput(null, roboService.getRoboFacing())) {
				right.executeCommand(roboService);
			}
			break;
		case LEFT:
			RoboPosCommand left = new RoboPosLeft();
			if (checkInput(null, roboService.getRoboFacing())) {
				left.executeCommand(roboService);
			}
			break;
		case QUIT:
			toContinue = false;
			break;
		default:
			break;
		}
		return toContinue;
	}
	
	/**
	 * 
	 * @param roboCordinates
	 * @param roboFacing
	 * @return
	 * @throws CustomException
	 */
	private boolean checkInput(RoboPosLongLat roboCordinates, RoboPosEnum roboFacing) throws CustomException {
		if (roboCordinates == null && roboFacing == null) {
			throw new CustomException(RoboConstants.INVLD_INP_NOW);
		}
		return true;
	}
	
	public boolean exePlaceService(String inputCmdAry, RoboPosCmdEnum roboCmdEnum, RoboPosSetup roboService) throws CustomException {
		String[] inputVals = inputCmdAry.split(RoboConstants.COMA);
		roboService.setPosition(inputCmdAry, new RoboPosLongLat(Integer.parseInt(inputVals[0]), Integer.parseInt(inputVals[1])));
		if (EnumUtils.isValidEnum(RoboPosEnum.class, inputVals[2])) {
			roboService.setRoboFacing(RoboPosEnum.valueOf(inputVals[2]));
		} else {
			throw new CustomException(RoboConstants.INVLD_INP);
		}
		return true;
	}

}
