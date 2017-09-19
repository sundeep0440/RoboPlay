package com.robo.pos.service;

import com.robo.pos.command.RoboPosSetup;
import com.robo.pos.exception.CustomException;
import com.robo.pos.exception.ExitException;
import com.robo.pos.util.RoboPosCmdEnum;

public class RoboPosServiceLocator {
	
	/**
	 * 
	 * @param inputCmdAry
	 * @param roboCmdEnum
	 * @param roboServ
	 * @return
	 * @throws CustomException
	 * @throws ExitException
	 */
	public boolean executeService(String inputCmdAry, RoboPosCmdEnum roboCmdEnum, RoboPosSetup roboServ) throws CustomException {
		boolean serviceResp = true;
		RoboPosServiceLookup lookup = new RoboPosServiceLookup();
		
		if(inputCmdAry!=null) {
			serviceResp = lookup.exePlaceService(inputCmdAry, roboCmdEnum, roboServ);
		} else {
			serviceResp = lookup.exeRoboPosCmd(roboCmdEnum, roboServ);
		}
		return serviceResp;
	}

}
