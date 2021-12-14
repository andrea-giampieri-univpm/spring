package com.example.demo.scheduled;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CurrentWeather;
import com.example.demo.utils.Config;

@Component
public class DataPolling implements InterfaceDataPolling {
	
	private CurrentWeather cw;
	private static final Logger log = LoggerFactory.getLogger(DataPolling.class);

	@Scheduled(fixedRate = 10000)
	@Async
	public void getCurrentWeather() {
		//@Value("${owm.apikey}")private String owmApiKey; 
		log.info("Scanning for data: ");
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<Long> cities = Config.getCities();
		for(Long city: cities) {
			this.cw = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?id="+city.longValue()+"&appid="+Config.getConf("owm_apikey")+"&units=metric&lang=it", CurrentWeather.class);
			JSONObject js = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?id="+city.longValue()+"&appid="+Config.getConf("owm_apikey")+"&units=metric&lang=it", JSONObject.class);

			System.out.println(js);
			System.out.println(cw);
			cw.appendToFile();
		}
	}
}
