package com.robo.pos.exception;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param exception
	 */
	public CustomException(String exception) {
		System.out.println(exception);
	}

}
