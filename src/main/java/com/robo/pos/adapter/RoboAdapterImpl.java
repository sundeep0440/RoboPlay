package com.robo.pos.adapter;

import java.util.Scanner;

import org.apache.commons.lang3.EnumUtils;

import com.robo.pos.command.RoboPosPlace;
import com.robo.pos.command.RoboPosSetup;
import com.robo.pos.exception.CustomException;
import com.robo.pos.exception.ExitException;
import com.robo.pos.service.RoboPosServiceLocator;
import com.robo.pos.util.RoboConstants;
import com.robo.pos.util.RoboPosCmdEnum;

/**
 * 
 * @author Sundeep Bellumkenda
 *
 */
public class RoboAdapterImpl implements RoboPosAdapter {

	@Override
	public void executeInstr(Object inputInstr1) {
		Scanner inputInstr = (Scanner)inputInstr1;
		boolean toContinue = true;
		String inputCmd = null;
		
		RoboPosSetup roboSetup = RoboPosPlace.getInstance();
		RoboPosServiceLocator serviceLocator = new RoboPosServiceLocator();
		RoboPosCmdEnum roboCmdEnum = null;
		while (toContinue) {
			inputCmd = inputInstr.nextLine();
			try {
				String[] inputCmdAry = inputCmd.split(RoboConstants.SPACE);
				if (EnumUtils.isValidEnum(RoboPosCmdEnum.class, inputCmdAry[0])) {
					roboCmdEnum = RoboPosCmdEnum.valueOf(inputCmdAry[0]);
					toContinue = (inputCmdAry.length >1
							? serviceLocator.executeService(inputCmdAry[1], roboCmdEnum, roboSetup)
							: serviceLocator.executeService(null, roboCmdEnum, roboSetup));
				} else {
					throw new CustomException(RoboConstants.INVLD_INP);
				}
			} catch (CustomException e) {
				//Do Nothing for Invalid commands and will continue.
			}
		}
	}

}
