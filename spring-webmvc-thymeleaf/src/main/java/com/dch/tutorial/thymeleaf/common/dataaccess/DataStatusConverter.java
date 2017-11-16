package com.dch.tutorial.thymeleaf.common.dataaccess;

import javax.persistence.AttributeConverter;

import com.dch.tutorial.thymeleaf.enums.DataStatus;

/**
 * Class that used to convert entity attribute state into database column
 * representation and back again.
 * 
 * @author David.Christianto
 */
public class DataStatusConverter implements AttributeConverter<DataStatus, Integer> {

	@Override
	public Integer convertToDatabaseColumn(DataStatus dataStatus) {
		return dataStatus.getCode();
	}

	@Override
	public DataStatus convertToEntityAttribute(Integer dbData) {
		switch (dbData) {
		case 0:
			return DataStatus.ACTIVATED;
		case 1:
			return DataStatus.DELETED;
		default:
			return null;
		}
	}
}
