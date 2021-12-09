package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentWeatherController {

	@GetMapping("/getinstant")
	public String getInstant(@RequestParam(value = "cityid") String cityId) {
		return "Greetings from Spring Boot!";
	}
}
