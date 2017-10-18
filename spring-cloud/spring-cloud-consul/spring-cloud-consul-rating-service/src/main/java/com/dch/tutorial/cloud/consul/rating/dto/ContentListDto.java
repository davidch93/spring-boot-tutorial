package com.dch.tutorial.cloud.consul.rating.dto;

import java.util.List;

/**
 * Class that defined response message from server containing list object and
 * the return type should be written straight to the HTTP response body.
 * 
 * @author David.Christianto
 * @param <T>
 *            the object to store.
 */
public class ContentListDto<T> {

	private long page;
	private long size;
	private long actualSize;
	private List<T> contentList;

	public ContentListDto() {
	}

	public ContentListDto(long page, long size, long actualSize, List<T> contentList) {
		this.page = page;
		this.size = size;
		this.actualSize = actualSize;
		this.contentList = contentList;
	}

	/**
	 * @return the page
	 */
	public long getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(long page) {
		this.page = page;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(long size) {
		this.size = size;
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
