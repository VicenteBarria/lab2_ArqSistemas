package com.gomitas.Gomitas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GomitasApplicationTests {

	@Test
	public void TestPOST() {
		int ResponseCode = 0;
        try{
            URL url = new URL("http://localhost:8081/gomitas");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String in = "{\"nombre\":\"Ositos\",\"marca\":\"Ambrosoli\",\"precio\":\"700\"}";
            OutputStream os = conn.getOutputStream();
            os.write(in.getBytes());
            os.flush();
            ResponseCode = conn.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            System.out.println("Salida de la peticion POST");
            String out;
            while ((out = br.readLine()) != null)
                System.out.println(out);
            conn.disconnect();
        }catch (MalformedURLException e) {
        	e.printStackTrace();
        }catch (IOException e) {
        	e.printStackTrace();
        }
        Assert.assertFalse("Error: " + ResponseCode, ResponseCode != 200);
	}
	
	@Test
	public void TestGET() {
        int ResponseCode = 0;
        try{
        	URL url = new URL("http://localhost:8081/gomitas");
        	HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        	conn.setRequestMethod("GET");
        	conn.setRequestProperty("Accept", "application/json");
        	ResponseCode = conn.getResponseCode();
        	BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        	String out;
        	System.out.println("Salida de la peticion GET");
        	while((out = br.readLine()) != null)
        		System.out.println(out);
        	conn.disconnect();
        }catch (MalformedURLException e) {
        	e.printStackTrace();
        }catch (IOException e) {
        	e.printStackTrace();
        }
        Assert.assertFalse("Error: " + ResponseCode, ResponseCode != 200);
    }
	
	@Test
	public void testUPDATE() {
        int ResponseCode = 0;
        try {
            URL url = new URL("http://localhost:8081/gomitas/1");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = "{\"nombre\":\"Gusanitos\",\"marca\":\"Trolli\",\"precio\":\"900\"}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            ResponseCode = conn.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            System.out.println("Salida de la peticion PUT");
            String out;
            while ((out = br.readLine()) != null)
                System.out.println(out);
            conn.disconnect();
        }catch (MalformedURLException e) {
        	e.printStackTrace();
        }catch (IOException e) {
        	e.printStackTrace();
        }
        Assert.assertFalse("Error: " + ResponseCode, ResponseCode!=200);
    }
	
	@Test
	public void testDELETE() {
        int ResponseCode = 0;
        try {
            URL url = new URL("http://localhost:8081/gomitas/1");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            ResponseCode = conn.getResponseCode();
            conn.disconnect();
        }catch (MalformedURLException e) {
        	e.printStackTrace();
        }catch (IOException e) {
        	e.printStackTrace();
        }
        Assert.assertFalse("Error: " + ResponseCode, ResponseCode != 200);
    }
}
