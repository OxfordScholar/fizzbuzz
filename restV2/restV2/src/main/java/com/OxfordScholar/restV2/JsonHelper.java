package com.OxfordScholar.restV2;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHelper {
	
	/**
	 * 
	 * @param data data coming in to be processed as JSON, in the form HashMap<String, String>
	 * @return
	 */
	public static String jsonStringParser(HashMap<String, String> data) {
		
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        	return gson.toJson(data);
	}
	
}