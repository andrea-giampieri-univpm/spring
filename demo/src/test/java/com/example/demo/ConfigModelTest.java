package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.example.demo.utils.Config;

class ConfigModelTest {


	
	@BeforeAll
	public static void secureConfig() {
		File conf = new File("config.json");
		File confbak = new File("config.json.bak");
		conf.renameTo(confbak);
	}
		 
	@Test
	@DisplayName("Test lettura configurazione inesistente")
	public void configReadUnavailable() {
		assertThrows(NullPointerException.class, () -> {
			File conf = new File("config.json");
			conf.delete();
			Config.initialize();
			});	
	}

	@After
	public static void restoreConf() {
		File conf = new File("config.json");
		File confbak = new File("config.json.bak");
		conf.delete();
		conf = new File("config.json");
		confbak.renameTo(conf);
	}
	


}
