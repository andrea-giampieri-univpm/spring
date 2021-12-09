package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CurrentWeather;
import com.example.demo.utils.Config;

@Component
public class DataPolling {
	
	private CurrentWeather cw;
	private static final Logger log = LoggerFactory.getLogger(DataPolling.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 10000)
	@Async
	public void reportCurrentTime() {
		//@Value("${owm.apikey}")private String owmApiKey; 
		log.info("Scanning for data: ", dateFormat.format(new Date()));
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<Long> cities = Config.getCities();
		for(Long city: cities) {
			this.cw = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?id="+city.longValue()+"&appid="+Config.getConf("owm_apikey")+"&units=metric&lang=it", CurrentWeather.class);
			System.out.println(cw);
			cw.saveToFile();
		}
	}
}
