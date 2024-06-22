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

import Dao.Proyecto.AsignaturaImp;

import Modelo.Proyecto.ClaseCursoDocente;


/**
 * Servlet implementation class ControladorAsignatura
 */
@WebServlet("/ControladorAsignatura")
public class ControladorAsignatura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAsignatura() {
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
			AsignaturaImp asiglist= new AsignaturaImp();
			List<ClaseCursoDocente> listadoAsig=asiglist.ListarCursoAsignado();

			request.setAttribute("listado", listadoAsig);
			//redireccionamos
			request.getRequestDispatcher("/ListadoCursoAsignado.jsp").forward(request, response);
			break;
			case "QuitarAsignatura":
				
				String url="";
				
				String iddoc=request.getParameter("iddoc");
				String idcur=request.getParameter("idcur");
				//instanciamos las respectivas clases...
				ClaseCursoDocente clcurdoc=new ClaseCursoDocente();
				AsignaturaImp asigimp= new AsignaturaImp();
				//asignamos el codigo a eliminar...
				clcurdoc.setIddocente(iddoc);
				clcurdoc.setIdcurso(idcur);
				
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la asignacion?","Confirmacion",JOptionPane.YES_NO_OPTION);
				
				List<ClaseCursoDocente> listado=new ArrayList<ClaseCursoDocente>();
				
				if(respuesta == JOptionPane.YES_OPTION){
					//invocamos el metodo eliminar
					asigimp.QuitarAsignatura(clcurdoc);
					//actualizamos nuestro listado
					listado=asigimp.ListarCursoAsignado();
					url="/ListadoCursoAsignado.jsp";
				}else{
					listado=asigimp.ListarCursoAsignado();
					url="/ListadoCursoAsignado.jsp";
				}
				
				//enviamos a la vista
				request.setAttribute("listado", listado);
				//redireccionamos...
				request.getRequestDispatcher(url).forward(request, response);
				break;
			
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String iddoc=request.getParameter("docente");
		String idcur=request.getParameter("curso");
		
		ClaseCursoDocente clsasi=new ClaseCursoDocente();
		AsignaturaImp asiimp=new AsignaturaImp();
		
		clsasi.setIddocente(iddoc);
		clsasi.setIdcurso(idcur);

		asiimp.AsignarCursoDocente(clsasi);

				
		//recuperar datos de la capa DAO
		List<ClaseCursoDocente> Listado=asiimp.ListarCursoAsignado();
		//enviamos a la vista
		request.setAttribute("listado", Listado);				
		//redireccionar al listado de productos
		request.getRequestDispatcher("/ListadoCursoAsignado.jsp").forward(request, response);
		
	}

}
