package com.robo.pos.tester;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.robo.pos.command.RoboPosCommand;
import com.robo.pos.command.RoboPosLeft;
import com.robo.pos.command.RoboPosMove;
import com.robo.pos.command.RoboPosPlace;
import com.robo.pos.command.RoboPosReport;
import com.robo.pos.command.RoboPosRight;
import com.robo.pos.exception.CustomException;
import com.robo.pos.util.RoboPosEnum;
import com.robo.pos.util.RoboPosLongLat;

import junit.framework.Assert;

/**
 * 
 * @author Sundeep Bellumkenda
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RoboPositionTest {

	@Before
	public void initServiceVars() {
		roboService = RoboPosPlace.getInstance();
		roboCordinates = Mockito.mock(RoboPosLongLat.class);
		report = Mockito.mock(RoboPosReport.class);
		left = new RoboPosLeft();
		right = new RoboPosRight();
		move = new RoboPosMove();
	}

	@InjectMocks
	RoboPosPlace roboService;
	RoboPosLongLat roboCordinates;
	RoboPosEnum roboFacing;
	RoboPosCommand report;
	RoboPosCommand left;
	RoboPosCommand right;
	RoboPosCommand move;

	
	@Test
	public void reprotTest(){
		roboFacing = RoboPosEnum.NORTH;
		roboCordinates = new RoboPosLongLat();
		roboCordinates.setLattitude(1);
		roboCordinates.setLongitude(0);
		roboService.setRoboCordinates(roboCordinates);
		roboService.setRoboFacing(roboFacing);
		boolean thrown = false;
		try {
			Mockito.doThrow(new CustomException("Done")).when(report).executeCommand(roboService);
			report.executeCommand(roboService);
		} catch (CustomException e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void leftTest(){
		roboFacing = RoboPosEnum.NORTH;
		roboCordinates = new RoboPosLongLat();
		roboCordinates.setLattitude(1);
		roboCordinates.setLongitude(0);
		roboService.setRoboCordinates(roboCordinates);
		roboService.setRoboFacing(RoboPosEnum.NORTH);
			try {
				left.executeCommand(roboService);
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Assert.assertEquals(RoboPosEnum.WEST, roboService.getRoboFacing());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void rightTest(){
		roboFacing = RoboPosEnum.NORTH;
		roboCordinates = new RoboPosLongLat();
		roboCordinates.setLattitude(1);
		roboCordinates.setLongitude(0);
		roboService.setRoboCordinates(roboCordinates);
		roboService.setRoboFacing(RoboPosEnum.NORTH);
		try {
			right.executeCommand(roboService);
		} catch (CustomException e) {
		}
		Assert.assertEquals(RoboPosEnum.EAST, roboService.getRoboFacing());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void moveTest(){
		roboFacing = RoboPosEnum.NORTH;
		roboCordinates = new RoboPosLongLat();
		roboCordinates.setLattitude(1);
		roboCordinates.setLongitude(0);
		roboService.setRoboCordinates(roboCordinates);
		roboService.setRoboFacing(RoboPosEnum.NORTH);
		try {
			move.executeCommand(roboService);
		} catch (CustomException e) {
		}
		Assert.assertEquals(1, roboService.getRoboCordinates().getLongitude());
	}
	
}
