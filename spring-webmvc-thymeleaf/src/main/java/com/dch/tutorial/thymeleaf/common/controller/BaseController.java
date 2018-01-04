package com.dch.tutorial.thymeleaf.common.controller;

import org.springframework.beans.BeanUtils;

/**
 * Class that define common function for all controller.
 *
 * @author David.Christianto
 */
public abstract class BaseController {

    /**
     * Method used to Copy bean properties.
     *
     * @param source {@link Object} source data.
     * @param clazz  {@link Class<T>} class of destination.
     * @return {@link T} destination object.
     */
    protected <T> T copyProperties(Object source, Class<T> clazz) {
        return copyProperties(source, clazz, null);
    }

    /**
     * Method used to Copy bean properties.
     *
     * @param source         {@link Object} source data.
     * @param clazz          {@link Class<T>} class of destination.
     * @param ignoreProperty {@link String[]} ignore parameter.
     * @return {@link T} destination object.
     * @throws RuntimeException if the class or its nullary constructor is not accessible or
     *                          if this Class represents an abstract class, an interface, an
     *                          array class, a primitive type, or void; or if the class has
     *                          no nullary constructor; or if the instantiation fails for
     *                          some other reason.
     */
    protected <T> T copyProperties(Object source, Class<T> clazz, String[] ignoreProperty) {
        try {
            if (source == null)
                return null;

            T target = clazz.newInstance();
            if (ignoreProperty != null)
                BeanUtils.copyProperties(source, target, ignoreProperty);
            else
                BeanUtils.copyProperties(source, target);

            return target;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
