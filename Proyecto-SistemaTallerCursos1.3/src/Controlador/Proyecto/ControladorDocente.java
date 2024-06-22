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

import Dao.Proyecto.CursoImp;
import Dao.Proyecto.DocenteImp;
import Modelo.Proyecto.ClaseCurso;
import Modelo.Proyecto.ClaseDocente;

/**
 * Servlet implementation class ControladorDocente
 */
@WebServlet("/ControladorDocente")
public class ControladorDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorDocente() {
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
		DocenteImp lista= new DocenteImp();
		List<ClaseDocente> listado=lista.ListarDocenteGeneral();
	
		request.setAttribute("listado", listado);
		//redireccionamos
		request.getRequestDispatcher("/ListadoDocente.jsp").forward(request, response);
		break;
		
		case "Actualizar":
			String buscadoc=request.getParameter("buscadoc");
			//instanciamos las respectivas clases...
			ClaseDocente cladoc=new ClaseDocente();
			DocenteImp docen=new DocenteImp();
			//asignamos el codigo a buscar..
			cladoc.setDni(buscadoc);
			ClaseDocente clalmdoc=docen.BuscarDocente(cladoc);
			//enviamos al formulario actualizar
			//los valores recuperados
			request.setAttribute("iddoc",clalmdoc.getIddocente());
			request.setAttribute("dnidoc",clalmdoc.getDni());
			request.setAttribute("nomdoc",clalmdoc.getNombre());
			request.setAttribute("apedoc",clalmdoc.getApellido());
			request.setAttribute("correo",clalmdoc.getCorreo());
			request.setAttribute("telefono",clalmdoc.getTelefono());
			//redireccionar
			request.getRequestDispatcher("/FrmActualizarDocente.jsp").forward(request,response);
		break;
		
		case "Eliminar":
			
			String url="";
	
			String iddoc=request.getParameter("iddoc");
			//instanciamos las respectivas clases...
			ClaseDocente cldoceli=new ClaseDocente();
			DocenteImp doceli= new DocenteImp();
			//asignamos el codigo a eliminar...
			cldoceli.setIddocente(iddoc);
			
			doceli.EliminarDocente(cldoceli);
			
			//int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro?","Confirmacion",JOptionPane.YES_NO_OPTION);
			
			List<ClaseDocente> listadoDocente=new ArrayList<ClaseDocente>();
			
			/*if(respuesta == JOptionPane.YES_OPTION){
				//invocamos el metodo eliminar
				doceli.EliminarDocente(cldoceli);
				//actualizamos nuestro listado
				listadoDocente=doceli.ListarDocenteGeneral();
				url="/ListadoDocente.jsp";
			}else{
				listadoDocente=doceli.ListarDocenteGeneral();
				url="/ListadoDocente.jsp";
			}*/
			listadoDocente=doceli.ListarDocenteGeneral();
			url="/ListadoDocente.jsp";
			
			//enviamos a la vista
			request.setAttribute("listado", listadoDocente);
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
		
		String iddoc=request.getParameter("iddocente");
		String dnidoc=request.getParameter("dni");
		String nomdoc=request.getParameter("nombre");
		String apedoc=request.getParameter("apellido");
		String cordoc=request.getParameter("correo");
		String teldoc=request.getParameter("telefono");
		String estado=request.getParameter("estadodocente");
		
		ClaseDocente clsdoc=new ClaseDocente();
		DocenteImp docimp=new DocenteImp();
		
		clsdoc.setDni(dnidoc);
		clsdoc.setNombre(nomdoc);
		clsdoc.setApellido(apedoc);
		clsdoc.setCorreo(cordoc);
		clsdoc.setTelefono(teldoc);
		clsdoc.setEstadodocente(estado);
		 if(iddoc!=null){
			 String codact = iddoc;
			 clsdoc.setIddocente(codact);
			 docimp.ActualizarDocente(clsdoc);
			 
		 } else {			
			docimp.RegistrarDocente(clsdoc);
		 }
				
		//recuperar datos de la capa DAO
		List<ClaseDocente> ListadoGeneral=docimp.ListarDocenteGeneral();
		//enviamos a la vista
		request.setAttribute("listado", ListadoGeneral);				
		//redireccionar al listado de productos
		request.getRequestDispatcher("/ListadoDocente.jsp").forward(request, response);
	}

}
