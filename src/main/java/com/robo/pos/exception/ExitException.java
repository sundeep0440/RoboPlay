package com.robo.pos.exception;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class ExitException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param exception
	 */
	public ExitException(String exception) {
		System.out.println("Exception Occured :: " + exception);
	}

}
