package com.dch.tutorial.thymeleaf.enums;

/**
 * List of data status that represent database column.
 *
 * @author David.Christianto
 */
public enum DataStatus {

    /**
     * Status for activated data.
     */
    ACTIVATED(0, "Activated"),

    /**
     * Status for deleted data.
     */
    DELETED(1, "Deleted");

    private final int code;
    private final String value;

    private DataStatus(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}