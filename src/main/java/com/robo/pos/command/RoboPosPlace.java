/**
 * 
 */
package com.robo.pos.command;

import org.apache.commons.lang3.EnumUtils;

import com.robo.pos.exception.CustomException;
import com.robo.pos.util.RoboConstants;
import com.robo.pos.util.RoboPosEnum;
import com.robo.pos.util.RoboPosLongLat;
import com.robo.pos.validator.RoboXYPosValidatorImpl;
import com.robo.pos.validator.ValidateCoordinates;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class RoboPosPlace implements RoboPosSetup {
	/**
	 * Singleton instance creation
	 */
	private static final RoboPosPlace instance = new RoboPosPlace();
	private RoboPosPlace(){}
	
	public static RoboPosPlace getInstance(){
        return instance;
    }

	private RoboPosLongLat roboCordinates;
	private RoboPosEnum roboFacing;

	/* (non-Javadoc)
	 * @see com.robo.pos.command.RoboPosSetup#setPosition(java.lang.String, com.robo.pos.util.RoboPosLongLat)
	 */
	@Override
	public void setPosition(String inputCmdAry, RoboPosLongLat roboPos) throws CustomException {
		ValidateCoordinates posValidator = new RoboXYPosValidatorImpl();
		String[] inputVals = inputCmdAry.split(RoboConstants.COMA);
		setRoboCordinates(new RoboPosLongLat(Integer.parseInt(inputVals[0]), Integer.parseInt(inputVals[1])));
		if (EnumUtils.isValidEnum(RoboPosEnum.class, inputVals[2])) {
			setRoboFacing(RoboPosEnum.valueOf(inputVals[2]));
		} else {
			throw new CustomException(RoboConstants.INVLD_INP);
		}
		
		if (posValidator.isOutOfRange(this.roboCordinates)) {
			this.roboCordinates = posValidator.resetCoordinates(this.roboCordinates);
			throw new CustomException(RoboConstants.INVLD_CORD);
		}
		this.roboCordinates = roboPos;
	}

	/* (non-Javadoc)
	 * @see com.robo.pos.command.RoboPosSetup#getRoboCordinates()
	 */
	@Override
	public RoboPosLongLat getRoboCordinates() {
		return roboCordinates;
	}

	/* (non-Javadoc)
	 * @see com.robo.pos.command.RoboPosSetup#setRoboCordinates(com.robo.pos.util.RoboPosLongLat)
	 */
	@Override
	public void setRoboCordinates(RoboPosLongLat roboCordinates) {
		this.roboCordinates = roboCordinates;
	}

	/* (non-Javadoc)
	 * @see com.robo.pos.command.RoboPosSetup#getRoboFacing()
	 */
	@Override
	public RoboPosEnum getRoboFacing() {
		return roboFacing;
	}

	/* (non-Javadoc)
	 * @see com.robo.pos.command.RoboPosSetup#setRoboFacing(com.robo.pos.util.RoboPosEnum)
	 */
	@Override
	public void setRoboFacing(RoboPosEnum roboFacing) {
		this.roboFacing = roboFacing;
	}

}
