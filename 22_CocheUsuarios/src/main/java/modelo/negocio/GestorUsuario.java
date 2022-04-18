package modelo.negocio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class GestorUsuario {
	
	public boolean validacionUsuario(String nombre, String password) {
		
		boolean v;
		try {
			
			HttpRequest request = HttpRequest.newBuilder()
					  .uri(new URI("http://localhost:8080/21_WebLogin/usuarios/login?nombre=" + nombre + "&password=" + password))
					  .GET()
					  .build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			JSONObject json = new JSONObject(response.body());
			v = json.getBoolean("validado");
			return v;
			
		
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		v = false;
		return v;
		
	}

}
