package com.example.model.owm;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Binding per la struttura json di owm https://openweathermap.org/current#current_JSON
 * @author Andrea Giampieri
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OwmCurrentWeather {
	OwmCoord coord;
	ArrayList<OwmWeather> weather;
	private String base;
	OwmMain main;
	private double visibility;
	OwmWind wind;
	OwmClouds clouds;
	private long dt;
	OwmSys sys;
	private long id;
	private String name;
	private int cod;


	// Getter Methods 

	public OwmCoord getCoord() {
		return coord;
	}
	
	public ArrayList<OwmWeather> getWeather() {
		return weather;
	}

	public String getBase() {
		return base;
	}

	public OwmMain getMain() {
		return main;
	}

	public double getVisibility() {
		return visibility;
	}

	public OwmWind getWind() {
		return wind;
	}

	public OwmClouds getClouds() {
		return clouds;
	}

	public long getDt() {
		return dt;
	}

	public OwmSys getSys() {
		return sys;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCod() {
		return cod;
	}

	// Setter Methods 

	public void setCoord( OwmCoord owmCoordObject ) {
		this.coord = owmCoordObject;
	}

	public void setWeather ( ArrayList<OwmWeather> owmWeatherObject ) {
		this.weather = owmWeatherObject;
	}
	
	public void setBase( String base ) {
		this.base = base;
	}

	public void setMain( OwmMain owmMainObject ) {
		this.main = owmMainObject;
	}

	public void setVisibility( double visibility ) {
		this.visibility = visibility;
	}

	public void setWind( OwmWind owmWindObject ) {
		this.wind = owmWindObject;
	}

	public void setClouds( OwmClouds owmCloudsObject ) {
		this.clouds = owmCloudsObject;
	}

	public void setDt( long dt ) {
		this.dt = dt;
	}

	public void setSys( OwmSys owmSysObject ) {
		this.sys = owmSysObject;
	}

	public void setId( long id ) {
		this.id = id;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setCod( int cod ) {
		this.cod = cod;
	}

}

