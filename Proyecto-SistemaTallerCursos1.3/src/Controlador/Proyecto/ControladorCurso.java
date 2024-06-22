package Controlador.Proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Dao.Proyecto.CursoImp;
import Modelo.Proyecto.ClaseCurso;

/**
 * Servlet implementation class ControladorCurso
 */
@WebServlet("/ControladorCurso")
public class ControladorCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<String> dias = Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");
		request.setAttribute("dias", dias);
		
		List<String> inicio = Arrays.asList("08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00"
				, "16:00", "17:00", "18:00", "19:00");
		request.setAttribute("inicio", inicio);
		
		List<String> fin = Arrays.asList("10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"
				, "18:00", "19:00", "20:00", "21:00");
		request.setAttribute("fin", fin);
		
		String accion=request.getParameter("accion");
		if(accion!=null){
		switch(accion){

		case "Listado":
		CursoImp curlistGen= new CursoImp();
		List<ClaseCurso> listadoGen=curlistGen.ListarCursoGeneral();
	
		request.setAttribute("listadoGeneral", listadoGen);
		//redireccionamos
		request.getRequestDispatcher("/ListadoCursoGeneral.jsp").forward(request, response);
		break;
		
		case "Actualizar":
			String nomcur=request.getParameter("nomcur");
			//instanciamos las respectivas clases...
			ClaseCurso clacur=new ClaseCurso();
			CursoImp curs=new CursoImp();
			//asignamos el codigo a buscar..
			clacur.setNomcurso(nomcur);;
			ClaseCurso clalmcur=curs.BuscarCurso(clacur);
			//enviamos al formulario actualizar
			//los valores recuperados
			request.setAttribute("id",clalmcur.getIdcurso());
			request.setAttribute("curso",clalmcur.getNomcurso());
			request.setAttribute("descrip",clalmcur.getDescripcion());
			request.setAttribute("dia",clalmcur.getDia());
			request.setAttribute("horini",clalmcur.getHorinicio());
			request.setAttribute("horfin",clalmcur.getHorafin());
			request.setAttribute("vacantes",clalmcur.getVacantes());
			//redireccionar
			request.getRequestDispatcher("/FrmActualizarCurso.jsp").forward(request,response);
		break;
		
		case "Eliminar":
			
			String url="";
	
			String idcur=request.getParameter("idcur");
			//instanciamos las respectivas clases...
			ClaseCurso clcureli=new ClaseCurso();
			CursoImp cureli= new CursoImp();
			//asignamos el codigo a eliminar...
			clcureli.setIdcurso(idcur);
			//invocamos el metodo eliminar
			cureli.EliminarCurso(clcureli);
			
			//int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?","Confirmacion",JOptionPane.YES_NO_OPTION);
			
			List<ClaseCurso> listado=new ArrayList<ClaseCurso>();
			
			/*if(respuesta == JOptionPane.YES_OPTION){
				//invocamos el metodo eliminar
				cureli.EliminarCurso(clcureli);
				//actualizamos nuestro listado
				listado=cureli.ListarCursoGeneral();
				url="/ListadoCursoGeneral.jsp";
			}else{
				listado=cureli.ListarCursoGeneral();
				url="/ListadoCursoGeneral.jsp";
			}*/
			listado=cureli.ListarCursoGeneral();
			url="/ListadoCursoGeneral.jsp";
			
			//enviamos a la vista
			request.setAttribute("listadoGeneral", listado);
			//redireccionamos...
			request.getRequestDispatcher(url).forward(request, response);
		break;
				
		/*case "BuscarCurso":
		CursoImp buscarCurso= new CursoImp();
		List<ClaseCurso> listaBusca=buscarCurso.BuscarCurso();
	
		request.setAttribute("listadoBusqueda", listaBusca);
		//redireccionamos
		request.getRequestDispatcher("/ListadoCursoGeneral.jsp").forward(request, response);
		break;*/
		}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		String idcur=request.getParameter("idcurso");
		
		String nomcur=request.getParameter("nomcurso");
		String descur=request.getParameter("descurso");
		String diacur=request.getParameter("diacurso");
		String horini=request.getParameter("horinicurso");
		String horfin=request.getParameter("horfincurso");
		String vaccur=request.getParameter("vaccurso");
		String estado=request.getParameter("estado");
		
		ClaseCurso clscur=new ClaseCurso();
		CursoImp curimp=new CursoImp();
		
		clscur.setNomcurso(nomcur);
		clscur.setDescripcion(descur);
		clscur.setDia(diacur);
		clscur.setHorinicio(horini);
		clscur.setHorafin(horfin);
		clscur.setVacantes(Integer.parseInt(vaccur));	
		clscur.setEstado(estado);
		 if(idcur!=null){
			 clscur.setIdcurso(idcur);
			 curimp.ActualizarCurso(clscur);
			 
		 } else {
			
			curimp.RegistrarCurso(clscur);
		 }
				
		//recuperar datos de la capa DAO
		List<ClaseCurso> ListadoGeneral=curimp.ListarCursoGeneral();
		//enviamos a la vista
		request.setAttribute("listadoGeneral", ListadoGeneral);				
		//redireccionar al listado de productos
		request.getRequestDispatcher("/ListadoCursoGeneral.jsp").forward(request, response);
		
	}

}
