package com.dch.tutorial.thymeleaf.dto;

import java.util.List;

/**
 * DTO class used for Open Weather Map data transfer process. Source:
 * http://api.openweathermap.org/data/2.5/weather.
 * 
 * @author David.Christianto
 */
public class OpenWeatherMapDto {

	private Coordinate coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private long visibility;
	private Wind wind;
	private Cloud clouds;
	private long dt;
	private System sys;
	private long id;
	private String name;
	private long cod;

	/**
	 * @return the coord
	 */
	public Coordinate getCoord() {
		return coord;
	}

	/**
	 * @param coord
	 *            the coord to set
	 */
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	/**
	 * @return the weather
	 */
	public List<Weather> getWeather() {
		return weather;
	}

	/**
	 * @param weather
	 *            the weather to set
	 */
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	/**
	 * @return the base
	 */
	public String getBase() {
		return base;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(String base) {
		this.base = base;
	}

	/**
	 * @return the main
	 */
	public Main getMain() {
		return main;
	}

	/**
	 * @param main
	 *            the main to set
	 */
	public void setMain(Main main) {
		this.main = main;
	}

	/**
	 * @return the visibility
	 */
	public long getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility
	 *            the visibility to set
	 */
	public void setVisibility(long visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the wind
	 */
	public Wind getWind() {
		return wind;
	}

	/**
	 * @param wind
	 *            the wind to set
	 */
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	/**
	 * @return the clouds
	 */
	public Cloud getClouds() {
		return clouds;
	}

	/**
	 * @param clouds
	 *            the clouds to set
	 */
	public void setClouds(Cloud clouds) {
		this.clouds = clouds;
	}

	/**
	 * @return the dt
	 */
	public long getDt() {
		return dt;
	}

	/**
	 * @param dt
	 *            the dt to set
	 */
	public void setDt(long dt) {
		this.dt = dt;
	}

	/**
	 * @return the sys
	 */
	public System getSys() {
		return sys;
	}

	/**
	 * @param sys
	 *            the sys to set
	 */
	public void setSys(System sys) {
		this.sys = sys;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the cod
	 */
	public long getCod() {
		return cod;
	}

	/**
	 * @param cod
	 *            the cod to set
	 */
	public void setCod(long cod) {
		this.cod = cod;
	}

	public static class Coordinate {

		private double lon;
		private double lat;

		/**
		 * @return the lon
		 */
		public double getLon() {
			return lon;
		}

		/**
		 * @param lon
		 *            the lon to set
		 */
		public void setLon(double lon) {
			this.lon = lon;
		}

		/**
		 * @return the lat
		 */
		public double getLat() {
			return lat;
		}

		/**
		 * @param lat
		 *            the lat to set
		 */
		public void setLat(double lat) {
			this.lat = lat;
		}
	}

	public static class Weather {

		private long id;
		private String main;
		private String description;
		private String icon;

		/**
		 * @return the id
		 */
		public long getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(long id) {
			this.id = id;
		}

		/**
		 * @return the main
		 */
		public String getMain() {
			return main;
		}

		/**
		 * @param main
		 *            the main to set
		 */
		public void setMain(String main) {
			this.main = main;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the icon
		 */
		public String getIcon() {
			return icon;
		}

		/**
		 * @param icon
		 *            the icon to set
		 */
		public void setIcon(String icon) {
			this.icon = icon;
		}
	}

	public static class Main {

		private double temp;
		private long pressure;
		private long humidity;
		private double temp_min;
		private double temp_max;

		/**
		 * @return the temp
		 */
		public double getTemp() {
			return temp;
		}

		/**
		 * @param temp
		 *            the temp to set
		 */
		public void setTemp(double temp) {
			this.temp = temp;
		}

		/**
		 * @return the pressure
		 */
		public long getPressure() {
			return pressure;
		}

		/**
		 * @param pressure
		 *            the pressure to set
		 */
		public void setPressure(long pressure) {
			this.pressure = pressure;
		}

		/**
		 * @return the humidity
		 */
		public long getHumidity() {
			return humidity;
		}

		/**
		 * @param humidity
		 *            the humidity to set
		 */
		public void setHumidity(long humidity) {
			this.humidity = humidity;
		}

		/**
		 * @return the temp_min
		 */
		public double getTemp_min() {
			return temp_min;
		}

		/**
		 * @param temp_min
		 *            the temp_min to set
		 */
		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}

		/**
		 * @return the temp_max
		 */
		public double getTemp_max() {
			return temp_max;
		}

		/**
		 * @param temp_max
		 *            the temp_max to set
		 */
		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}
	}

	public static class Wind {

		private double speed;
		private double deg;

		/**
		 * @return the speed
		 */
		public double getSpeed() {
			return speed;
		}

		/**
		 * @param speed
		 *            the speed to set
		 */
		public void setSpeed(double speed) {
			this.speed = speed;
		}

		/**
		 * @return the deg
		 */
		public double getDeg() {
			return deg;
		}

		/**
		 * @param deg
		 *            the deg to set
		 */
		public void setDeg(double deg) {
			this.deg = deg;
		}
	}

	public static class Cloud {

		private long all;

		/**
		 * @return the all
		 */
		public long getAll() {
			return all;
		}

		/**
		 * @param all
		 *            the all to set
		 */
		public void setAll(long all) {
			this.all = all;
		}
	}

	public static class System {

		private long type;
		private long id;
		private long message;
		private String country;
		private long sunrise;
		private long sunset;

		/**
		 * @return the type
		 */
		public long getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(long type) {
			this.type = type;
		}

		/**
		 * @return the id
		 */
		public long getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(long id) {
			this.id = id;
		}

		/**
		 * @return the message
		 */
		public long getMessage() {
			return message;
		}

		/**
		 * @param message
		 *            the message to set
		 */
		public void setMessage(long message) {
			this.message = message;
		}

		/**
		 * @return the country
		 */
		public String getCountry() {
			return country;
		}

		/**
		 * @param country
		 *            the country to set
		 */
		public void setCountry(String country) {
			this.country = country;
		}

		/**
		 * @return the sunrise
		 */
		public long getSunrise() {
			return sunrise;
		}

		/**
		 * @param sunrise
		 *            the sunrise to set
		 */
		public void setSunrise(long sunrise) {
			this.sunrise = sunrise;
		}

		/**
		 * @return the sunset
		 */
		public long getSunset() {
			return sunset;
		}

		/**
		 * @param sunset
		 *            the sunset to set
		 */
		public void setSunset(long sunset) {
			this.sunset = sunset;
		}
	}
}
