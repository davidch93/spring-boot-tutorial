package com.dch.tutorial.cloud.eureka.rating.dto;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * Class that defined response message from server containing list object and
 * the return type should be written straight to the HTTP response body.
 * 
 * @author David.Christianto
 * @param <T>
 *            the object to store.
 */
public class ContentListDto<T> {

	private Pageable page;
	private long actualSize;
	private List<T> contentList;

	public ContentListDto() {
	}

	public ContentListDto(Pageable page, int actualSize, List<T> contentList) {
		this.page = page;
		this.actualSize = actualSize;
		this.contentList = contentList;
	}

	/**
	 * @return the page
	 */
	public Pageable getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(Pageable page) {
		this.page = page;
	}

	/**
	 * @return the actualSize
	 */
	public long getActualSize() {
		return actualSize;
	}

	/**
	 * @param actualSize
	 *            the actualSize to set
	 */
	public void setActualSize(long actualSize) {
		this.actualSize = actualSize;
	}

	/**
	 * @return the contentList
	 */
	public List<T> getContentList() {
		return contentList;
	}

	/**
	 * @param contentList
	 *            the contentList to set
	 */
	public void setContentList(List<T> contentList) {
		this.contentList = contentList;
	}
}
