package com.dch.tutorial.thymeleaf.dto;

import com.dch.tutorial.thymeleaf.common.validator.CreateValidationGroup;
import com.dch.tutorial.thymeleaf.common.validator.UpdateValidationGroup;
import org.hibernate.validator.constraints.NotBlank;

/**
 * DTO class used for City data transfer process.
 *
 * @author David.Christianto
 */
public class CityDto {

    @NotBlank(groups = {CreateValidationGroup.class, UpdateValidationGroup.class})
    private String name;

    @NotBlank(groups = CreateValidationGroup.class)
    private String countryCode;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
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
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
