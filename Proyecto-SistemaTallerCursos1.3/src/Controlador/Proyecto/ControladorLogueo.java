package Controlador.Proyecto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Dao.Proyecto.UsuarioImp;
import Modelo.Proyecto.ClaseUsuario;

/**
 * Servlet implementation class ControladorLogueo
 */
@WebServlet("/ControladorLogueo")
public class ControladorLogueo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControladorLogueo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				//declaramos una variable para el mensaje
				String mensaje="";
				String successMessage="";
				//declaramos variuable para redireccionar...
				String url="";
						
						
				//recuperamos los valores del formulario
				String usuario=request.getParameter("usuario");
				String password=request.getParameter("password");
						
				// instanciamos la clase de nombre Clase Usuario...
				ClaseUsuario clusu=new ClaseUsuario();				
				// asignamos los valores que vienen del formulario
				// a los metodos setter
						
				clusu.setNomusuario(usuario);
				clusu.setPassword(password);
						
				//instanciamos la clase usuarioimpl
				UsuarioImp valusu=new UsuarioImp();
				//recuperamos los valores que vienen de la BD...
				// invocamos al metodo validar usuario
				ClaseUsuario verusu=valusu.validarUsuario(clusu);
						
				//aplicamos una condicion
				if(verusu.getNomusuario()!=null && verusu.getPassword()!=null){
					mensaje="Credenciales correctas";
					successMessage = "Inicio de sesión exitoso. ¡Bienvenido!";
					
					//redireccionamos
					url="/MenuPrincipal.jsp";
					
					// Enviar respuesta 'success'
			        response.getWriter().write("success");
				} else{
					mensaje="Credenciales incorrectas";
					
					//redireccionamos
					url="/Index.jsp";
					// Enviar respuesta 'error'
			        response.getWriter().write("error");
					
				} //fin del else
						
				//salidas hacia el archivo JSP...
				request.setAttribute("mensaje", mensaje);
				request.setAttribute("successMessage", successMessage);
						
				//realizamos el respectivo redireccionamiento
				request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
