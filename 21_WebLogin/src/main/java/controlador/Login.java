package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import modelo.entidad.Usuario;
import modelo.negocio.GestorUsuario;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestorUsuario gu;   
    
    public Login() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setPassword(password);
		
		int r = gu.comprobacionUsuarioLogin(u);
		
			
	
		
		if(r==1) {
			
			request.getSession().setAttribute("nombre", nombre);
			Gson gson = new Gson();
			String json = gson.toJson(u);
		
			response.getWriter().append(json);
			
			
		} else {
			request.getSession().setAttribute("nombre", nombre);
			Gson gson = new Gson();
			String json = gson.toJson(u);
		
			response.getWriter().append(json);
		}
		
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
