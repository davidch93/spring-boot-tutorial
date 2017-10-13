package com.dch.tutorial.cloud.eureka.book.dto;

/**
 * DTO class used for store error information.
 * 
 * @author David.Christianto
 */
public class ErrorDto {

	private String error;
	private String message;

	public ErrorDto(String error, String message) {
		this.error = error;
		this.message = message;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
