package com.adalbertosolf.domain.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
//import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;

@Service
public class CepService {

	public String getDadosCEP(String cep){
		String json;
		try {
			URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
	        URLConnection urlConnection = url.openConnection();
	        InputStream is = urlConnection.getInputStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        StringBuilder jsonSb = new StringBuilder();
	        br.lines().forEach(l -> {
		        	if(l.indexOf("siafi")==-1) {
		        		jsonSb.append(l.trim());
		        	}else {
		        		if(jsonSb.length()>0)
		        			jsonSb.setLength(jsonSb.length()-1);
		        	}
		        }
	        );
	        
	        json = jsonSb.toString();
	        return json;
        }catch (Exception e) {
            throw new RuntimeException(e);
	    }
	}
	
}
