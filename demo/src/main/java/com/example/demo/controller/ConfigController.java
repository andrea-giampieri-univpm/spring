package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.Config;

@RestController
public class ConfigController {
	
	@GetMapping("/addmonitoring")
	public String addCity(@RequestParam(value = "cityid") String cityId) {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/addmonitoringday")
	public String addCityDaily(@RequestParam(value = "cityid") String cityId, @RequestParam(value = "day") String day) {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/addmonitoringrange")
	public String addCityRange(@RequestParam(value = "cityid") String cityId,@RequestParam(value = "from") String from,@RequestParam(value = "to") String to) {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/status")
	public String getStatus() {
		return Config.toJson();
	}
	
	@GetMapping("/removemonitoring")
	public String df(@RequestParam(value = "cityid") String cityId)  {
		
		return "Greetings from Spring Boot!";
	}

}