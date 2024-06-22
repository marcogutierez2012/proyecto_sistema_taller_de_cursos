package Controlador.Proyecto;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Dao.Proyecto.CursoImp;
import Dao.Proyecto.EstudianteImp;
import Dao.Proyecto.InscripcionImp;
import Modelo.Proyecto.ClaseCurso;
import Modelo.Proyecto.ClaseEstudiante;
import Modelo.Proyecto.ClaseInscripcion;

/**
 * Servlet implementation class ControladorInscripcion
 */
@WebServlet("/ControladorInscripcion")
public class ControladorInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorInscripcion() {
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
		request.getRequestDispatcher("/ListadoNoInscritos.jsp").forward(request, response);
		break;
		
		case "ListadoInscrito":
		InscripcionImp insimp=new InscripcionImp();
		List<ClaseInscripcion> ListadoInscritos=insimp.ListarInscripcion();
		//enviamos a la vista
		request.setAttribute("listado", ListadoInscritos);				
		//redireccionar al listado de productos
		request.getRequestDispatcher("/ListadoInscripcion.jsp").forward(request, response);
		break;
		
		case "Inscribir":
			String buscaest=request.getParameter("buscaest");
			//instanciamos las respectivas clases...
			ClaseEstudiante claest=new ClaseEstudiante();
			EstudianteImp estu=new EstudianteImp();
			//asignamos el codigo a buscar..
			claest.setDni(buscaest);
			ClaseEstudiante clalmest=estu.BuscarEstudiante(claest);
			//enviamos al formulario actualizar
			//los valores recuperados
			request.setAttribute("nombres", clalmest.getApellido()+", "+clalmest.getNombre());
			request.setAttribute("idest", clalmest.getIdestudiante());
			//redireccionar
			request.getRequestDispatcher("/GenerarInscripcion.jsp").forward(request,response);
		break;
case "EliminarInscripcion":
			
			String url="";
			
			String idest=request.getParameter("idest");
			String idcur=request.getParameter("idcur");
			//instanciamos las respectivas clases...
			ClaseInscripcion clins=new ClaseInscripcion();
			InscripcionImp ins=new InscripcionImp();
			//asignamos el codigo a buscar..
			clins.setIdestudiante(idest);
			clins.setIdcurso(idcur);
			
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la inscripcion?","Confirmacion",JOptionPane.YES_NO_OPTION);
			
			List<ClaseInscripcion> listins=new ArrayList<ClaseInscripcion>();
			
			if(respuesta == JOptionPane.YES_OPTION){
				//invocamos el metodo eliminar
				ins.EliminarInscripcion(clins);
				//actualizamos nuestro listado
				listins=ins.ListarInscripcion();
				url="/ListadoInscripcion.jsp";
			}else{
				listins=ins.ListarInscripcion();
				url="/ListadoInscripcion.jsp";
			}
			
			//enviamos a la vista
			request.setAttribute("listado", listins);
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
		String idest=request.getParameter("idestudiante");	
		String idcur=request.getParameter("curso");
		String fechains=request.getParameter("fechains");
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

		ClaseInscripcion clsins=new ClaseInscripcion();
		InscripcionImp insimp=new InscripcionImp();
		
		CursoImp curimp=new CursoImp();

		clsins.setIdestudiante(idest);
		clsins.setIdcurso(idcur);
		Date fecha;
		try {
			fecha=sdf.parse(fechains);
			Date fechainssql=new Date(fecha.getTime());
			clsins.setFechainscrip(fechainssql);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //fin del catch...
		
		ClaseCurso clscur=new ClaseCurso();
		clscur.setIdcurso(idcur);
		ClaseCurso busqueda = curimp.BuscarCursoID(clscur);
		
		if (busqueda.getIdcurso().equals(clsins.getIdcurso())) {
		    if (busqueda.getVacantes() > 0) {
		        insimp.GenerarInscripcion(clsins);
		        response.getWriter().write("success");
		    } else {
		    	System.out.println("No quedan Vacantes");
		        response.getWriter().write("no_vacancies");
		    }
		} else {
			System.out.println("Curso no Encontrado");
		    response.getWriter().write("course_not_found");
		}

		
	
		//recuperar datos de la capa DAO
		List<ClaseInscripcion> ListadoInscritos=insimp.ListarInscripcion();
		//enviamos a la vista
		request.setAttribute("listado", ListadoInscritos);				
		//redireccionar al listado de productos
		request.getRequestDispatcher("/ListadoInscripcion.jsp").forward(request, response);
		
	}

}
