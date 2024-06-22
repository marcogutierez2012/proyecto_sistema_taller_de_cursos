package Controlador.Proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Dao.Proyecto.EstudianteImp;
import Modelo.Proyecto.ClaseEstudiante;

/**
 * Servlet implementation class ControladorEstudiante
 */
@WebServlet("/ControladorEstudiante")
public class ControladorEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String accion=request.getParameter("accion");
		if(accion!=null){
		switch(accion){
	
		case "Listado":
		EstudianteImp lista= new EstudianteImp();
		List<ClaseEstudiante> listado=lista.ListarEstudianteGeneral();
	
		request.setAttribute("listado", listado);
		//redireccionamos
		request.getRequestDispatcher("/ListadoEstudiante.jsp").forward(request, response);
		break;
		
		case "Actualizar":
			String buscaest=request.getParameter("buscaest");
			//instanciamos las respectivas clases...
			ClaseEstudiante claest=new ClaseEstudiante();
			EstudianteImp estu=new EstudianteImp();
			//asignamos el codigo a buscar..
			claest.setDni(buscaest);
			ClaseEstudiante clalmest=estu.BuscarEstudiante(claest);
			//enviamos al formulario actualizar
			//los valores recuperados
			request.setAttribute("idest",clalmest.getIdestudiante());
			request.setAttribute("dniest",clalmest.getDni());
			request.setAttribute("nomest",clalmest.getNombre());
			request.setAttribute("apeest",clalmest.getApellido());
			request.setAttribute("correo",clalmest.getCorreo());
			request.setAttribute("telefono",clalmest.getTelefono());
			//redireccionar
			request.getRequestDispatcher("/FrmActualizarEstudiante.jsp").forward(request,response);
		break;
		
		case "Eliminar":
			
			String url="";
	
			String idest=request.getParameter("idest");
			//instanciamos las respectivas clases...
			ClaseEstudiante clesteli=new ClaseEstudiante();
			EstudianteImp esteli= new EstudianteImp();
			//asignamos el codigo a eliminar...
			clesteli.setIdestudiante(idest);
			
			//invocamos el metodo eliminar
			esteli.EliminarEstudiante(clesteli);
			
			//int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro?","Confirmacion",JOptionPane.YES_NO_OPTION);
			
			List<ClaseEstudiante> listadoEstudiante=new ArrayList<ClaseEstudiante>();
			
			/*if(respuesta == JOptionPane.YES_OPTION){
				//invocamos el metodo eliminar
				esteli.EliminarEstudiante(clesteli);
				//actualizamos nuestro listado
				listadoEstudiante=esteli.ListarEstudianteGeneral();
				url="/ListadoEstudiante.jsp";
			}else{
				listadoEstudiante=esteli.ListarEstudianteGeneral();
				url="/ListadoEstudiante.jsp";
			}*/
			listadoEstudiante=esteli.ListarEstudianteGeneral();
			url="/ListadoEstudiante.jsp";
			
			//enviamos a la vista
			request.setAttribute("listado", listadoEstudiante);
			//redireccionamos...
			request.getRequestDispatcher(url).forward(request, response);
		break;
		
		/*case "BuscarCurso":
		CursoImp buscarCurso= new CursoImp();
		List<ClaseCurso> listaBusca=buscarCurso.BuscarCurso();
	
		request.setAttribute("listadoBusqueda", listaBusca);
		//redireccionamos
		request.getRequestDispatcher("/ListadoCursoGeneral.jsp").forward(request, response);
		break;
		}*/
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String idest=request.getParameter("idestudiante");
		String dniest=request.getParameter("dni");
		String nomest=request.getParameter("nombre");
		String apeest=request.getParameter("apellido");
		String corest=request.getParameter("correo");
		String telest=request.getParameter("telefono");
		String estado=request.getParameter("estado");
		
		ClaseEstudiante clsest=new ClaseEstudiante();
		EstudianteImp estimp=new EstudianteImp();
		
		clsest.setDni(dniest);
		clsest.setNombre(nomest);
		clsest.setApellido(apeest);
		clsest.setCorreo(corest);
		clsest.setTelefono(telest);
		clsest.setEstado(estado);
		 if(idest!=null){
			 clsest.setIdestudiante(idest);
			 estimp.ActualizarEstudiante(clsest);
			 
		 } else {			
			estimp.RegistrarEstudiante(clsest);
		 }
				
		//recuperar datos de la capa DAO
		List<ClaseEstudiante> ListadoGeneral=estimp.ListarEstudianteGeneral();
		//enviamos a la vista
		request.setAttribute("listado", ListadoGeneral);				
		//redireccionar al listado de productos
		request.getRequestDispatcher("/ListadoEstudiante.jsp").forward(request, response);
	
	}

}
