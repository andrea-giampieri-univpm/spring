package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DiskOperation {

	/*
	public void loadFromDisk() {
		JSONParser jparser = new JSONParser();
		try {
			json = (JSONObject) jparser.parse(new BufferedReader (new FileReader (Config.getConf("data_path")+"data.json" )));	
		}catch (Exception e){
			System.out.println("ERRORE NON SPECIFICATO: verifica il log.");
			System.out.println(e);
		}
	}
	
	public void saveToDisk() {//ma perchè il try ha le parentesi
		HashMap<String,Object> map =new HashMap<>();
		map.put("id", super.getId());
		map.put("dt", this.timeRef.toString());
		map.put("temp", super.getMain().getTemp());
		map.put("pressure", super.getMain().getPressure());
		JSONObject data=new JSONObject(map);
		JSONArray jsonarr = new JSONArray();
		jsonarr.add(data);
        try (FileWriter fw = new FileWriter(Config.getConf("data_path")+"data_"+this.getId()+".json",true)) {
        	BufferedWriter bw = new BufferedWriter(fw);
        	PrintWriter pw = new PrintWriter(bw);
        	pw.println(jsonarr);
        	pw.close();
            bw.close();
            fw.close();
        } catch (Exception e) {
        	System.out.println("Errore scrittura file configurazione");
        }
	}
	*/
}
