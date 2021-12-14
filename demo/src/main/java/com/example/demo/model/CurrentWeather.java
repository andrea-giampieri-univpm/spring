package com.example.demo.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.TimeZone;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.example.demo.model.owm.OwmCurrentJson;
import com.example.demo.utils.Config;

public class CurrentWeather extends OwmCurrentJson implements InterfaceDataSave, InterfaceCurrentWeather {
	
	public CurrentWeather() {
		
	}
	
	public CurrentWeather(String jsonString) {
		try {
		JSONParser jparser = new JSONParser();
		JSONObject json = (JSONObject) jparser.parse(jsonString);
		this.setId((Long) json.get("id"));
		this.getMain().setTemp((Double) json.get("temp"));
		this.getMain().setPressure((Double) json.get("pressure"));
		this.setDt((Long)json.get("dt"));
		} catch (Exception e) {
			System.out.println("Errore parsing stringa json");
		}
	}
	
	public LocalDateTime getFormattedDt() {
		return LocalDateTime.ofInstant(Instant.ofEpochSecond(super.getDt()), TimeZone.getTimeZone("Europe/Rome").toZoneId());
	}
	
	public double getPressure() {
		return super.getMain().getPressure();
	}
	
	public double getTemp() {
		return super.getMain().getTemp();
	}
	
	public void appendToFile() {
		try {
			HashMap<String, Object> keyvalue= new HashMap<>();
			JSONObject jsonobj = new JSONObject(keyvalue);
			 //implementare con hashmap
			keyvalue.put("id", this.getId());
			
			jsonobj.put("id", this.getId());
			jsonobj.put("dt", this.getDt());
			jsonobj.put("temp", this.getMain().getTemp());
			jsonobj.put("pressure", this.getMain().getPressure());
			
			FileWriter fw = new FileWriter(Config.getConf("data_path")+"data_"+this.getId()+".json",true);
        	BufferedWriter bw = new BufferedWriter(fw);
        	PrintWriter pw = new PrintWriter(bw);
        	pw.println(jsonobj);
        	pw.close();
            bw.close();
            fw.close();
	        
		} catch (Exception e) {
        	System.out.println("Errore scrittura file");
        }
	}
	
	@Override
	public String toString() {
		return "City ("+this.getId()+"):"+this.getName()+" Temp: "+this.getMain().getTemp()+" Press: "+this.getMain().getPressure()+ " Time: "+this.getFormattedDt();
	}
}
