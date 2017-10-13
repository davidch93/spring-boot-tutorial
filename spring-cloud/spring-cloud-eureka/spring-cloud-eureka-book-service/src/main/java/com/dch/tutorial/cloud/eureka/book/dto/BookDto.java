package com.dch.tutorial.cloud.eureka.book.dto;

/**
 * DTO class used for Book Entity data transfer process.
 * 
 * @author David.Christianto
 */
public class BookDto {

	private String author;
	private String title;

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
