package controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import modelo.entidad.Usuario;
import modelo.negocio.GestorUsuario;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestorUsuario gu;   
    
    public Login() {
       
    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		
		int r = gu.comprobacionUsuarioLogin(nombre, password);
			
	
		
		if(r==1) {
			
			request.getSession().setAttribute("nombre", nombre);
			String jsonTrue = "{'validado'}:'true'";
			response.getWriter().append(jsonTrue);
			
			
		} else {
			request.getSession().setAttribute("nombre", nombre);
			String jsonFalse = "{'validado'}:'false'";
			response.getWriter().append(jsonFalse);
		}
		
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
