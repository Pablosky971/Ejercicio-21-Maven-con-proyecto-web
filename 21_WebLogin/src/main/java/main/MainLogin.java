package main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class MainLogin {
	
	public static void main(String[] args) {
		try {
			
			HttpRequest request = HttpRequest.newBuilder()
					  .uri(new URI("http://localhost:8080/21_WebLogin/Login"))
					  .GET()
					  .build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
			System.out.println(response);
			System.out.println(response.body());
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}
	}


