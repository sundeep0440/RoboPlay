package com.robo.pos.tester;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.robo.pos.command.RoboPosPlace;
import com.robo.pos.command.RoboPosSetup;
import com.robo.pos.exception.CustomException;
import com.robo.pos.service.RoboPosServiceLookup;
import com.robo.pos.util.RoboPosCmdEnum;
import com.robo.pos.util.RoboPosEnum;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class RoboPosServiceLookupTest {
	
	private static RoboPosServiceLookup roboPosCheck;
	private static RoboPosSetup roboSetup;

	@BeforeClass
	public static void initCheck(){
		roboPosCheck = new RoboPosServiceLookup();
		roboSetup = RoboPosPlace.getInstance();
	}
	
	@Test
	public void testPlaceRobo(){
		boolean result = false;
		try {
			result = roboPosCheck.exePlaceService("0,0,NORTH", RoboPosCmdEnum.PLACE, roboSetup);
		} catch (CustomException e) {
		}
		assertEquals(true,result);
	}
	
	@Test
	public void testMoveRobo(){
		boolean result = false;
		try {
			roboSetup.setRoboFacing(RoboPosEnum.EAST);
			result = roboPosCheck.exeRoboPosCmd(RoboPosCmdEnum.MOVE, roboSetup);
		} catch (CustomException e) {
		}
		assertEquals(true,result);
	}

}
