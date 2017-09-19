package com.robo.pos.adapter;

import com.robo.pos.exception.ExitException;

/**
 * 
 * @author Sundeep Bellumkenda
 * 
 * Used Adapter Design pattern in-order to accommodate future changes
 *
 */

public interface RoboPosAdapter {
	
	/**
	 * 
	 * @param inputInstr
	 * @throws ExitException
	 */
	public void executeInstr(Object inputVal);

}
