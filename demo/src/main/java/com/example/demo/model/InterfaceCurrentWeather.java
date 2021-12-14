package com.example.demo.model;

import java.time.LocalDateTime;

public interface InterfaceCurrentWeather {

	public double getTemp();
	
	public double getPressure();
	
	public LocalDateTime getFormattedDt();
}
