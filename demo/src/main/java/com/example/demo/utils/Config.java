package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Config {
	
	private static JSONObject conf;
	
	public static String toJson() {
		return conf.toString();
	}
	
	public static void initialize() {
		//Controllo ed ingresso parametri applicazione indispensabili per il funzionamento
		JSONParser jparser = new JSONParser();
		try {
			conf = (JSONObject) jparser.parse(new BufferedReader (new FileReader ("config.json" )));	
			if(conf.containsKey("owm_apikey"))System.out.println("Using API KEY: "+conf.get("owm_apikey")); else throw new ParseException(0);
			if(conf.containsKey("h_period")) System.out.println("Using period H: "+conf.get("h_period")); else throw new ParseException(0);
			if(conf.containsKey("data_path")) System.out.println("Using data path: "+conf.get("data_path")); else throw new ParseException(0);
		} catch (FileNotFoundException e) {
			System.out.println("ERRORE: file di configurazione non trovato, app termina esecuzione.");
			System.out.println(e);
			System.exit(1);
		} catch (Exception e){
			System.out.println("ERRORE NON SPECIFICATO: verifica il log, app termina esecuzione.");
			System.out.println(e);
			System.exit(1);
		}
	}
	
	public static Object getConf(String param) {
		if(conf.containsKey(param)) return conf.get(param); else return null;
	}
	
	public static Object setConf(String param, Object value)  {
		return conf.put(param, value);
	}
	
	public static Object setConf(String param, Object value, boolean commit)  {
		Object ret = conf.put(param, value);
		if (commit) Config.commit();
		return ret;
	}
	
	public static void commit() {//ma perchè il try ha le parentesi
        try (BufferedWriter br = new BufferedWriter(new FileWriter("config.json" ))) {
            br.write(conf.toJSONString());
            br.close();
        } catch (Exception e) {
        	System.out.println("Errore scrittura file configurazione");
        }
	}
	
	public static ArrayList<Long> getCities(){
		try {
			ArrayList<Long> cities = (ArrayList<Long>) conf.get("cities");
			return cities;
		} catch (ClassCastException e) {
			System.out.println("Errore formato dati da json");
			return null;
		}
		
	}
}
