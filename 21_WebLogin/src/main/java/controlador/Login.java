package controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import modelo.entidad.Usuario;
import modelo.negocio.GestorUsuario;


@WebServlet("/usuarios/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestorUsuario gu = null;   
    
    public Login() {
       super();
    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario u = new Usuario();
		u.setId(-1);
		u.setNombre(nombre);
		u.setPassword(password);
		
		gu = new GestorUsuario();
		
		
		boolean validacion = gu.comprobacionUsuarioLogin(u);
		
		JSONObject json = new JSONObject();
		json.put("validado", validacion);
		
		response.getWriter().write(json.toString());
			
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
