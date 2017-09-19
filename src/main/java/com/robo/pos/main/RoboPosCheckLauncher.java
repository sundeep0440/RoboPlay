package com.robo.pos.main;

import java.util.Scanner;

import com.robo.pos.adapter.RoboAdapterImpl;
import com.robo.pos.adapter.RoboPosAdapter;
import com.robo.pos.util.RoboConstants;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class RoboPosCheckLauncher {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		RoboPosAdapter roboAdapter = new RoboAdapterImpl();
		System.out.println(RoboConstants.INP_CMD);
		try {
			roboAdapter.executeInstr(inputScanner);
		} finally {
			inputScanner.close();
		}
	}
}
