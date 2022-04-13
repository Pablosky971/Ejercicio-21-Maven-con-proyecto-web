package main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Usuario;
import modelo.negocio.GestorUsuario;

public class MainLogin {
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido al sistema de gesti�n de usuarios");
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		GestorUsuario g = new GestorUsuario();
		
		do {
			menu();
			System.out.println("Indica el n�mero correspondiente a la opci�n que desee efectuar.");
			int opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Introduzca los credenciales del usuario:");
				
				System.out.println("Nombre: ");
				String nombre= sc.next();
				
				System.out.println("Password: ");
				String password = sc.next();
			
				
				
					
					try {
						
						HttpRequest request = HttpRequest.newBuilder()
								  .uri(new URI("http://localhost:8080/21_WebLogin/login"))
								  .GET()
								  .header(nombre, nombre)
								  .header(password, password)
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
					
				
			
				break;
			
			case 2:
			List<Usuario> usuarios = g.listarUsuarios() ;
							
							int i = 1;
							for(Usuario usuario: usuarios) {
								
								System.out.println("Usuario " + i);
								System.out.println("Identificador: " + usuario.getId());
								System.out.println("Nombre: " + usuario.getNombre());
								System.out.println("Password: " + usuario.getPassword());
								
					i++;
				}
				break;
				
			case 3:
				fin=true;
				break;
			}
		}while(!fin);
		
		System.out.println("Fin de programa");
	}
		
		

	
	
	private static void menu() {
		
			System.out.println("1. Login");
			System.out.println("2. Listar todos los usuarios");
			System.out.println("3- Salir de la aplicaci�n");
		
	}
	}


