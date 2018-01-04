package com.dch.tutorial.thymeleaf.entity;

import com.dch.tutorial.thymeleaf.common.dataaccess.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The entity used to provide data about the Weather and represent the columns
 * in the database.
 *
 * @author David.Christianto
 */
@Entity
@Table(name = "weather")
public class WeatherEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3196460270871598454L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Long weatherId;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "country")
    private String country;

    @Column(name = "icon")
    private String icon;

    @Column(name = "description")
    private String description;

    @Column(name = "temp")
    private double temp;

    @Column(name = "temp_min")
    private double tempMin;

    @Column(name = "temp_max")
    private double tempMax;

    @Column(name = "wind_speed")
    private double windSpeed;

    @Column(name = "cloud")
    private long cloud;

    @Column(name = "pressure")
    private long pressure;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

    /**
     * @return the weatherId
     */
    public Long getWeatherId() {
        return weatherId;
    }

    /**
     * @param weatherId the weatherId to set
     */
    public void setWeatherId(Long weatherId) {
        this.weatherId = weatherId;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the temp
     */
    public double getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * @return the tempMin
     */
    public double getTempMin() {
        return tempMin;
    }

    /**
     * @param tempMin the tempMin to set
     */
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    /**
     * @return the tempMax
     */
    public double getTempMax() {
        return tempMax;
    }

    /**
     * @param tempMax the tempMax to set
     */
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    /**
     * @return the windSpeed
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param windSpeed the windSpeed to set
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * @return the cloud
     */
    public long getCloud() {
        return cloud;
    }

    /**
     * @param cloud the cloud to set
     */
    public void setCloud(long cloud) {
        this.cloud = cloud;
    }

    /**
     * @return the pressure
     */
    public long getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    /**
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(double lon) {
        this.lon = lon;
    }
}
