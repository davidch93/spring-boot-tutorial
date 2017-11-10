package com.dch.tutorial.thymeleaf.entity;

import java.io.Serializable;

public class CityEntity implements Serializable {

	private static final long serialVersionUID = -6487967141827830245L;

	private Long cityId;
	private String name;
	private String countryCode;

	/**
	 * @return the cityId
	 */
	public Long getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
